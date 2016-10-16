package com.nabil.anl.model;

public class Book {

	private Integer bId ; 
	private String bName ;
	private String bAuthor ;
	private String bISBN ;
	
	public String getbISBN() {
		return bISBN;
	}
	public void setbISBN(String bISBN) {
		this.bISBN = bISBN;
	}
	public Integer getbId() {
		return bId;
	}
	public void setbId(Integer bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbAuthor() {
		return bAuthor;
	}
	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	
}
