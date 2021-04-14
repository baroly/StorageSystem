package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.ProductDao;
import com.Dao.ProductPsDao;
import com.Modal.Product;

/**
 * Servlet implementation class ScanStored
 */
@WebServlet("/ScanStored")
public class ScanStored extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScanStored() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession se=request.getSession();
		String data = "true";
		
		String id = (String)se.getAttribute("id");
		ArrayList<Product> p = ProductDao.getProductByOrder(id);
		
//		if(ProductDao){
//			
//		}
//		ProductDao.selectStorageInScan(request.getParameter("id"),
//				request.getParameter("productNum"),
//				request.getParameter("productSerialNum"))
		if(ProductDao.selectStorageInScanT(p, request.getParameter("productSerialNum"),
				request.getParameter("productNum"))) {	//要在ProductDao裡新增selectScanIn()
			response.setContentType("text/html");
	        response.setCharacterEncoding("UTF-8");
	        // 获取PrintWriter对象
	        PrintWriter out = response.getWriter();
	        out.print(data);
	        // 释放PrintWriter对象
	        out.flush();
	        out.close();
		}
	}

}
