package com.sist.board.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;
import com.sist.board.dao.*;
import com.sist.board.dao.ReplyVO;
import com.sist.board.dao.BoardVO;

@Controller
public class FreeBoardModel {
   @RequestMapping("views/template/main/freeboard.do")
   public String freeboard_list(HttpServletRequest request,HttpServletResponse response)
   {
	   //page
	   String page=request.getParameter("page");
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   FreeBoardDAO dao=new FreeBoardDAO();
	   List<BoardVO> list=dao.freeboardListData(curpage);
	   int totalpage=dao.freeboardTotalPage();
	   
	   request.setAttribute("curpage", curpage);
	   request.setAttribute("totalpage", totalpage);
	   request.setAttribute("list", list);
	   request.setAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	   request.setAttribute("jsp", "../../board/freeboard/list.jsp");
	   return "index.jsp";
   }
   
   @RequestMapping("views/template/main/freeboard_insert.do")
   public String freeboard_insert(HttpServletRequest request,HttpServletResponse response)
   {
	   request.setAttribute("jsp", "../../board/freeboard/insert.jsp");
	   return "index.jsp";
   }
   
   @RequestMapping("views/template/main/freeboard_insert_ok.do")
   public String freeboard_insert_ok(HttpServletRequest request,HttpServletResponse response)
   {
	   try
	   {
		   request.setCharacterEncoding("UTF-8");
	   }catch(Exception ex){}
	   
	   String name=request.getParameter("name");
	   String subject=request.getParameter("subject");
	   String content=request.getParameter("content");
	   String pwd=request.getParameter("pwd");
	   
	   BoardVO vo=new BoardVO();
	   vo.setName(name);
	   vo.setSubject(subject);
	   vo.setContent(content);
	   vo.setPwd(pwd);
	   FreeBoardDAO dao=new FreeBoardDAO();
	   dao.freeboardInsert(vo);
	   return "redirect:../freeboard/list.do";
   }
   
   @RequestMapping("views/template/main/freeboard_detail.do")
   public String freeboard_detail(HttpServletRequest request,HttpServletResponse response)
   {
	   String no=request.getParameter("no");//bno
	   String page=request.getParameter("page");
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=10;
	   int start=(curpage*rowSize)-(rowSize-1);
	   int end=curpage*rowSize;
	   map.put("pStart", start);
	   map.put("pEnd", end);
	   map.put("pBno", Integer.parseInt(no));
	   List<ReplyVO> list=FreeBoardReplyDAO.replyListData(map);
	   
	   map=new HashMap();
	   map.put("pBno", Integer.parseInt(no));
	   int totalpage=FreeBoardReplyDAO.replyTotalPage(map);
	   FreeBoardDAO dao=new FreeBoardDAO();
	   BoardVO vo=dao.freeboardInfoData(Integer.parseInt(no), 1);
	   request.setAttribute("list", list);
	   request.setAttribute("curpage", curpage);
	   request.setAttribute("totalpage", totalpage);
	   request.setAttribute("vo", vo);
	   request.setAttribute("jsp", "../../board/freeboard/detail.jsp");
	   return "index.jsp";
   }
   
   @RequestMapping("views/template/main/freeboard_update.do")
   public String freeboard_update(HttpServletRequest request,HttpServletResponse response)
   {
	   String no=request.getParameter("no");
	   FreeBoardDAO dao=new FreeBoardDAO();
	   BoardVO vo=dao.freeboardInfoData(Integer.parseInt(no), 2);
	   request.setAttribute("vo", vo);
	   request.setAttribute("jsp", "../../board/freeboard/update.jsp");
	   return "index.jsp";
   }
   
   @RequestMapping("views/template/main/freeboard_update_ok.do")
   public String freeboard_update_ok(HttpServletRequest request,HttpServletResponse response)
   {
	   try
	   {
		   request.setCharacterEncoding("UTF-8");// 디코딩 ( 송신:인코딩 , 수신:디코딩 )
	   }catch(Exception ex){}
	   
	   String name=request.getParameter("name");
	   String subject=request.getParameter("subject");
	   String content=request.getParameter("content");
	   String pwd=request.getParameter("pwd");
	   String no=request.getParameter("no");
	   
	   BoardVO vo=new BoardVO();
	   vo.setName(name);
	   vo.setSubject(subject);
	   vo.setContent(content);
	   vo.setPwd(pwd);
	   vo.setNo(Integer.parseInt(no));
	   FreeBoardDAO dao=new FreeBoardDAO();
	   boolean bCheck=dao.freeboardUpdate(vo);
	   request.setAttribute("bCheck", bCheck);
	   request.setAttribute("no", no);
	   return "../freeboard/update_ok.jsp";
   }
   @RequestMapping("views/template/main/freeboard_delete.do")
   public String freeboard_delete(HttpServletRequest request,HttpServletResponse response)
   {
	   String no=request.getParameter("no");
	   request.setAttribute("no", no);
	   request.setAttribute("jsp", "../../board/freeboard/delete.jsp");
	   return "index.jsp";
   }
   
   @RequestMapping("views/template/main/freeboard_delete_ok.do")
   public String freeboard_delete_ok(HttpServletRequest request,HttpServletResponse response)
   {
	   String no=request.getParameter("no");
	   String pwd=request.getParameter("pwd");
	   FreeBoardDAO dao=new FreeBoardDAO();
	   boolean bCheck=dao.freeboardDelete(Integer.parseInt(no), pwd);
	   request.setAttribute("bCheck", bCheck);
	   return "../freeboard/delete_ok.jsp";
   }
   
   @RequestMapping("views/template/main/freeboard_reply_insert.do")
   public String freeboard_reply_insert(HttpServletRequest request,HttpServletResponse response)
   {
	   try
	   {
		   request.setCharacterEncoding("UTF-8");
	   }catch(Exception ex){}
	   String bno=request.getParameter("bno");
	   String msg=request.getParameter("msg");
	   HttpSession session=request.getSession();// request=>Session,Cookie
	   String id=(String)session.getAttribute("id");
	   String name=(String)session.getAttribute("name");
	   
	   Map<String,Object> map=new HashMap<String,Object>();
	   map.put("pBno", Integer.parseInt(bno));
	   map.put("pId", id);
	   map.put("pName", name);
	   map.put("pMsg", msg);
	   // insert 처리 
	   FreeBoardReplyDAO.replyInsert(map);
	   return "redirect:../freeboard/detail.do?no="+bno;
   }
   
   @RequestMapping("views/template/main/freeboard_reply_update.do")
   public String freeboard_reply_update(HttpServletRequest request,HttpServletResponse response)
   {
	   try
	   {
		   request.setCharacterEncoding("UTF-8");
	   }catch(Exception ex){}
	   String bno=request.getParameter("bno");
	   String no=request.getParameter("no");
	   String msg=request.getParameter("msg");
	   
	   Map map=new HashMap();
	   map.put("pNo", Integer.parseInt(no));
	   map.put("pMsg", msg);
	   
	   FreeBoardReplyDAO.replyUpdate(map);
	   return "redirect:../freeboard/detail.do?no="+bno;
   }
   
   @RequestMapping("views/template/main/freeboard_reply_reply_insert.do")
   public String freeboard_reply_reply_insert(HttpServletRequest request,HttpServletResponse response)
   {
	   try
	   {
		  request.setCharacterEncoding("UTF-8");   
	   }catch(Exception ex){}
	   
	   String bno=request.getParameter("bno");
	   String pno=request.getParameter("pno");
	   String msg=request.getParameter("msg");
	   HttpSession session=request.getSession();
	   String id=(String)session.getAttribute("id");
	   String name=(String)session.getAttribute("name");
	   
	   Map map=new HashMap();
	   map.put("pBno", Integer.parseInt(bno));
	   map.put("pPno", Integer.parseInt(pno));
	   map.put("pId", id);
	   map.put("pName", name);
	   map.put("pMsg", msg);
	   // DAO
	   FreeBoardReplyDAO.replyReplyInsert(map);
	   return "redirect:../freeboard/detail.do?no="+bno;
   }
   @RequestMapping("views/template/main/freeboard_reply_delete.do")
   public String freeboard_reply_delete(HttpServletRequest request,HttpServletResponse response)
   {
	   String no=request.getParameter("no");
	   String bno=request.getParameter("bno");
	   Map map=new HashMap();
	   map.put("pNo", Integer.parseInt(no));
	   // DAO
	   FreeBoardReplyDAO.replyDelete(map);
	   return "redirect:../freeboard/detail.do?no="+bno;
   }
}













