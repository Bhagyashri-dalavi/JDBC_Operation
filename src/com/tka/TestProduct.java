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
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM student");
			//execute query
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
