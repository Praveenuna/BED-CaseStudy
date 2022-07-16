package net.javaguides.AssignmentCategory.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.employeemanagement.dao.EmployeeDao;
import net.javaguides.employeemanagement.model.Employee;



@WebServlet("/register")
public class AssignmentCatogeryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AssignmentCategoryDao AssignmentCategoryDao;

    public void init() {
        AssignmentCategoryDao = new AssignmentCategoryDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String SerialNo = request.getParameter("SerialNo");
        String StudentName = request.getParameter("StudentName");
        String Subject = request.getParameter("Subject");
        String AssignmentCategory = request.getParameter("AssignmentCategory");
        String Dataofsubmission = request.getParameter("Dataofsubmission");
        String Points = request.getParameter("Points");

        Employee AssignmentCategory = new AssignmentCategory();
        employee.setSerialNo(serialNo);
        employee.setStudentName(studentName);
        employee.setSubject(subject);
        employee.setPAssignmentCategory(assignmentcategory);
        employee.setDataofsubmission(dataofsubmission);
        employee.setPoints(Points);

        try {
            assignmentcategoryDao.registerAssignmentCategory(assignmentcategory);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("AssignmentCategorydetails.html");
    }
}