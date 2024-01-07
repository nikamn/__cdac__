namespace SqlExamples
{
    internal class Employee
    {
        private int _empNo;
        public int EmpNo { get { return _empNo; } set { _empNo = value; } }

        private string _name;
        public string Name { get { return _name; } set { _name = value; } }

        private decimal _basic;
        public decimal Basic { get { return _basic; } set { _basic = value; } }

        private int _deptNo;
        public int DeptNo { get { return _deptNo; } set { _deptNo = value; } }

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
            return $"EmpNo: {EmpNo}\tName: {Name}       \tBasic: {Basic} \tDeptNo: {DeptNo}";
        }

    }
}
