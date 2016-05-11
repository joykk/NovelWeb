package com.DBUtility;

import java.util.ArrayList;

import com.bean.NovelBean;

public class SqlSearch {
	private String keyword;

	public SqlSearch(String keyword) {
		super();
		this.keyword = keyword;
	}

	
	public ArrayList<NovelBean> Search()
	{
		String where="where NovelName='"+keyword+"' or AuthorName='"+keyword+"';";
		SqlNovel sn=new SqlNovel();
		ArrayList<NovelBean> list=sn.getBookList(where);
		SqlHelper.Close();
		return list;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
