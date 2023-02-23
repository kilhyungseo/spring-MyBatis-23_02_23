package com.hyungseo.root.controller;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hyungseo.root.dao.Mapper;
import com.hyungseo.root.dto.BoardDto;
import com.hyungseo.root.dto.MemberDto;

@Controller
public class RootController {

		@Autowired
		private SqlSession sqlSession; //DI 의존주입
		
		
		@RequestMapping(value= "/")
		public String index() {
			
			
			return "index";
		}
		
		
		
		@RequestMapping(value= "/join" )
		public String join() {
			
			return "join";
		}
		
		@RequestMapping(value= "/joinOk")
		public String joinOk(HttpServletRequest request, Model model) {
			
			String mid = request.getParameter("mid");
			String mpw = request.getParameter("mpw");
			String mname = request.getParameter("mname");
			String memail = request.getParameter("memail");
			
			Mapper mapper = sqlSession.getMapper(Mapper.class);
			mapper.joinDao(mid, mpw, mname, memail);
			
			model.addAttribute("mname", mname);
			return "joinOk";
		}
		
		@RequestMapping(value= "/login")
		public String login() {
			
			
			return "login";
		}
		
		@RequestMapping(value= "/loginOk")
		public String loginOk(HttpServletRequest request, Model model) {
			
			String mid = request.getParameter("mid");
			String mpw = request.getParameter("mpw");
			
			Mapper mapper = sqlSession.getMapper(Mapper.class);
			int result = mapper.loginCheck(mid, mpw);	//반환값이 1이면 아이디와 비밀번호가 일치->로그인성공
			model.addAttribute("loginCheck", result);
			if(result == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("sessionid", mid);
				session.setAttribute("ValidMem", "yes");
				model.addAttribute("memberid", mid);
				
			}
			return "loginOk";
		}
		
		@RequestMapping(value= "/logout")
		public String logout(HttpServletRequest request) {
			
			HttpSession session = request.getSession();
			session.invalidate();
			System.out.println("logout");
			return "redirext:index";
		}
		
		@RequestMapping(value= "/memberInfo")
		public String memberInfo(HttpServletRequest request, Model model) {
			
			HttpSession session = request.getSession();
			String sessionId = (String) session.getAttribute("sessionid");
			Mapper mapper = sqlSession.getMapper(Mapper.class);
			MemberDto dto = mapper.memberInfo(sessionId);
			model.addAttribute("memberDto", dto);
			return "memberInfo";
		}
		
		@RequestMapping(value= "/memberDelete")
		public String memberDelete(HttpServletRequest request, Model model) {
			
			HttpSession session = request.getSession();
			String sessionId = (String) session.getAttribute("sessionid");
			Mapper mapper = sqlSession.getMapper(Mapper.class);
			mapper.memberDelete(sessionId);
			
			return "index";
		}
		
		@RequestMapping(value= "/writeForm")
		public String writeForm(HttpServletRequest request, Model model) {
			
			HttpSession session = request.getSession();
			String sessionId = (String) session.getAttribute("sessionid");
			if(sessionId == null) {	//로그인 하지 않은 상태
				model.addAttribute("mid", "GUEST");
				model.addAttribute("mname", "비회원");
			}else {
				Mapper mapper = sqlSession.getMapper(Mapper.class);
				MemberDto dto = mapper.memberInfo(sessionId);
				model.addAttribute("mid", dto.getMid());
				model.addAttribute("mname", dto.getMname());
			}
			
			return "writeForm";
		}
		
		@RequestMapping(value= "/write")
		public String write(HttpServletRequest request, Model model) {
			
			HttpSession session = request.getSession();
			String sessionId = (String) session.getAttribute("sessionid");
			Mapper mapper = sqlSession.getMapper(Mapper.class);
			
			String btitle = request.getParameter("btitle");
			String bcontent = request.getParameter("bcontent");
			String bmid = null;
			String bmname = null;
			if(sessionId == null) {	//로그인 하지 않은 상태
				bmid = "GUEST";
				bmname = "비회원";
				mapper.write(bmid, bmname, btitle, bcontent);
			}else {
				MemberDto dto = mapper.memberInfo(sessionId);
				bmid = dto.getMid();
				bmname = dto.getMname();
				mapper.write(bmid, bmname, btitle, bcontent);
			}
			
			return "redirect:list";
		}
		
		@RequestMapping(value= "/list")
		public String list(Model model) {
			Mapper mapper = sqlSession.getMapper(Mapper.class);
			ArrayList<BoardDto> list = mapper.list();
			model.addAttribute("list", list);
			
			return "list";
		}
		@RequestMapping(value= "/bcontentView")
		public String bcontentView(HttpServletRequest request, Model model) {
			int bid = Integer.parseInt(request.getParameter("bid").toString());
			Mapper mapper = sqlSession.getMapper(Mapper.class);
			BoardDto bdto = mapper.contentView(bid);
			model.addAttribute("bdto", bdto);
			return "bcontentView";
		}
		
		@RequestMapping(value= "/modifyView")
		public String modifyView(HttpServletRequest request, Model model) {
			int bid = Integer.parseInt(request.getParameter("bid").toString());
			Mapper mapper = sqlSession.getMapper(Mapper.class);
			BoardDto bdto = mapper.contentView(bid);
			model.addAttribute("bdto", bdto);
			return "modifyView";
		}
		
		@RequestMapping(value= "/modify")
		public String modify(HttpServletRequest request, Model model) {
			int bid = Integer.parseInt(request.getParameter("bid").toString());
			String btitle = request.getParameter("btitle");
			String bcontent = request.getParameter("bcontent");
			Mapper mapper = sqlSession.getMapper(Mapper.class);
			mapper.modify(bid, btitle, bcontent);
			
			return "redirect:list";
		}
		
		@RequestMapping(value= "/delete")
		public String delete(HttpServletRequest request, Model model) {
			int bid = Integer.parseInt(request.getParameter("bid").toString());
			
			Mapper mapper = sqlSession.getMapper(Mapper.class);
			mapper.delete(bid);
			
			return "redirect:list";
		}
}
