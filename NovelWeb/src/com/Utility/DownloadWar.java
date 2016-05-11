package com.Utility;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadWar")
public class DownloadWar extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int status = 0;
		byte b[] = new byte[1024];
		FileInputStream in = null;
		ServletOutputStream out2 = null;
		try {
			response.setHeader("content-disposition",
					"attachment; filename=NovelWeb.war");
			in = new FileInputStream("/usr/tomcat/tomcat/webapps/NovelWeb.war");
			out2 = response.getOutputStream();
			while (status != -1) {
				status = in.read(b);
				out2.write(b);
			}
			out2.flush();
		} catch (Exception e) {
			System.out.println("傻屌你来晚了");
			response.sendRedirect("error.jsp");
		} finally {
			if (in != null)
				in.close();
			if (out2 != null)
				out2.close();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
