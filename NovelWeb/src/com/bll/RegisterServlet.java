package com.bll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.UEncoder;

import com.DBUtility.SqlLogin;
import com.DBUtility.SqlRegister;
import com.Utility.MD5;
import com.bean.AuthorBean;
import com.bean.Man;
import com.bean.UserBean;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		String pwd = request.getParameter("password").trim();
		String pwd2 = request.getParameter("passwordAgain").trim();
		String man = request.getParameter("man").trim();
		Man user = new Man(username);
		request.setAttribute("user", user);
		SqlRegister RegisterBll=new SqlRegister();
		if(!pwd.equals(pwd2)){
			response.sendRedirect(this.getServletContext().getContextPath()
					+ "/register.jsp?code=2");
			return;
		}
		if(""==username||null==pwd||null==pwd2){
			response.sendRedirect(this.getServletContext().getContextPath()
					+ "/register.jsp?code=4");
			return;
		}
		if(!RegisterBll.CheckNameExistByName(user,man))
		{//用户名不冲突
			pwd=MD5.stringMD5(pwd);
			user.setPwd(pwd);
			user.setUserName(username);
			if(RegisterBll.Register(user,man))
			{//insert成功
				HttpSession se=request.getSession();
				SqlLogin sl=new SqlLogin();
				if(man.equals("reader"))
				{
					UserBean ub =(UserBean) sl.CheckLogin(user,man);
					se= request.getSession();
					se.setAttribute("user", ub);
					request.getRequestDispatcher("IndexServlet").forward(request, response);
				}else{
					AuthorBean ab=(AuthorBean) sl.CheckLogin(user,man);
					se= request.getSession();
					se.setAttribute("author", ab);
					response.sendRedirect(this.getServletContext().getContextPath()
							+ "/author/index.jsp");
				}
				return;
			}
			else{//insert失败
				response.sendRedirect(this.getServletContext().getContextPath()
						+ "/register.jsp?code=3");
			}
		}else{
			//用户名重复
			response.sendRedirect(this.getServletContext().getContextPath()
					+ "/register.jsp?code=1");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
