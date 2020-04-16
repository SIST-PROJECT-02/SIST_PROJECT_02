package com.sist.hotel.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.hotel.dao.HotelDAO;
import com.sist.hotel.dao.HotelVO;
import com.sist.hotel.dao.ReviewBoardDAO;
import com.sist.hotel.dao.ReviewBoardVO;

@Controller
public class ReviewBoardModel {

	
	@RequestMapping("views/template/main/modalList.do")
	public String getSlidingAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		List<ReviewBoardVO> list = new ArrayList<ReviewBoardVO>();
		int start = Integer.parseInt(request.getParameter("startPoint")) + 1;
		int inputCount = Integer.parseInt(request.getParameter("getCount"));
		int productId = Integer.parseInt(request.getParameter("productId"));

		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		// 1. 총 개수를 얻는다
		int count = ReviewBoardDAO.reviewCount(productId);
		System.out.println("count : " + count);

		list = ReviewBoardDAO.reviewListDataFromStartDESC(start, inputCount, productId);
		
		for (int i = 0; i < list.size(); i++) {
			JSONObject tmpObj = new JSONObject();
			tmpObj.put("id", list.get(i).getId());
			tmpObj.put("memberEmail", list.get(i).getMember_email());
			tmpObj.put("regdate", String.valueOf(list.get(i).getRegdate()));
			tmpObj.put("content", list.get(i).getContent());
			tmpObj.put("evelPoint", list.get(i).getRate());
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
}
