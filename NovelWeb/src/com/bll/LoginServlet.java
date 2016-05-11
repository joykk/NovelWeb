package com.bll;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBUtility.SqlLogin;
import com.Utility.MD5;
import com.bean.AuthorBean;
import com.bean.UserBean;

import java.io.IOException;

/**
 * Created by zhangyi on 2016/3/20.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		String pwd = request.getParameter("password").trim();
		String man = request.getParameter("man").trim();
		SqlLogin loginBll=new SqlLogin();
		pwd=MD5.stringMD5(pwd);
		if(man.equals("reader"))
		{
			UserBean user = new UserBean(username, pwd);
			if(""==user.getUserName()||""==user.getPwd())
			{
				response.sendRedirect(this.getServletContext().getContextPath()
						+ "/login.jsp?code=1");
				return;
			}
			user=(UserBean) loginBll.CheckLogin(user,man);
			if (user!=null) {
				if(user.getStatus().equals("disabled"))
				{
					response.sendRedirect(this.getServletContext().getContextPath()
							+ "/login.jsp?code=3");
					return;
				}
				HttpSession se= request.getSession();
				se.setAttribute("user", user);			
				request.getRequestDispatcher("IndexServlet").forward(request, response);
				return;
			}else{
				response.sendRedirect(this.getServletContext().getContextPath()
						+ "/login.jsp?code=2");
				return;
			}
		}else{
			AuthorBean aur = new AuthorBean(username, pwd);
			if(""==aur.getUserName()||""==aur.getPwd())
			{
				response.sendRedirect(this.getServletContext().getContextPath()
						+ "/login.jsp?code=1");
				return;
			}
			aur=(AuthorBean) loginBll.CheckLogin(aur,man);
			if (aur!=null) {
				
				if(aur.getStatus().equals("disabled"))
				{
					response.sendRedirect(this.getServletContext().getContextPath()
							+ "/login.jsp?code=3");
					return;
				}
				HttpSession se= request.getSession();
				se.setAttribute("author", aur);
				response.sendRedirect(this.getServletContext().getContextPath()
						+ "/author/index.jsp");
				return;
			}else{
				response.sendRedirect(this.getServletContext().getContextPath()
						+ "/login.jsp?code=2");
				return;
			}
		}
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
