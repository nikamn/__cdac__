namespace ControllerViewOnly.Models
{
    public class Employee
    {
        public int EmpNo { get; set; }

        public string? Name { get; set; }

        public decimal Basic { get; set; }

        public int DeptNo { get; set; }
        public Employee()
        {
        }

        public Employee(int empNo, string name, decimal basic, int deptNo)
        {
            EmpNo = empNo;
            Name = name;
            Basic = basic;
            DeptNo = deptNo;
        }

        public override string ToString()
        {
            return $"EmpNo: {EmpNo}\tName: {Name} \tBasic: {Basic} \tDeptNo: {DeptNo}";
        }
    }
}
