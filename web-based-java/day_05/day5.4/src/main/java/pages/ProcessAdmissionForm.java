package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Course;
import pojos.Student;

@WebServlet("/admission")
public class ProcessAdmissionForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {
			String fName = request.getParameter("fn");
			String lName = request.getParameter("ln");

			int marks = Integer.parseInt(request.getParameter("score"));
			Course course = Course.valueOf(request.getParameter("course").toUpperCase());

			Student newStudent = new Student(fName, lName, marks, course);

			if (marks >= course.getMinMarks())
				newStudent.setAdmissionStatus(true);
			request.setAttribute("student_dtls", newStudent);
			
			pw.print("<h3>From 1st page ...!</h3>");
		
			RequestDispatcher rd = request.getRequestDispatcher("result");
			rd.include(request, response);
			
			System.out.println("control came back ...!");
			pw.print("<h5>1st page generating contents again ...!</h5>");
		}
	}

}
