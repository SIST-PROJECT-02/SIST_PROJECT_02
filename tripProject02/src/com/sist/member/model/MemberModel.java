package com.sist.member.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller
public class MemberModel {
	@RequestMapping("views/member/signin.do")
	public String mem(HttpServletRequest request, HttpServletResponse response){
		System.out.println("hello");
		return "hello";
	}
}
