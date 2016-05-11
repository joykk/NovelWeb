package com.DBAuther;

import java.util.ArrayList;

import com.DBUtility.SqlHelper;
import com.DBUtility.SqlNovel;
import com.bean.NovelBean;

public class SqlAutherNovel {
	public ArrayList<NovelBean> getNovelsByAutherID(int authorID)
	{
		SqlNovel sn=new SqlNovel();
		String where=String.format("where a.authorID = '%s'", authorID);
		ArrayList<NovelBean> list= sn.getBookList(where);
		SqlHelper.Close();
		return list;
	}
}
