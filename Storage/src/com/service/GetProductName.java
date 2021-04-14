package com.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.ProductDao;
import com.Dao.ProductDetailDao;
import com.Modal.Product;

/**
 * Servlet implementation class GetProductName
 */
@WebServlet("/GetProductName")
public class GetProductName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProductName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		ArrayList<String> list = ProductDetailDao.getProductName();
		request.setAttribute("productName", list);
		request.getRequestDispatcher("productorderadd.jsp").forward(request, response);
		return;
	}

}
