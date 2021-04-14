package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Modal.Product;
import com.Modal.ProductDetail;

public class ProductDetailDao {
	
	public static void main(String[] args) {
		//insert(new ProductDetail("B140"));
		//System.out.println(productNameJudge("B140"));
		//del("B140");
		
//		ArrayList<String> a = getProductName();
//		System.out.println(a.size());
//		a.forEach(System.out::println);
		
	}
	
	public static ArrayList<String> getProductName(){
		
		ArrayList<String> a = new ArrayList<>();
		String sql = "select * from productdetail";
		Connection conn = BaseDao.getConn();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				a.add(rs.getString("productName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return a;
	}
	
	public static int insert(ProductDetail p) {
		String sql = "insert into productdetail(productName) values(?)";
		Object[] o = {p.getProductName()};
		
		return BaseDao.executeIUD(sql, o);
	}
	
	public static boolean productNameJudge(String name) {
		boolean x = false;
		String sql = "select * from productdetail where productName=?";
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
	
	public static void del(String name) {
		String sql = "delete from productdetail where productName=?";
		
		Object[] obj = {name};
		BaseDao.executeIUD(sql, obj);
	}
}
