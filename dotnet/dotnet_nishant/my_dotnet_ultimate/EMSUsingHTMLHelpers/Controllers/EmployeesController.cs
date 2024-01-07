using EMSUsingHTMLHelpers.DataAccessObject;
using EMSUsingHTMLHelpers.Models;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;

namespace EMSUsingHTMLHelpers.Controllers
{
    public class EmployeesController : Controller
    {
        [HttpGet]
        public IActionResult Index()
        {
            List<Employee> employeeList = EmployeeDao.GetAllEmployees();
            return View(employeeList);
        }

        [HttpGet]
        public IActionResult Details(int id)
        {
            Employee employee = EmployeeDao.GetSingleEmployee(id);
            return View(employee);
        }

        [HttpGet]
        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Create(Employee newEmployee)
        {
            try
            {
                EmployeeDao.InsertNewEmployee(newEmployee);
                return RedirectToAction("Index");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return View();
            }
        }

        [HttpGet]
        public IActionResult Edit(int id)
        {
            Employee employee = EmployeeDao.GetSingleEmployee(id);
            return View(employee);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Edit(Employee updatedEmployee)
        {
            try
            {
                EmployeeDao.UpdateEmployee(updatedEmployee);
                return RedirectToAction("Index");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return View();
            }
        }

        [HttpGet]
        public IActionResult Delete(int id)
        {
            Employee employee = EmployeeDao.GetSingleEmployee(id);
            return View(employee);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Delete(int id, Employee employee)
        {
            try
            {
                EmployeeDao.DeleteEmployee(id);
                return RedirectToAction("Index");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return View();
            }
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
