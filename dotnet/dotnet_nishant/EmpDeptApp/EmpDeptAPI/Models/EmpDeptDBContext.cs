using Microsoft.EntityFrameworkCore;

namespace EmpDeptAPI.Models
{
    public class EmpDeptDBContext : DbContext
    {
        public EmpDeptDBContext() { }

        public EmpDeptDBContext(DbContextOptions<EmpDeptDBContext> options) : base(options) { }

        protected override void OnConfiguring(DbContextOptionsBuilder options)
        {
            options.UseSqlServer("Data Source=(localdb)\\ProjectModels;Initial Catalog=EmpDeptDB;Integrated Security=True;MultipleActiveResultSets=true;");
        }

        public virtual DbSet<Employee> Employees { get; set; }

        public virtual DbSet<Department> Departments { get; set; }
    }
}
