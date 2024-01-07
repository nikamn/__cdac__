using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace SecondWebAPI.Models
{
    public class Department
    {
        [Key]
        [Column("DeptNo", TypeName = "int")]
        public int DeptNo { get; set; }

        [Column("DeptName", TypeName = "varchar(50)")]
        public string DeptName { get; set; } = null!;

        public virtual ICollection<Employee> Employees { get; set; } = new List<Employee>();
    }
}
