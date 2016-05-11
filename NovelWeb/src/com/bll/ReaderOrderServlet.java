package com.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.DBUtility.SqlOrder;
import com.bean.NovelBean;
import com.bean.UserBean;

@WebServlet("/ReaderOrderServlet")
public class ReaderOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession hs = request.getSession();
		UserBean ub = (UserBean) hs.getAttribute("user");
		ArrayList<NovelBean> ShoppingCar = (ArrayList<NovelBean>) hs.getAttribute("ShoppingCar");

		if (request.getParameter("delID") != null) {// 删除按键
			int delID = Integer.parseInt(request.getParameter("delID"));
			for (NovelBean novelBean : ShoppingCar) {
				if (novelBean.getNovelID() == delID) {
					ShoppingCar.remove(novelBean);
					break;
				}
			}
		}
		if (request.getParameter("pay") != null) {// 点击购买，最后清空ShoppingCar
			if (ShoppingCar == null || ShoppingCar.size() == 0) {// 购物车里面没有
				request.getRequestDispatcher("/ReaderOrder.jsp").forward(
						request, response);
				return;
			}
			SqlOrder so = new SqlOrder();
			try {
				if (so.insertList(ShoppingCar,  ub.getId())) {
					hs.removeAttribute("ShoppingCar");
					request.setAttribute("message", "购买成功");
					request.getRequestDispatcher("/success.jsp").forward(
							request, response);
					return;
				}
			} catch (NullPointerException ne) {//登录后购买
				response.sendRedirect(this.getServletContext().getContextPath()
						+ "/login.jsp?code=4");
				return;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		}

		float totalPrice = 0;

		if (ShoppingCar == null || ShoppingCar.size() == 0) {// 没有购物车
			request.getRequestDispatcher("/ReaderOrder.jsp").forward(request,
					response);
			return;
		}
		for (NovelBean novelBean : ShoppingCar) {
			totalPrice += novelBean.getPrice();
		}
		request.setAttribute("totalPrice", totalPrice);
		request.getRequestDispatcher("/ReaderOrder.jsp").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
