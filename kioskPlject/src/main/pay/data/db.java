package main.pay.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import Login.MainF;

public class db {

	Connection conn;
	// MySql private information
	String jdbc = "jdbc:mysql://localhost:3306/data";
	String root = "root";
	String pwd = "dlrlwk86532@";

	public db() {

	}

	public void connectDB() {

		try {
			conn = DriverManager.getConnection(jdbc, root, pwd);
			System.out.println("db 연결 성공");

			conn.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void insert(String id, String seat, String payT, String sTime, String eTime, String product, String price,
			String payType, String menuType) {
		String query = "INSERT INTO paydata VALUE(\"" + id + "\",\"" + seat + "\",\"" + payT + "\",\"" + sTime + "\",\""
				+ eTime + "\",\"" + product + "\",\"" + price + "\",\"" + payType + "\",\"" + menuType + "\");";
		try {
			conn = DriverManager.getConnection(jdbc, root, pwd);
			Statement stat = conn.createStatement();
			stat.executeUpdate(query);

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void update(String id, String seat, String payT, String sTime, String eTime, String product, String price,
			String payType, String menuType) {
		String query = "UPDATE paydata SET SeatNum='"+seat+"',PayTime='"+payT+"',StartTime='"+sTime+"',EndTime='"+eTime+"',ProdName='"+product+"', Price='"+price+"',Method='"+payType+"',Menu='"+menuType+"' WHERE Id='"+id+"';";
//		System.out.println(query);
		try {
			conn = DriverManager.getConnection(jdbc, root, pwd);
	
			Statement stat = conn.createStatement();
			stat.executeUpdate(query);
			
			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public ArrayList<String> select(String a, String tableName) {
		String query = "SELECT " + a + " FROM " + tableName + ";";
		System.out.println(query);
		ResultSet rs;
		ArrayList<String> arr = new ArrayList<String>();
		try {
			conn = DriverManager.getConnection(jdbc, root, pwd);

			Statement stat = conn.createStatement();
			rs = stat.executeQuery(query);

			while (rs.next()) {
				arr.add(rs.getString(a));
			}

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arr;
	}

	public ArrayList<String> selectAll(String tableName, int i) {
		String query = "SELECT * FROM " + tableName + ";";
		ResultSet rs;
		ArrayList<String> arr = new ArrayList<String>();
		try {
			conn = DriverManager.getConnection(jdbc, root, pwd);
//			System.out.println("db 연결 성공");
//			System.out.println(query);
			Statement stat = conn.createStatement();
			rs = stat.executeQuery(query);

			while (rs.next()) {
				arr.add(rs.getString(i) + "_" + rs.getString(4) + "_" + rs.getString(5));
			}

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arr;
	}

	// column명 arr 반환
	public ArrayList<String> colLookUp(String tableName) {
		String query = "SELECT * FROM " + tableName + ";";
		ResultSet rs;
		ResultSetMetaData rsmd;
		ArrayList<String> arr = new ArrayList<String>();
		try {
			conn = DriverManager.getConnection(jdbc, root, pwd);
//			System.out.println("db 연결 성공");

			Statement stat = conn.createStatement();
			rs = stat.executeQuery(query);
			rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				arr.add(rsmd.getColumnName(i));
			}

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arr;
	}

	public void delete(String tableName, String condition) {

		String query = "DELETE FROM " + tableName + condition+";";
		ResultSet rs;
		try {
			conn = DriverManager.getConnection(jdbc, root, pwd);
//			System.out.println("db 연결 성공");

			PreparedStatement stat = conn.prepareStatement(query);
			stat.executeUpdate();

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void dml(String query) {
		try {
			System.out.println(query);
			conn = DriverManager.getConnection(jdbc, root, pwd);
			Statement stat = conn.createStatement();
			stat.executeUpdate(query);

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}
}