using EMSUsingHTMLHelpers.DataAccessObject;
using FirstWebAPI.Models;
using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace FirstWebAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EmployeesController : ControllerBase
    {
        // GET: api/<EmployeesController>
        [HttpGet]
        public IEnumerable<Employee> Get()
        {
            List<Employee> employeeList = EmployeeDao.GetAllEmployees();
            return employeeList;
        }

        // GET api/<EmployeesController>/5
        [HttpGet("{id}")]
        public Employee Get(int id)
        {
            Employee employee = EmployeeDao.GetSingleEmployee(id);
            return employee;
        }

        // POST api/<EmployeesController>
        [HttpPost]
        public void Post([FromBody] Employee newEmployee)
        {
            EmployeeDao.InsertNewEmployee(newEmployee);
        }

        // PUT api/<EmployeesController>/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] Employee updatedEmployee)
        {
            updatedEmployee.EmpNo = id;
            EmployeeDao.UpdateEmployee(updatedEmployee);
        }

        // DELETE api/<EmployeesController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            EmployeeDao.DeleteEmployee(id);
        }
    }
}
