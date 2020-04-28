package com.sist.tour.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.dao.CreateSqlsessionFactory;
import com.sist.tour.model.TourVO;

public class TourDAO {
	
private static SqlSessionFactory ssf;
	
	static
	{
		ssf=CreateSqlsessionFactory.getSsf();
	}
	
	public static List tourlist(String product_kind)
	{
		SqlSession session=null;
		List<TourVO> vo=new ArrayList<TourVO>();
		try 
		{
			session=ssf.openSession();
			vo=session.selectList("tourlist",product_kind);
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
		return vo;
	}
	
}
