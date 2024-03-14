package com.Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.ProductPsDao;
import com.Modal.ProductPS;

/**
 * Servlet implementation class POrderJudge
 */
@WebServlet("/POrderJudge")
public class POrderJudge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public POrderJudge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		Date date = new Date();
		LocalDateTime ldt = LocalDateTime.of(date.getYear() + 1900, date.getMonth() + 1, date.getDate(), 0, 0);
		
		
		String fillingDate = (date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-" + date.getDate();
		String shipmentVendorName = request.getParameter("shipmentVendorName");
		String companyOrderNum = request.getParameter("companyOrderNum");
		String trackingNum = request.getParameter("trackingNum");
		String invoiceNo = request.getParameter("invoiceNo");
		String orderNum = request.getParameter("orderNum");
		Double exchangeRate = Double.parseDouble(request.getParameter("exchangeRate"));
		String offshoreDate = request.getParameter("offshoreDate");
		String arrivlDate = request.getParameter("arrivalDate");
		
		if(offshoreDate.length() == 8) {
			offshoreDate = offshoreDate.substring(0, 4) + "-" + 
					offshoreDate.substring(4, 6) + "-" + 
					offshoreDate.substring(6, 8);
		}else {
//			offshoreDate = ldt.format(DateTimeFormatter.BASIC_ISO_DATE);
//			offshoreDate = arrivlDate.substring(0, 4) + "-" + 
//					offshoreDate.substring(4, 6) + "-" + 
//					offshoreDate.substring(6, 8);
			offshoreDate = "0000-00-00";
		}
		
		if(arrivlDate.length() == 8) {
			arrivlDate = arrivlDate.substring(0, 4) + "-" + 
					arrivlDate.substring(4, 6) + "-" + 
					arrivlDate.substring(6, 8);
		}else {
//			arrivlDate = ldt.format(DateTimeFormatter.BASIC_ISO_DATE);
//			arrivlDate = arrivlDate.substring(0, 4) + "-" + 
//					arrivlDate.substring(4, 6) + "-" + 
//					arrivlDate.substring(6, 8);
			offshoreDate = "0000-00-00";
		}
		
		ProductPS pps = new ProductPS(fillingDate, shipmentVendorName, companyOrderNum, trackingNum,
				invoiceNo, orderNum, exchangeRate, offshoreDate, arrivlDate, "0000-00-00");
		
		
		session.setAttribute("PPS", pps);
		response.sendRedirect("pordercheck.jsp");
	}

}
