using ControllerViewOnly.Models;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using System.Diagnostics;
using System.Net.Http.Headers;

namespace ControllerViewOnly.Controllers
{
    public class EmployeesController : Controller
    {
        private readonly string _url = "http://localhost:5157/api/employees/";

        [HttpGet]
        public async Task<IActionResult> Index()
        {
            List<Employee>? employeeList = null;

            using (HttpClient client = new())
            {
                HttpResponseMessage response = await client.GetAsync(_url);

                if (response.IsSuccessStatusCode)
                {
                    string content = await response.Content.ReadAsStringAsync();

                    employeeList = JsonConvert.DeserializeObject<List<Employee>>(content);
                }
            }
            return View(employeeList);
        }

        [HttpGet]
        public async Task<IActionResult> Details(int id)
        {
            Employee? employee = null;

            using (HttpClient client = new())
            {
                HttpResponseMessage response = await client.GetAsync($"{_url}{id}");

                if (response.IsSuccessStatusCode)
                {
                    string content = await response.Content.ReadAsStringAsync();

                    employee = JsonConvert.DeserializeObject<Employee>(content);
                }
            }

            return View(employee);
        }

        [HttpGet]
        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create(Employee newEmployee)
        {
            try
            {
                using (HttpClient client = new())
                {
                    StringContent body = new(JsonConvert.SerializeObject(newEmployee, Formatting.Indented, new JsonSerializerSettings
                    {
                        PreserveReferencesHandling = PreserveReferencesHandling.Objects
                    }));
                    body.Headers.ContentType = new MediaTypeHeaderValue("application/json");

                    HttpResponseMessage response = await client.PostAsync(_url, body);

                    if (!response.IsSuccessStatusCode)
                    {
                        string content = await response.Content.ReadAsStringAsync();
                        throw new Exception(content);
                    }
                }

                return RedirectToAction("Index");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return View();
            }
        }

        [HttpGet]
        public async Task<IActionResult> Edit(int id)
        {
            Employee? employee = null;

            using (HttpClient client = new())
            {
                HttpResponseMessage response = await client.GetAsync($"{_url}{id}");

                if (response.IsSuccessStatusCode)
                {
                    string content = await response.Content.ReadAsStringAsync();

                    employee = JsonConvert.DeserializeObject<Employee>(content);
                }
            }
            return View(employee);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, Employee updatedEmployee)
        {
            try
            {
                using (HttpClient client = new())
                {
                    StringContent body = new(JsonConvert.SerializeObject(updatedEmployee));
                    body.Headers.ContentType = new MediaTypeHeaderValue("application/json");

                    HttpResponseMessage response = await client.PutAsync($"{_url}{id}", body);

                    if (!response.IsSuccessStatusCode)
                    {
                        string content = await response.Content.ReadAsStringAsync();
                        throw new Exception(content);
                    }
                }

                return RedirectToAction("Index");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return View();
            }
        }

        [HttpGet]
        public async Task<IActionResult> Delete(int id)
        {
            Employee? employee = null;

            using (HttpClient client = new())
            {
                HttpResponseMessage response = await client.GetAsync($"{_url}{id}");

                if (response.IsSuccessStatusCode)
                {
                    string content = await response.Content.ReadAsStringAsync();

                    employee = JsonConvert.DeserializeObject<Employee>(content);
                }
            }

            return View(employee);
        }

        [HttpPost]
        [ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirm(int id)
        {
            try
            {
                using (HttpClient client = new())
                {

                    HttpResponseMessage response = await client.DeleteAsync($"{_url}{id}");

                    if (!response.IsSuccessStatusCode)
                    {
                        string content = await response.Content.ReadAsStringAsync();
                        throw new Exception(content);
                    }
                }

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
