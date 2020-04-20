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

	// 해당 호텔의 총 평점 점수를 얻는다
	public static int sumOfRate(int product_id) {
		Map map = new HashMap();
		int res = 0;
		map.put("product_id", product_id);
		try (SqlSession session = ssf.openSession()) {
			res = session.selectOne("sumOfRate", map);
		} catch (Exception e) {
		}
		return res;
	}

	public static List<ReviewBoardVO> reviewListDataFromStartDESC(int start, int count, int product_id) {
		List<ReviewBoardVO> list = null;
		Map map = new HashMap();
		try (SqlSession session = ssf.openSession()) {
			map.put("start", start);
			map.put("end", start + count - 1);
			map.put("product_id", product_id);
			list = session.selectList("reviewListDataFromStartDESC", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static int reviewCount(int productId) {
		int count = 0;
		Map map = new HashMap();
		map.put("product_id", productId);
		try (SqlSession session = ssf.openSession()) {
			count = session.selectOne("reviewCount", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static int isMyReview(int productId, String member_email) {
		int count = 0;
		Map map = new HashMap();
		map.put("product_id", productId);
		map.put("member_email",member_email);
		try (SqlSession session = ssf.openSession()) {
			count = session.selectOne("isMyReview", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public static int insertModalReview(ReviewBoardVO vo) {
		int count = 0;
		try (SqlSession session = ssf.openSession()) {
			count = session.insert("insertModalReview", vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public static int deleteModalReview(int product_id, String member_email) {
		int count = 0;
		Map map = new HashMap();
		try (SqlSession session = ssf.openSession()) {
			map.put("product_id", product_id);
			map.put("member_email", member_email);
			count = session.insert("deleteModalReview", map);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public static int updateModalReview(ReviewBoardVO vo) {
		int count = 0;
		try (SqlSession session = ssf.openSession()) {
			count = session.insert("updateModalReview", vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
