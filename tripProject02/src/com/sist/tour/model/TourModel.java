package com.sist.tour.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.hotel.dao.HotelVO;
import com.sist.tour.model.TourDAO;

@Controller
public class TourModel {

	@RequestMapping("views/template/main/tour.do")
	public String tourlist(HttpServletRequest request, HttpServletResponse response)
	{	
		String product_kind="관광지";
		/*System.out.println("1. member_email은 "+member_email);*/
		List<HotelVO> vo=TourDAO.tourlist(product_kind);
		/*System.out.println("4. List는 "+vo);*/
		request.setAttribute("vo", vo);
		request.setAttribute("jsp", "../../tour/tour.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/tour_more.do")
	public String tourlistmore(HttpServletRequest request, HttpServletResponse response)
	{	
		
		try{
			request.setCharacterEncoding("UTF-8");
		}catch (Exception ex) {	}
		String page=request.getParameter("page");
		
		if(page==null) page="1";
		
		int i=0;
		int totalpage=0;
		int curpage=Integer.parseInt(page);
		int rowSize=9;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=(curpage*rowSize);
		
		
		
		return "redirect:tour.do";
	}
}
