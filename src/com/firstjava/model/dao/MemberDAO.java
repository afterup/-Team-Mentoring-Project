package com.firstjava.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import com.firstjava.model.vo.MemberVO;

public class MemberDAO {

	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;

	Properties pro;

	public MemberDAO() {
		try {
			pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));
			Class.forName(pro.getProperty("driver"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// 생성자
	
	
	public boolean updateMember(MemberVO m) {

		connect();
		try {

			String sql = "update member set email = ?, phone = ? where userid = ?";

			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, m.getEmail());
			stmt.setString(2, m.getPhone());
			stmt.setString(3, m.getUserId());
		

			stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	
	public boolean updatePass(String newPass,MemberVO m) {

		connect();
		try {

			String sql = "update member set pass = ?, "
					+ "where userid = ? and pass = ";

			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, newPass);
			stmt.setString(2, m.getUserId());
			stmt.setString(3, m.getPassword());
		

			stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}// insert
	


	public boolean joinMember(MemberVO m) {

		connect();
		try {

			String sql = "insert into member values (?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, m.getUserId());
			stmt.setString(2, m.getPassword());
			stmt.setString(3, m.getUname());
			stmt.setString(4, m.getEmail());
			stmt.setString(5, m.getPhone());

			stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}// insert



	public String deleteMember(String name) {
		connect();

		try {

			String sql = "DELETE FROM member WHERE userid=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);

			stmt.executeUpdate();
			return "강퇴되었습니다.";
		} catch (SQLException e) {
			disconnect();
		}
		return "강퇴에 실패하였습니다.";

	}
	
	public int findExistId(String id) {
		connect();
		int count = 0;
		try {
			String sql = "select count(*) as count from member where userid= ?";

			stmt = conn.prepareStatement(sql);// sql문 DB에 전송
			// stmt.set자료형(물음표인덱스1~, 설정데이터);//?(바인드변수)에 대한 데이터 설정
			stmt.setString(1, id);
			rs = stmt.executeQuery();// 전송한 sql문 실행요청
			if (rs.next()) {
				count = rs.getInt("count");// rs.getInt(인덱스1,2,3..또는 "컬럼명" 또는 "별명")
				System.out.println(count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return count;
	}// findExistId
	
	public boolean findLogin(String id, String pass) {

		connect();
		try {
			String sql = "select count(*) cnt from member where userid = ? and password = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pass);

			rs = stmt.executeQuery();

			if (rs.next()) {
				if (rs.getInt("cnt") == 1) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}// findLogin
	
	public String findId(String name, String email) {
		connect();
		String id = "";
		try {
			String sql = "select userid  FROM member " + "where uname= ? and email = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, email);

			rs = stmt.executeQuery();

			if (rs.next()) {
				id = rs.getString("userid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return id;

	}
	
	public ArrayList<MemberVO> selectMember(String id) // 회원정보 조회
	{
		connect();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();

		try {
			String sql = "SELECT * FROM member WHERE userid =?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				list.add(new MemberVO(rs.getString("userid"), "", rs.getString("uname"),
						rs.getString("email"), rs.getString("phone")));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}// find
	
	public String findPass(String id, String name, String email) {
		connect();
		String pass = "";
		try {
			String sql = "select password  FROM member " + "where userid = ? and uname= ? and email = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, name);
			stmt.setString(3, email);

			rs = stmt.executeQuery();

			if (rs.next()) {
				pass = rs.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return pass;

	}

	public ArrayList<MemberVO> searchMember(Map<String, String> map) {
		connect();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		String title = map.get("title");
		String keyword = map.get("keyword");

		try {

			String sql = "select userid, uname, email, phone from member ";

			if (title.equals("아이디"))
				sql += "where userid like ?";
			else if (title.equals("이름"))
				sql += "where uname like ?";
			else if (title.equals("이메일"))
				sql += "where email like ?";
			else if (title.equals("전화번호"))
				sql += "where phone like ?";

			stmt = conn.prepareStatement(sql);// sql문 전송
			stmt.setString(1, "%" + keyword + "%");// '%홍%'
			rs = stmt.executeQuery();// sql문 실행요청(실행시점!!)
			// 덩어리


			while (rs.next()) {// 행얻기
				// 열데이터 얻기
				MemberVO vo = new MemberVO();
				// 7개의 관련있는 속성데이터를 묶어주기 위해 사용.
				vo.setUserId(rs.getString("userid"));
				vo.setUname(rs.getString("uname"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));

				list.add(vo);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}// findAll

	public ArrayList<MemberVO> selectAll() { // 회원정보 전체조회
		connect();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			String sql = "SELECT userid, uname, email, phone FROM member";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setUserId(rs.getString("userid"));
				vo.setUname(rs.getString("uname"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}// MemberTable

	private void connect() {
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// connect

	private void disconnect() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// disconnect

}
