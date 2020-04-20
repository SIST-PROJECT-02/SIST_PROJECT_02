package com.sist.member.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.member.model.*;
import java.util.*;

@Controller
public class MemberModel {

	@RequestMapping("views/template/main/join.do")
	public String join(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("jsp","../../member/join.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/member/join_ok.do")
	public String join_ok(HttpServletRequest request, HttpServletResponse response)
	{
		//한글송수인가능하도록 코드변환
		try
		{
			request.setCharacterEncoding("UTF-8");
		}
		catch(Exception ex){}
		
		//회원가입 필요정보 저장
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd1");
		String name=request.getParameter("name");
		String nick=request.getParameter("nick");
		String gender=request.getParameter("gender");
		String birth=request.getParameter("birth");
		String tel=request.getParameter("tel");
		
		//vo에 값저장
		MemberVO vo=new MemberVO();
		vo.setEmail(email);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setNick(nick);
		vo.setGender(gender);
		vo.setBirth(birth);
		vo.setTel(tel);
		
		//dao연결
		MemberDAO.memberInsert(vo);
		
		/*request.setAttribute("jsp","../../member/join.jsp");*/
		return "redirect:../template/main/index.jsp";
	}
	
	@RequestMapping("views/member/login.do")
	public String memberLogin(HttpServletRequest request,HttpServletResponse response)
	{
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		MemberVO vo=MemberDAO.memberLogin(email, pwd);
		if(vo.getMsg().equals("OK"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("name", vo.getName());
			session.setAttribute("admin",vo.getAdmin());
		}
		System.out.println("MappingEmail: "+vo);
		request.setAttribute("msg", vo.getMsg());
		return "login.jsp";
	}
	
	@RequestMapping("views/template/main/logout.do")
	public String memberLogout(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		session.invalidate();
		return "index.jsp";
	}
	
	@RequestMapping("views/member/checkid.do")
	public String memberidCheck(HttpServletRequest request, HttpServletResponse response)
	{
		return "checkid.jsp";
	}
	
	@RequestMapping("views/member/checkid_ok.do")
	public String memberidCheckOk(HttpServletRequest request, HttpServletResponse response)
	{
		String email=request.getParameter("email");
		int count=MemberDAO.checkid(email);
		request.setAttribute("count", count);
		return "checkid_ok.jsp";
	}
	
	@RequestMapping("views/template/main/mypage.do")
	public String memberDetailData(HttpServletRequest request, HttpServletResponse response)
	{	
		/*name,nick,birth,tel*/
		String email=request.getParameter("email");
		MemberVO vo=MemberDAO.memberDetailData(email);
		request.setAttribute("vo", vo);
		request.setAttribute("jsp", "../../member/mypage.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/member/update.do")
	public String memberUpdate(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex){}
		
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd1");
		String name=request.getParameter("name");
		String nick=request.getParameter("nick");
		String gender=request.getParameter("gender");
		String birth=request.getParameter("birth");
		String tel=request.getParameter("tel");
		
		MemberVO vo=new MemberVO();
		vo.setEmail(email);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setNick(nick);
		vo.setGender(gender);
		vo.setBirth(birth);
		vo.setTel(tel);
		
		MemberDAO.memberUpdate(vo);
		return "redirect:../template/main/index.jsp";
	}
}
