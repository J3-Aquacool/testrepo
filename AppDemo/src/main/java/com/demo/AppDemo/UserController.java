package com.demo.AppDemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;



public class UserController {


	private DataSource dataSource;

	
	public String getUser(String username) throws SQLException {
		// BAD: Vulnerable to SQL Injection
		String query = "SELECT * FROM users WHERE username = '" + username + "'";
		try (Connection conn = dataSource.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			if (rs.next()) {
				return "Welcome " + rs.getString("username");
			}
			return "User not found";
		}
	}
}