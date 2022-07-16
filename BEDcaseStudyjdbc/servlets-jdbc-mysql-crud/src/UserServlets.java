package net.javaguides.AssignmentCategory.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.AssignmentCategory.dao.UserDAO;
import net.javaguides.AssignmentCategory.model.User;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */

@WebServlet("/")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;
	
	public void init() {
		studentDAO = new StudentDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Student> listStudent = studentDAO.selectAllStudents();
		request.setAttribute("listStudents", listStudents);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.html");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.html");
		dispatcher.forward(request, response);
	}
//doubt
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("assignmentcategory"));
		Student existingUser = studentDAO.selectStudent(name);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.html");
		request.setAttribute("user", existingStudent);
		dispatcher.forward(request, response);

	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String assignemntcategory = request.getParameter("assignemntcategory");
		String weight = request.getParameter("weight");
		Student newStudent = new Student(assignmentcategory, weight);
		studentDAO.insertUser(newStudent);
		response.sendRedirect("list");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {

		String assignmentcategory = request.getParameter("assignmentcategory");
		String weight = request.getParameter("weight");

		Student updateStudent = new Student(assignmentcategory, weight);
		studentDAO.updateStudent(updateStudent);
		response.sendRedirect("list");
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		studentDAO.deleteStudent(id);
		response.sendRedirect("list");
	}
}