package com.DBAuther;

import com.DBUtility.SqlHelper;
import com.bean.ChapterBean;
/**
 * 章节class
 * @author zhangyi
 *
 */
public class SqlChapter {
	public boolean insertBean(ChapterBean cb)
	{
		String sql=String.format("insert into chapter (ChapterName,ChapterContent,NovelID) values ('%s','%s','%s')",
				cb.getChapterName(),cb.getChapterContent(),cb.getNovelID());
		return SqlHelper.executeNonQuery(sql)==1;
	}
}
