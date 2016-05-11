package com.DBUtility;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.CatalogBean;
import com.bean.NovelBean;
import com.mysql.jdbc.ResultSet;

public class SqlNovel {

	public String getChapterName(int Chapterid) {
		String sql=String.format("select ChapterName from chapter where Chapterid='%s'",Chapterid);
		ResultSet rs=SqlHelper.executeQuery(sql);
		try {
			if(rs.next())
			{
				return rs.getString("ChapterName");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.Close();
		}
		return "没读到章节内容";
	}
	/**
	 * 获得小说的第一章
	 * @param novelid
	 * @return
	 */
	public int getFristId(int novelid)
	{
		String sql=String.format("select * from chapter where NovelID='%s' order by ChapterID limit 1",novelid);
		ResultSet rs=SqlHelper.executeQuery(sql);
		try {
			if(rs.next())
			{
				return rs.getInt("ChapterID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.Close();
		}
		return -1;
	}
	/**
	 * 按添加查询所有书籍
	 * @param where
	 * @return
	 */
	public ArrayList<NovelBean> getBookList(String where){
		
		String sql="select * from novel n left join author a on n.AuthorID=a.AuthorID "+ where;
		ResultSet rs=SqlHelper.executeQuery(sql);
		
		ArrayList<NovelBean> arraybook=new ArrayList<NovelBean>();
		try {
			while(rs.next())
			{
				NovelBean nb=new NovelBean();
				nb.setNovelID(rs.getInt("NovelID"));
				nb.setNovelName(rs.getString("NovelName"));
				nb.setPic(rs.getString("Pic"));
				nb.setContent(rs.getString("Content"));
				nb.setCategory(rs.getString("Category"));
				nb.setClickCount(rs.getInt("ClickCount"));
				nb.setProgress(rs.getString("Progress"));
				nb.setWordCount(rs.getInt("WordCount"));
				nb.setPrice(rs.getFloat("Price"));
				nb.setAuthorID(rs.getInt("AuthorID"));
				nb.setAuthorName(rs.getString("AuthorName"));
				arraybook.add(nb);
			}
			return arraybook;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.Close();
		}
		return null;
	}
	/**
	 * 所有书籍
	 * @return
	 */
	public ArrayList<NovelBean> getBookList(){
		
		String sql="select * from novel n left join author a on n.AuthorID=a.AuthorID;";
		ResultSet rs=SqlHelper.executeQuery(sql);
		
		ArrayList<NovelBean> arraybook=new ArrayList<NovelBean>();
		try {
			while(rs.next())
			{
				NovelBean nb=new NovelBean();
				nb.setNovelID(rs.getInt("NovelID"));
				nb.setNovelName(rs.getString("NovelName"));
				nb.setPic(rs.getString("Pic"));
				nb.setContent(rs.getString("Content"));
				nb.setCategory(rs.getString("Category"));
				nb.setClickCount(rs.getInt("ClickCount"));
				nb.setProgress(rs.getString("Progress"));
				nb.setWordCount(rs.getInt("WordCount"));
				nb.setPrice(rs.getFloat("Price"));
				nb.setAuthorID(rs.getInt("AuthorID"));
				nb.setAuthorName(rs.getString("AuthorName"));
				arraybook.add(nb);
			}
			return arraybook;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.Close();
		}
		return null;
	}	
	
	/**
	 *根据小说id，获取目录
	 * @param NovelID
	 * @return
	 */
	public ArrayList<CatalogBean> getCatalogByNovelID(String NovelID)
	{
		String sql="select ChapterID,ChapterName,NovelID from chapter where NovelID='"+NovelID+"';";
		ResultSet rs=SqlHelper.executeQuery(sql);
		ArrayList<CatalogBean> arrayCatalog=new ArrayList<CatalogBean>();
		try {
			while(rs.next())
			{
				CatalogBean cb=new CatalogBean();
				cb.setChapterID(rs.getInt("ChapterID"));
				cb.setChapterName(rs.getString("ChapterName"));
				//cb.setChapterContent(rs.getString("ChapterContent"));//内存大，不读出来
				cb.setNovelID(rs.getInt("NovelID"));
				arrayCatalog.add(cb);
			}
			return arrayCatalog;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.Close();
		}
		return null;
	}
	
	/**
	 * 根据章节ID获得内容
	 * @param ChapterID
	 * @return
	 */
	public String getChapterContentByChapterID(int ChapterID)
	{
		
		String sql="select ChapterContent from chapter where ChapterID='"+ChapterID+"'";
		ResultSet rs=SqlHelper.executeQuery(sql);
		try {
			if(rs.next())
			{
				
				return rs.getString("ChapterContent");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.Close();
		}
		return "无法读取章节内容";
	}
	/**
	 * 获得上下章目录
	 * @param ChapterID
	 * @return
	 */
	public ArrayList<CatalogBean> getUpAndDownChapterBy(String ChapterID,ArrayList<CatalogBean> CatalogList)
	{
		int index=-1;//ChapterID在CatalogList的下标
		for (CatalogBean catalogBean : CatalogList) {
			if(catalogBean.getChapterID()==Integer.parseInt(ChapterID))
				index=CatalogList.indexOf(catalogBean);
		}
		
		ArrayList<CatalogBean> UpAndDownChapterlist=new ArrayList<CatalogBean>();
		UpAndDownChapterlist.clear();
		if(index>0&&index<CatalogList.size()-1)
		{//当前章节为中间章节
			UpAndDownChapterlist.add(CatalogList.get(index-1));
			UpAndDownChapterlist.add(CatalogList.get(index+1));
		}else if(index==0){
			//为第一章
			CatalogBean cb=new CatalogBean(-1,"没有了");
			UpAndDownChapterlist.add(cb);
			if(CatalogList.size()!=1)
			{//为第一章，且只有一章
				UpAndDownChapterlist.add(CatalogList.get(index+1));
			}else{
				UpAndDownChapterlist.add(cb);
			}
			
		}else{
			//为最后一章
			CatalogBean cb=new CatalogBean(-1,"没有了");
			UpAndDownChapterlist.add(CatalogList.get(index-1));
			UpAndDownChapterlist.add(cb);
		}
		
		SqlHelper.Close();
		
		return UpAndDownChapterlist;
		
	}
	/**
	 * 根据小说id获得小说bean
	 * @param novelID
	 * @return
	 */
	public NovelBean getBeanByNovelID(String novelID) {
		String sql="select * from novel n left join author a on n.AuthorID=a.AuthorID where novelID='"+novelID+"';";
		ResultSet rs=SqlHelper.executeQuery(sql);
		try {
			if(rs.next())
			{
				NovelBean nb=new NovelBean();
				nb.setNovelID(rs.getInt("NovelID"));
				nb.setNovelName(rs.getString("NovelName"));
				nb.setPic(rs.getString("Pic"));
				nb.setContent(rs.getString("Content"));
				nb.setCategory(rs.getString("Category"));
				nb.setClickCount(rs.getInt("ClickCount"));
				nb.setProgress(rs.getString("Progress"));
				nb.setWordCount(rs.getInt("WordCount"));
				nb.setPrice(rs.getFloat("Price"));
				nb.setAuthorID(rs.getInt("AuthorID"));
				nb.setAuthorName(rs.getString("AuthorName"));
				return nb;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.Close();
		}
		return null;
		
	}
	/**
	 * 插入NovelBean
	 * @param NovelBean
	 * @return
	 */
	public boolean addNovelBean(NovelBean nb){
		String sql=String.format("insert into novel (NovelName,Pic,Content,Category,ClickCount,Progress,WordCount,"
				+ "Price,AuthorID) values ('%s','%s','%s','%s','%s','%s','%s','%s','%s');",
				nb.getNovelName(),nb.getPic(),nb.getContent(),nb.getCategory(),nb.getClickCount(),
				nb.getProgress(),nb.getWordCount(),nb.getPrice(),nb.getAuthorID());
		boolean b= SqlHelper.executeNonQuery(sql)==1;

		SqlHelper.Close();

		return b;
	}
	/**
	 * 更新NovelBean
	 * @param nb
	 * @return
	 */
	public boolean updateNovelBean(NovelBean nb) {
		String sql=String.format("update novel set NovelName='%s', Pic='%s',Content='%s',Category='%s',"
				+ "ClickCount='%s',Progress='%s',WordCount='%s',Price='%s',AuthorID='%s' where novelID='%s';",
				nb.getNovelName(),nb.getPic(),nb.getContent(),nb.getCategory(),nb.getClickCount(),
				nb.getProgress(),nb.getWordCount(),nb.getPrice(),nb.getAuthorID(),nb.getNovelID());
		boolean b= SqlHelper.executeNonQuery(sql)==1;
		SqlHelper.Close();
		return b;
	}
	/**
	 * 删除小说，级联删除章节
	 * @param novelID
	 * @return
	 */
	public boolean delNovelBynovelID(int novelID)
	{
		String sql=String.format("DELETE FROM novel WHERE novelID = '%s';",novelID);
		boolean b1= SqlHelper.executeNonQuery(sql)==1;
		sql=String.format("DELETE FROM Chapter WHERE novelID = '%s';",novelID);
		boolean b2= SqlHelper.executeNonQuery(sql)>=1;
		SqlHelper.Close();
		return b1&&b2;
	}
}
