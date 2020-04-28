package com.sist.hotel.reservation;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller
public class ReservationModel {

	@RequestMapping("views/template/main/reservation.do")
	public String reservation(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("hello");

		request.setAttribute("jsp", "./../../hotel/jsp/reservation.jsp");
		return "index.jsp";
	}

	@RequestMapping("views/template/main/reservationCalendar.do")
	public String reservationCalendar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String strYear = request.getParameter("year");
		String strMonth = request.getParameter("month");
		int year = Integer.parseInt(strYear);
		int month = Integer.parseInt(strMonth);

		JSONObject jsonObj = new JSONObject();
		PrintWriter out = response.getWriter();

		int totalDay = 0;
		int week = 0;
		int total = 0;
		int monthList[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (year == -1) {
			// 현재 날짜를 구해서 클라이언트한테 줘야 한다.
			SimpleDateFormat f = new SimpleDateFormat("yyyy-mm");
			Calendar time = Calendar.getInstance();

			year = time.get(Calendar.YEAR);
			month = time.get(Calendar.MONTH);

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
			
			System.out.println("week : " + week);

		}else{
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
			
			System.out.println("week : " + week);

		}

		jsonObj.put("totalDay", totalDay);
		jsonObj.put("week", week);
		jsonObj.put("month", month);

		out.println(jsonObj);
		out.flush();
		return "./../../hotel/jsp/dummy.jsp";
	}
}