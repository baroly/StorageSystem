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
import com.Dao.VendorDao;
import com.Modal.ProductPS;

/**
 * Servlet implementation class ModifyPorder
 */
@WebServlet("/ModifyPorder")
public class ModifyPorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession se = request.getSession();
		
		String id = request.getParameter("idm");
		ProductPS pps = ProductPsDao.selectOrderByName(id);
		se.setAttribute("PPS", pps);
		
		ArrayList<String> list = VendorDao.getAllVendor(pps.getShipmentVendorName());
		request.setAttribute("VendorName", list);
		request.getRequestDispatcher("modifyporder.jsp").forward(request, response);
		return;
	}

}
