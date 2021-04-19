package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.Modal.Product;
import com.Modal.ProductPS;

public class ProductPsDao {
	public static void main(String[] args) {
//		boolean x = judgeProOrder("T100S101-121");
//		System.out.println(x);
		
//		ArrayList<ProductPS> a = selectAll();
//		Iterator<ProductPS> i = a.iterator();
//		while(i.hasNext()) {
//			ProductPS p = i.next();
//			System.out.println(p.getCompanyOrderNum() + "\t\t" +
//							p.getShipmentVendorName() + "\t\t" +
//							p.getInvoiceNo() + "\t\t" +
//							p.getTrackingNum() + "\t\t" +
//							p.getOrderNum() + "\t\t" +
//							p.getOffshoreDate() + "\t\t" +
//							p.getArrivalDate() + "\t\t" +
//							p.getFillingDate());
//		}
		
//		insert(new ProductPS("s", "我", "s", "s",
//				"s", "s", 12.1, "s", "s", "0000-00-00"));
		
//		ArrayList<ProductPS> list = selectByName("D2021");
//		for(ProductPS i : list) {
//			ProductPS p = i;
//			System.out.println(p.getCompanyOrderNum() + "\t" + p.getShipmentVendorName() + "\t" + p.getFillingDate());
//		}
		
//		boolean x = serchPorder("D2022");
//		System.out.println(x);
		
		//delPorderDetail("D202104070001");
		
//		ProductPS pps = selectOrderByName("D202104070003");
//		System.out.println(pps.getExchangeRate());
		

		
	}
	
	public static int insert(ProductPS p) {
		String sql = "insert into productpurchaseorder(CompanyOrderNum,ShipmentVendorName,InvoiceNo,"
				+ "FillingDate,ExchangeRate,TrackingNum,OrderNum,OffshoreDate,ArrivalDate) value(?,?,?,?,?,?,?,?,?)";
		Object[] o = {p.getCompanyOrderNum(),
					p.getShipmentVendorName(),
					p.getInvoiceNo(),
					p.getFillingDate(),
					p.getExchangeRate(),
					p.getTrackingNum(),
					p.getOrderNum(),
					p.getOffshoreDate(),
					p.getArrivalDate()};
		
		return BaseDao.executeIUD(sql, o);
	}
	
	public static boolean judgeProOrder(String proOrder) {
		boolean x = false;
		String sql = "select * from productpurchaseorder where CompanyOrderNum=?";
		Connection conn = BaseDao.getConn();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, proOrder);
			
			ResultSet rs = ps.executeQuery();
			x = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return x;
	}
	
	public static ArrayList<ProductPS> selectAll() {
		ArrayList<ProductPS> list = new ArrayList<ProductPS>();

		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = BaseDao.getConn();

		try {

			String sql = "select * from productpurchaseorder order by FillingDate DESC";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				ProductPS p = new ProductPS(rs.getString("CompanyOrderNum"),
							rs.getString("shipmentVendorName"),
							rs.getString("InvoiceNo"),
							rs.getString("TrackingNum"),
							rs.getString("OrderNum"),
							rs.getString("OffshoreDate"),
							rs.getString("ArrivalDate"),
							rs.getString("StorageTime"));
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
	
	public static ProductPS selectOrder(String name) {
		ProductPS p = null;
		String sql = "";
		Connection conn = BaseDao.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			sql = "select * from productpurchaseorder where CompanyOrderNum=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				p = new ProductPS(rs.getString("companyOrderNum"),
						rs.getString("shipmentVendorName"),
						rs.getString("invoiceNo"),
						rs.getString("exchangeRate"),
						rs.getString("trackingNum"),
						rs.getString("orderNum"),
						rs.getString("offshoreDate"),
						rs.getString("arrivalDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(rs, ps, conn);
		}
		
		return p;
		
	}
	
	public static ProductPS selectOrderByName(String name) {
		ProductPS p = null;
		String sql = "";
		Connection conn = BaseDao.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			sql = "select * from productpurchaseorder where CompanyOrderNum=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				p = new ProductPS(rs.getString("companyOrderNum"),
						rs.getString("shipmentVendorName"),
						rs.getString("invoiceNo"),
						Double.valueOf(rs.getInt("ExchangeRate")),
						rs.getString("trackingNum"),
						rs.getString("orderNum"),
						rs.getString("offshoreDate"),
						rs.getString("arrivalDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, ps, conn);
		}
		return p;
		
	}
	
	public static boolean serchPorder(String name) {
		boolean x = false;
		Connection conn = BaseDao.getConn();
		String sql = "select * from productpurchaseorder where CompanyOrderNum like ?;";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name + "%");
			
			rs = ps.executeQuery();
			
			x = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}
	
	public static ArrayList<ProductPS> selectByName(String name){
		ArrayList<ProductPS> list = new ArrayList<>();
		Connection conn = BaseDao.getConn();
		String sql = "select * from productpurchaseorder where CompanyOrderNum like ? order by FillingDate DESC";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name + "%");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new ProductPS(rs.getString("CompanyOrderNum"),
							rs.getString("shipmentVendorName"),
							rs.getString("FillingDate")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void delPorderDetail(String name) {
		String sql = "";
		Connection conn = BaseDao.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			sql = "select * from productorder where CompanyOrderNum=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("ProductSerialNumT");
				PorderDao.del(id);
			}
			delPorder(name);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(rs, ps, conn);
		}
		
	}
	
	private static void delPorder(String name) {
		String sql = "delete from productpurchaseorder where CompanyOrderNum=?";
		
		Object[] obj = {name};
		BaseDao.executeIUD(sql, obj);
	}
}
