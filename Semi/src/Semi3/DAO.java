package Semi3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DAO {
	//1.����̹� ����
	public DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� �����ϴ�");
			e.printStackTrace();
		}
	}
	//2. ����Ŭ�� ����
	public Connection getConnection() {
		Connection conn=null;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="C##semiuser";
		String password="m1234";
		try {
			conn=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			System.out.println("����Ŭ�� ���� ����");
			e.printStackTrace();
		}
		return conn;
	}
	//3.SQL �۾�ó��
	public void insert(DTO dto, int year, int month) {
		int su=0;
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		String sql="insert into memo values (?,?,?, ?, ? , ? , ?, ?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, year);
			pstmt.setInt(2, month);
			pstmt.setString(3, dto.getId());
			pstmt.setString(4, dto.getTitle());
			pstmt.setString(5, dto.getTime1());
			pstmt.setString(6, dto.getTime2());
			pstmt.setString(7, dto.getColor());
			pstmt.setString(8, dto.getMemo());
			//4.ó���� ��� ����
			su=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//5. ���� ����
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	

}
