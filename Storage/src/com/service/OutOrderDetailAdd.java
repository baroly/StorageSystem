package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.OutboundDao;
import com.Modal.Outbound;

/**
 * Servlet implementation class OutOrderDetailAdd
 */
@WebServlet("/OutOrderDetailAdd")
public class OutOrderDetailAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutOrderDetailAdd() {
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
		
		Outbound ob = new Outbound(request.getParameter("outType"),
						request.getParameter("outSerialNum"),
						request.getParameter("fillingName"),
						request.getParameter("client"));
		
		int a = OutboundDao.insert(ob);
		
		if(a > 0) {
			se.setAttribute("serialNum", ob.getSerialNum());
			se.setAttribute("type", ob.getType());
			
			response.sendRedirect("outstorageproduct.jsp");
			return;
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('添加失敗')");
			out.write("location.href='productOAS.jsp");
			out.write("</script>");
			response.sendRedirect("outstorages.jsp");
			return;
		}
		
		
	}

}
