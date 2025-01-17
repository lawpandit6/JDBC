package in.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_Opretions {

	private static final String url = "jdbc:mysql://localhost:3306/jdbc";
	private static final String username = "root";
	private static final String password = "AshokIT@123";

//Create table into jdbc
	public void createTable() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			String sql_Create = "CREATE TABLE BOOKS(b_id INT,b_name VARCHAR(300),b_price DOUBLE)";
			int rowEffected = stmt.executeUpdate(sql_Create);
			System.out.println("rowEffected::" + rowEffected);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//Insert data into jdbc table
	public void insertData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			String sql_Insert = "INSERT INTO BOOKS VALUES (1,'The Comfirt Crisis',120),(2,'The Atomic Habbit',287.3)";
			int rowEffected = stmt.executeUpdate(sql_Insert);
			System.out.println("rowEffected::" + rowEffected);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// Update data into jdbc table
	public void updateData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			String sql_Update = "UPDATE BOOKS SET b_price=100.1 WHERE b_id=2";
			int rowEffected = stmt.executeUpdate(sql_Update);
			System.out.println("rowEffected::" + rowEffected);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//Delete data from jdbc table
	public void deleteDate() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			String sql_Delete = "DELETE FROM BOOKS WHERE b_id=1";
			int rowEffected = stmt.executeUpdate(sql_Delete);
			System.out.println("rowEffected::" + rowEffected);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//Retrieve the data from table
	public void retrieveData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			String sql_Retrieve = "SELECT * FROM BOOKS";
			ResultSet rs = stmt.executeQuery(sql_Retrieve);
			while (rs.next()) {
				System.out.println("b_id = " + rs.getInt(1) + " , b_name = " + rs.getString(2) + " , b_price = "
						+ rs.getDouble(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Jdbc_Opretions jdbc = new Jdbc_Opretions();

		// jdbc.createTable();
		// jdbc.insertData();
		// jdbc.updateData();
		// jdbc.deleteDate();
		// jdbc.retrieveData();
		
	}

}
