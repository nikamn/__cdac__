using Microsoft.Data.SqlClient;
using System.Data;

namespace SqlExamples
{
    public class Program
    {
        static void Main()
        {
            SqlConnection cn = OpenConnection();

            Connect(cn);

            //InsertUsingText(cn);

            //Employee employee = new(6, "Alisha", 80000, 20);
            //InsertUsingStoredProcedure(cn, employee);

            //SelectSingleValue(cn);

            //DataReader(cn);
            //DataReader2(cn);

            //Employee employee = GetSingleEmployee(cn, 1);
            //Console.WriteLine(employee);

            //List<Employee> employees = GetAllEmployees(cn);
            //foreach (var item in employees)
            //{
            //    Console.WriteLine(item);
            //}

            //DataReader3(cn);
            //Transactions(cn);
            //DataReader3(cn);

            CloseConnection(cn);

        }

        // close connection
        public static void CloseConnection(SqlConnection cn)
        {
            cn.Close();
        }

        // open connection
        public static SqlConnection OpenConnection()
        {
            SqlConnection cn = new()
            {
                ConnectionString = @"Data Source=(localdb)\ProjectModels;Initial Catalog=ActsDec2023;Integrated Security=True;Multiple Active Result Sets=True;"
            };

            return cn;
        }

        // connect to database
        public static void Connect(SqlConnection cn)
        {
            try
            {
                cn.Open();
                Console.WriteLine("Success ...! Connected to database ...@!");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        // insert into database using Commandtype.Text
        static void InsertUsingText(SqlConnection cn)
        {
            try
            {
                SqlCommand sqlCommand = new()
                {
                    Connection = cn,
                    CommandType = System.Data.CommandType.Text,
                    CommandText = "INSERT INTO Employees VALUES(5,'Shivani', 12345, 30)"
                };

                sqlCommand.ExecuteNonQuery();

                Console.WriteLine("Inserted record to database using Commandtype.Text ...@!");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        // insert into database using stored procedure
        static void InsertUsingStoredProcedure(SqlConnection cn, Employee employee)
        {
            try
            {
                SqlCommand sqlCommand = new()
                {
                    Connection = cn,
                    CommandType = System.Data.CommandType.StoredProcedure,
                    CommandText = "InsertEmployee"
                };

                sqlCommand.Parameters.AddWithValue("EmpNo", employee.EmpNo);
                sqlCommand.Parameters.AddWithValue("Name", employee.Name);
                sqlCommand.Parameters.AddWithValue("Basic", employee.Basic);
                sqlCommand.Parameters.AddWithValue("DeptNo", employee.DeptNo);

                sqlCommand.ExecuteNonQuery();

                Console.WriteLine("Inserted record to database using CommandType.StoredProcedure ...@!");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        static void SelectSingleValue(SqlConnection cn)
        {
            try
            {
                SqlCommand sqlCommand = new()
                {
                    Connection = cn,
                    CommandType = System.Data.CommandType.Text,
                    CommandText = "SELECT COUNT(*) FROM Employees"
                };

                object result = sqlCommand.ExecuteScalar();
                Console.WriteLine("Using ExecuteScalar ...@!");
                Console.WriteLine(result);

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }

        }

        static void DataReader(SqlConnection cn)
        {
            try
            {
                SqlCommand sqlCommand = new()
                {
                    Connection = cn,
                    CommandType = System.Data.CommandType.Text,
                    CommandText = "SELECT * FROM Employees"
                };

                Console.WriteLine("Using ExecuteReader ...@!");

                SqlDataReader sdr = sqlCommand.ExecuteReader();

                while (sdr.Read())
                {
                    Console.WriteLine($"{sdr["EmpNo"]}\t{sdr["Name"]}    \t{sdr["Basic"]} \t{sdr["DeptNo"]}");
                }
                sdr.Close();

                Console.WriteLine("\nRead records successfully");

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        static void DataReader2(SqlConnection cn)
        {
            try
            {
                SqlCommand sqlCommand = new()
                {
                    Connection = cn,
                    CommandType = System.Data.CommandType.Text,
                    CommandText = "SELECT * FROM Employees; SELECT * FROM Departments"
                };

                Console.WriteLine("Using ExecuteReader ...@!");

                SqlDataReader sdr = sqlCommand.ExecuteReader();

                while (sdr.Read())
                {
                    Console.WriteLine($"{sdr["EmpNo"]}\t{sdr["Name"]}    \t{sdr["Basic"]} \t{sdr["DeptNo"]}");
                }

                Console.WriteLine();
                sdr.NextResult();

                while (sdr.Read())
                {
                    Console.WriteLine($"{sdr["DeptNo"]}\t{sdr["DeptName"]}");
                }

                sdr.Close();

                Console.WriteLine("\nRead records successfully");

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        static Employee GetSingleEmployee(SqlConnection cn, int EmpId)
        {
            Employee obj = new();

            try
            {
                SqlCommand sqlCommand = new()
                {
                    Connection = cn,
                    CommandType = System.Data.CommandType.Text,
                    CommandText = "SELECT * FROM Employees WHERE EmpNo=@Number"
                };

                sqlCommand.Parameters.AddWithValue("Number", EmpId);

                SqlDataReader sdr = sqlCommand.ExecuteReader();

                if (sdr.Read())
                {
                    obj.EmpNo = sdr.GetInt32("EmpNo");
                    obj.Name = sdr.GetString("Name");
                    obj.Basic = sdr.GetDecimal("Basic");
                    obj.DeptNo = sdr.GetInt32("DeptNo");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }

            return obj;
        }

        static List<Employee> GetAllEmployees(SqlConnection cn)
        {
            List<Employee> list = new();

            try
            {
                SqlCommand sqlCommand = new()
                {
                    Connection = cn,
                    CommandType = System.Data.CommandType.Text,
                    CommandText = "SELECT * FROM Employees;"
                };


                SqlDataReader sdr = sqlCommand.ExecuteReader();

                while (sdr.Read())
                {
                    list.Add(new Employee(sdr.GetInt32("EmpNo"), sdr.GetString("Name"), sdr.GetDecimal("Basic"), sdr.GetInt32("DeptNo")));
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }

            return list;
        }

        static void CustomDataReader(SqlConnection cn, string commandText)
        {
            SqlDataReader sdr = GetDataReader(cn, commandText);

            while (sdr.Read())
            {
                // write custom function or delegate here later instead of hardcoding
                Console.WriteLine($"{sdr["EmpNo"]}\t{sdr["Name"]}    \t{sdr["Basic"]} \t{sdr["DeptNo"]}");
            }

            sdr.Close();
        }

        static SqlDataReader GetDataReader(SqlConnection cn, string commandText)
        {
            SqlCommand sqlCommand = new()
            {
                Connection = cn,
                CommandType = System.Data.CommandType.Text,
                CommandText = commandText
            };

            SqlDataReader sdr = sqlCommand.ExecuteReader();
            //following line closes connection automatically after ExecuteReader()
            //SqlDataReader sdr = sqlCommand.ExecuteReader(CommandBehavior.CloseConnection);

            //cn.Close();

            return sdr;
        }

        static void DataReader3(SqlConnection cn)
        {
            try
            {
                //SqlCommand sqlCommand = new()
                //{
                //    Connection = cn,
                //    CommandType = System.Data.CommandType.Text,
                //    CommandText = "SELECT * FROM Employees"
                //};

                Console.WriteLine("Using ExecuteReader ...@!");

                //SqlDataReader sdr = sqlCommand.ExecuteReader();

                //while (sdr.Read())
                //{
                //    Console.WriteLine($"{sdr["EmpNo"]}\t{sdr["Name"]}    \t{sdr["Basic"]} \t{sdr["DeptNo"]}");
                //}
                //sdr.Close();

                CustomDataReader(cn, "SELECT * FROM Employees");

                Console.WriteLine("\nRead records successfully");

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        static void Transactions(SqlConnection cn)
        {
            // begin transaction
            SqlTransaction t = cn.BeginTransaction();

            SqlCommand cmdInsert1 = new()
            {
                Connection = cn,
                Transaction = t,

                CommandType = System.Data.CommandType.Text,
                CommandText = "INSERT INTO Employees VALUES(10, 'Shweta', 12345, 30)"
            };

            SqlCommand cmdInsert2 = new()
            {
                Connection = cn,
                Transaction = t,

                CommandType = System.Data.CommandType.Text,
                CommandText = "INSERT INTO Employees VALUES(20, 'Shweta', 12345, 30)"
            };

            try
            {
                cmdInsert1.ExecuteNonQuery();
                cmdInsert2.ExecuteNonQuery();

                // commit transaction
                t.Commit();
                Console.WriteLine("No Errors -- committ");
            }
            catch (Exception ex)
            {
                // rollback transaction in case of exception
                t.Rollback();
                Console.WriteLine("Error -- rollback");
                Console.WriteLine(ex.Message);
            }
        }


    }
}
