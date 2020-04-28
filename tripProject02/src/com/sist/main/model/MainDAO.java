package com.sist.main.model;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.dao.CreateSqlsessionFactory;

public class MainDAO {
	
	private static SqlSessionFactory ssf;
	
	static
	{
		ssf=CreateSqlsessionFactory.getSsf();
	}
	
	public static List mainpageHotel(Map hotelmap)
	{
		List<MainHotelVO> hotelvo=new ArrayList<MainHotelVO>();
		SqlSession session=null;
		/*System.out.println("2. vo은 "+hotelvo);*/
		try
		{
			session=ssf.openSession();
			hotelvo=session.selectList("mainPageHotel",hotelmap);
			/*System.out.println("3. hotelvo은 "+hotelvo);*/
			
		}
		catch(Exception ex)
		{
			System.out.println("mainPageHotel_error(): "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return hotelvo;
	}
	
	public static List mainpageTour(Map tourmap)
	{
		List<MainTourVO> tourvo=new ArrayList<MainTourVO>();
		SqlSession session=null;
		/*System.out.println("2. vo은 "+vo);*/
		try
		{
			session=ssf.openSession();
			tourvo=session.selectList("mainPageTour",tourmap);
			/*System.out.println("3. hotelvo은 "+tourvo);*/
			
		}
		catch(Exception ex)
		{
			System.out.println("mainPageTour_error(): "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return tourvo;
	}
	
	public static List mainpageFood(Map foodmap)
	{
		List<MainFoodVO> foodvo=new ArrayList<MainFoodVO>();
		SqlSession session=null;
		/*System.out.println("2. vo은 "+vo);*/
		try
		{
			session=ssf.openSession();
			foodvo=session.selectList("mainPageFood",foodmap);
			/*System.out.println("3. foodvo은 "+foodvo);*/
			
		}
		catch(Exception ex)
		{
			System.out.println("mainPageFood_error(): "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return foodvo;
	}

}
