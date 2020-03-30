package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.model.*;
import java.util.*;

public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//Spring구조: <bean id="list" class="com.sist.model.ListModel"/>
	private String[] strCmd={"list","insert","insert_ok","detail","update","update_ok"};
	private String[] strCls={
			"com.sist.model.ListModel",
			"com.sist.model.InsertModel",
			"com.sist.model.InsertOkModel",
			"com.sist.model.DetailModel",
			"com.sist.model.UpdateModel",
			"com.sist.model.UpdateOkModel"
	};
	private Map clsMap=new HashMap();
	
	/*
	 * 메모리할당
	 * 
	 * Controller con=new Controller()
	 * 
	 * con.init()
	 * {
	 * 		//초기화(: 생성자), 한번만사용가능
	 * }
	 * 
	 * con.service()
	 * {
	 * 		
	 * }
	 * 
	 * con.destory()
	 * {
	 * 		System.gc();
	 * }
	 */
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try
		{
			for(int i=0;i<strCls.length;i++)
			{
				Class clsName=Class.forName(strCls[i]);
				//메모리 할당 = new를 쓰지않아도 메모리를 할당할 수 있다.
				Object obj=clsName.newInstance();
				System.out.println(obj);
				clsMap.put(strCmd[i], obj);
			}
		}
		catch(Exception ex) { }
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd=request.getRequestURI();
		//list.do
		cmd=cmd.substring(request.getContextPath().length()+1,cmd.lastIndexOf("."));
		//list
		Model model=(Model)clsMap.get(cmd);
		//System.out.println(model);
		String jsp=model.execute(request);
		//System.out.println(jsp);
		if(jsp.startsWith("redirect"))
		{
			response.sendRedirect(jsp.substring(jsp.indexOf(":")+1));
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
	
	}

}
