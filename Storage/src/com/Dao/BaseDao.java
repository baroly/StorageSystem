package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

//	public static void main(String[] args) {
//		getConn();
//	}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() {
		String url = "jdbc:mysql://localhost:3306/companyc?useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String password = "1234";
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static int executeIUD(String sql, Object[] params) {
		int count = 0;
		
		PreparedStatement ps = null;
		Connection conn = BaseDao.getConn();
		
		try {
			ps = conn.prepareCall(sql);
			
			for(int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeAll(null, ps, conn);
		
		return count;
	}
	
	public static void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) {
		
			try {
				if(rs != null)
					rs.close();
				
				if(ps != null)
					ps.close();
				
				if(conn != null)
					conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
