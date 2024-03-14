package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.Modal.Product;
import com.Modal.ProductOrder;

public class ProductDao {
	public static void main(String[] args) {
//		Product p = new Product("伊",
//					"q",
//					"c",
//					"unknow",
//					"stored",
//					0);
//		insert(p);
//		ArrayList<ProductOrder> a = selectSName("T100S101-125");
//		for(ProductOrder c : a) {
//			System.out.println(c.getProductSerialNum() + "\t  " +
//					c.getProductNum() + "\t  " +
//					c.getAmount() + "\t  " +
//					c.getInternalContent() + "\t  " +
//					c.getStatus());
//		}
		
//		ArrayList<String> e = new ArrayList<String>();
//		e.add("1");
//		System.out.println(e.isEmpty());
		
//		ArrayList<Product> a = selectAll("ac");
//		for(Product c : a) {
//			System.out.println(c.getProductSerialNum());
//		}
//		
//		ArrayList<Product> a = selectType("inLoan", "fvccx569");
//		for(Product c : a) {
//			System.out.println(c.getProductSerialNum());
//		}
		
//		ArrayList<Product> pi = getProductByOrder("T100S101-11");
//		Iterator<Product> i = pi.iterator();
//		while(i.hasNext()) {
//			Product pp = i.next();
//			System.out.println(pp.getProductSerialNum());
//		}
		
		//System.out.println(selectStorageInScan("20210222", "022201", "a1"));
		
		//updateStorage("022201", "a2");
		
//		String confirm = confirmCanOut(new Product("A-13T002", "z11", 1));
//		System.out.println(confirm);
		
	}
	//ProductSerialNum,ProductName,ProductSerialNumT,Principal,Status,InternalContent) value('a','b','unknow','stored','s',0
	public static void insert(Product p) {
		String sql = "insert into product(ProductSerialNum,ProductName,ProductSerialNumT,Principal,"
				+ "Status,InternalContent) values(?,?,?,?,?,?)";
		Object[] o = {p.getProductSerialNum(),
					p.getProductName(),
					p.getProductSerialNumT(),
					p.getPrincipal(),
					p.getStatus(),
					p.getInternalContent()};
		
		BaseDao.executeIUD(sql, o);
	}
	
	public static String confirmCanOut(Product p) {
		String x = "error";
		String sql;
		Connection conn = BaseDao.getConn();
		
		try {
			sql = "select * from product where ProductName=? and ProductSerialNum=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getProductName());
			ps.setString(2, p.getProductSerialNum());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				if(p.getInternalContent() > 0) {
					if((rs.getInt("InternalContent") - p.getInternalContent()) > 0) {
						x = "pass";
					}else {
						x = "contentIsntEnough";
					}
				}else {
					x = "pass";
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return x;
	}
	
	public static ArrayList<ProductOrder> selectSName(String name) {
		ArrayList<ProductOrder> list = new ArrayList<ProductOrder>();

		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = BaseDao.getConn();

		try {
			String sql = "select * from productorder where CompanyOrderNum='"+ name +"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				ProductOrder p = new ProductOrder(rs.getString("ProductNum"),
						rs.getString("ProductSerialNumT"),
						rs.getInt("amount"),
						rs.getInt("InternalContent"),
						rs.getString("Status"));
//				System.out.println(rs.getString("CompanyOrderNum") + "\t" +
//							rs.getString("ProductNum") + "\t" +
//							rs.getString("ProductSerialNumT") +  "\t" +
//							rs.getInt("amount") + "\t" +
//							rs.getString("InternalContent") + "\t" +
//							rs.getString("FillingDate"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, ps, conn);
		}

		return list;
	}
	
	public static ArrayList<Product> getProductByOrder(String id) {
		ArrayList<Product> list = new ArrayList<Product>();

		String orderNum = null;
		ResultSet rso = null;
		ResultSet rsp = null;
		PreparedStatement ps = null;
		Connection conn = BaseDao.getConn();
		int i = 1;

		try {
			String sql = "select * from productorder where CompanyOrderNum='"+ id +"'";
			ps = conn.prepareStatement(sql);
			rso = ps.executeQuery();

			while (rso.next()) {
				orderNum = rso.getString("ProductSerialNumT");
				String sqlp = "select * from product where ProductSerialNumT='" +  orderNum + "'";
				ps = conn.prepareStatement(sqlp);
				rsp = ps.executeQuery();
				while(rsp.next()) {
					Product p = new Product(rsp.getString("ProductSerialNum"),
												rsp.getString("ProductName"),
												rsp.getString("Status"),
												rsp.getInt("InternalContent"),
												i++);
					
					list.add(p);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rso, ps, conn);
			BaseDao.closeAll(rsp, null, null);
		}

		return list;
	}
	
	public static ArrayList<Product> selectAll(String a) {
		ArrayList<Product> list = new ArrayList<Product>();

		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = BaseDao.getConn();

		try {
			if(a.equals("")) {
				String sql = "select * from product";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
			}else {
				String sql = "select * from product where ProductSerialNum='" +  a + "'";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
			}
			
			while (rs.next()) {
				Product p = new Product(rs.getString("ProductSerialNum"),
						rs.getString("ProductName"),
						rs.getString("Principal"),
						rs.getString("Status"),
						rs.getInt("InternalContent"));
//				System.out.println(rs.getString("CompanyOrderNum") + "\t" +
//							rs.getString("ProductNum") + "\t" +
//							rs.getString("ProductSerialNumT") +  "\t" +
//							rs.getInt("amount") + "\t" +
//							rs.getString("InternalContent") + "\t" +
//							rs.getString("FillingDate"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, ps, conn);
		}
		
		return list;
	}
	
	public static ArrayList<Product> selectType(String type, String name){
		ArrayList<Product> list = new ArrayList<Product>();

		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = BaseDao.getConn();

		try {
			if(name.equals("")) {
				if(type.equals("stored")) {
					String sql = "select * from product where Status='stored'";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
				}else if(type.equals("outStorage")) {
					String sql = "select * from product where Status='outStorage'";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
				}else if(type.equals("extLoan")) {
					String sql = "select * from product where Status='extLoan'";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
				}else {
					String sql = "select * from product where Status='inLoan'";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
				}
				
			}else {
				if(type.equals("stored")) {
					String sql = "select * from product where ProductName='" + name +"' and Status='stored'";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
				}else if(type.equals("outStorage")) {
					String sql = "select * from product where ProductName='" + name +"' and Status='outStorage'";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
				}else if(type.equals("extLoan")) {
					String sql = "select * from product where ProductName='" + name +"' and Status='extLoan'";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
				}else {
					String sql = "select * from product where ProductName='" + name +"' and Status='inLoan'";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
				}
			}
			
			while (rs.next()) {
				Product p = new Product(rs.getString("ProductSerialNum"),
						rs.getString("ProductName"),
						rs.getString("Principal"),
						rs.getString("Status"),
						rs.getInt("InternalContent"));
//				System.out.println(rs.getString("CompanyOrderNum") + "\t" +
//							rs.getString("ProductNum") + "\t" +
//							rs.getString("ProductSerialNumT") +  "\t" +
//							rs.getInt("amount") + "\t" +
//							rs.getString("InternalContent") + "\t" +
//							rs.getString("FillingDate"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, ps, conn);
		}
		BaseDao.closeAll(rs, ps, conn);
		return list;
	}
	
	public static boolean judgePName(String productSName) {
		boolean x = false;
		String sql = "select * from product where ProductSerialNum=?";
		Connection conn = BaseDao.getConn();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, productSName);
			
			ResultSet rs = ps.executeQuery();
			x = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(null, null, conn);
		}
		
		return x;
	}
	
	public static boolean selectStorageInScan(String orderNum, String productName, String serialNum) {
		boolean ans = false;
		
		Connection conn = BaseDao.getConn();
		PreparedStatement ps = null;
		ResultSet rso = null;
		ResultSet rsi = null;
		
		try {
			String sql = "select * from productorder where CompanyOrderNum='" + orderNum +
					"' and ProductNum='" + productName +"'";
			ps = conn.prepareStatement(sql);
			rso = ps.executeQuery();
			while (rso.next()) {
				orderNum = rso.getString("ProductSerialNumT");
				String sqli = "select * from product where ProductName='" + productName +
						"' and ProductSerialNum='"+ serialNum + "' and Status<>'stored'";
				ps = conn.prepareStatement(sqli);
				rsi = ps.executeQuery();
				if(rsi.next()) {
					ps.close();
					rso.close();
					rsi.close();
					conn.close();
					return ans = true;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rso, ps, conn);
			BaseDao.closeAll(rsi, null, null);
		}
		
		return ans;
	}
	
	public static boolean selectStorageInScanT(ArrayList<Product> p, String serial, String name) {
		boolean ans = true;
		Iterator<Product> i = p.iterator();
		Product x;
		while(i.hasNext()) {
			x = i.next();
			if(x.getProductSerialNum().equals(serial) && x.getProductName().equals(name) && x.getStatus().equals("待入庫")) {
				
				ans = false;
				return ans;
			}
		}
		
		return ans;
	}
	
	public static void updateStorage(String name, String serial) {
		String sql = "update product set Status='" + "入庫" + "' where ProductSerialNum=? and ProductName=?;";
		Object[] o = {serial, name};
		BaseDao.executeIUD(sql, o);
	}
	
	public static int delProduct(String id) {
		String sql = "delete from product where ProductSerialNumT=?";
		
		Object[] obj = {id};
		return BaseDao.executeIUD(sql, obj);
	}
}
