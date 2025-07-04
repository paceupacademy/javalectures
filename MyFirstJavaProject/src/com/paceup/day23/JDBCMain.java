package com.paceup.day23;
import java.sql.Connection;  //Establishes connection between application and DB
import java.sql.DriverManager; //Manages list of database drivers. Matches conn requests from app with appropriate driver
import java.sql.PreparedStatement; //PreCompiled SQL statement used for execution of parameterized queries
import java.sql.ResultSet; //Holds data retrieved from a SELECT query
import java.sql.SQLException;
import java.sql.Statement; // Used for executing SQL queries

public class JDBCMain {

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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		readStudents();
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

	// Main method to test JDBC operations
	public static void main(String[] args) {
		// Example usage
		createStudent(3, "Aishwarya");
		readStudents();
		updateStudent(3, "Aishwarya Jadhav");
		deleteStudent(3);
	}

}
