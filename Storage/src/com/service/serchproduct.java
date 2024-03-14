package com.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.ProductDao;
import com.Modal.Product;

/**
 * Servlet implementation class serchproduct
 */
@WebServlet("/serchproduct")
public class serchproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serchproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		if(request.getParameter("productName").equals("")) {
			if(request.getParameter("serch").equals("1")) {
				ArrayList<Product> list = ProductDao.selectAll("");
				request.setAttribute("product", list);
				request.getRequestDispatcher("productserch.jsp").forward(request, response);
				return;
			}else if(request.getParameter("serch").equals("2")) {
				ArrayList<Product> list = ProductDao.selectType("入庫", "");
				request.setAttribute("product", list);
				request.getRequestDispatcher("productserch.jsp").forward(request, response);
				return;
			}else if(request.getParameter("serch").equals("3")) {
				ArrayList<Product> list = ProductDao.selectType("outStorage", "");
				request.setAttribute("product", list);
				request.getRequestDispatcher("productserch.jsp").forward(request, response);
				return;
			}else if(request.getParameter("serch").equals("4")) {
				ArrayList<Product> list = ProductDao.selectType("extLoan", "");
				request.setAttribute("product", list);
				request.getRequestDispatcher("productserch.jsp").forward(request, response);
				return;
			}else {
				ArrayList<Product> list = ProductDao.selectType("inLoan", "");
				request.setAttribute("product", list);
				request.getRequestDispatcher("productserch.jsp").forward(request, response);
				return;
			}
		}else {
			if(request.getParameter("serch").equals("1")) {
				ArrayList<Product> list = ProductDao.selectAll(request.getParameter("productName"));
				request.setAttribute("product", list);
				request.getRequestDispatcher("productserch.jsp").forward(request, response);
				return;
			}else if(request.getParameter("serch").equals("2")) {
				ArrayList<Product> list = ProductDao.selectType("入庫", request.getParameter("productName"));
				request.setAttribute("product", list);
				request.getRequestDispatcher("productserch.jsp").forward(request, response);
				return;
			}else if(request.getParameter("serch").equals("3")) {
				ArrayList<Product> list = ProductDao.selectType("outStorage", request.getParameter("productName"));
				request.setAttribute("product", list);
				request.getRequestDispatcher("productserch.jsp").forward(request, response);
				return;
			}else if(request.getParameter("serch").equals("4")) {
				ArrayList<Product> list = ProductDao.selectType("extLoan", request.getParameter("productName"));
				request.setAttribute("product", list);
				request.getRequestDispatcher("productserch.jsp").forward(request, response);
				return;
			}else {
				ArrayList<Product> list = ProductDao.selectType("inLoan", request.getParameter("productName"));
				request.setAttribute("product", list);
				request.getRequestDispatcher("productserch.jsp").forward(request, response);
				return;
			}
		}
		
	}

}
