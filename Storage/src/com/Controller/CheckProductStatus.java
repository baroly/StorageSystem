package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.ProductDao;
import com.Dao.VendorDao;
import com.Modal.Product;

/**
 * Servlet implementation class CheckProductStatus
 */
@WebServlet("/CheckProductStatus")
public class CheckProductStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckProductStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String data = "true";
		
		Product p = new Product(request.getParameter("serialNum"),
						request.getParameter("productNum"),
						Integer.parseInt(request.getParameter("internalContent")));
		
		String ans = ProductDao.confirmCanOut(p);
		System.out.println(ans);
		if (ans.equals("error")) {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			// 获取PrintWriter对象
			PrintWriter out = response.getWriter();
			out.print(data);
			// 释放PrintWriter对象
			out.flush();
			out.close();
		}
		
		if(ans.equals("contentIsntEnough")) {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			data = "content";
			// 获取PrintWriter对象
			PrintWriter out = response.getWriter();
			out.print(data);
			// 释放PrintWriter对象
			out.flush();
			out.close();
		}
	}

}
