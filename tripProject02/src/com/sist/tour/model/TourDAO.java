package com.sist.tour.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.dao.CreateSqlsessionFactory;
import com.sist.hotel.dao.HotelVO;
import com.sist.tour.model.TourVO;

public class TourDAO {
	
	private static SqlSessionFactory ssf;
	
	static
	{
		ssf=CreateSqlsessionFactory.getSsf();
	}
	
	public static List<TourVO> tourlist(Map map)
	{
		SqlSession session=null;
		List<TourVO> list=new ArrayList<TourVO>();
		try 
		{
			session=ssf.openSession();
			list=session.selectList("tourlist",map);
		}
		catch(Exception ex)
		{
			System.out.println("tourlist_error(): "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close();
		}	
		return list;
	}
	
	/*public static List<TourVO> startTourListData(Map map)
	{
		SqlSession session=null;
		List<TourVO> list=new ArrayList<TourVO>();
		
		try{
			session=ssf.openSession();
			list=session.selectList("startTourListData",map);
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			if(session!=null)
				session.close();
		}
		return list;
	}*/
	
	/*public static List<TourVO> endTourListData(Map map)
	{
		SqlSession session=null;
		List<TourVO> list=new ArrayList<TourVO>();
		
		try{
			session=ssf.openSession();
			list=session.selectList("endTourListData",map);
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			if(session!=null)
				session.close();
		}
		return list;
	}*/
	
	public static int tourTotalPage(String product_kind)
	{
		int totalpage=0;
		SqlSession session=null;
		
		try{
			session=ssf.openSession();
			totalpage=session.selectOne("tourTotalPage",product_kind);
			System.out.println("totalPage는"+totalpage);
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		return totalpage;
	}
	
}
