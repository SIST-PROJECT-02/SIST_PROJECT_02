package com.sist.member.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.dao.CreateSqlsessionFactory;
import com.sist.member.model.*;
import com.sun.corba.se.impl.protocol.BootstrapServerRequestDispatcher;

import java.util.*;


public class MemberDAO {

	private static SqlSessionFactory ssf;
	
	static
	{
		ssf=CreateSqlsessionFactory.getSsf();
	}
	
	public static void memberInsert(MemberVO vo)
	{
		SqlSession session=null;
		try
		{
			session=ssf.openSession(true);
			session.insert("memberInsert",vo);
		}
		catch(Exception ex)
		{
			System.out.println("memberInsert_error: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close();
		}			
	}
	
	public static MemberVO memberLogin(String email, String pwd)
	{
		MemberVO vo=new MemberVO();
		SqlSession session=null;
		try
		{
			session=ssf.openSession();
			int count=session.selectOne("idCount", email);
			System.out.println("idCount: "+count);
			if(count==0)
			{
				//아이디가 존재하지않는 경우
				vo.setMsg("NOID");
				System.out.println("아이디가 존재하지않습니다.");
			}
			else
			{
				//아이디가 존재하는 경우
				MemberVO mvo=session.selectOne("getPwd", email);
				System.out.println("아이디가 존재합니다.");
				if(pwd.equals(mvo.getPwd()))
				{
					vo.setMsg("OK");
					vo.setAdmin(mvo.getAdmin());
					vo.setName(mvo.getName());
				}
				else
				{
					vo.setMsg("NOPWD");
					System.out.println("비밀번호가 일치하지않습니다.");
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("memberLogin_error: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		return vo;
	}
	
	public static int checkid(String email)
	{
		int count=0;
		SqlSession session=null;
		try
		{
			session=ssf.openSession();
			count=session.selectOne("idCheck", email);
			System.out.println("count: "+count);
		}
		catch(Exception ex)
		{
			System.out.println("checkid_error: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		return count;
	}
	
	public static MemberVO memberDetailData(String email)
	{
		MemberVO vo=new MemberVO();
		SqlSession session=null;
		try
		{
			session=ssf.openSession();
			vo=session.selectOne("memberDetailData",email);
		}
		catch(Exception ex)
		{
			System.out.println("memberDetailData_error: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		return vo; 
	}
	
	public static void memberUpdate(MemberVO vo)
	{
		SqlSession session=null;
		try
		{
			session=ssf.openSession(true);
			session.update("memberUpdate",vo);
		}
		catch(Exception ex)
		{
			System.out.println("memberUpdate_error: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close();
		}
	}
}
