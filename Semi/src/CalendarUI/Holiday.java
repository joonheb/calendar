package CalendarUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Holiday{
	private int year, month;
	private String holiday ="";
	private int day;
	private boolean isHoliday = false;
	private String result="";
	
	public Holiday(int year, int month) {
		this.year = year;
		this.month = month;
		DriverLoading();
	}
	
	public void DriverLoading() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##semiuser";
		String password = "m1234";
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void selectArticle2() {
		// DB
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select month, day, holiday from Holiday where year is null and month=?";
		
		try {
			pstmt = conn.prepareStatement(sql);	// 생성
			pstmt.setInt(1,  month);
			rs = pstmt.executeQuery();			// 실행 -> 결과값 저장
			
			while(rs.next()) {
				month = rs.getInt("month");
				day = rs.getInt("day");
				holiday = rs.getString("holiday");
				isHoliday = true;
				result =result+month+"\t"+day+"\t"+holiday+"\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void selectArticle() {
		// DB
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select month, day, holiday from Holiday where year=? and month=?";
		
		try {
			pstmt = conn.prepareStatement(sql);	// 생성
			pstmt.setInt(1, year);
			pstmt.setInt(2,  month);
			rs = pstmt.executeQuery();			// 실행 -> 결과값 저장
			
			while(rs.next()) {
				month = rs.getInt("month");
				day = rs.getInt("day");
				holiday = rs.getString("holiday");
				isHoliday = true;
				result =result+month+"\t"+day+"\t"+holiday+"\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public boolean isHoliday() {
		return isHoliday;
	}
	

	public String getHoliday() {
		return holiday;
	}

	public int getDay() {
		return day;
	}

	public String getResult() {
		return result;
	}


}
