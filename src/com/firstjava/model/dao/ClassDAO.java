package com.firstjava.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.firstjava.model.vo.ClassVO;

public class ClassDAO {

	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;

	Properties pro;// DB접속관련 정보 저장 객체

	public ClassDAO() {
		try {
			pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));
			Class.forName(pro.getProperty("driver"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// 생성자

	public ArrayList<ClassVO> search(String category) { // 검색
		connect();	
		ArrayList<ClassVO> list = new ArrayList<ClassVO>();
		
		try {
			String sql = "select  * from class " + "where lower(cname) like lower(?)";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, "%" + category + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {

				ClassVO vo = new ClassVO();
				vo.setClassno(rs.getInt("classid"));
				vo.setClassinfo(rs.getString("classinfo"));
				vo.setUserid(rs.getString("userid"));
				vo.setCateno(rs.getInt("cateno"));
				vo.setCname(rs.getString("cname"));
				vo.setOpenDate(rs.getString("opendate"));
				vo.setCloseDate(rs.getString("closedate"));
				vo.setStudent(rs.getInt("student"));
				vo.setLimit(rs.getInt("limit"));

				list.add(vo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

	public ArrayList<ClassVO> findAll() { // 전체검색
		connect();
		ArrayList<ClassVO> list = new ArrayList<ClassVO>();
		try {
			String sql = "select * from class";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();//
			// 덩어리

			while (rs.next()) {// 행얻기
				// 열데이터 얻기
				ClassVO vo = new ClassVO();
				// 7개의 관련있는 속성데이터를 묶어주기 위해 사용.

				vo.setClassno(rs.getInt("classid"));
				vo.setClassinfo(rs.getString("classinfo"));
				vo.setUserid(rs.getString("userid"));
				vo.setCateno(rs.getInt("cateno"));
				vo.setCname(rs.getString("cname"));
				vo.setOpenDate(rs.getString("opendate"));
				vo.setCloseDate(rs.getString("closedate"));
				vo.setStudent(rs.getInt("student"));
				vo.setLimit(rs.getInt("limit"));

				list.add(vo);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}// findAll

	private void connect() {// 연결객체생성
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void disconnect() {// DB자원반환
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}// ClassDAO
