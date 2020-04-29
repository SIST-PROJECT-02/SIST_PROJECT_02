package com.sist.tour.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.airplane.dao.AirplaneDAO;
import com.sist.airplane.dao.AirplaneVO;
import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.hotel.dao.HotelVO;
import com.sist.tour.model.TourDAO;

@Controller
public class TourModel {

	@RequestMapping("views/template/main/tour.do")
	public String tour(HttpServletRequest request, HttpServletResponse response)
	{	
		String product_kind="관광지";
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowsize=9;
		int start=(rowsize*curpage)-(rowsize-1);
		int end=(rowsize*curpage);
		
		Map map=new HashMap();
		
		map.put("product_kind", product_kind);
		map.put("start", start);
		map.put("end", end);
	
		List<TourVO> list=TourDAO.tourlist(map);
		
		for(TourVO vo:list)
		{
			String title=vo.getTitle();
			if(title.indexOf("(") > 0)
			{
				title=title.substring(0,title.indexOf("("));
				vo.setTitle(title);
			}
			
		}
		
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("jsp", "../../tour/tour.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/tour_list.do")
	public String tour_list(HttpServletRequest request, HttpServletResponse response)
	{	
		System.out.println("hi");
		String product_kind="관광지";
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowsize=9;
		int start=(rowsize*curpage)-(rowsize-1);
		int end=(rowsize*curpage);
		
		Map map=new HashMap();
		
		map.put("product_kind", product_kind);
		map.put("start", start);
		map.put("end", end);
	
		List<TourVO> list=TourDAO.tourlist(map);
		for(TourVO vo:list)
		{
			String title=vo.getTitle();
			if(title.indexOf("(") > 0)
			{
				title=title.substring(0,title.indexOf("("));
				vo.setTitle(title);
			}
			
		}
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		
		return "../../tour/tour_list.jsp";
	}
	
	/*@RequestMapping("views/template/main/tour_more.do")
	public String tourlistmore(HttpServletRequest request, HttpServletResponse response)
	{	
		
		try{
			request.setCharacterEncoding("UTF-8");
		}catch (Exception ex) {	}
		
		String product_kind="관광지";
		int totalpage=TourDAO.tourTotalPage(product_kind);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("jsp", "../../tour/tour.jsp");
		return "index.jsp";
	}*/
}
