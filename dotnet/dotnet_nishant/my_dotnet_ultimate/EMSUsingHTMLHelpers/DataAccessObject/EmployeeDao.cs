using EMSUsingHTMLHelpers.Models;
using Microsoft.Data.SqlClient;
using System.Data;

namespace EMSUsingHTMLHelpers.DataAccessObject
{
    public class EmployeeDao
    {
        public EmployeeDao() { }

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

        // for list all employees
        public static List<Employee> GetAllEmployees()
        {
            List<Employee> list = new();

            SqlConnection conn = OpenConnection();
            Connect(conn);

            try
            {
                SqlCommand sqlCommand = new()
                {
                    Connection = conn,
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

            CloseConnection(conn);

            return list;
        }

        // for details of each employee
        public static Employee GetSingleEmployee(int EmpId)
        {
            Employee obj = new();

            SqlConnection conn = OpenConnection();
            Connect(conn);

            try
            {
                SqlCommand sqlCommand = new()
                {
                    Connection = conn,
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

            CloseConnection(conn);

            return obj;
        }

        // for create employee
        public static void InsertNewEmployee(Employee employee)
        {
            SqlConnection conn = OpenConnection();
            Connect(conn);

            try
            {
                SqlCommand sqlCommand = new()
                {
                    Connection = conn,
                    CommandType = System.Data.CommandType.StoredProcedure,
                    CommandText = "InsertEmployee"
                };

                sqlCommand.Parameters.AddWithValue("EmpNo", employee.EmpNo);
                sqlCommand.Parameters.AddWithValue("Name", employee.Name);
                sqlCommand.Parameters.AddWithValue("Basic", employee.Basic);
                sqlCommand.Parameters.AddWithValue("DeptNo", employee.DeptNo);

                sqlCommand.ExecuteNonQuery();
                Console.WriteLine($"Inserted Employee: {employee.Name} successfully to db @...!");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }

            CloseConnection(conn);
        }

        // for update employee
        public static void UpdateEmployee(Employee employee)
        {
            SqlConnection conn = OpenConnection();
            Connect(conn);

            try
            {
                SqlCommand sqlCommand = new()
                {
                    Connection = conn,
                    CommandType = System.Data.CommandType.StoredProcedure,
                    CommandText = "UpdateEmployee"
                };

                sqlCommand.Parameters.AddWithValue("EmpNo", employee.EmpNo);
                sqlCommand.Parameters.AddWithValue("Name", employee.Name);
                sqlCommand.Parameters.AddWithValue("Basic", employee.Basic);
                sqlCommand.Parameters.AddWithValue("DeptNo", employee.DeptNo);

                sqlCommand.ExecuteNonQuery();
                Console.WriteLine($"Updated Employee: {employee.EmpNo} successfully to db @...!");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }

            CloseConnection(conn);
        }

        // delete employee from db
        public static void DeleteEmployee(int empId)
        {
            SqlConnection conn = OpenConnection();
            Connect(conn);

            try
            {
                SqlCommand sqlCommand = new()
                {
                    Connection = conn,
                    CommandType = System.Data.CommandType.StoredProcedure,
                    CommandText = "DeleteEmployee"
                };

                sqlCommand.Parameters.AddWithValue("EmpNo", empId);

                sqlCommand.ExecuteNonQuery();
                Console.WriteLine($"Deleted EmpNo: {empId} successfully from db @...!");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }

            CloseConnection(conn);
        }
    }
}
