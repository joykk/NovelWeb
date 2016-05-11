package com.bll;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBUtility.SqlNovel;

/**
 * 产生小说全部目录数据
 * @author zhangyi
 *
 */
@WebServlet("/ReadNovelcCatalog")
public class ReadNovelcCatalog extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String novelID= request.getParameter("novelID");
		novelID=new String(novelID.trim().getBytes("ISO-8859-1"), "UTF-8"); 
		String novelName= request.getParameter("novelName");
		novelName=new String(novelName.trim().getBytes("ISO-8859-1"), "UTF-8");  
		SqlNovel sn=new SqlNovel();
		request.setAttribute("novelID", novelID);
		request.setAttribute("novelName", novelName);
		request.setAttribute("Catalog", sn.getCatalogByNovelID(novelID));
		request.getRequestDispatcher("/readNovelCatalog.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
