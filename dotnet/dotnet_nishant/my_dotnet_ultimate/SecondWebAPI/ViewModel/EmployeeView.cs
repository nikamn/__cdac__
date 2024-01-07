namespace SecondWebAPI.ViewModel
{
    public class EmployeeView
    {
        public EmployeeView(int empNo, string? name, decimal basic, int deptNo, string? deptName)
        {
            EmpNo = empNo;
            Name = name;
            Basic = basic;
            DeptNo = deptNo;
            DeptName = deptName;
        }

        public int EmpNo { get; set; }

        public string? Name { get; set; }

        public decimal Basic { get; set; }

        public int DeptNo { get; set; }

        public string? DeptName { get; set; }

    }
}
