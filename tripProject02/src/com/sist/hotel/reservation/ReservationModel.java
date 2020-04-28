package com.sist.hotel.reservation;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.hotel.dao.HotelDAO;
import com.sist.hotel.dao.HotelVO;

@Controller
public class ReservationModel {

	@RequestMapping("views/template/main/reservation.do")
	public String reservation(HttpServletRequest request, HttpServletResponse response) {
		String product_id = request.getParameter("product_id");
		request.setAttribute("jsp", "./../../hotel/jsp/reservation.jsp?product_id=" + product_id);
		return "index.jsp";
	}

	@RequestMapping("views/template/main/reservationCalendar.do")
	public String reservationCalendar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String strYear = request.getParameter("year");
		String strMonth = request.getParameter("month");
		String strProduct_id = request.getParameter("product_id");
		int product_id = Integer.parseInt(strProduct_id);
		int year = Integer.parseInt(strYear);
		int month = Integer.parseInt(strMonth);

		JSONObject jsonObj = new JSONObject();
		PrintWriter out = response.getWriter();

		int totalDay = 0;
		int week = 0;
		int total = 0;
		int monthList[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (year == -1) {
			SimpleDateFormat f = new SimpleDateFormat("yyyy-mm");
			Calendar time = Calendar.getInstance();

			year = time.get(Calendar.YEAR);
			month = time.get(Calendar.MONTH);
		} else {
			month--;
		}
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			monthList[1] = 29;
		} else
			monthList[1] = 28;

		totalDay = monthList[month];
		total = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
		for (int i = 0; i < month; i++) {
			total += monthList[i];
		}
		total++;

		week = total % 7;

		// 년, 월을 통해 예약 가능한 날짜를 전부 가져온다.
		List list = ReservationDAO.getDateListByYearAndMonth(product_id, year, month + 1);
		JSONArray jsonArr = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			jsonArr.add(list.get(i));
		}

		// detail 가져오기
		HotelVO vo = HotelDAO.getHotelDetailById(product_id);
		jsonObj.put("thumbnail", vo.getThumbnail());
		jsonObj.put("title", vo.getTitle());
		jsonObj.put("list", jsonArr);
		jsonObj.put("totalDay", totalDay);
		jsonObj.put("week", week);
		jsonObj.put("month", month);
		jsonObj.put("year", year);

		out.println(jsonObj);
		out.flush();
		return "./../../hotel/jsp/dummy.jsp";
	}

	@RequestMapping("views/template/main/reservationSelected.do")
	public String reservationSelected(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		PrintWriter out = response.getWriter();

		String strProduct_id = request.getParameter("product_id");
		String strInwon = request.getParameter("inwon");
		String strCheckIn = request.getParameter("checkIn");
		String strCheckOut = request.getParameter("checkOut");

		int product_id = Integer.parseInt(strProduct_id);
		int inwon = Integer.parseInt(strInwon);
		Date checkIn = new SimpleDateFormat("yyyy/MM/dd").parse(strCheckIn);
		Date checkOut = new SimpleDateFormat("yyyy/MM/dd").parse(strCheckOut);
		Calendar cal = Calendar.getInstance();
		cal.setTime(checkOut);
		cal.add(Calendar.DATE, 1);
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		checkOut = df.parse(df.format(cal.getTime()));
		int price = 0;

		// check in, check out범위에 드는 가격,id리스트를 가져온다

		List<HashMap> list = ReservationDAO.getPriceByRegdate(product_id, checkIn, checkOut);
		List<HashMap> resList = new ArrayList<HashMap>();
		String regdate = "0";

		try {
			for (int i = 0; i < list.size(); i++) {
				if (regdate.equals(String.valueOf(list.get(i).get("regdate")))) {
					continue;
				} else {
					HashMap myMap = new HashMap();
					myMap.put("id", list.get(i).get("id"));
					myMap.put("price", list.get(i).get("price"));
					myMap.put("regdate", list.get(i).get("regdate"));
					resList.add(myMap);
					regdate = String.valueOf(list.get(i).get("regdate"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < resList.size(); i++) {
			JSONObject tmpObj = new JSONObject();
			tmpObj.put("id", String.valueOf(resList.get(i).get("id")));
			tmpObj.put("price", String.valueOf(resList.get(i).get("price")));
			tmpObj.put("regdate", String.valueOf(resList.get(i).get("regdate")));
			jsonArr.add(tmpObj);
		}
		jsonObj.put("list", jsonArr);
		out.println(jsonObj);
		out.flush();
		return "./../../hotel/jsp/dummy.jsp";
	}
	
	@RequestMapping("views/template/main/reservationFinal.do")
	public String reservationFinal(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		JSONObject jsonObj = new JSONObject();
		PrintWriter out = response.getWriter();
		String strProduct_id = request.getParameter("product_id");
		String strInwon = request.getParameter("inwon");
		String strCheckIn = request.getParameter("checkIn");
		String strCheckOut = request.getParameter("checkOut");
		String strPrice = request.getParameter("price");
		int product_id = Integer.parseInt(strProduct_id);
		int inwon = Integer.parseInt(strInwon);
		Date checkIn = new SimpleDateFormat("yyyy/MM/dd").parse(strCheckIn);
		Date checkOut = new SimpleDateFormat("yyyy/MM/dd").parse(strCheckOut);
		int price = Integer.parseInt(strPrice);
		HttpSession mySession = request.getSession();
		if(mySession.getAttribute("email") == null){
			jsonObj.put("isSuc", "false");
			out.println(jsonObj);
			out.flush();
			return "./../../hotel/jsp/dummy.jsp";
		}
		String member_email = String.valueOf(mySession.getAttribute("email"));
		HotelVO vo = HotelDAO.getHotelDetailById(product_id);
		String title = vo.getTitle();
		ReservationDAO.insertReservation(price, member_email, title, product_id, checkIn, checkOut);
		jsonObj.put("isSuc", "true");
		out.println(jsonObj);
		out.flush();
		return "./../../hotel/jsp/dummy.jsp";
	}

}