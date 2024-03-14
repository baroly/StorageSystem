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

import com.Dao.ProductDao;
import com.Modal.Product;
import com.Modal.ProductOrder;

/**
 * Servlet implementation class productSave
 */
@WebServlet("/productSave")
public class productSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productSave() {
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
		
		ArrayList<String> e = new ArrayList<String>();
		
		ArrayList<ProductOrder> p = ProductDao.selectSName((String)se.getAttribute("porderNum"));
		
		for(ProductOrder a : p) {
			String[] sName = tools.SpiltName.spiltName(a.getProductSerialNum());
			for(int i = 0; i < sName.length; i++) {
				if(ProductDao.judgePName(sName[i])) {
					e.add(sName[i]);
				}else {
					Product x = new Product(sName[i],
							a.getProductSerialNum(),
							a.getProductNum(),
							"nuknow",
							a.getStatus(),
							a.getInternalContent());
					ProductDao.insert(x);
				}
			}
		}
		
		if(e.isEmpty()) {
			response.sendRedirect("savesess.jsp");
			return;
//			PrintWriter out = response.getWriter();
//			out.write("<script>");
//			out.write("alert('儲存成功')");
//			out.write("location.href='productOAS.jsp");
//			out.write("</script>");
		}else {
			request.setAttribute("error", e);
			request.getRequestDispatcher("productadd.jsp").forward(request, response);
		}
		
	}

}
