package com.sist.hotel.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.hotel.dao.HotelDAO;
import com.sist.hotel.dao.HotelVO;
import com.sist.hotel.dao.LikeDAO;
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
		System.out.println("start : " + start);
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
		
		HttpSession mySession = request.getSession();
		
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
			
			if(mySession.getAttribute("email") == null){
				tmpObj.put("like", "false");
			}else{
				int like = LikeDAO.getLikeById(list.get(i).getId(), String.valueOf(mySession.getAttribute("email")));
				if(like >= 1){
					tmpObj.put("like", "true");
				}else{
					tmpObj.put("like", "false");
				}
			}
			
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
		HttpSession mySession = request.getSession();
		
		int count = ReviewBoardDAO.reviewCount(id);
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
		jsonObj.put("count", count);
		if(mySession.getAttribute("email") == null){
			jsonObj.put("like", "false");
		}else{
			int like = LikeDAO.getLikeById(vo.getId(), String.valueOf(mySession.getAttribute("email")));
			if(like >= 1){
				jsonObj.put("like", "true");
			}else{
				jsonObj.put("like", "false");
			}
		}
		
		PrintWriter out = response.getWriter();
		out.println(jsonObj);
		out.flush();
		return "./../../hotel/jsp/dummy.jsp";
	}
	@RequestMapping("views/template/main/modalLike.do")
	public String changeModalLike(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject jsonObj = new JSONObject();
		
		int product_id = Integer.parseInt(request.getParameter("productId"));
		HttpSession mySession = request.getSession();
		if(mySession.getAttribute("email") == null){
			jsonObj.put("like", "no");
			out.println(jsonObj);
			out.flush();
			return "./../../hotel/jsp/dummy.jsp";
		}
		String member_email = String.valueOf(mySession.getAttribute("email"));
		int like = LikeDAO.getLikeById(product_id, member_email);
		if(like >= 1){
			jsonObj.put("like", "off");
			LikeDAO.deleteLike(product_id, member_email);
		}else{
			jsonObj.put("like", "on");
			LikeDAO.insertLike(product_id, member_email);
		}
		out.println(jsonObj);
		out.flush();
		
		return "./../../hotel/jsp/dummy.jsp";
	}
	
	@RequestMapping("views/template/main/modalMap.do")
	public String getModalMap(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		int product_id = Integer.parseInt(request.getParameter("productId"));
		HotelVO vo = HotelDAO.getHotelDetailById(product_id);
		
		double longitude = 0;
		double latitude = 0;
		try{
			longitude = Double.parseDouble(vo.getLongitude());
			latitude = Double.parseDouble(vo.getLatitude());
		}catch(Exception e){
			latitude = 33.39527;
			longitude = 126.24705;
		}
		JSONObject myJson = new JSONObject();
		myJson.put("latitude", latitude);
		myJson.put("longitude", longitude);
		myJson.put("title", vo.getTitle());
		jsonObj.put("myData", myJson.toJSONString());
		
		//ACOS( COS( RADIANS( 90-위도1 )) * COS( RADIANS( 90-위도2 )) + SIN( RADIANS( 90-위도1 )) * SIN( RADIANS( 90-위도2 )) * COS( RADIANS( 경도1-경도2 ))) * 6378.137
		List<HotelVO> list = new ArrayList<HotelVO>();
		List<List> resList = new ArrayList<List>();
		list = HotelDAO.productAllData();
		for(HotelVO hvo : list){
			if(hvo.getLatitude() == null || hvo.getLongitude() == null){
				continue;
			}
			double la = 0;
			double lo = 0;
			try{
				la = Double.parseDouble(hvo.getLatitude());
				lo = Double.parseDouble(hvo.getLongitude());
			}catch(Exception e){
				//e.printStackTrace();
				la = 0;
				lo = 0;
			}
			if(Math.acos(Math.cos(Math.toRadians(90 - latitude))*Math.cos(Math.toRadians(90-la))+Math.sin(Math.toRadians(90-latitude))*Math.sin(Math.toRadians(90-la))*Math.cos(Math.toRadians(longitude-lo)))*6378.137 <= 1){
				JSONObject tmpJson = new JSONObject();
				tmpJson.put("latitude", la);
				tmpJson.put("longitude", lo);
				tmpJson.put("title", hvo.getTitle());
				tmpJson.put("thumbnail", hvo.getThumbnail());
				tmpJson.put("product_kind", hvo.getProduct_kind());
				jsonArray.add(tmpJson.toJSONString());
				System.out.println("tmpJson : " + tmpJson.toJSONString());
			}
		}
		jsonObj.put("othersData", jsonArray);
		out.println(jsonObj);
		out.flush();
		
		return "./../../hotel/jsp/dummy.jsp"; 
	}
	
}