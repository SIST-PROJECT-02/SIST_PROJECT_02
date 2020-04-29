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
	
	public static AirplaneVO airplaneReserveSelect(Map map)
	{
		AirplaneVO vo=new AirplaneVO();
		SqlSession session=null;
		try{
			session=ssf.openSession();
			vo=session.selectOne("airplaneReserveSelect",map);
					
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		return vo;
	}
	
	public static void airplaneOnewayReserveInsert(Map map)
	{
		SqlSession session=null;
		try{
			session=ssf.openSession(true);
			session.insert("airplaneReserveInsert",map);
					
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
	}
	
	public static void airplaneRoundReserveInsert(Map map)
	{
		SqlSession session=null;
		try{
			session=ssf.openSession();
			session.insert("airplaneReserveInsert",map);
			session.insert("airplaneReserveInsert2",map);
			session.commit();
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
	}
	
	public static List<AirplaneReserveVO> airplaneReserveData(Map map)
	{
		SqlSession session=null;
		List<AirplaneReserveVO> list=new ArrayList<AirplaneReserveVO>();
		try{
			session=ssf.openSession();
			list=session.selectList("airplaneReserveData",map);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally{
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	public static void airplaneReserveDataUpdate(int rno)
	{
		SqlSession session=null;
		try{
			session=ssf.openSession(true);
			session.update("airplaneReserveDataUpdate",rno);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally{
			if(session!=null)
				session.close();
		}
	}
}
