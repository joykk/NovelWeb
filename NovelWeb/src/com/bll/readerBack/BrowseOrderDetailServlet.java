package com.bll.readerBack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBUtility.SqlOrder;
@WebServlet("/reader/BrowseOrderDetailServlet") 
public class BrowseOrderDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String readerOrderID=request.getParameter("readerOrderID");
		SqlOrder so=new SqlOrder();
		request.setAttribute("detaillist", so.getOrderDetailList(Integer.parseInt(readerOrderID)));
		request.getRequestDispatcher("detaillist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
