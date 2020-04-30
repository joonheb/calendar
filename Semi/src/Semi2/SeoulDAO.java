package Semi2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import Semi1.MemberDTO;

public class SeoulDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	boolean isExit = false;
	String str;

	/* 1. Driver Loading */
	public SeoulDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/* 2. Connection */
	public Connection getConn() {
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

	/* tourCode 검색 */
	public void selectTourCode(int num) {
		Connection con = getConn(); // 연결
		PreparedStatement ps = null; // 명령
		String sql = "select tourCode from seoul where num = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			while (rs.next()) {
//				SeoulDTO seoulDTO = new SeoulDTO();
//				seoulDTO.setTourCode(rs.getString("tourCode"));
//				str = seoulDTO.getTourCode();
				str = rs.getString("tourCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	/* foodCode 검색 */
	public String selectFoodCode(int num) {
		Connection con = getConn(); // 연결
		PreparedStatement ps = null; // 명령
		String sql = "select foodCode from seoul where num = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				str = rs.getString("foodCode");
				System.out.println("2");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return str;
	}

//	/* tourCode 검색 */
//	public List<SeoulDTO> selectTourCode() {
//		Connection con = null;
//		PreparedStatement ps = null;
//		List<SeoulDTO> list = new ArrayList<SeoulDTO>();
//		String sql = "select tourCode from tb_seoul where count = ?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				SeoulDTO seoulDTO = new SeoulDTO();
//				seoulDTO.setNum(rs.getInt("num"));
//			
//				list.add(seoulDTO);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close();			
//		}
//		return list;
//	}
	public void close() {
		try {
			if (conn != null)
				conn.close();
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public static void main(String[] args) {
		SeoulDAO aa = new SeoulDAO();
		String str = aa.selectFoodCode(24);
		System.out.println(str);
	}
}