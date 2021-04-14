package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Modal.Product;
import com.Modal.ProductOrder;

import tools.JudgeSName;

public class PorderDao {
	public static void main(String[] args) {
		ProductOrder p = new ProductOrder("T100S101-125",
						"RAC50",
						"HG300-HG311",
						12,
						0,
						"",
						"2020-12-13");
		//insert(p);
//		ArrayList<ProductOrder> a = select("T100S101-126");
//		for(ProductOrder c : a) {
//			System.out.println(c.getProductNum() + "\t" +
//							c.getProductSerialNum() + "\t" +
//							c.getAmount());
//		}
	}

	public static int insert(ProductOrder p) {
		String sql = "insert into productorder(CompanyOrderNum,ProductNum,ProductSerialNumT,"
				+ "amount,InternalContent,Status,FillingDate) value(?,?,?,?,?,?,?)";
		Object[] o = {p.getCompanyOrderNum(),
					p.getProductNum(),
					p.getProductSerialNum(),
					p.getAmount(),
					p.getInternalContent(),
					p.getStatus(),
					p.getFillingDate(),
					};
		
		return BaseDao.executeIUD(sql, o);
	}

	public static ArrayList<ProductOrder> select(String name) {

		ArrayList<ProductOrder> list = new ArrayList<ProductOrder>();

		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = BaseDao.getConn();

		try {
			String sql = "select * from productorder where CompanyOrderNum='"+ name +"' order by ProductNum DESC";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				ProductOrder p = new ProductOrder(rs.getString("ProductNum"),
						rs.getString("ProductSerialNumT"),
						rs.getInt("amount"));
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
	
	public static boolean judgeProOrder(String sName) {
		boolean x = false;
		String sql = "select * from productorder where ProductSerialNumT=?";
		Connection conn = BaseDao.getConn();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sName);
			
			ResultSet rs = ps.executeQuery();
			x = rs.next();
			if(!x) {
				x = !JudgeSName.judgeSName(sName);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return x;
	}
	
	public static int del(String id) {
		ProductDao.delProduct(id);
		
		String sql = "delete from productorder where ProductSerialNumT=?";
		
		Object[] obj = {id};
		return BaseDao.executeIUD(sql, obj);
	}
}
