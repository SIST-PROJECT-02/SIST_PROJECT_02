package com.sist.member.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import sun.nio.cs.HistoricallyNamedCharset;


@Controller
public class MemberModel {

	@RequestMapping("views/template/main/member_join.do")
	public String join(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("jsp","../../member/member_join.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/member_join_ok.do")
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
		
		request.setAttribute("jsp","../../member/member_join_ok.jsp");
		/*return "redirect:../template/main/index.jsp";*/
		return "index.jsp";
	}
	
	@RequestMapping("views/member/member_login.do")
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
		/*System.out.println("MappingEmail: "+vo);*/
		request.setAttribute("msg", vo.getMsg());
		return "member_login.jsp";
	}
	
	@RequestMapping("views/template/main/member_logout.do")
	public String memberLogout(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		session.invalidate();
		return "index.jsp";
	}
	
	@RequestMapping("views/member/member_checkid.do")
	public String memberidCheck(HttpServletRequest request, HttpServletResponse response)
	{
		return "member_checkid.jsp";
	}
	
	@RequestMapping("views/member/member_checkid_ok.do")
	public String memberidCheckOk(HttpServletRequest request, HttpServletResponse response)
	{
		String email=request.getParameter("email");
		int count=MemberDAO.checkid(email);
		request.setAttribute("count", count);
		return "member_checkid_ok.jsp";
	}
	
	@RequestMapping("views/template/main/member_mypage.do")
	public String memberDetailData(HttpServletRequest request, HttpServletResponse response)
	{	
		/*name,nick,birth,tel*/
		String email=request.getParameter("email");
		MemberVO vo=MemberDAO.memberDetailData(email);
		request.setAttribute("vo", vo);
		request.setAttribute("jsp", "../../member/member_mypage.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/member_update.do")
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
		request.setAttribute("jsp", "../../member/member_update.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/member_delete.do")
	public String memberDelete(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex){}
		
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		/*System.out.println("mapper email:"+email);
		System.out.println("mapper pwd"+pwd);*/
		//DAO연결
		boolean bCheck=MemberDAO.memberDelete(email, pwd);
		request.setAttribute("bCheck", bCheck);
		return "../../member/member_delete.jsp";
	}
	
	@RequestMapping("views/template/main/member_delete_ok.do")
	public String memberDeleteOK(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		session.invalidate();
		request.setAttribute("jsp", "../../member/member_delete_ok.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/member_like.do")
	public String memberLike(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("jsp", "../../member/member_like.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/member_reservation.do")
	public String memberReservation(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("jsp", "../../member/member_reservation.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/reserve_hotel.do")
	public String reserve_hotel(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("jsp", "../../member/reserve_hotel.jsp");
		return "redirect:../../member/reserve_hotel.jsp";
	}
	
	@RequestMapping("views/template/main/reserve_air.do")
	public String reserve_air(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("jsp", "../../member/reserve_air.jsp");
		return "redirect:../../member/reserve_air.jsp";
	}
	
	@RequestMapping("views/template/main/guidebook_safe.do")
	public String guidebook_safe(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("jsp", "../../guidebook/guidebook_safe.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/guidebook_map.do")
	public String guidebook_map(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("jsp", "../../guidebook/guidebook_map.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/guidebook_guide.do")
	public String guidebook_guide(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("jsp", "../../guidebook/guidebook_guide.jsp");
		return "index.jsp";
	}
}
