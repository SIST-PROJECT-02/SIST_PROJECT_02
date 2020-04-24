package com.sist.guidebook.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller
public class GuidebookModel {
	
	@RequestMapping("views/template/main/guidebook_safe.do")
	public String safeTravel(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("jsp", "../../guidebook/guidebook_safe.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/guidebook_guide.do")
	public String travelGuide(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("jsp", "../../guidebook/guidebook_guide.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/guidebook_map.do")
	public String travelMap(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("jsp", "../../guidebook/guidebook_map.jsp");
		return "index.jsp";
	}
	
}
