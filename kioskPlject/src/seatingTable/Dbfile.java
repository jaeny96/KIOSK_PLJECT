package seatingTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Dbfile {
	Connection conn;
	String jdbc = "jdbc:mysql://localhost:3306/coderium";
	String root = "root";
//	String pwd = "1234";
	String pwd = "1234";
	
	public Dbfile() {
		
	}
	
	public void connectDB() {
		try {
			conn = DriverManager.getConnection(jdbc, root, pwd);
			System.out.println("db 연결 성공");
			
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}
	
	public void dml(String query) {
		try {
			conn = DriverManager.getConnection(jdbc,root,pwd);
			System.out.println("db 연결 성공");

			Statement stat = conn.createStatement();
			stat.executeUpdate(query);

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}
	//좌석 db부르는 select
	public ArrayList<String> select(String a, String query1) {
		String query = query1;	
		ResultSet rs;
		ArrayList<String> seat = new ArrayList<String>();
		try {
			conn = DriverManager.getConnection(jdbc,root,pwd);
			System.out.println("db 연결 성공");

			Statement stat = conn.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
				seat.add(rs.getString(a));
			}

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return seat;
	}
	//start 시간 부르는 select
	public ArrayList<String> t_select(String a, String query1) {
		String query = query1;	
		ResultSet rs;
		ArrayList<String> start = new ArrayList<String>();
		try {
			conn = DriverManager.getConnection(jdbc,root,pwd);
			System.out.println("db 연결 성공");

			Statement stat = conn.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
				start.add(rs.getString(a));
			}

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return start;
	}
	//예약 시간!
	public ArrayList<String> r_select(String a, String tableName) {
		String query = "select * from "+ tableName +";";	
		ResultSet rs;
		ArrayList<String> r_start = new ArrayList<String>();
		try {
			conn = DriverManager.getConnection(jdbc,root,pwd);
			System.out.println("db 연결 성공");

			Statement stat = conn.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
				r_start.add(rs.getString(a));
			}

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return r_start;
	}
}
