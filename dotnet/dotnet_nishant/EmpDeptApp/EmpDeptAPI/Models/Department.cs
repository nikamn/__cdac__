using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace EmpDeptAPI.Models
{
    public class Department
    {
        [Key]
        [Column("department_id", TypeName = "int")]
        public int DepartmentId { get; set; }

        [Required]
        [StringLength(50)]
        [DataType(DataType.Text)]
        [Column(name: "department_name", TypeName = "varchar(50)")]
        public string DepartmentName { get; set; }

        public virtual ICollection<Employee> Employees { get; set; } = new List<Employee>();
    }
}
