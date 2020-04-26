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
		   session.update("nreplyListData",map);
		   list=(ArrayList<NoticeReplyVO>)map.get("pResult");// CURSOR
		   // mybatis => CURSOR => List
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
   // Model => DAO(매개변수로 전송)
   // 매개변수 => 클래스 => 값변경,추가가 가능하다 (주소에 의한 전달)
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
   
   public static int nreplyTotalPage(Map map)
   {
	   int total=0;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   session.update("nreplyTotalPage",map); //프로시저 호출 
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
   
   public static void nreplyUpdate(Map map)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   session.update("nreplyUpdate",map); //프로시저 호출 
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
   
   public static void nreplyReplyInsert(Map map)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   session.update("nreplyReplyInsert",map); //프로시저 호출 
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
   
   public static void nreplyDelete(Map map)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   session.update("nreplyDelete",map); //프로시저 호출 
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










