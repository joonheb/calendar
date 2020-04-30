package Semi1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/* 1. Driver Loading */
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	/* 2. Connection */
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

	/** 회원 등록 */
	public boolean insertMember(MemberDTO dto) {
		boolean ok = false;

		try {

			conn = getConnection();
			String sql = "insert into tb_member values(?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getAddr());
			pstmt.setString(6, dto.getBirth());
			pstmt.setString(7, dto.getEmail());
			int r = pstmt.executeUpdate(); // 실행 -> 저장

			if (r > 0) {
				System.out.println("가입 성공");
				ok = true;
			} else {
				System.out.println("가입 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력정보 부족");
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		}
		return ok;
	}

	
	//로그인
	public MemberDTO memberLogin(String id, String pwd) {
		Connection conn = getConnection();
		MemberDTO memberDTO = new MemberDTO();
		String sql = "select * from TB_MEMBER where id = ? and pwd = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setName(rs.getString("name"));
				memberDTO.setTel(rs.getString("tel"));
				memberDTO.setAddr(rs.getString("addr"));
				memberDTO.setBirth(rs.getString("birth"));
				memberDTO.setEmail(rs.getString("email"));
			}
			
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("데이터 읽어오기 실패");
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}

}