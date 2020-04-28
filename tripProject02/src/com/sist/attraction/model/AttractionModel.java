package com.sist.attraction.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.attraction.dao.AttractionDAO;
import com.sist.attraction.vo.AttractionDetailVO;
import com.sist.attraction.vo.AttractionVO;
import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;


@Controller
public class AttractionModel {
	@RequestMapping("views/template/main/attr.do")
	public String attr_attr(HttpServletRequest request,HttpServletResponse response)
	{
		
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		//Map
		Map map=new HashMap();
		map.put("start", start);
		map.put("end",end);
		map.put("product_kind", "관광지");
		List<AttractionVO> list=AttractionDAO.attractionListData(map);//데이터추가
		
		for(AttractionVO vo:list)
		{
			String title=vo.getTitle();
			if(title.length()>12)
			{
				title=title.substring(0,12).concat("...");
				vo.setTitle(title);
			}
			
		}
		
		int totalpage=AttractionDAO.attrTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		int allPage=totalpage;
		if(endPage>allPage)
			endPage=allPage;
		
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("BLOCK", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("allPage", allPage);
	
		request.setAttribute("jsp", "./../../hotel/jsp/attr.jsp");
		return "index.jsp";
		
	}
	
		@RequestMapping("views/template/main/attr_detail.do")
		 public String attr_detail(HttpServletRequest request,HttpServletResponse response)
	   {
		   String no=request.getParameter("no");
		   // DAO
		   int count=AttractionDAO.attr_count(Integer.parseInt(no));
		   if(count!=0)
		   {
		    AttractionDetailVO vo=AttractionDAO.attraction_detail(Integer.parseInt(no));
		     vo.setAttrmake(vo.getAttrmake().replace("\n", "@"));
		     request.setAttribute("vo", vo);
		   }
		   
		   	request.setAttribute("count", count);
			request.setAttribute("jsp", "./../../hotel/jsp/attr_detail.jsp");
			return "index.jsp";   }

	
		 
	
	
	
	
	
	
	
	
}
