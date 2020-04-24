package com.sist.hotel.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ProductRoomsDAO {
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("Config.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 호텔 아이디를 전부 가져온다
	public static List getAllHotelId() {
		List<HotelVO> list = new ArrayList<HotelVO>();
		try (SqlSession session = ssf.openSession()) {
			list = session.selectList("getAllHotelId");
		} catch (Exception e) {
		}
		return list;
	}
	
	public static void insertProductRooms(ProductRoomsVO vo){
		try (SqlSession session = ssf.openSession(true)) {
			session.insert("insertProductRooms", vo);
		} catch (Exception e) {
		}
	}
}
