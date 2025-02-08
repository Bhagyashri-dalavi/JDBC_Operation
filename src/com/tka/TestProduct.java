package com.tka;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestProduct {
	

	public static void main(String[] args) {
		//create connection
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//get connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbms1", "root", "root");
			//write query
			
			PreparedStatement statement = connection.prepareStatement("Insert into student (id, name,course,cgpa) values(?,?,?,?)");
			statement.setInt(1,101);
			statement.setString(2, "pooja");
			statement.setString(3, "BCA");
			statement.setString(4, "8.8");
			
			//execute query
			int rows = statement.executeUpdate();
			
			if(rows>0) {
				System.out.println("Student record added successfully");
			}
			PreparedStatement ps =connection.prepareStatement("SELECT * FROM student");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				//get data
				System.out.print(rs.getInt("id")+ " | ");
				System.out.print(rs.getString("name")+ " | ");
				System.out.print(rs.getString("course")+ " | ");
				System.out.print(rs.getString("cgpa")+ " | ");
				System.out.println();		
			}
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
