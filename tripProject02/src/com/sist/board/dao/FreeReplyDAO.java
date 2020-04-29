package com.sist.board.dao;
import java.sql.ResultSet;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.board.dao.FreeReplyVO;
import com.sist.board.dao.ReplyVO;
public class FreeReplyDAO {
   private static SqlSessionFactory ssf;
   static
   {
	   ssf=CreateSqlSessionFactory.getSsf();
   }
   
   public static List<FreeReplyVO> freereplyListData(Map map)
   {
	   List<FreeReplyVO> list=new ArrayList<FreeReplyVO>();
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   session.update("freereplyListData",map);
		   list=(ArrayList<FreeReplyVO>)map.get("pResult");// CURSOR
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return list;
   }
   public static void freereplyInsert(Map map)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   session.update("freereplyInsert",map); //프로시저 호출 
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
   }
   
   public static int freereplyTotalPage(Map map)
   {
	   int total=0;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   session.update("freereplyTotalPage",map); //프로시저 호출 
		   total=(int)map.get("pTotal");
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return total;
   }
   
   public static void freereplyUpdate(Map map)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   session.update("freereplyUpdate",map); //프로시저 호출 
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
   }
   
   
   
   public static void freereplyDelete(Map map)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   session.update("freereplyDelete",map); //프로시저 호출 
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
   }
   public static void freereplyReplyInsert(Map map)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   session.update("freereplyReplyInsert",map); //프로시저 호출 
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
   }
  
}










