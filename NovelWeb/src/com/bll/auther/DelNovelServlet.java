package com.bll.auther;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBUtility.SqlNovel;
import com.bean.AuthorBean;
import com.bean.NovelBean;
@WebServlet("/author/DelNovelServlet")
public class DelNovelServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String novelID=request.getParameter("novelID");
		SqlNovel sn=new SqlNovel();
		if(sn.delNovelBynovelID(Integer.parseInt(novelID)))
		{
			request.setAttribute("message", "删除成功");
			request.getRequestDispatcher("ManageNovelServlet").forward(request, response);
		}else{
			request.setAttribute("message", "删除失败");
			request.getRequestDispatcher("ManageNovelServlet").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
