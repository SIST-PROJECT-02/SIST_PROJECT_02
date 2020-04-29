package com.sist.member.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.*;
import com.sist.dao.CreateSqlsessionFactory;


public class HotelplaneDAO {

	private static SqlSessionFactory ssf;
	
	static
	{
		ssf=CreateSqlsessionFactory.getSsf();
	}
	
	public static List<HotelReserveVO> HotelReserve(Map hmap)
	{
		List<HotelReserveVO> list=new ArrayList<HotelReserveVO>();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			list=session.selectList("hotelreserve",hmap);
		}
		catch(Exception ex)
		{
			System.out.println("HotelReserve_Error: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
			{
				session.close();
			}
		}
		
		return list;
	}
}
