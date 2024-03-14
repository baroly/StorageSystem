package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Modal.Vendor;

public class VendorDao {
	
	public static void main(String[] args) {
//		insert(new Vendor("早安", "午安", "123"));
//		ArrayList<String> a = getAllVendor("kindom");
//		a.forEach(System.out::println);
	}
	
	public static ArrayList<String> getAllVendor(){
		ArrayList<String> a = new ArrayList<>();
		String sql = "select * from vendor";
		Connection conn = BaseDao.getConn();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		a.add("--");
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				a.add(rs.getString("VendorName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return a;
	}
	
	public static ArrayList<String> getAllVendor(String name){
		ArrayList<String> a = new ArrayList<>();
		String sql = "select * from vendor";
		Connection conn = BaseDao.getConn();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		a.add(name);
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String get = rs.getString("VendorName");
				if(get.indexOf(name) < 0) {
					a.add(get);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//a.forEach(System.out::println);
		
		return a;
	}
	
	public static int insert(Vendor v) {
		String sql = "insert into vendor(VendorName,ProductPrincipal,VendorID) values(?,?,?)";
		Object[] o = {v.getVendorName(),
					v.getProductPrincipal(),
					v.getVendorID()};
		
		return BaseDao.executeIUD(sql, o);
	}
	
	public static boolean judgeName(String name) {
		boolean x = false;
		String sql = "select * from vendor where VendorName=?";
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
