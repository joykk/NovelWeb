package com.bll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBUtility.SqlSearch;
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword= request.getParameter("keyword");
		keyword=new String(keyword.trim().getBytes("ISO-8859-1"), "UTF-8");  //get乱码
		SqlSearch ss=new SqlSearch(keyword);
		request.setAttribute("searchNovels", ss.Search());
		request.getRequestDispatcher("/Search.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
