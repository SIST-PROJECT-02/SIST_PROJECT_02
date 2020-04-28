package com.sist.hotel.dao;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ProductRoomsAvailableDAO {
	
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("Config.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static List<ProductRoomsVO> getAllHotelRoomId(){
		List<ProductRoomsVO> list = null;
		try (SqlSession session = ssf.openSession()) {
			list = session.selectList("getAllHotelRoomId");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void insertProductRoomDates(ProductRoomsAvailableVO vo){
		try (SqlSession session = ssf.openSession(true)) {
			session.insert("insertProductRoomDates",vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
