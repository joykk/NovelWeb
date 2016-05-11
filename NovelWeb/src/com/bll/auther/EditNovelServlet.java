package com.bll.auther;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBAuther.SqlAutherNovel;
import com.DBUtility.SqlNovel;
import com.bean.AuthorBean;
import com.bean.NovelBean;

@WebServlet("/author/EditNovelServlet")
public class EditNovelServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String novelID = request.getParameter("novelID");
		if (request.getSession().getAttribute("editNovel") == null) {//点击的是列表的修改
			SqlNovel sn = new SqlNovel();
			NovelBean nb = sn.getBeanByNovelID(novelID);
			request.getSession().setAttribute("editNovel", nb);//暂存session中
			request.getRequestDispatcher("/author/editNovel.jsp").forward(
					request, response);
		} else {
			// 点击的是修改提交
			NovelBean nb = new NovelBean();
			nb = (NovelBean) request.getSession().getAttribute("editNovel");
			nb.setNovelName(request.getParameter("novelName"));
			nb.setCategory(request.getParameter("category"));
			nb.setContent(request.getParameter("content"));
			SqlNovel sn = new SqlNovel();
			if(sn.updateNovelBean(nb))
			{
				request.setAttribute("message", "修改成功");
			}else{
				request.setAttribute("message", "修改失败");
			}
			request.getSession().removeAttribute("editNovel");
			request.getRequestDispatcher("ManageNovelServlet").forward(request,
					response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
