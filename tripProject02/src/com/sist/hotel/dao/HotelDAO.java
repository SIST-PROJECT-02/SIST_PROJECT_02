package com.sist.hotel.dao;

import java.io.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HotelDAO {

	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("Config.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static List<HotelVO> hotelAllData() {
		List<HotelVO> list = null;
		Map map = new HashMap();
		map.put("start", 1);
		map.put("end", 10);
		try (SqlSession session = ssf.openSession()) {
			list = session.selectList("hotelAllData", map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	// 호텔의 데이터를 별점순(내림차순)으로 얻는다
	public static List<HotelVO> hotelAllDataByEvelDESC(int start, int count, String search) {
		List<HotelVO> list = null;
		Map map = new HashMap();
		try (SqlSession session = ssf.openSession()) {
			map.put("start", start);
			map.put("end", start + count - 1);
			map.put("product_kind", "숙박");
			map.put("search", search);
			list = session.selectList("hotelAllDataByEvelDESC", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 호텔의 데이터를 별점순(오름차순)으로 얻는다
	public static List<HotelVO> hotelAllDataByEvelASC(int start, int count, String search) {
		List<HotelVO> list = null;
		Map map = new HashMap();
		try (SqlSession session = ssf.openSession()) {
			map.put("start", start);
			map.put("end", start + count - 1);
			map.put("product_kind", "숙박");
			map.put("search", search);
			list = session.selectList("hotelAllDataByEvelASC", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 호텔의 데이터를 인기순(내림차순)으로 얻는다
	public static List<HotelVO> hotelAllDataByReviewDESC(int start, int count, String search) {
		List<HotelVO> list = null;
		Map map = new HashMap();
		try (SqlSession session = ssf.openSession()) {
			map.put("start", start);
			map.put("end", start + count - 1);
			map.put("product_kind", "숙박");
			map.put("search", search);
			list = session.selectList("hotelAllDataByReviewDESC", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 호텔의 데이터를 인기순(오름차순)으로 얻는다
	public static List<HotelVO> hotelAllDataByReviewASC(int start, int count, String search) {
		List<HotelVO> list = null;
		Map map = new HashMap();
		try (SqlSession session = ssf.openSession()) {
			map.put("start", start);
			map.put("end", start + count - 1);
			map.put("product_kind", "숙박");
			map.put("search", search);
			list = session.selectList("hotelAllDataByReviewASC", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 호텔의 총 개수를 얻는다
	public static int hotelCount() {
		int count = 0;
		Map map = new HashMap();
		List list = new ArrayList();
		map.put("product_kind", "숙박");
		try (SqlSession session = ssf.openSession()) {
			list = session.selectList("hotelCount", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		count = (int) list.get(0);
		return count;
	}

	// 호텔의 검색 총 개수를 얻는다
	public static int hotelCountBySearch(String search) {
		int count = 0;
		Map map = new HashMap();
		List list = new ArrayList();
		map.put("product_kind", "숙박");
		map.put("search", search);
		try (SqlSession session = ssf.openSession()) {
			list = session.selectList("hotelCountBySearch", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		count = (int) list.get(0);
		return count;
	}

	// 호텔 start~ x개 가져오기
	public static List<HotelVO> getHotelFromStartToX(int start, int count) {
		List<HotelVO> list = null;
		if (count == 0) {
			return null;
		}
		Map map = new HashMap();
		try (SqlSession session = ssf.openSession()) {
			map.put("start", start);
			map.put("end", start + count - 1);
			map.put("product_kind", "숙박");
			list = session.selectList("getHotelFromStartToX", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 호텔 id로 detail 가져오기
	public static HotelVO getHotelDetailById(int id) {
		HotelVO vo = new HotelVO();

		Map map = new HashMap();
		try (SqlSession session = ssf.openSession()) {
			map.put("id", id);
			vo = session.selectOne("getHotelDetailById", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return vo;
	}
	public static void updateHotelReview(int product_id){
		try(SqlSession session = ssf.openSession(true)){
			session.update("updateHotelReview",product_id);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void updateDownHotelReview(int product_id){
		try(SqlSession session = ssf.openSession(true)){
			session.update("updateDownHotelReview",product_id);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static List<HotelVO> productAllData(){
		List<HotelVO> list = new ArrayList<HotelVO>();
		try(SqlSession session = ssf.openSession(true)){
			list = session.selectList("productAllData");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
