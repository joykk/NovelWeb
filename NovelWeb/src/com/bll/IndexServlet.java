package com.bll;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBUtility.SqlNovel;
import com.bean.NovelBean;
/**
 * 产生所有的书籍列表（未分页）
 * @author zhangyi
 *
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SqlNovel sqln=new SqlNovel();
		ArrayList<NovelBean> novellist=sqln.getBookList();
		HttpSession se= request.getSession();
		se.setAttribute("novellist", novellist);
		response.sendRedirect(this.getServletContext().getContextPath()
				+ "/index.jsp");
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
