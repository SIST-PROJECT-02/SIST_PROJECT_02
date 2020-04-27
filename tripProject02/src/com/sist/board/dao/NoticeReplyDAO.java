package com.sist.board.dao;
import java.sql.ResultSet;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.board.dao.NoticeReplyVO;
import com.sist.board.dao.ReplyVO;
public class NoticeReplyDAO {
   private static SqlSessionFactory ssf;
   static
   {
	   ssf=CreateSqlSessionFactory.getSsf();
   }
   
   public static List<NoticeReplyVO> noticereplyListData(Map map)
   {
	   List<NoticeReplyVO> list=new ArrayList<NoticeReplyVO>();
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   session.update("noticereplyListData",map);
		   list=(ArrayList<NoticeReplyVO>)map.get("pResult");// CURSOR
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
   public static void noticereplyInsert(Map map)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   session.update("noticereplyInsert",map); //프로시저 호출 
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
   
   public static int noticereplyTotalPage(Map map)
   {
	   int total=0;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   session.update("noticereplyTotalPage",map); //프로시저 호출 
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
   
   public static void noticereplyUpdate(Map map)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   session.update("noticereplyUpdate",map); //프로시저 호출 
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
   
   
   
   public static void noticereplyDelete(Map map)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   session.update("noticereplyDelete",map); //프로시저 호출 
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
   public static void noticereplyReplyInsert(Map map)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   session.update("noticereplyReplyInsert",map); //프로시저 호출 
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










