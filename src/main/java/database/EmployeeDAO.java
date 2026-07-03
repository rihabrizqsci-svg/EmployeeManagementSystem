package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import models.Employee;
/**
 * Represents an employee in the Employee Management System.
 *
 * This class stores employee information such as ID,
 * username, password, department, and salary.
 *
 * @author hp
 */
public class EmployeeDAO {

    // Insert Employee
    public void addEmployee(Employee emp) {

        String sql = "INSERT INTO Employees "
                + "(id, username, password, department, salary) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, emp.getId());
            pst.setString(2, emp.getUsername());
            pst.setString(3, emp.getPassword());
            pst.setString(4, emp.getDepartment());
            pst.setDouble(5, emp.getSalary());

            pst.executeUpdate();

            System.out.println("Employee Added Successfully!");

        } catch (SQLException e) {

            System.out.println("Insert Failed!");

            e.printStackTrace();
        }
    }

    // Display Employees
    public void showEmployees() {

        String sql = "SELECT * FROM Employees";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            var rs = pst.executeQuery();

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Salary: " + rs.getDouble("salary"));

                System.out.println("----------------------");
            }

        } catch (SQLException e) {

            System.out.println("Display Failed!");

            e.printStackTrace();
        }
    }
    // Update Employee Salary
public void updateSalary(int id, double newSalary) {

    String sql = "UPDATE Employees SET salary = ? WHERE id = ?";

    try {

        Connection conn = DBConnection.getConnection();

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setDouble(1, newSalary);
        pst.setInt(2, id);

        pst.executeUpdate();

        System.out.println("Salary Updated Successfully!");

    } catch (SQLException e) {

        System.out.println("Update Failed!");

        e.printStackTrace();
    }
    
}
// Delete Employee
public void deleteEmployee(int id) {

    String sql = "DELETE FROM Employees WHERE id = ?";

    try {

        Connection conn = DBConnection.getConnection();

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setInt(1, id);

        pst.executeUpdate();

        System.out.println("Employee Deleted Successfully!");

    } catch (SQLException e) {

        System.out.println("Delete Failed!");

        e.printStackTrace();
    }
    
}
public boolean login(String username, String password) {

    String sql = "SELECT * FROM Employees WHERE username = ? AND password = ?";

    try {

        Connection conn = DBConnection.getConnection();

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, username);
        pst.setString(2, password);

        var rs = pst.executeQuery();

        return rs.next();

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return false;
}
public java.sql.ResultSet getEmployees() {

    String sql = "SELECT * FROM Employees";

    try {

        Connection conn = DBConnection.getConnection();

        PreparedStatement pst = conn.prepareStatement(sql);

        return pst.executeQuery();

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return null;
}
public ResultSet getEmployeesByDepartment(String department) {

    String sql = "SELECT * FROM Employees WHERE department = ?";

    try {

        Connection conn = DBConnection.getConnection();

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, department);

        return pst.executeQuery();

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return null;
}
public ResultSet getEmployeesBySalary(double salary) {

    String sql = "SELECT * FROM Employees WHERE salary >= ?";

    try {

        Connection conn = DBConnection.getConnection();

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setDouble(1, salary);

        return pst.executeQuery();

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return null;
}
public ResultSet searchEmployee(String username) {

    String sql = "SELECT * FROM Employees WHERE username LIKE ?";

    try {

        Connection conn = DBConnection.getConnection();

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, "%" + username + "%");

        return pst.executeQuery();

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return null;
}
public int getEmployeeCount() {

    String sql = "SELECT COUNT(*) FROM Employees";

    try {

        Connection conn = DBConnection.getConnection();

        PreparedStatement pst = conn.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        }

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return 0;
}
public int getDepartmentCount() {

    String sql = "SELECT COUNT(DISTINCT department) FROM Employees";

    try {

        Connection conn = DBConnection.getConnection();

        PreparedStatement pst = conn.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        }

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return 0;
}
public double getTotalSalary() {

    String sql = "SELECT SUM(salary) FROM Employees";

    try {

        Connection conn = DBConnection.getConnection();

        PreparedStatement pst = conn.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getDouble(1);
        }

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return 0;
}
}