package com.paceup.JDBC;

import java.sql.*;

/**
 * JDBCExample:
 * ------------
 * 
 * Key Concepts:
 * -------------
 * 1. **JDBC**:
 *    - API for connecting Java applications to relational databases.
 *    - Provides interfaces for Connection, Statement, PreparedStatement, ResultSet.
 *
 * 2. **DriverManager.getConnection()**:
 *    - Establishes connection to database using URL, username, password.
 *
 * 3. **Statement vs PreparedStatement**:
 *    - Statement: executes static SQL queries.
 *    - PreparedStatement: executes parameterized queries (prevents SQL injection).
 *
 * 4. **CRUD Operations**:
 *    - CREATE → Insert new records.
 *    - READ   → Retrieve records.
 *    - UPDATE → Modify existing records.
 *    - DELETE → Remove records.
 *
 * Backend Working:
 * ----------------
 * - `connect()`:
 *   → Loads MySQL driver (`Class.forName`).
 *   → Establishes connection via `DriverManager`.
 *   → Creates table `students` if not exists.
 *
 * - `createStudent()`:
 *   → Uses PreparedStatement to insert student record.
 *
 * - `readStudents()`:
 *   → Executes SELECT query, iterates ResultSet to print records.
 *
 * - `updateStudent()`:
 *   → Updates student name by ID, then calls `readStudents()` to show changes.
 *
 * - `deleteStudent()`:
 *   → Deletes student by ID, then calls `readStudents()` to show remaining records.
 *
 * Expected Output:
 * ----------------
 * Table 'students' created successfully.
 * Student added successfully
 * Student added successfully
 * ID: 1, Name: Aishwarya
 * ID: 2, Name: Diya
 * Student updated successfully
 * ID: 1, Name: Aishwarya Jadhav
 * ID: 2, Name: Diya
 * Student deleted successfully
 * ID: 2, Name: Diya
 */
public class JDBCExample {

    // Method to establish a connection
    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/student2";
        String user = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, user, password);

        String createTableQuery = "CREATE TABLE IF NOT EXISTS students (" +
                "id INT PRIMARY KEY, " +
                "name VARCHAR(100)" +
                ")";

        try {
            // Load JDBC Driver (optional in Java 6+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create statement and execute query
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(createTableQuery);

            System.out.println("Table 'students' created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    // CREATE operation
    public static void createStudent(int id, String name) {
        String sql = "INSERT INTO students (id, name) VALUES (?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            System.out.println("Student added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ operation
    public static void readStudents() {
        String sql = "SELECT * FROM students";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE operation
    public static void updateStudent(int id, String newName) {
        String sql = "UPDATE students SET name = ? WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Student updated successfully");
            readStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE operation
    public static void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Student deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        readStudents();
    }

    public static void main(String[] args) {
        createStudent(1, "Aishwarya");
        createStudent(2, "Diya");
        readStudents();
        updateStudent(1, "Aishwarya Jadhav");
        deleteStudent(1);
    }
}
