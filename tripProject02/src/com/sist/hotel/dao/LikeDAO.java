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

public class LikeDAO {
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("Config.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static int getLikeById(int product_id, String member_email){
		int res = 0;
		
		Map map = new HashMap();
		List list = new ArrayList();
		try (SqlSession session = ssf.openSession()) {
			map.put("product_id", product_id);
			map.put("member_email",member_email);
			
			list = session.selectList("getLikeById", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		res = (int)list.get(0);
		return res;
	}
	
	public static void insertLike(int product_id, String member_email){
		Map map = new HashMap();
		try (SqlSession session = ssf.openSession()) {
			map.put("product_id",product_id);
			map.put("member_email",member_email);
			session.insert("insertLike", map);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteLike(int product_id, String member_email){
		Map map = new HashMap();
		try (SqlSession session = ssf.openSession()) {
			map.put("product_id",product_id);
			map.put("member_email",member_email);
			session.delete("deleteLike", map);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void insertReviewLog(int product_id, String member_email){
		Map map = new HashMap();
		try (SqlSession session = ssf.openSession()) {
			map.put("product_id",product_id);
			map.put("member_email",member_email);
			session.insert("insertReviewLog", map);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteReviewLog(int product_id, String member_email){
		Map map = new HashMap();
		try (SqlSession session = ssf.openSession()) {
			map.put("product_id",product_id);
			map.put("member_email",member_email);
			session.insert("deleteReviewLog", map);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
