package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.ProductDao;
import com.Modal.Product;

/**
 * Servlet implementation class SelectPorder
 */
@WebServlet("/SelectPorder")
public class SelectPorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectPorder() {
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
		
		String id = request.getParameter("id");
		se.setAttribute("id", id);
		
		ArrayList<Product> p = ProductDao.getProductByOrder(id);
		request.setAttribute("product", p);
		
		int total = p.size();
		int done = 0;
		int less = 0;
		Iterator<Product> i = p.iterator();
		while(i.hasNext()) {
			Product x = i.next();
			if(x.getStatus().equals("入庫")) {
				done++;
			}
		}
		less = total - done;
		
		String t = String.valueOf(total);
		String d = String.valueOf(done);
		String l = String.valueOf(less);
		
		se.setAttribute("total", t);
		se.setAttribute("done", d);
		se.setAttribute("less", l);
		
		
		
		request.getRequestDispatcher("scanproduct.jsp").forward(request, response);
		//response.sendRedirect("scanproduct.jsp");
		return;
	}

}
