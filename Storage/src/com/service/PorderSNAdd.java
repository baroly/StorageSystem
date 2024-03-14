package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.PorderDao;
import com.Dao.ProductDetailDao;
import com.Modal.ProductOrder;

import tools.SpiltName;

/**
 * Servlet implementation class PorderSNAdd
 */
@WebServlet("/PorderSNAdd")
public class PorderSNAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PorderSNAdd() {
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
		Date date = new Date();
		int count = 0;
		int internalContent;
		
		String status;
		if(request.getParameter("stroaging") == null) {
			status = "待入庫";
		}else {
			status = "不入庫";
		}
		if(request.getParameter("internalContent").equals("")) {
			internalContent = 0;
		}else {
			internalContent = Integer.valueOf(request.getParameter("internalContent"));
		}
//		String x = request.getParameter("productSerialNum");	(String)se.getAttribute("porderNum")
		ProductOrder p = new ProductOrder((String)se.getAttribute("porderNum"),
								request.getParameter("productNum"),
								request.getParameter("productSerialNum"),
								SpiltName.spiltName(request.getParameter("productSerialNum")).length,
								internalContent,
								status,
								(date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-" + date.getDate());
		
		count = PorderDao.insert(p);
		
		if(count > 0) {
			ArrayList<ProductOrder> list = PorderDao.select((String)se.getAttribute("porderNum"));
			
			request.setAttribute("porder", list);
			
			ArrayList<String> lista = ProductDetailDao.getProductName();
			request.setAttribute("productName", lista);
			request.getRequestDispatcher("productadd.jsp").forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('添加失敗')");
			out.write("location.href='productOAS.jsp");
			out.write("</script>");
		}
		
		//request.getRequestDispatcher("productadd.jsp").forward(request, response);response.sendRedirect("print.jsp");
	}

}
