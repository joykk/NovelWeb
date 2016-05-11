package com.bll.auther;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBAuther.SqlAutherNovel;
import com.bean.AuthorBean;

@WebServlet("/author/ManageNovelServlet")
public class ManageNovelServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs=request.getSession();
		AuthorBean ab= (AuthorBean) hs.getAttribute("author");
		SqlAutherNovel san=new SqlAutherNovel();
		request.setAttribute("novels", san.getNovelsByAutherID(ab.getAuthorID()));
		request.getRequestDispatcher("/author/manageNovel.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
