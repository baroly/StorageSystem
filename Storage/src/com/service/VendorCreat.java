package com.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.VendorDao;
import com.Modal.Vendor;

/**
 * Servlet implementation class VendorCreat
 */
@WebServlet("/VendorCreat")
public class VendorCreat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorCreat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		Vendor v = new Vendor(request.getParameter("vendorName"),
					request.getParameter("vendorPrincipal"),
					request.getParameter("vendorID"));
		
		int count = VendorDao.insert(v);
		
		if(count > 0) {
			response.sendRedirect("savesess.jsp");
		}else {
			response.sendRedirect("savefail.jsp");
		}
	}

}
