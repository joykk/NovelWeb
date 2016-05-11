package com.bll;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBUtility.SqlNovel;
/**
 * 章节内容
 * @author zhangyi
 *
 */
@WebServlet("/ReadChapterServlet") 
public class ReadChapterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ChapterID= request.getParameter("ChapterID");
		String NovelID= request.getParameter("NovelID");
		SqlNovel sn=new SqlNovel();
		if(ChapterID==null)
		{//直接点击“开始阅读”
			ChapterID=sn.getFristId(Integer.parseInt(NovelID))+"";
		}
		if(Integer.parseInt(ChapterID)==-1)
		{
			//没有上或下一章
			response.sendRedirect("ReadNovelcCatalog?novelID="+NovelID+"&novelName=没有了");
			return;
		}
		String ChapterName= request.getParameter("ChapterName");
		if(ChapterName!=null)
		{
			ChapterName=new String(ChapterName.trim().getBytes("ISO-8859-1"), "UTF-8");  //get乱码
		}else{
			ChapterName=sn.getChapterName(Integer.parseInt(ChapterID));
		}
		request.setAttribute("ChapterName", ChapterName);
		request.setAttribute("NovelID", NovelID);
		request.setAttribute("ChapterContent", sn.getChapterContentByChapterID(Integer.parseInt(ChapterID)));
		request.setAttribute("UpAndDownChapterlist", sn.getUpAndDownChapterBy(ChapterID,sn.getCatalogByNovelID(NovelID)));
		request.getRequestDispatcher("/readNovelChapter.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
