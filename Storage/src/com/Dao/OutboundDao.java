package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.Modal.Outbound;

public class OutboundDao {

	public static void main(String[] args) {
		
//		int a = insert(new Outbound("sell", "12345", "Leo", "20210408", "Google"));
//		System.out.println(a);
		
//		boolean b = judgeName("12345s");
//		System.out.println(b);
	}
	
	public static int insert(Outbound out) {
		Date date = new Date();
		String today = (date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-" + date.getDate();
		
		String sql = "insert into outbound(serialNum,type,fillingName,fillingDate,client) values(?,?,?,?,?)";
//		System.out.println(out.getFillingDate());
//		System.out.println(out.getType());
//		System.out.println(out.getSerialNum());
//		System.out.println(out.getFillingName());
//		System.out.println(out.getClient());
		
		Object[] o = {out.getSerialNum(),
					out.getType(),
					out.getFillingName(),
					today,
					out.getClient()};
		
		return BaseDao.executeIUD(sql, o);
	}
	
	public static boolean judgeName(String name) {
		boolean x = false;
		String sql = "select * from outbound where serialNum=?";
		Connection conn = BaseDao.getConn();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			x = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return x;
	}

}
