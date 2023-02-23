package com.hyungseo.root.dto;

import java.sql.Timestamp;

public class BoardDto {
	private int bid; //게시판번호
	private String btitle;	//게시판제목
	private String bcontent;	//게시판내용
	private Timestamp bdate;	//게시판글쓴날짜
	private String bmid;	//게시판글쓴아이디
	private String bmname;	//게시판글쓴이이름
	
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardDto(int bid, String btitle, String bcontent, Timestamp bdate, String bmid, String bmname) {
		super();
		this.bid = bid;
		this.btitle = btitle;
		this.bcontent = bcontent;
		
		this.bdate = bdate;
		this.bmid = bmid;
		this.bmname = bmname;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public Timestamp getBdate() {
		return bdate;
	}
	public void setBdate(Timestamp bdate) {
		this.bdate = bdate;
	}
	public String getBmid() {
		return bmid;
	}
	public void setBmid(String bmid) {
		this.bmid = bmid;
	}
	public String getBmname() {
		return bmname;
	}
	public void setBmname(String bmname) {
		this.bmname = bmname;
	}
	
	
}
