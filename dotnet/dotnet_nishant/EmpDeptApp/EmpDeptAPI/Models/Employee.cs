using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace EmpDeptAPI.Models
{
    public class Employee
    {
        [Key]
        [Column(name: "employee_id", TypeName = "int")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int EmployeeId { get; set; }

        [Required]
        [StringLength(50)]
        [DataType(DataType.Text)]
        [RegularExpression(pattern: "^[a-zA-Z' ']+$", ErrorMessage = "Name contains only letters and spaces")]
        [Column(name: "employee_name", TypeName = "varchar(50)")]
        public string EmployeeName { get; set; }

        [Required]
        [DataType(DataType.Date)]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:dd/MM/yyyy}")]
        [Column(name: "date_of_joining", TypeName = "date")]
        public DateTime DateOfJoining { get; set; }

        [StringLength(200)]
        [DataType(DataType.Text)]
        [Column(name: "photo_file_name", TypeName = "varchar(200)")]
        public string PhotoFileName { get; set; }

        [Column("dept_no", TypeName = "int")]
        public int DepartmentId { get; set; }

        [ForeignKey("DepartmentId")]
        public virtual Department DeptNoNavigation { get; set; } = null!;

    }
}
