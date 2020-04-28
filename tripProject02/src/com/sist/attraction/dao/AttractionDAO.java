package com.sist.attraction.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.attraction.vo.AttractionDetailVO;
import com.sist.attraction.vo.AttractionVO;
import com.sist.dao.CreateSqlsessionFactory;


public class AttractionDAO {
   private static SqlSessionFactory ssf;
   static
   {
	   ssf=CreateSqlsessionFactory.getSsf();
   }
   
   public static List<AttractionVO> attractionListData(Map map)
   {
	    SqlSession session=null;
	    List<AttractionVO> list=new ArrayList<AttractionVO>();
	    try
	    {
	    	session=ssf.openSession();
	    	list=session.selectList("attractionListData",map);
	    }catch(Exception ex)
	    {
	    	System.out.println(ex.getMessage());
	    }
	    finally
	    {
	    	if(session!=null)
	    		session.close();
	    }
	    return list;
   }
   
   public static int attrTotalPage()
   {
	    SqlSession session=null;
	    int total=0;
	    try
	    {
	    	session=ssf.openSession();
	    	total=session.selectOne("attrTotalPage");
	    }catch(Exception ex)
	    {
	    	System.out.println(ex.getMessage());
	    }
	    finally
	    {
	    	if(session!=null)
	    		session.close();
	    }
	    return total;
   }
   
   public static AttractionDetailVO attraction_detail(int id)
   {
	   AttractionDetailVO vo=new AttractionDetailVO();
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   vo=session.selectOne("attraction_detail", id);
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return vo;
   }
   
   public static int attr_count(int id)
   {
	    SqlSession session=null;
	    int total=0;
	    try
	    {
	    	session=ssf.openSession();
	    	total=session.selectOne("attr_count",id);
	    }catch(Exception ex)
	    {
	    	System.out.println(ex.getMessage());
	    }
	    finally
	    {
	    	if(session!=null)
	    		session.close();
	    }
	    return total;
   }

   
   
}
   