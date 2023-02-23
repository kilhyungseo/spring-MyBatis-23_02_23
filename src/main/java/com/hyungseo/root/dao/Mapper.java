package com.hyungseo.root.dao;

import java.util.ArrayList;

import com.hyungseo.root.dto.BoardDto;
import com.hyungseo.root.dto.MemberDto;

public interface Mapper {
	//성공한 리턴값을 받을려면 int 안받으려면 void
	public void joinDao(String mid, String mpw, String mname, String memail); //회원가입 메서드
	
	public int loginCheck(String mid, String mpw);	//아이디 중복 조회
	
	public MemberDto memberInfo(String mid);	//회원정보 조회 메서드
	
	public void memberDelete(String mid);
	
	public void write(String bmid, String bmname, String btitle, String bcontent);	//게시판 글쓰기
	
	public ArrayList<BoardDto> list();	//게시판 리스트보기
	
	public BoardDto contentView(int bid); //게시판 글보기
	
	public void modify(int bid, String btitle, String bcontent);	//게시판 글수정
	
	public void delete(int bid);	//게시판 글 삭제
}
