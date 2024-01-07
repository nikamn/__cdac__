using Microsoft.EntityFrameworkCore;

namespace SecondWebAPI.Models
{
    public class CodeFirstAPIContext : DbContext
    {
        public CodeFirstAPIContext() { }

        public CodeFirstAPIContext(DbContextOptions<CodeFirstAPIContext> options) : base(options) { }

        public virtual DbSet<Employee> Employees { get; set; }

        public virtual DbSet<Department> Departments { get; set; }
    }
}
