package com.bll.auther;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBAuther.SqlChapter;
import com.bean.ChapterBean;
@WebServlet("/author/UpdateChapter")
public class UpdateChapter extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String chapterContent =request.getParameter("chapterContent");
		String novelID=request.getParameter("novelID");
		if(chapterContent==null)
		{
			request.getSession().setAttribute("updateNovelID", novelID);//��¼��novelid
			request.getRequestDispatcher("/author/updatechapter.jsp").forward(request, response);
			return;
		}
		String chapterName=request.getParameter("chapterName");
		ChapterBean cb=new ChapterBean();
		cb.setChapterName(chapterName);
		cb.setChapterContent(chapterContent);
		cb.setNovelID(Integer.parseInt((String) request.getSession().getAttribute("updateNovelID")));
		SqlChapter sc=new SqlChapter();
		if(sc.insertBean(cb))
		{
			request.setAttribute("message", "更新成功");
			request.getRequestDispatcher("/author/updatechapter.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "更新失败");
			request.setAttribute("chapter", cb);
			request.getRequestDispatcher("/author/updatechapter.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
