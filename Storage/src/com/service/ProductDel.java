package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.PorderDao;
import com.Dao.ProductPsDao;
import com.Modal.ProductOrder;
import com.Modal.ProductPS;

/**
 * Servlet implementation class ProductDel
 */
@WebServlet("/ProductDel")
public class ProductDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDel() {
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
		int count =PorderDao.del(id);
		if(count > 0) {
			ArrayList<ProductOrder> list = PorderDao.select((String)se.getAttribute("porderNum"));//(String)se.getAttribute("porderNum")
			request.setAttribute("porder", list);
			request.getRequestDispatcher("productadd.jsp").forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('添加失敗')");
			out.write("location.href='productOAS.jsp");
			out.write("</script>");
		}
		
	}

}
