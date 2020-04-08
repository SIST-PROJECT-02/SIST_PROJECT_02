package com.sist.hotel.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.hotel.dao.HotelDAO;
import com.sist.hotel.dao.HotelVO;

@Controller
public class tmpHotelModel {

	@RequestMapping("views/template/main/staying.do")
	public String tmpMethod(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("jsp", "./../../hotel/jsp/hotelList.jsp");
		// request.setAttribute("jsp", "./../detail/04_staying.jsp");
		List<HotelVO> list = HotelDAO.hotelAllDataByEvelDESC(1000, 1150);
		for (HotelVO vo : list) {
			// id, title, Evel_point, thumbnail

		}
		request.setAttribute("list", list);
		return "index.jsp";
	}

	@RequestMapping("views/template/main/sliding.do")
	public String getSlidingAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<HotelVO> list = new ArrayList<HotelVO>();
		int start = 1;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String tmpCount = request.getParameter("count");
		int inputCount;
		try {
			inputCount = Integer.parseInt(tmpCount);
		} catch (Exception e) {
			inputCount = 0;
			e.printStackTrace();
		}

		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		// 1. 총 개수를 얻는다
		int count = HotelDAO.hotelCount();
		if (inputCount > count) {
			list = HotelDAO.getHotelFromStartToX(0, inputCount);
		} else {
			start = (int) (Math.random() * count + 1) - inputCount;
			list = HotelDAO.getHotelFromStartToX(start, inputCount);
		}
		for (int i = 0; i < list.size(); i++) {
			JSONObject tmpObj = new JSONObject();
			tmpObj.put("id", list.get(i).getId());
			tmpObj.put("thumbnail", list.get(i).getThumbnail());
			tmpObj.put("title", list.get(i).getTitle());
			tmpObj.put("information", list.get(i).getIntroduction());
			jsonArr.add(tmpObj);

		}
		jsonObj.put("list", jsonArr);
		PrintWriter out = response.getWriter();
		out.println(jsonObj);
		out.flush();

		return "./../../hotel/jsp/dummy.jsp";
	}

	@RequestMapping("views/template/main/list.do")
	public String getListAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		 * startPoint : 0, getCount : 6, sortCondition : 0
		 * 
		 */
		int start = Integer.parseInt(request.getParameter("startPoint")) + 1;
		int inputCount = Integer.parseInt(request.getParameter("getCount"));
		int sortCondition = Integer.parseInt(request.getParameter("sortCondition"));

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		// 1. 총 개수를 구한다
		int count = HotelDAO.hotelCount();
		// 2. 데이터를 얻는다
		List<HotelVO> list = new ArrayList<HotelVO>();
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();

		if (sortCondition == 0) {
			list = HotelDAO.hotelAllDataByEvelDESC(start, inputCount);
		}
		for (int i = 0; i < list.size(); i++) {
			JSONObject tmpObj = new JSONObject();
			tmpObj.put("id", list.get(i).getId());
			tmpObj.put("thumbnail", list.get(i).getThumbnail());
			tmpObj.put("title", list.get(i).getTitle());
			tmpObj.put("information", list.get(i).getIntroduction());
			tmpObj.put("evelPoint", list.get(i).getEvel_point());
			jsonArr.add(tmpObj);

		}
		jsonObj.put("list", jsonArr);
		if(start + inputCount >= count){
			jsonObj.put("more", "false");
		}else{
			jsonObj.put("more", "true");
		}
		PrintWriter out = response.getWriter();
		out.println(jsonObj);
		out.flush();

		return "./../../hotel/jsp/dummy.jsp";
	}
}