package com.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.ProductDetailDao;
import com.Dao.VendorDao;
import com.Modal.ProductDetail;

/**
 * Servlet implementation class ProductCreat
 */
@WebServlet("/ProductCreat")
public class ProductCreat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductCreat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		ProductDetail p = new ProductDetail(request.getParameter("productName"));
		
		int count = ProductDetailDao.insert(p);;
		
		if(count > 0) {
			response.sendRedirect("savesess.jsp");
		}else {
			response.sendRedirect("savefail.jsp");
		}
	}

}
