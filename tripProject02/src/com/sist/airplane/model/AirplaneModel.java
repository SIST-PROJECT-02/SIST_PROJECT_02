package com.sist.airplane.model;

import java.text.SimpleDateFormat;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

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
		String inwon=request.getParameter("inwon");
		String plane_id=request.getParameter("plane_id");
		
		Map map=new HashMap();
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
		
		
		request.setAttribute("inwon", inwon);
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
	
	/*airplane_reserver_oneway_trip.do*/
	@RequestMapping("views/airplane/airplane_reserve_oneway_trip.do")
	public String airplane_reserve_oneway_ok(HttpServletRequest request,HttpServletResponse response)
	{
		try{
			request.setCharacterEncoding("UTF-8");
		}catch (Exception ex) {}
		
		System.out.println("Oneway ok.do ??");
		HttpSession session=request.getSession();
		
		String email=(String)session.getAttribute("email");
		String name=(String)session.getAttribute("name");
		
		String start_airport=request.getParameter("start_airport");
		String end_airport=request.getParameter("end_airport");
		String start_time=request.getParameter("start_time");
		String plane_id=request.getParameter("plane_id");
		String seattype=request.getParameter("seattype");
		String inwon=request.getParameter("inwon");
		String airway=request.getParameter("airway");
		
		int inwonInt=Integer.parseInt(inwon);
		
		Map map=new HashMap();
		
		map.put("start_airport", start_airport);
		map.put("end_airport", end_airport);
		map.put("start_time", start_time);
		map.put("plane_id", plane_id);
		map.put("seattype", seattype);
		
		//DAO
		AirplaneVO vo=AirplaneDAO.airplaneReserveSelect(map);
		
		String priceTmp=(vo.getSeatVO().getPrice()).trim();
		int priceInt=Integer.parseInt(priceTmp.replace(",", ""));
		String price=Integer.toString(priceInt*inwonInt);
		
		System.out.println("price:"+price);
		
		map.put("vo", vo);
		map.put("email", email);
		map.put("name",name);
		map.put("price", price);
		map.put("inwon", inwon);
		map.put("airway", airway);
		
		
		AirplaneDAO.airplaneOnewayReserveInsert(map);
		
		return "redirect:../../template/main/member_reservation.do";
	}
	
	@RequestMapping("views/airplane/airplane_reserve_round_trip.do")
	public String airplane_reserve_round_trip(HttpServletRequest request,HttpServletResponse response)
	{
		try{
			request.setCharacterEncoding("UTF-8");
		}catch (Exception ex) {}
		
		HttpSession session=request.getSession();
		
		String email=(String)session.getAttribute("email");
		String name=(String)session.getAttribute("name");
		String inwon=request.getParameter("inwon");
		String airway=request.getParameter("airway");
		
		int inwonInt=Integer.parseInt(inwon);
		
		// 가는날
		String start_airport=request.getParameter("start_airport");
		String end_airport=request.getParameter("end_airport");
		String start_time=request.getParameter("start_time");
		String plane_id=request.getParameter("plane_id");
		String seattype=request.getParameter("seattype");
		System.out.println("seattype " + seattype);
		Map map=new HashMap();
		
		map.put("start_airport", start_airport);
		map.put("end_airport", end_airport);
		map.put("start_time", start_time);
		map.put("plane_id", plane_id);
		map.put("seattype", seattype);
		
		// Go DAO
		
		AirplaneVO vo=AirplaneDAO.airplaneReserveSelect(map);
		
		String priceTmp=(vo.getSeatVO().getPrice()).trim();
		int priceInt=Integer.parseInt(priceTmp.replace(",", ""));
		String price=Integer.toString(priceInt*inwonInt);
		
		map.put("vo", vo);
		map.put("price", price);
		// 오는날
		String start_airport2=request.getParameter("start_airport2");
		String end_airport2=request.getParameter("end_airport2");
		String start_time2=request.getParameter("start_time2");
		String plane_id2=request.getParameter("plane_id2");
		String seattype2=request.getParameter("seattype2");
		
		map.put("start_airport", start_airport2);
		map.put("end_airport", end_airport2);
		map.put("start_time", start_time2);
		map.put("plane_id", plane_id2);
		map.put("seattype", seattype2);
		
		AirplaneVO vo2=AirplaneDAO.airplaneReserveSelect(map);
		
		String priceTmp2=(vo2.getSeatVO().getPrice()).trim();
		int priceInt2=Integer.parseInt(priceTmp2.replace(",", ""));
		String price2=Integer.toString(priceInt2*inwonInt);
		
		map.put("vo2", vo2);
		map.put("price2", price2);
		
		
		map.put("email", email);
		map.put("name",name);
		map.put("inwon", inwon);
		map.put("airway", airway);
		
		AirplaneDAO.airplaneRoundReserveInsert(map);
		
		System.out.println("hi");
		
		return "redirect:../../template/main/member_reservation.do";
	}
	

}
