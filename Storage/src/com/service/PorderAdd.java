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
import com.Dao.ProductDetailDao;
import com.Dao.ProductPsDao;
import com.Modal.Product;
import com.Modal.ProductOrder;
import com.Modal.ProductPS;

/**
 * Servlet implementation class PorderAdd
 */
@WebServlet("/PorderAdd")
public class PorderAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PorderAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession se=request.getSession();
		
		ProductPS pps = (ProductPS)se.getAttribute("PPS");
		
		int count = ProductPsDao.insert(pps);
		
		if(count > 0) {
			//response.sendRedirect("productadd.jsp");
			se.setAttribute("porderNum", pps.getCompanyOrderNum());
			
			ArrayList<ProductOrder> list = PorderDao.select(pps.getCompanyOrderNum());
			
			request.setAttribute("porder", list);
			se.removeAttribute("pps");
			
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
		
		
	}

}
