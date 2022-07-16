package net.javaguides.AssignmentCategory.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.employeemanagement.dao.EmployeeDao;
import net.javaguides.employeemanagement.model.Employee;

/**
 * @email Ramesh Fadatare
 */

@WebServlet("/register")
public class AssignmentCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AssignmentCategoryDao assignmentcategoryDao;
	
	public void init() {
		assignmentcategoryDao = new AssignmentCategoryDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String SerialNo = request.getParameter("SerialNo");
		String StudentName = request.getParameter("StudentName");
		String subject = request.getParameter("subject");
		String assignmentcategory = request.getParameter("assignmentcategory");
		String dateofsubmission = request.getParameter("dateofsubmission");
		String Points = request.getParameter("Points");
		
		Employee assignmentcategory = new AssignmentCategory();
		employee.setSerialNo(serialno);
		employee.setStudentName(studentname);
		employee.setSubject(Subject);
		employee.setAssignmentCategory(Assignmentcategory);
		employee.setDataofsubmission(dataofsubmission);
		employee.setPoints(points);
		
		try {
			assignmengtcategoryDao.registerAssignmentCategory(assignmengtcategory);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("assignmentcategorydetails.html");
	}
}
