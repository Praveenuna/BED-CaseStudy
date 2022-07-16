package net.javaguides.employeemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguides.employeemanagement.model.Employee;

public class AssignmentCategory {

    public int registerAssignmentCategory(AssignmentCategory assignmentcategory) throws ClassNotFoundException {
        String INSERT_ASSIGNMENT_SQL = "INSERT INTO AssignmentCategory" +
            "  (getSerialNo, getStudentName, getSubject, getAssignmentCategory,getDateofsubmissiom,getPoints) VALUES " +
            " (?, ?, ?, ?, ?,?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "100106");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ASSIGNMENT_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, Aassignmentcategory.getSerialNo());
            preparedStatement.setString(3, AssignmentCategory.getStudentName());
            preparedStatement.setString(4, AssignmentCategory.getSubject());
            preparedStatement.setString(5, AssignmentCategory.getAssignmentCategory());
            preparedStatement.setString(6, AssignmentCategory.getDateofsubmissiom());
            preparedStatement.setString(7, AssignmentCategory.getPoints());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}