package com.bll;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBUtility.SqlNovel;
import com.bean.NovelBean;
/**
 * 添加小说到session的list中
 * @author zhangyi
 *
 */
@WebServlet("/AddNovelToShoppingCar")

public class AddNovelToShoppingCar extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String novelID = request.getParameter("ID");
		SqlNovel sn=new SqlNovel();
		try{
			ArrayList<NovelBean> ShoppingCar=null;
			HttpSession se= request.getSession();
			NovelBean nb= sn.getBeanByNovelID(novelID);
			if(se.getAttribute("ShoppingCar")==null)
			{//没有购物车
				ShoppingCar=new ArrayList<NovelBean>();
				ShoppingCar.add(nb);
				se.setAttribute("ShoppingCar", ShoppingCar);
			}else{
				//购物车已经存在
				ShoppingCar =(ArrayList<NovelBean>) se.getAttribute("ShoppingCar");
				ShoppingCar.add(nb);
				se.setAttribute("ShoppingCar", ShoppingCar);
			}
			
			response.getWriter().write(ShoppingCar.size()+"");//回调函数的data
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
