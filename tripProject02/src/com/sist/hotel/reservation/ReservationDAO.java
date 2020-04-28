package com.sist.hotel.reservation;

import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.hotel.dao.HotelVO;

public class ReservationDAO {
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("Config.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static List getDateListByYearAndMonth(int product_id, int year, int month) {
		List list = null;
		Map map = new HashMap();
		map.put("product_id", product_id);
		map.put("year", year);
		map.put("month", month);
		System.out.println("id,y,m : " + product_id + "," + year + "," + month);
		try (SqlSession session = ssf.openSession()) {
			list = session.selectList("getDateListByYearAndMonth", map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static List getPriceByRegdate(int product_id, Date check_in, Date check_out) {
		List<HashMap> list = null;
		Map map = new HashMap();
		map.put("product_id", product_id);
		map.put("check_in", check_in);
		map.put("check_out", check_out);
		try (SqlSession session = ssf.openSession()) {
			list = session.selectList("getPriceByRegdate", map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void insertReservation(int price, String member_email, String title, int product_id, Date check_in, Date check_out) {
		Map map = new HashMap();
		map.put("check_in", check_in);
		map.put("check_out", check_out);
		map.put("price", price);
		map.put("member_email", member_email);
		map.put("title", title);
		try (SqlSession session = ssf.openSession(true)) {
			session.insert("insertReservation", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}