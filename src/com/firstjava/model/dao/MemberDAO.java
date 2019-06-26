package com.firstjava.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			
			if(rs.next()) {
				if(rs.getInt("cnt") == 1) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}//findLogin
	
	public boolean insert(MemberVO m) {
		
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
