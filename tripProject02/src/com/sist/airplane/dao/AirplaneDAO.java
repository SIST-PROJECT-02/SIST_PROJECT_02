package com.sist.airplane.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.*;
import java.io.*;
public class AirplaneDAO {
	private static SqlSessionFactory ssf;
	static
	{
		try{
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public static List<AirplaneVO> startAirplaneListData(Map map)
	{
		SqlSession session=null;
		List<AirplaneVO> list=new ArrayList<AirplaneVO>();
		
		try{
			session=ssf.openSession();
			list=session.selectList("startAirplaneListData",map);
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	public static List<AirplaneVO> endAirplaneListData(Map map)
	{
		SqlSession session=null;
		List<AirplaneVO> list=new ArrayList<AirplaneVO>();
		
		try{
			session=ssf.openSession();
			list=session.selectList("endAirplaneListData",map);
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	public static int airplaneTotalPage(Map map)
	{
		int totalpage=0;
		SqlSession session=null;
		
		try{
			session=ssf.openSession();
			totalpage=session.selectOne("airplaneTotalPage",map);
			
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
