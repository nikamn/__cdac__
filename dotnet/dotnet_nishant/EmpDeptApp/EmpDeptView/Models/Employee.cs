namespace EmpDeptView.Models
{
    public class Employee
    {
        public int EmployeeId { get; set; }
        public string EmployeeName { get; set; }
        public DateOnly DateOfJoining { get; set; }
        public string PhotoFileName { get; set; }
        public int DepartmentId { get; set; }
        public Department DeptNoNavigation { get; set; }
    }
}
