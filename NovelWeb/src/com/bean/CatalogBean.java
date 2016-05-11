package com.bean;

public class CatalogBean {
	private int chapterID;
	private String ChapterName;
	private String ChapterContent;
	private int novelID;
	
	
	public CatalogBean(int chapterID, String chapterName) {
		super();
		this.chapterID = chapterID;
		ChapterName = chapterName;
	}
	public CatalogBean() {
		// TODO Auto-generated constructor stub
	}
	public int getChapterID() {
		return chapterID;
	}
	public void setChapterID(int chapterID) {
		this.chapterID = chapterID;
	}
	public String getChapterName() {
		return ChapterName;
	}
	public void setChapterName(String chapterName) {
		ChapterName = chapterName;
	}
	public String getChapterContent() {
		return ChapterContent;
	}
	public void setChapterContent(String chapterContent) {
		ChapterContent = chapterContent;
	}
	public int getNovelID() {
		return novelID;
	}
	public void setNovelID(int novelID) {
		this.novelID = novelID;
	}
	
}
