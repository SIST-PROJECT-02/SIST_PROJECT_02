package com.sist.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.board.dao.BoardVO;

import java.util.*;

public class NoticeDAO {
	private static SqlSessionFactory ssf;
	static
	{
		
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	public static List<BoardVO> nrListData()
	   {
		   List<BoardVO> list=new ArrayList<BoardVO>();
		   SqlSession session=null;
		   try
		   {
			   session=ssf.openSession();
			   list=session.selectList("nrListData");
		   }catch(Exception ex)
		   {
			   System.out.println(ex.getMessage());
		   }
		   finally
		   {
			   if(session!=null)
				   session.close();// 반환 => DBCP
		   }
		   return list;
	   }
	
	public static List<BoardVO> noticeListData(Map map)
	{
		List<BoardVO> list=new ArrayList<BoardVO>();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();	
			list=session.selectList("noticeListData",map); 
		}catch(Exception ex)
		{
			System.out.println("noticeListData: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static int noticeTotalPage()
	{
		int total=0;
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();	
			total=session.selectOne("noticeTotalPage");
			
		}catch(Exception ex)
		{
			System.out.println("noticeTotalPage: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close(); // 반환 
		}
		
		return total;
	}
	public static int noticecount(int no){
		int count=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			count=session.selectOne("noticecount",no);
		} catch (Exception e) {
			System.out.println("noticecount "+e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		return count;
	}
	
	public static BoardVO noticeDetailData(int no)
	{
		BoardVO vo = new BoardVO();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();	
			vo=session.selectOne("noticeDetailData",no); 
			
		}catch(Exception ex)
		{
			System.out.println("noticeDetailData: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close(); 
		}
		return vo;
	}
	
	public static BoardVO nhitIncrement(int no)
	{
		BoardVO vo = new BoardVO();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();	
			session.update("nhitIncrement",no);
			session.commit(); 
			
			vo=session.selectOne("noticeDetailData", no); 
			
		}catch(Exception ex)
		{
			System.out.println("nhitIncrement: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close(); 
		}
		
		return vo;
	}
	
	
	public static BoardVO noticeInsertData(BoardVO vo)
	{
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession(true); 
			session.insert("noticeInsertData",vo); 
			
		}catch(Exception ex)
		{
			System.out.println("noticeInsertData: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close(); 
		}
		return vo;
	}
	
	public static String noticeGetPassword(int no)
	{
		String pwd="";
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();	
			pwd=session.selectOne("noticeGetPassword",no); 
			
		}catch(Exception ex)
		{
			System.out.println("noticeGetPassword: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close(); 
		}
		return pwd;
	}
	
	
	public static BoardVO noticeUpdateData(BoardVO vo)
	{
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession(true); 
			session.update("noticeUpdateData",vo); 

		}catch(Exception ex)
		{
			System.out.println("noticeUpdateData: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close(); 
		}
		return vo;
	}
	
	public static void noticeReplyInsert(int pno,BoardVO vo){
		SqlSession session=null;
		try {
			session=ssf.openSession();
			BoardVO pvo=session.selectOne("noticeParentInfoData",pno);
			session.update("noticeGroupStepIncrement",pvo);
			//replyReplyInsert
			//replyDepthIncrement
			vo.setGroup_id(pvo.getGroup_id());
			vo.setGroup_step(pvo.getGroup_step()+1);
			vo.setGroup_tab(pvo.getGroup_tab()+1);
			vo.setRoot(pno);
			
			session.insert("noticeReplyInsert", vo);
			session.update("noticeDepthIncrement", pno);
			
			session.commit();	
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.rollback();					//실패하면 롤백
		}finally{
			if(session!=null)
				session.close();
		}
	}
	
	public static boolean noticeDelete(int no,String email){
		boolean bCheck=false;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			String db_pwd=session.selectOne("noticeGetPassword", no);
			if(db_pwd.equals(email)){
				bCheck=true;
				BoardVO vo=session.selectOne("noticeDeleteInfoData", no);
				if(vo.getDepth()==0){
					session.delete("noticeDelete",no);
				}else{
					vo.setSubject("관리자가 삭제한 게시물입니다");
					vo.setContent("관리자가 삭제한 게시물입니다");
					vo.setNo(no);
					session.update("noticeSubjectUpdate",vo);
				}
				session.update("noticeDepthDecrement", vo.getRoot());
			}else{
				bCheck=false;
			}
			session.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.rollback();
		}finally{
			if(session!=null)
				session.close();
		}
		return bCheck;
	}
	
	
}




