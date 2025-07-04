package com.paceup.day23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

	// Method to establish a connection
	public static Connection connect() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/student";
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
		}catch(Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	// Method to perform CREATE operation
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

	// Method to perform READ operation
	public static void readStudents() {
		String sql = "SELECT * FROM students";
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Method to perform UPDATE operation
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

	// Method to perform DELETE operation
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
		// TODO Auto-generated method stub
		createStudent(1, "Aishwarya");
		createStudent(2, "Diya");
		readStudents();
		updateStudent(1, "Aishwarya Jadhav");
		deleteStudent(1);

	}

}
