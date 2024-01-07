using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using SecondWebAPI.Models;

namespace SecondWebAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EmployeesController : ControllerBase
    {
        private readonly CodeFirstAPIContext _context;

        public EmployeesController(CodeFirstAPIContext context)
        {
            _context = context;
        }

        // GET Employees/Index
        // GET: /api/employees/
        [HttpGet]
        public async Task<IEnumerable<Employee>> Get()
        {
            var codeFirstAPIContext = _context.Employees;
            return await codeFirstAPIContext.ToListAsync();
        }

        // GET: Employees/Details/5
        // GET: /api/employees/id
        [HttpGet("{id}")]
        public async Task<Employee?> Get(int? id)
        {
            //if (id == null || _context.Employees == null)
            //{
            //    return HttpResponse;
            //}

            var employee = await _context.Employees
                .FirstOrDefaultAsync(m => m.EmpNo == id);
            //if (employee == null)
            //{
            //    return NotFound();
            //}

            return employee;
        }

        //[HttpGet("{id}")]
        //public async Task<EmployeeView> Get(int? id)
        //{
        //    var employee =  _context.Employees.Include(e => e.DeptNoNavigation).FirstOrDefaultAsync(m => m.EmpNo == id);

        //    var employeeView = await new { employee.EmpNo, employee.Name, employee.Basic, employee.DeptNo, employee.DeptNoNavigation!.DeptName };

        //    return ;
        //}

        // POST: Employees/Create
        // POST: /api/employees
        [HttpPost]
        public async Task<int> Post([FromBody] Employee? employee)
        {
            _context.Employees.Add(employee!);
            return await _context.SaveChangesAsync();

        }

        // POST: Employees/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        //[HttpPost]
        //[ValidateAntiForgeryToken]
        //public async Task<IActionResult> Create([Bind("EmpNo,Name,Basic,DeptNo")] Employee employee)
        //{
        //    if (ModelState.IsValid)
        //    {
        //        _context.Add(employee);
        //        await _context.SaveChangesAsync();
        //        return RedirectToAction(nameof(Index));
        //    }
        //    return ;
        //}

        //// GET: Employees/Edit/5
        //public async Task<IActionResult> Edit(int? id)
        //{
        //    if (id == null || _context.Employees == null)
        //    {
        //        return NotFound();
        //    }

        //    var employee = await _context.Employees.FindAsync(id);
        //    if (employee == null)
        //    {
        //        return NotFound();
        //    }
        //    ViewData["DeptNo"] = new SelectList(_context.Departments, "DeptNo", "DeptNo", employee.DeptNo);
        //    return View(employee);
        //}

        //// POST: Employees/Edit/5
        //// To protect from overposting attacks, enable the specific properties you want to bind to.
        //// For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        //[HttpPost]
        //[ValidateAntiForgeryToken]
        //public async Task<IActionResult> Edit(int id, [Bind("EmpNo,Name,Basic,DeptNo")] Employee employee)
        //{
        //    if (id != employee.EmpNo)
        //    {
        //        return NotFound();
        //    }

        //    if (ModelState.IsValid)
        //    {
        //        try
        //        {
        //            _context.Update(employee);
        //            await _context.SaveChangesAsync();
        //        }
        //        catch (DbUpdateConcurrencyException)
        //        {
        //            if (!EmployeeExists(employee.EmpNo))
        //            {
        //                return NotFound();
        //            }
        //            else
        //            {
        //                throw;
        //            }
        //        }
        //        return RedirectToAction(nameof(Index));
        //    }
        //    ViewData["DeptNo"] = new SelectList(_context.Departments, "DeptNo", "DeptNo", employee.DeptNo);
        //    return View(employee);
        //}

        //// GET: Employees/Delete/5
        //public async Task<IActionResult> Delete(int? id)
        //{
        //    if (id == null || _context.Employees == null)
        //    {
        //        return NotFound();
        //    }

        //    var employee = await _context.Employees
        //        .Include(e => e.DeptNoNavigation)
        //        .FirstOrDefaultAsync(m => m.EmpNo == id);
        //    if (employee == null)
        //    {
        //        return NotFound();
        //    }

        //    return View(employee);
        //}

        //// POST: Employees/Delete/5
        //[HttpPost, ActionName("Delete")]
        //[ValidateAntiForgeryToken]
        //public async Task<IActionResult> DeleteConfirmed(int id)
        //{
        //    if (_context.Employees == null)
        //    {
        //        return Problem("Entity set 'CodeFirstAPIContext.Employees'  is null.");
        //    }
        //    var employee = await _context.Employees.FindAsync(id);
        //    if (employee != null)
        //    {
        //        _context.Employees.Remove(employee);
        //    }

        //    await _context.SaveChangesAsync();
        //    return RedirectToAction(nameof(Index));
        //}

        //private bool EmployeeExists(int id)
        //{
        //    return (_context.Employees?.Any(e => e.EmpNo == id)).GetValueOrDefault();
        //}
    }
}
