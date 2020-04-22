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
import com.sist.hotel.dao.LikeVO;
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
		HttpSession mySession = request.getSession();
		String isMyReview = "";
		if(mySession.getAttribute("email") == null){
			isMyReview = "false";
		}else{
			String member_email = String.valueOf(mySession.getAttribute("email"));
			int isReview = ReviewBoardDAO.isMyReview(productId, member_email);
			if(isReview > 0){
				isMyReview = "true";
			}else{
				isMyReview = "false";
			}
		}

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
		jsonObj.put("isMyReview", isMyReview);
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
	
	@RequestMapping("views/template/main/modalReviewCreate.do")
	public String getModalReviewFormAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8"); 
		
		HttpSession mySession = request.getSession();
		JSONObject jsonObj = new JSONObject();
		PrintWriter out = response.getWriter();
		
		if(mySession.getAttribute("email") == null){
			System.out.println("session is null!");
			jsonObj.put("modalRes", "false");
			out.println(jsonObj);
			out.flush();
			return "./../../hotel/jsp/dummy.jsp"; 
		}
		
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		String member_email = String.valueOf(mySession.getAttribute("email"));
		String content = request.getParameter("content");
		double rate = Double.parseDouble(request.getParameter("rate"));
		
		ReviewBoardVO vo = new ReviewBoardVO();
		vo.setProduct_id(product_id);
		vo.setMember_email(member_email);
		vo.setContent(content);
		vo.setRate(rate);
		
		ReviewBoardDAO.insertModalReview(vo);
		LikeDAO.insertReviewLog(product_id, member_email);
		HotelDAO.updateHotelReview(product_id);
		
		HotelVO hvo = HotelDAO.getHotelDetailById(product_id);
		int sumOfRate = ReviewBoardDAO.sumOfRate(product_id);
		int count = ReviewBoardDAO.reviewCount(product_id);
		
		jsonObj.put("reviewCount", hvo.getReview_count());
		jsonObj.put("sumOfRate", sumOfRate);
		jsonObj.put("count", count);
		jsonObj.put("title", hvo.getTitle());
		jsonObj.put("evelPoint", hvo.getEvel_point());
		
		jsonObj.put("modalRes", "true");
		out.println(jsonObj);
		out.flush();
		
		return "./../../hotel/jsp/dummy.jsp";
	}
	
	@RequestMapping("views/template/main/modalReviewDelete.do")
	public String deleteModalReviewFormAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8"); 
		
		HttpSession mySession = request.getSession();
		JSONObject jsonObj = new JSONObject();
		PrintWriter out = response.getWriter();
		
		if(mySession.getAttribute("email") == null){
			System.out.println("session is null!");
			jsonObj.put("modalRes", "false");
			out.println(jsonObj);
			out.flush();
			return "./../../hotel/jsp/dummy.jsp"; 
		}
		
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		String member_email = String.valueOf(mySession.getAttribute("email"));
		
		ReviewBoardDAO.deleteModalReview(product_id,member_email);
		LikeDAO.deleteReviewLog(product_id, member_email);
		HotelDAO.updateDownHotelReview(product_id);
		
		HotelVO hvo = HotelDAO.getHotelDetailById(product_id);
		int sumOfRate = ReviewBoardDAO.sumOfRate(product_id);
		int count = ReviewBoardDAO.reviewCount(product_id);
		
		jsonObj.put("reviewCount", hvo.getReview_count());
		jsonObj.put("sumOfRate", sumOfRate);
		jsonObj.put("count", count);
		jsonObj.put("title", hvo.getTitle());
		jsonObj.put("evelPoint", hvo.getEvel_point());
		
		jsonObj.put("modalRes", "true");
		out.println(jsonObj);
		out.flush();
		
		return "./../../hotel/jsp/dummy.jsp";
	}
	
	@RequestMapping("views/template/main/modalReviewUpdate.do")
	public String updateModalReviewFormAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8"); 
		
		HttpSession mySession = request.getSession();
		JSONObject jsonObj = new JSONObject();
		PrintWriter out = response.getWriter();
		
		if(mySession.getAttribute("email") == null){
			System.out.println("session is null!");
			jsonObj.put("modalRes", "false");
			out.println(jsonObj);
			out.flush();
			return "./../../hotel/jsp/dummy.jsp"; 
		}
		
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		String member_email = String.valueOf(mySession.getAttribute("email"));
		String content = request.getParameter("content");
		double rate = Double.parseDouble(request.getParameter("rate"));
		ReviewBoardVO vo = new ReviewBoardVO();
		vo.setProduct_id(product_id);
		vo.setMember_email(member_email);
		vo.setContent(content);
		vo.setRate(rate);
		
		ReviewBoardDAO.updateModalReview(vo);
		
		HotelVO hvo = HotelDAO.getHotelDetailById(product_id);
		int sumOfRate = ReviewBoardDAO.sumOfRate(product_id);
		int count = ReviewBoardDAO.reviewCount(product_id);
		
		jsonObj.put("reviewCount", hvo.getReview_count());
		jsonObj.put("sumOfRate", sumOfRate);
		jsonObj.put("count", count);
		jsonObj.put("title", hvo.getTitle());
		jsonObj.put("evelPoint", hvo.getEvel_point());
		
		jsonObj.put("modalRes", "true");
		out.println(jsonObj);
		out.flush();
		
		return "./../../hotel/jsp/dummy.jsp";
	}
}
