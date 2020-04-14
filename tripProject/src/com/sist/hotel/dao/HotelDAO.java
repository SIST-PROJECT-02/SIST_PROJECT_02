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
			list = session.selectList("hotelAllData",map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<HotelVO> hotelAllDataByEvel() {
		List<HotelVO> list = null;
		Map map = new HashMap();
		map.put("start", 1);
		map.put("end", 6);
		try (SqlSession session = ssf.openSession()) {
			list = session.selectList("hotelAllDataByEvel",map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
