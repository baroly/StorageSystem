package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.ProductPsDao;

/**
 * Servlet implementation class porderNumJudge
 */
@WebServlet("/porderNumJudge")
public class porderNumJudge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public porderNumJudge() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String data = "true";
		
		if(ProductPsDao.judgeProOrder(request.getParameter("companyOrderNum"))) {
			response.setContentType("text/html");
	        response.setCharacterEncoding("UTF-8");
	        // 获取PrintWriter对象
	        PrintWriter out = response.getWriter();
	        out.print(data);
	        // 释放PrintWriter对象
	        out.flush();
	        out.close();
		}
		
//        //返回结果
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//        // 获取PrintWriter对象
//        PrintWriter out = response.getWriter();
//        out.print(data);
//        // 释放PrintWriter对象
//        out.flush();
//        out.close();
	}

}
