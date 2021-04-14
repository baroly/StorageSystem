package com.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.ProductPsDao;
import com.Modal.ProductPS;

/**
 * Servlet implementation class GetPorderByName
 */
@WebServlet("/GetPorderByName")
public class GetPorderByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPorderByName() {
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
		
		se.setAttribute("Name", request.getParameter("companyOrderNum"));
		ArrayList<ProductPS> p = ProductPsDao.selectByName(request.getParameter("companyOrderNum"));
		request.setAttribute("Porder", p);
		request.getRequestDispatcher("modifyporderserch.jsp").forward(request, response);
		return;
	}

}
