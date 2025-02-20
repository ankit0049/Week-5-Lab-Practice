package com.generatejsonreportfromdatabase;

import java.sql.*;
import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * This class connects to a MySQL database, fetches employee records,
 * and generates a JSON report displaying the retrieved data.
 */
public class DatabaseToJsonReport {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/company_db";
        String user = "root";
        String password = "password";
        String query = "SELECT EmployeeID, Name, Department, Salary FROM Employees";

        // Try-with-resources to ensure automatic resource management
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Create a JSON array to store employee records
            JSONArray employeeArray = new JSONArray();

            // Iterate through the result set and convert records to JSON format
            while (rs.next()) {
                JSONObject employee = new JSONObject();
                employee.put("EmployeeID", rs.getInt("EmployeeID"));
                employee.put("Name", rs.getString("Name"));
                employee.put("Department", rs.getString("Department"));
                employee.put("Salary", rs.getDouble("Salary"));
                employeeArray.put(employee);
            }

            // Print the generated JSON report in a readable format
            System.out.println(employeeArray.toString(4));
        } catch (Exception e) {
            // Handle any SQL or JSON exceptions
            e.printStackTrace();
        }
    }
}
