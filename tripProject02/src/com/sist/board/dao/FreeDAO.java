package com.sist.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.board.dao.BoardVO;

import java.util.*;

public class FreeDAO {
	private static SqlSessionFactory ssf;
	static
	{
		
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	
	public static List<BoardVO> freeListData(Map map)
	{
		List<BoardVO> list=new ArrayList<BoardVO>();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();	
			list=session.selectList("freeListData",map); 
		}catch(Exception ex)
		{
			System.out.println("freeListData: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static int freeTotalPage()
	{
		int total=0;
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();	
			total=session.selectOne("freeTotalPage");
			
		}catch(Exception ex)
		{
			System.out.println("freeTotalPage: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close(); // 반환 
		}
		
		return total;
	}
	public static int freecount(int no){
		int count=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			count=session.selectOne("freecount",no);
		} catch (Exception e) {
			System.out.println("freecount "+e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		return count;
	}
	
	public static BoardVO freeDetailData(int no)
	{
		BoardVO vo = new BoardVO();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();	
			vo=session.selectOne("freeDetailData",no); 
			
		}catch(Exception ex)
		{
			System.out.println("freeDetailData: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close(); 
		}
		return vo;
	}
	
	public static BoardVO fhitIncrement(int no)
	{
		BoardVO vo = new BoardVO();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();	
			session.update("fhitIncrement",no);
			session.commit(); 
			
			vo=session.selectOne("freeDetailData", no); 
			
		}catch(Exception ex)
		{
			System.out.println("fhitIncrement: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close(); 
		}
		
		return vo;
	}
	
	
	public static BoardVO freeInsertData(BoardVO vo)
	{
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession(true); 
			session.insert("freeInsertData",vo); 
			
		}catch(Exception ex)
		{
			System.out.println("freeInsertData: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close(); 
		}
		return vo;
	}
	
	public static String freeGetPassword(int no)
	{
		String pwd="";
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();	
			pwd=session.selectOne("freeGetPassword",no); 
			
		}catch(Exception ex)
		{
			System.out.println("freeGetPassword: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close(); 
		}
		return pwd;
	}
	
	
	public static BoardVO freeUpdateData(BoardVO vo)
	{
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession(true); 
			session.update("freeUpdateData",vo); 

		}catch(Exception ex)
		{
			System.out.println("freeUpdateData: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close(); 
		}
		return vo;
	}
	
	public static void freeReplyInsert(int pno,BoardVO vo){
		SqlSession session=null;
		try {
			session=ssf.openSession();
			BoardVO pvo=session.selectOne("freeParentInfoData",pno);
			session.update("freeGroupStepIncrement",pvo);
			//replyReplyInsert
			//replyDepthIncrement
			vo.setGroup_id(pvo.getGroup_id());
			vo.setGroup_step(pvo.getGroup_step()+1);
			vo.setGroup_tab(pvo.getGroup_tab()+1);
			vo.setRoot(pno);
			
			session.insert("freeReplyInsert", vo);
			session.update("freeDepthIncrement", pno);
			
			session.commit();	
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.rollback();					//실패하면 롤백
		}finally{
			if(session!=null)
				session.close();
		}
	}
	
	public static boolean freeDelete(int no,String email){
		boolean bCheck=false;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			String db_pwd=session.selectOne("freeGetPassword", no);
			if(db_pwd.equals(email)){
				bCheck=true;
				BoardVO vo=session.selectOne("freeDeleteInfoData", no);
				if(vo.getDepth()==0){
					session.delete("freeDelete",no);
				}else{
					vo.setSubject("관리자가 삭제한 게시물입니다");
					vo.setContent("관리자가 삭제한 게시물입니다");
					vo.setNo(no);
					session.update("freeSubjectUpdate",vo);
				}
				session.update("freeDepthDecrement", vo.getRoot());
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




