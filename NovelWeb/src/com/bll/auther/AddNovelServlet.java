package com.bll.auther;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.DBUtility.SqlNovel;
import com.bean.AuthorBean;
import com.bean.NovelBean;

@WebServlet("/author/AddNovelServlet")
public class AddNovelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String novelName = request.getParameter("novelName");
			String category = request.getParameter("category");
			String content = request.getParameter("content");
			NovelBean nb = new NovelBean();
			nb.setNovelName(novelName);
			nb.setPic("无");
			nb.setContent(content);
			nb.setCategory(category);
			nb.setClickCount(0);
			nb.setProgress("未完");
			nb.setWordCount(0);
			nb.setPrice(0);
			//nb.setPic(upPic(request, response));
			AuthorBean Author = (AuthorBean) request.getSession().getAttribute(
					"author");
			nb.setAuthorID(Author.getAuthorID());
			SqlNovel sn = new SqlNovel();
			if (sn.addNovelBean(nb)) {
				
				request.setAttribute("message", "添加成功");
				request.getRequestDispatcher("/author/addNovel.jsp").forward(
						request, response);
			} else {
				request.setAttribute("message", "添加失败");
				request.getRequestDispatcher("/author/addNovel.jsp").forward(
						request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String upPic(HttpServletRequest request, HttpServletResponse response) {
		String uploadPath = "BookPic/"; // 上传文件的目录
		String tempPath = "BookPic/temp"; // 临时文件目录
		String serverPath = null;
		int sizeMax = 1;// 图片最大上限
		String[] fileType = new String[] { ".jpg", ".gif", ".bmp", ".png",
				".jpeg", ".ico" };

		serverPath = getServletContext().getRealPath("/").replace("\\", "/");
		// Servlet初始化时执行,如果上传文件目录不存在则自动创建
		if (!new File(serverPath + uploadPath).isDirectory()) {
			new File(serverPath + uploadPath).mkdirs();
		}
		if (!new File(serverPath + tempPath).isDirectory()) {
			new File(serverPath + tempPath).mkdirs();
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(5 * 1024); // 最大缓存
		factory.setRepository(new File(serverPath + tempPath));// 临时文件目录

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(sizeMax * 1024 * 1024);// 文件最大上限

		String filePath = null;
		try {
			List<FileItem> items = upload.parseRequest(request);// 获取所有文件列表
			for (FileItem item : items) {
				// 获得文件名，这个文件名包括路径
				if (!item.isFormField()) {
					// 文件名
					String fileName = item.getName().toLowerCase();

					if (fileName.endsWith(fileType[0])
							|| fileName.endsWith(fileType[1])
							|| fileName.endsWith(fileType[2])
							|| fileName.endsWith(fileType[3])
							|| fileName.endsWith(fileType[4])
							|| fileName.endsWith(fileType[5])) {
						String uuid = UUID.randomUUID().toString();
						// 按照时间保存
						SimpleDateFormat dateFormater = new SimpleDateFormat(
								"yyyyMMddHHmmss");
						Date date = new Date();
						String timefileName = dateFormater.format(date);

						filePath = serverPath + uploadPath + uuid
								+ timefileName.substring(fileName.lastIndexOf("."));
						item.write(new File(filePath));
						PrintWriter pw = response.getWriter();
						pw.flush();
						pw.close();
						break;
					} else {
						request.setAttribute("message",
								"上传失败,请确认上传的文件存在并且类型是图片!");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "上传失败,请确认上传的文件存在并且类型是图片!");
			return null;
		}
		return filePath;

	}
}
