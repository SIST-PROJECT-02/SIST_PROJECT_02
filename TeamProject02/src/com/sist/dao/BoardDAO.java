package com.sist.dao;
import java.util.*;
import java.io.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/*
 *	자바
 *	클래스의 구성요소
 *	============
 *	1) 멤버변수
 *		= 인스턴스: new를 이용해서 메모리할당(: 생성)
 *		= 정적변수(static): JVM이 클래스를 읽기 시작
 *	2) 메소드
 *	3) 생성자
 *
 *	============
 *	필요시에 멤버변수에 대한 초기화
 *	= 명시적 방법
 *		public class A
 *		{
 *			int a=10;
 *			static int b=20;
 *			================> 외부나 메소드를 이용해서 초기화를 할 수 없다.
 *			클래스 영역은 선언만 가능하다.(메소드 호출이나 제어문, 연산자 사용이 불가능하다.)
 *		}
 *	= 생성자 이용
 *		외부파일릭기, 네트워크연결, db연결, xml파싱
 *	
 *	= 초기화 블록이용
 *		인스턴스블록: 변수가 인스턴스일 경우
 *		public class A
 *		{
 *			int a;
 *
 *			{
 *				a=getNumber();
 *			}
 *
 *		}
 *		
 *		정적(static)블록: static일 경우에 사용
 *		public class A
 *		{
 *			static int b;
 *
 *			static
 *			{
 *				b=getNumber();
 *			}
 *
 *		}
 *
 *	순서: 명시적방법=>초기화블록=>생성자
 *	
 */
public class BoardDAO {
	
	private static SqlSessionFactory ssf;
	static
	{
		// parshing=> getConnection(), disConnection()
		try
		{
			//xml파일 읽기
			Reader reader=Resources.getResourceAsReader("Config.xml");
			//Spring, Mybatis => classpath(: src)
			
			//parshing
			ssf=new SqlSessionFactoryBuilder().build(reader);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		// id, sql문장 Map에 저장
		// id를 입력하고 sql문장을 전송 
	}
	
	public static List<BoardVO> boardListData(Map map)
	{
		List<BoardVO> list=new ArrayList<BoardVO>();
		SqlSession session=ssf.openSession();
		list=session.selectList("boardListData",map);
		//connection반환
		session.close();
		return list;
	}
	
	public static BoardVO boardDetailData(int no)
	{
		BoardVO vo=new BoardVO();
		SqlSession session=ssf.openSession();
		session.update("hitIncrement",no);//<update>
		session.commit();
		// <insert> => insert("id",값) , <delete> => delete("id",값)
		vo=session.selectOne("boardDetailData",no);   
		session.close();
		return vo;
	}
	
	public static int boardTotalPage()
	{
		int total=0;
		SqlSession session=ssf.openSession();
		total=session.selectOne("boardTotalPage");
		session.close();
		return total;
	}
	
	public static void boardInsert(BoardVO vo)
	{
		//오토커밋
		SqlSession session=ssf.openSession(true);
		session.insert("boardInsert",vo);
		session.close();
	}
	
	public static void boardUpdate(BoardVO vo)
	{
		SqlSession session=ssf.openSession(true);
		session.update("boardUpdate",vo);
		session.close();
	}
	
	public static BoardVO boardUpdateData(int no)
	{
		BoardVO vo=new BoardVO();
		SqlSession session=ssf.openSession();
		vo=session.selectOne("boardDetailData",no);   
		session.close();
		return vo;
	}

}
