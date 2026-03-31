package com.paceup.JDBC;

import java.sql.*;

/**
 * JDBCMain:
 * ---------
 * Demonstrates CRUD operations (Create, Read, Update, Delete) using JDBC with MySQL.
 *
 * Key Concepts:
 * -------------
 * 1. JDBC API → Interfaces for connecting Java apps to relational databases.
 *    - Connection, Statement, PreparedStatement, ResultSet.
 *
 * 2. DriverManager.getConnection() → Establishes DB connection using URL, username, password.
 *
 * 3. Statement vs PreparedStatement:
 *    - Statement → Executes static SQL queries.
 *    - PreparedStatement → Executes parameterized queries (prevents SQL injection).
 *
 * 4. CRUD Operations:
 *    - CREATE → Insert new records.
 *    - READ   → Retrieve records.
 *    - UPDATE → Modify existing records.
 *    - DELETE → Remove records.
 */
public class JDBCMain {

    /**
     * Establishes connection and ensures database/table exist.
     */
    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "root";

        // Step 1: Establish connection to MySQL server
        Connection conn = DriverManager.getConnection(url, user, password);

        // Step 2: SQL commands for DB and table setup
        String dbsql = "CREATE DATABASE IF NOT EXISTS Students";
        String usedb = "USE Students";
        String createTableQuery = "CREATE TABLE IF NOT EXISTS students (" +
                                  "id INT PRIMARY KEY, " +
                                  "name VARCHAR(100)" +
                                  ")";

        try {
            // Step 3: Load JDBC Driver (optional in modern Java, but good practice)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 4: Create statement object
            Statement stmt = conn.createStatement();

            // Step 5: Execute DB creation
            stmt.executeUpdate(dbsql);
            System.out.println("Database 'Students' created or already exists.");

            // Step 6: Switch to Students DB
            stmt.execute(usedb);
            System.out.println("Database in use: Students");

            // Step 7: Create table if not exists
            stmt.executeUpdate(createTableQuery);
            System.out.println("Table 'students' created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * CREATE operation → Insert new student record.
     */
    public static void createStudent(int id, String name) {
        String sql = "INSERT INTO students (id, name) VALUES (?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Bind parameters
            pstmt.setInt(1, id);
            pstmt.setString(2, name);

            // Execute insert
            pstmt.executeUpdate();
            System.out.println("Student added successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * READ operation → Fetch all students.
     * Shows Statement usage, with PreparedStatement code commented for reference.
     */
    public static void readStudents() {
        String sql = "SELECT * FROM students"; // Fetch all records

        // Alternative PreparedStatement query (commented out)
        // String sql = "SELECT * FROM students WHERE id=?";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            /*
             * PreparedStatement Example (commented):
             * --------------------------------------
             * PreparedStatement pstmt = conn.prepareStatement(sql);
             * pstmt.setInt(1, 2); // Example: fetch student with id=2
             * ResultSet rs = pstmt.executeQuery();
             */

            // Execute query using Statement
            ResultSet rs = stmt.executeQuery(sql);

            // Iterate through results
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * UPDATE operation → Change student name by ID.
     */
    public static void updateStudent(int id, String newName) {
        readStudents(); // Show current records
        System.out.println();

        String sql = "UPDATE students SET name = ? WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Bind parameters
            pstmt.setString(1, newName);
            pstmt.setInt(2, id);

            // Execute update
            pstmt.executeUpdate();
            System.out.println("Student updated successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        readStudents(); // Show updated records
    }

    /**
     * DELETE operation → Remove student by ID.
     */
    public static void deleteStudent(int id) {
        readStudents(); // Show current records
        System.out.println();

        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Bind parameter
            pstmt.setInt(1, id);

            // Execute delete
            pstmt.executeUpdate();
            System.out.println("Student deleted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        readStudents(); // Show remaining records
    }

    /**
     * Main method → Demonstrates CRUD operations.
     */
    public static void main(String[] args) {
        // CREATE
        createStudent(15, "Aishwarya");

        // READ
        readStudents();

        // UPDATE
        updateStudent(15, "Aishwarya Jadhav");

        // DELETE
        deleteStudent(15);

        // Add more students
        createStudent(2, "Neha");
        createStudent(3, "Shraddha");

        System.out.println("\nFinal Records:");
        readStudents();
    }
}

/*
┌─────────────────────┐
│   Class.forName()   │
│ Loads JDBC Driver   │
└─────────┬───────────┘
          │
          ▼
┌─────────────────────┐
│ DriverManager       │
│ getConnection()     │
│ → returns Connection│
└─────────┬───────────┘
          │
          ▼
┌─────────────────────┐
│ Connection Object   │
│ Represents DB link  │
└─────────┬───────────┘
          │
┌─────────┴───────────┐
│                     │
▼                     ▼
┌───────────────┐   ┌──────────────────┐
│ Statement     │   │ PreparedStatement│
│ Static SQL    │   │ Parameterized SQL│
└───────┬───────┘   └─────────┬────────┘
        │                     │
        ▼                     ▼
┌───────────────────────────────┐
│ 		ResultSet               │
│       Holds query results     │
└────────────────┬──────────────┘
                 │
                 ▼
	┌─────────────────────┐
	│ Application Logic   │
	│ Iterates ResultSet  │
	│ Prints/Processes    │
	└─────────────────────┘
*/