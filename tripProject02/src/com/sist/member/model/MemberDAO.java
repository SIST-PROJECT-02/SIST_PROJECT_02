package com.sist.member.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.dao.CreateSqlsessionFactory;
import com.sist.member.model.*;
import com.sun.corba.se.impl.protocol.BootstrapServerRequestDispatcher;

import javafx.scene.control.Alert;

import java.util.*;
import com.sist.hotel.dao.*;


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
			/*System.out.println("idCount: "+count);*/
			if(count==0)
			{
				//아이디가 존재하지않는 경우
				vo.setMsg("NOID");
				/*System.out.println("아이디가 존재하지않습니다.");*/
			}
			else
			{
				//아이디가 존재하는 경우
				MemberVO mvo=session.selectOne("getPwd", email);
				/*System.out.println("아이디가 존재합니다.");*/
				if(pwd.equals(mvo.getPwd()))
				{
					vo.setMsg("OK");
					vo.setAdmin(mvo.getAdmin());
					vo.setName(mvo.getName());
				}
				else
				{
					vo.setMsg("NOPWD");
					/*System.out.println("비밀번호가 일치하지않습니다.");*/
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
			/*System.out.println("count: "+count);*/
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
	
	public static boolean memberDelete(String email, String pwd)
	{
		boolean bCheck=false;
		SqlSession session=null;
		try
		{
			/*System.out.println("email: "+email);
			System.out.println("pwd: "+pwd);*/
			session=ssf.openSession();
			String db_pwd=session.selectOne("memberGetPwd", email);
			if(db_pwd.equals(pwd))
			{
				bCheck=true;
				session.delete("memberDelete_ok",email);
			}
			else
			{
				bCheck=false;
				System.out.println("비밀번호가 일치하지않습니다.");
			}
			session.commit();
		}
		catch(Exception ex)
		{
			System.out.println("memberDelete_error: "+ex.getMessage());
			session.rollback();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		return bCheck;
	}
	
	public static List memberLike(String member_email)
	{
		
		SqlSession session=null;
		/*HotelVO vo=new HotelVO();*/
		List<HotelVO> vo=new ArrayList<HotelVO>();
		/*System.out.println("2. DAO연결완료 ");*/
		try 
		{
			session=ssf.openSession();
			vo=session.selectList("memberLikeDetail",member_email);
			/*System.out.println("3. vo저장완료 "+vo);*/
		}
		catch(Exception ex)
		{
			System.out.println("memberLike_error(): "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close();
		}	
		return vo;
	}
	
	public static String memberforgotemail(String name, String birth)
	{
		
		String email="";
		
		Map map = new HashMap();
		/*List list=new ArrayList();*/ 
	
		try (SqlSession session = ssf.openSession()) 
		{
			map.put("name", name);
			map.put("birth",birth);
			
			/*list = session.selectList("memberforgotemail",map);*/
			
			/*if(list.isEmpty())
			{
				System.out.println(list);
			}*/
			email=session.selectOne("memberforgotemail",map);
		}
		catch(Exception ex)
		{
			System.out.println("tourlist_error(): "+ex.getMessage());
		}
		
		/*email = (String)list.get(0);*/
		System.out.println("1번"+email);
		
		return email;
	}
	
	public static String memberforgotpwd(String email)
	{
		SqlSession session=null;
		String pwd="";
		try
		{
			session=ssf.openSession();
			pwd=session.selectOne("memberGetPwd",email);
		}
		catch(Exception ex)
		{
			System.out.println("memeberforgotpwd_error: "+ex.getMessage());
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return pwd;
	}	
	
}
