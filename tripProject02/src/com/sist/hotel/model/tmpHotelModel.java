package com.sist.hotel.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.hotel.dao.HotelDAO;
import com.sist.hotel.dao.HotelVO;

@Controller
public class tmpHotelModel {
	
	@RequestMapping("views/template/main/staying.do")
	public String tmpMethod(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("jsp", "./../../hotel/hotelList.jsp");
		//request.setAttribute("jsp", "./../detail/04_staying.jsp");
		List<HotelVO> list = HotelDAO.hotelAllDataByEvel();
		for(HotelVO vo : list){
			System.out.println("호텔 : " + vo.getThumbnail());
			//id, title, Evel_point, thumbnail
			
		}
		request.setAttribute("list", list);
		return "index.jsp";
	}
}