package com.sist.member.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import com.sist.airplane.dao.AirplaneDAO;
import com.sist.airplane.dao.AirplaneReserveVO;
import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.hotel.dao.HotelDAO;
import com.sist.hotel.dao.HotelVO;
import com.sist.hotel.dao.LikeDAO;
import com.sist.hotel.dao.LikeVO;

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
		request.setAttribute("jsp", "mainPage.jsp");
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
		String member_email=request.getParameter("email");
		/*System.out.println("1. member_email은 "+member_email);*/
		List<HotelVO> vo=MemberDAO.memberLike(member_email);
		/*System.out.println("4. List는 "+vo);*/
		request.setAttribute("email", member_email);
		request.setAttribute("vo", vo);
		request.setAttribute("jsp","../../member/member_like_ok.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/member_reservation.do")
	public String memberReservation(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			request.setCharacterEncoding("UTF-8");
		}catch (Exception ex) {}
		HttpSession session=request.getSession();
		
		String email=(String)session.getAttribute("email");
		String admin=(String)session.getAttribute("admin");
		
		Map map=new HashMap();
		map.put("email", email);
		map.put("admin", admin);
		List<AirplaneReserveVO> list=AirplaneDAO.airplaneReserveData(map);
		Map hmap=new HashMap();
		hmap.put("email", email);
		hmap.put("admin", admin);
		List<HotelReserveVO> hotellist=HotelplaneDAO.HotelReserve(hmap);
		for(AirplaneReserveVO vo:list)
		{
			String date=vo.getStart_time().substring(0,10);
			String day=vo.getStart_time().substring(vo.getStart_time().indexOf("("),vo.getStart_time().lastIndexOf(")")+1);
			vo.setDate(date);
			vo.setDay(day);
		}
		request.setAttribute("jsp", "../../member/member_reservation.jsp");
		request.setAttribute("airList", list);
		request.setAttribute("hotelList",hotellist);
		return "index.jsp";
	}
	@RequestMapping("views/template/main/member_admin_reservation.do")
	public String member_admin_reservation(HttpServletRequest request,HttpServletResponse response)
	{
		try{
			request.setCharacterEncoding("UTF-8");
		}catch (Exception ex) {}
		HttpSession session=request.getSession();
		
		String email=(String)session.getAttribute("email");
		String admin=(String)session.getAttribute("admin");
		
		Map map=new HashMap();
		map.put("email", email);
		map.put("admin", admin);
		
		List<AirplaneReserveVO> list=AirplaneDAO.airplaneReserveData(map);
		
		for(AirplaneReserveVO vo:list)
		{
			String date=vo.getStart_time().substring(0,10);
			String day=vo.getStart_time().substring(vo.getStart_time().indexOf("("),vo.getStart_time().lastIndexOf(")")+1);
			vo.setDate(date);
			vo.setDay(day);
		}
		request.setAttribute("jsp", "../../member/member_admin_reservation.jsp");
		request.setAttribute("airList", list);
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/member_admin_reservation_ok.do")
	public String member_admin_reservation_ok(HttpServletRequest request, HttpServletResponse response)
	{
		String rno=request.getParameter("rno");
		
		AirplaneDAO.airplaneReserveDataUpdate(Integer.parseInt(rno));
		return "redirect:../../template/main/member_admin_reservation.do";
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
	
	@RequestMapping("views/template/main/member_forgot.do")
	public String memberForgot(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("jsp", "../../member/member_forgot.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/member_forgot_email_ok.do")
	public String memberforgotemail(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex){}
		
		String name=request.getParameter("name");
		String birth=request.getParameter("birth");
		String email=MemberDAO.memberforgotemail(name, birth);
		request.setAttribute("email",email);
		request.setAttribute("jsp", "../../member/member_forgot_email_ok.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/member_forgot_pwd_ok.do")
	public String memberforgotpwdok(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex){}
		
		String email=request.getParameter("email");
		String pwd=MemberDAO.memberforgotpwd(email);
		request.setAttribute("pwd", pwd);
		request.setAttribute("jsp", "../../member/member_forgot_pwd_ok.jsp");
		return "index.jsp";
	}
}
