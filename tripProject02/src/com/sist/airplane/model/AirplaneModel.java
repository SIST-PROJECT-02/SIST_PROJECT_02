package com.sist.airplane.model;

import java.text.SimpleDateFormat;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import com.sist.airplane.dao.*;

@Controller
public class AirplaneModel {
	@RequestMapping("views/template/main/airplane.do")
	public String airplane_list(HttpServletRequest request,HttpServletResponse response)
	{
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		Calendar c=Calendar.getInstance();
		Date currentTime = new Date ();
		c.setTime(currentTime);
		c.add(Calendar.DATE, 1);
		String today = mSimpleDateFormat.format(c.getTime());
		
		request.setAttribute("height", "height:1350px");
		request.setAttribute("today", today);
		request.setAttribute("jsp", "../../airplane/airplaneList.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/airplane/airplaneList_ok.do")
	public String airplane_list_ok(HttpServletRequest request,HttpServletResponse response)
	{
		try{
			request.setCharacterEncoding("UTF-8");
		}catch (Exception ex) {	}
		String page=request.getParameter("page");
		System.out.println("Model page:"+page);
		
		int i=0;
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=(rowSize*curpage);
		int totalpage=0;
		String type=request.getParameter("type");
		System.out.println("type :"+type);
		if(type==null)
			type="0";
		int typeInt=Integer.parseInt(type);
		
		String start_airport="";
		String end_airport="";
		String start_time="";
		String end_time="";
		String airway="";
		
		
		Map map=new HashMap();
		/*System.out.println("typeInt :" +typeInt);*/
		List<AirplaneVO> list = null;
		
		
		if(typeInt==1)
		{
			start_airport=request.getParameter("start_airport");
			end_airport=request.getParameter("end_airport");
			end_time=request.getParameter("end_time");
			airway=request.getParameter("airway");
			
			end_time=end_time.replace("-", "/");
			if(end_time.length() != 8)
				end_time=end_time.substring(2);
			System.out.println("===================================");
			System.out.println("start_airport :"+start_airport);
			System.out.println("end_airport :"+end_airport);
			System.out.println("start_time: "+start_time);
			System.out.println("end_time :"+end_time);
			System.out.println("airway :"+airway);
			System.out.println("type :"+type);
			System.out.println("start:" +start);
			System.out.println("end :"+end);
			System.out.println("===================================");
			
			map.put("start_airport", start_airport);
			map.put("end_airport", end_airport);
			map.put("start_time", start_time);
			map.put("end_time", end_time);
			map.put("airway", airway);
			map.put("start", start);
			map.put("end", end);
			
			totalpage=AirplaneDAO.airplaneTotalPage(map);
			System.out.println("end totalpage :" +totalpage);
			list=AirplaneDAO.endAirplaneListData(map);
			
		}
		else
		{
			
			start_airport=request.getParameter("start_airport");
			end_airport=request.getParameter("end_airport");
			start_time=request.getParameter("start_time");
			end_time=request.getParameter("end_time");
			airway=request.getParameter("airway");
			type=request.getParameter("type");
			
			
			start_time=start_time.replace("-", "/");
			
			if(start_time.length() != 8)
				start_time=start_time.substring(2);
			
		/*	System.out.println(start_airport);
			System.out.println(end_airport);
			System.out.println(start_time);
			System.out.println(end_time);
			System.out.println(airway);
			System.out.println(type);
			System.out.println(start);
			System.out.println(end);*/
			
			
			
			map.put("start_airport", start_airport);
			map.put("end_airport", end_airport);
			map.put("start_time", start_time);
			map.put("end_time", end_time);
			map.put("airway", airway);
			map.put("start", start);
			map.put("end", end);
			
			totalpage=AirplaneDAO.airplaneTotalPage(map);
			System.out.println("start totalpage :" +totalpage);
			list=AirplaneDAO.startAirplaneListData(map);
		}
		
		request.setAttribute("type", typeInt+1);
		request.setAttribute("airway", airway);
		request.setAttribute("start_airport", start_airport);
		request.setAttribute("end_airport", end_airport);
		request.setAttribute("start_time", start_time);
		request.setAttribute("end_time", end_time);
		request.setAttribute("list", list);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("page", page);
		request.setAttribute("listSize", list.size());
		/*System.out.println("model page : "+page);*/
		System.out.println("list size:"+list.size());
		
		if(list.size()==0)
		{
			return "redirect:../../airplane/airplaneList.do";
		}
		else
		{
			return "../airplane/airplaneList_ok.jsp";
		}
		
	}
	

}
