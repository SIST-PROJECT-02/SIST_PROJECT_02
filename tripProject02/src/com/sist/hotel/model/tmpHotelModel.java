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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.hotel.dao.HotelDAO;
import com.sist.hotel.dao.HotelVO;
import com.sist.hotel.dao.ReviewBoardDAO;

@Controller
public class tmpHotelModel {

	@RequestMapping("views/template/main/staying.do")
	public String tmpMethod(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("jsp", "./../../hotel/jsp/hotelList.jsp");
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
			tmpObj.put("evelPoint", list.get(i).getEvel_point());
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

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		int start = Integer.parseInt(request.getParameter("startPoint")) + 1;
		int inputCount = Integer.parseInt(request.getParameter("getCount"));
		int sortCondition = Integer.parseInt(request.getParameter("sortCondition"));
		
		String search = request.getParameter("search");
		if(search.equals("")){
			search = "*";
		}
		
		int count = HotelDAO.hotelCountBySearch(search);
		List<HotelVO> list = new ArrayList<HotelVO>();
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();

		switch(sortCondition){
		case 1: list = HotelDAO.hotelAllDataByEvelDESC(start, inputCount,search); break;
		case 2: list = HotelDAO.hotelAllDataByEvelASC(start, inputCount,search); break;
		case 3: list = HotelDAO.hotelAllDataByReviewDESC(start, inputCount,search); break;
		case 4: list = HotelDAO.hotelAllDataByReviewASC(start, inputCount,search); break;
		}
		
		int sumOfRate = 0;
		for (int i = 0; i < list.size(); i++) {
			JSONObject tmpObj = new JSONObject();
			tmpObj.put("id", list.get(i).getId());
			tmpObj.put("thumbnail", list.get(i).getThumbnail());
			tmpObj.put("title", list.get(i).getTitle());
			tmpObj.put("information", list.get(i).getIntroduction());
			tmpObj.put("evelPoint", list.get(i).getEvel_point());
			tmpObj.put("reviewCount", list.get(i).getReview_count());
			
			sumOfRate = ReviewBoardDAO.sumOfRate(list.get(i).getId());
			tmpObj.put("sumOfRate", sumOfRate);
			
			jsonArr.add(tmpObj);

		}
		jsonObj.put("list", jsonArr);
		jsonObj.put("count", count);
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
	
	@RequestMapping("views/template/main/listDetail.do")
	public String getModalAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		HotelVO vo = HotelDAO.getHotelDetailById(id);
		int sumOfRate = ReviewBoardDAO.sumOfRate(id);
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", vo.getId());
		jsonObj.put("title", vo.getTitle());
		jsonObj.put("productKind", vo.getProduct_kind());
		jsonObj.put("hashTag", vo.getHash_tag());
		jsonObj.put("introduction", vo.getIntroduction());
		jsonObj.put("evelPoint", vo.getEvel_point());
		jsonObj.put("webSite", vo.getWeb_site());
		jsonObj.put("description", vo.getDescription());
		jsonObj.put("convenience", vo.getConvenience());
		jsonObj.put("address", vo.getAddress());
		jsonObj.put("roadAddress", vo.getRoad_address());
		jsonObj.put("tel", vo.getTel());
		jsonObj.put("longitude", vo.getLongitude());
		jsonObj.put("latitude", vo.getLatitude());
		jsonObj.put("shortDescription", vo.getShort_description());
		jsonObj.put("thumbnail", vo.getThumbnail());
		jsonObj.put("reviewCount", vo.getReview_count());
		jsonObj.put("sumOfRate", sumOfRate);
		
		PrintWriter out = response.getWriter();
		out.println(jsonObj);
		out.flush();
		return "./../../hotel/jsp/dummy.jsp";
	}
}