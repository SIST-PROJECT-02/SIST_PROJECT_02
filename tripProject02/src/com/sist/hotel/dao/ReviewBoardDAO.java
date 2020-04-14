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

public class ReviewBoardDAO {

	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("Config.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//해당 호텔의 총 평점 점수를 얻는다
		public static int sumOfRate(int product_id){
			Map map = new HashMap();
			int res = 0;
			map.put("product_id", product_id);
			try (SqlSession session = ssf.openSession()) {
				res = session.selectOne("sumOfRate",map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return res;
		}
}
