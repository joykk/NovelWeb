package com.bll.readerBack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBUtility.SqlOrder;
import com.bean.UserBean;

@WebServlet("/reader/browseOrderServlet")
public class BrowseOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession hs=request.getSession();
		UserBean ub= (UserBean) hs.getAttribute("user");
		if(null==ub)
		{
			response.sendRedirect(this.getServletContext().getContextPath()
					+ "/login.jsp?code=5");
			return;
		}
		SqlOrder so=new SqlOrder();
		request.setAttribute("orderlist", so.getOrderList(ub.getId()));
		request.getRequestDispatcher("browseOrder.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
