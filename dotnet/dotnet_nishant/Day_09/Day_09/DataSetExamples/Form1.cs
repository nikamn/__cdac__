using Microsoft.Data.SqlClient;
using System.Data;

namespace DataSetExamples
{
    public partial class Form1 : Form
    {
        private DataSet dataSet;

        public Form1()
        {
            InitializeComponent();
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


        private void button1_Click(object sender, EventArgs e)
        {
            SqlConnection conn = OpenConnection();
            conn.Open();

            try
            {
                SqlCommand cmd = new()
                {
                    Connection = conn,
                    CommandType = CommandType.Text,
                    CommandText = "SELECT * FROM Employees"
                };

                dataSet = new DataSet();

                SqlDataAdapter sqlDataAdapter = new()
                {
                    SelectCommand = cmd
                };

                // dataSet = DataSet name, Employees = DataTable name
                sqlDataAdapter.Fill(dataSet, "Employees");

                cmd.CommandText = "SELECT * FROM Departments";
                sqlDataAdapter.Fill(dataSet, "Departments");    // Departments here is DataTable name

                // primary key constraints
                DataColumn[] dataColumns = new DataColumn[] { dataSet.Tables["Employees"].Columns["EmpNo"] };
                dataSet.Tables["Employees"].PrimaryKey = dataColumns;

                // foreign key constraint
                dataSet.Relations.Add(dataSet.Tables["Departments"].Columns["DeptNo"], dataSet.Tables["Employees"].Columns["DeptNo"]);

                // column level constraint
                dataSet.Tables["Departments"].Columns["DeptName"].Unique = true;

                dataGridView1.DataSource = dataSet.Tables["Employees"];

            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                CloseConnection(conn);
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            SqlConnection conn = OpenConnection();
            conn.Open();

            try
            {
                // update command
                SqlCommand cmdUpdate = new()
                {
                    Connection = conn,
                    CommandType = CommandType.Text,
                    CommandText = "UPDATE Employees SET Name=@Name, Basic=@Basic, DeptNo=@DeptNo WHERE EmpNo=@EmpNo"
                };

                cmdUpdate.Parameters.Add(new SqlParameter { ParameterName = "@Name", SourceColumn = "Name", SourceVersion = DataRowVersion.Current });
                cmdUpdate.Parameters.Add(new SqlParameter { ParameterName = "@Basic", SourceColumn = "Basic", SourceVersion = DataRowVersion.Current });
                cmdUpdate.Parameters.Add(new SqlParameter { ParameterName = "@DeptNo", SourceColumn = "DeptNo", SourceVersion = DataRowVersion.Current });
                cmdUpdate.Parameters.Add(new SqlParameter { ParameterName = "@EmpNo", SourceColumn = "EmpNo", SourceVersion = DataRowVersion.Original });


                // delete
                SqlCommand cmdDelete = new()
                {
                    Connection = conn,
                    CommandType = CommandType.Text,
                    CommandText = "DELETE FROM Employees WHERE EmpNo=@EmpNo"
                };

                cmdDelete.Parameters.Add(new SqlParameter { ParameterName = "@EmpNo", SourceColumn = "EmpNo", SourceVersion = DataRowVersion.Original });

                // insert
                SqlCommand cmdInsert = new()
                {
                    Connection = conn,
                    CommandType = CommandType.Text,
                    CommandText = "INSERT INTO Employees VALUES (@EmpNo,@Name,@Basic,@DeptNo)"
                };

                cmdInsert.Parameters.Add(new SqlParameter { ParameterName = "@Name", SourceColumn = "Name", SourceVersion = DataRowVersion.Current });
                cmdInsert.Parameters.Add(new SqlParameter { ParameterName = "@Basic", SourceColumn = "Basic", SourceVersion = DataRowVersion.Current });
                cmdInsert.Parameters.Add(new SqlParameter { ParameterName = "@DeptNo", SourceColumn = "DeptNo", SourceVersion = DataRowVersion.Current });
                cmdInsert.Parameters.Add(new SqlParameter { ParameterName = "@EmpNo", SourceColumn = "EmpNo", SourceVersion = DataRowVersion.Current });

                SqlDataAdapter sqlDataAdapter = new()
                {
                    UpdateCommand = cmdUpdate,
                    DeleteCommand = cmdDelete,
                    InsertCommand = cmdInsert
                };

                sqlDataAdapter.Update(dataSet.Tables["Employees"]);
                dataSet.AcceptChanges();

                MessageBox.Show("Update Success ...!");
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                CloseConnection(conn);
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            dataSet.RejectChanges();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            dataSet.Tables["Employees"].DefaultView.RowFilter = "DeptNo=" + textBox1.Text;
        }

        private void button5_Click(object sender, EventArgs e)
        {
            dataSet.WriteXmlSchema("Employee.xsd");
            dataSet.WriteXml("Employees.xml", XmlWriteMode.DiffGram);
        }

        private void button6_Click(object sender, EventArgs e)
        {
            dataSet = new DataSet();
            dataSet.ReadXmlSchema("Employee.xsd");
            dataSet.ReadXml("Employees.xml", XmlReadMode.DiffGram);
            dataGridView1.DataSource = dataSet.Tables["Employees"];
        }
    }
}
