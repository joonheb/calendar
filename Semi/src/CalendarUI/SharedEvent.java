package CalendarUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SharedEvent {
	private String id, title, starttime, endtime, color, text;
	String result="";
	
	public SharedEvent(int year, int month) {
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
	
	public void selectEvent(int year, int month) {
		// DB
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select title, starttime, endtime, color from memo where year=? and month=?";
		
		try {
			pstmt = conn.prepareStatement(sql);	// 积己
			pstmt.setInt(1, year);
			pstmt.setInt(2,  month);
			rs = pstmt.executeQuery();			// 角青 -> 搬苞蔼 历厘
			
			while(rs.next()) {
				title = rs.getString("title");
				starttime = rs.getString("starttime");
				endtime = rs.getString("endtime");
				color = rs.getString("color");
				
				//"力格 / 2019-11-27/ 2019-12-29 / 255,0,0"
				result =result+title+"/"+starttime+"/"+endtime+"/"+color+"\n";
				//System.out.println(result);
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
	
	public void selectEventAll(int year, int month) {
		// DB
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select id, title, text from memo where year=? and month=?";
		
		try {
			pstmt = conn.prepareStatement(sql);	// 积己
			pstmt.setInt(1, year);
			pstmt.setInt(2,  month);
			rs = pstmt.executeQuery();			// 角青 -> 搬苞蔼 历厘
			
			while(rs.next()) {
				//id, title, start_time, end_time, color, text
				id = rs.getString("id");
				title = rs.getString("title");
//				starttime = rs.getString("starttime");
//				endtime = rs.getString("endtime");
//				color = rs.getString("color");
				text = rs.getString("text");
				
				//"力格 / 2019-11-27/ 2019-12-29 / 255,0,0"
				result =result+id+"/"+title+"/"+text+"\n";
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
	
	public String getResult() {
		return result;
	}

}
