package com.sist.main.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller
public class MainModel {

	@RequestMapping("views/template/main/mainPage.do")
	public String mainProducts(HttpServletRequest request,HttpServletResponse response) 
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}
		catch(Exception ex){}

		String start="1";
		String end="5";
		double evel_point=3.0;
		
		Map hotelmap=new HashMap();
		Map tourmap=new HashMap();
		Map foodmap=new HashMap();
		
		hotelmap.put("start", start);
		hotelmap.put("end", end);
		hotelmap.put("evel_point", evel_point);

		tourmap.put("start", start);
		tourmap.put("end", end);
		tourmap.put("evel_point", evel_point);
		
		foodmap.put("start", start);
		foodmap.put("end", end);
		foodmap.put("evel_point", evel_point);
		
		List<MainHotelVO> hotelvo=MainDAO.mainpageHotel(hotelmap);
		List<MainTourVO> tourvo=MainDAO.mainpageTour(tourmap);
		List<MainFoodVO> foodvo=MainDAO.mainpageFood(foodmap);

		request.setAttribute("hotelvo", hotelvo);
		request.setAttribute("tourvo", tourvo);
		request.setAttribute("foodvo", foodvo);
		
		/*System.out.println("hotelvo는 "+hotelvo);
		System.out.println("tourvo는 "+tourvo);
		System.out.println("foodvo는 "+foodvo);*/
		
		request.setAttribute("jsp", "mainPage.jsp");

		return "index.jsp";
	}
	
}
