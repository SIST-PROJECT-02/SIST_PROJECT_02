package com.sist.board.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.board.dao.BoardVO;
import com.sist.board.dao.FreeDAO;
import com.sist.board.dao.FreeReplyDAO;
import com.sist.board.dao.FreeReplyVO;
import com.sist.board.dao.NoticeDAO;
import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.board.dao.NoticeReplyDAO;
import com.sist.board.dao.NoticeReplyVO;


@Controller
public class FreeModel {
	
	@RequestMapping("views/template/main/free.do")
	public String free_list(HttpServletRequest request, HttpServletResponse response)
	{
		
		
		String page=request.getParameter("npage");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=15;
		int start = rowSize*(curpage-1)+1;
		int end=rowSize*curpage;
		map.put("nstart", start);
		map.put("nend", end);
		
		List freplyList=new ArrayList();
		
	
		int freplyCount = 0;
		List<BoardVO> list=FreeDAO.freeListData(map);//start부터 end까지 자유게시판 가져온다
		for(int i = 0; i < list.size(); i++){
			freplyCount = FreeDAO.freecount(list.get(i).getNo());
			freplyList.add(freplyCount);
		}
		request.setAttribute("countList", freplyList);
		
		int totalpage=FreeDAO.freeTotalPage();
		request.setAttribute("nlist", list);
		request.setAttribute("ncurpage", curpage);
		request.setAttribute("ntotalpage", totalpage);
	
		request.setAttribute("jsp", "../../board/free/flist.jsp"); // main에 include시킴 
		return "index.jsp";
	}
	
	
	@RequestMapping("views/template/main/fdetail.do")
	public String free_detail(HttpServletRequest request, HttpServletResponse response)
	{
		String no = request.getParameter("no");
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
	    List<FreeReplyVO> list=FreeReplyDAO.freereplyListData(map);
	    
	    map=new HashMap();
	    map.put("pBno", Integer.parseInt(no));
	    int totalpage=FreeReplyDAO.freereplyTotalPage(map);
	    
		BoardVO vo = FreeDAO.freeDetailData(Integer.parseInt(no));
		vo=FreeDAO.fhitIncrement(Integer.parseInt(no));
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("vo", vo);		
		request.setAttribute("jsp", "../../board/free/fdetail.jsp"); // main에 include시킴 
		return "index.jsp";
		
	}
	
	
	@RequestMapping("views/template/main/freereply_insert.do")
	   public String free_reply_insert(HttpServletRequest request,HttpServletResponse response)
	   {
		   try
		   {
			   request.setCharacterEncoding("UTF-8");
		   }catch(Exception ex){}
		   String bno=request.getParameter("bno");
		   String msg=request.getParameter("msg");
		   HttpSession session=request.getSession();// request=>Session,Cookie
		   String email=(String)session.getAttribute("email");
		   String name=(String)session.getAttribute("name");
		   
		   // DAO => Map에 묶어서 전송
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("pBno", Integer.parseInt(bno));
		   map.put("pId", email);
		   map.put("pName", name);
		   map.put("pMsg", msg);
		   // insert 처리 
		   FreeReplyDAO.freereplyInsert(map);
		   return "redirect:fdetail.do?no="+bno;
	   }
	@RequestMapping("views/template/main/free_insert.do")
	public String free_insert(HttpServletRequest request, HttpServletResponse response)
	{		
		request.setAttribute("jsp", "../../board/free/finsert.jsp");
		return "index.jsp";
	}
	// [새 글 작성] 
	
	@RequestMapping("views/template/main/free_insert_ok.do")
	public String free_insert_ok(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex){}
		
		
		// 클라이언트가 입력한 데이터를 가지고 와야...
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		HttpSession mysession=request.getSession();
		String name=String.valueOf(mysession.getAttribute("name"));
		String pwd=String.valueOf(mysession.getAttribute("email"));
		
		// 클라이언트가 입력해준 데이터 VO에 저장 
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);	
		
		
		// VO를 INSERT 하게 mapper에서 수행 
		FreeDAO.freeInsertData(vo);
		
		return "redirect:free.do";
	}
	
	// [글 수정] - 기존 글의 데이터 가져옴 
	@RequestMapping("views/template/main/fupdate.do")
	public String free_update(HttpServletRequest request, HttpServletResponse response)
	{
		// 요청 데이터 갖고 온다
		String no = request.getParameter("no");
				
		// DAO - 해당 글의 데이터 보여준다. 
		BoardVO vo=FreeDAO.freeDetailData((Integer.parseInt(no)));	
		
		request.setAttribute("vo", vo);		
				
		request.setAttribute("jsp", "../../board/free/fupdate.jsp"); // main에 include시킴 
		return "index.jsp";
	}
	
	
	// [글 수정] - 비번 체크 
	@RequestMapping("views/template/main/fpassword_check.do")
	public String free_password_check(HttpServletRequest request, HttpServletResponse response)
	{
		// 클라이언트 데이터 
		String no=request.getParameter("no");
		String user_input_pwd=request.getParameter("pwd"); // 클라이언트가 입력한 데이터  
		System.out.println("user_input_pwd="+user_input_pwd);
		
		// 클라이언트가 입력한 비번과 DB의 실제비번이 같은지 확인
		String db_pwd=FreeDAO.freeGetPassword(Integer.parseInt(no)); // 이게 수행이 안 됨 
		System.out.println("db_pwd="+db_pwd);
		
		int res=0;
		if(db_pwd.equals(user_input_pwd))
		{
			res=1;
		}
		else
		{
			res=0;
		}
		request.setAttribute("result", res);
		
		return "../../board/free/fpassword_check.jsp";
	}
	
	
	// [글 수정] - 실제 수정. update.
	@RequestMapping("views/template/main/fupdate_ok.do")
	public String reply_update_ok(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex){}
		
		// 클라이언트가 수정한 데이터를 가지고 와서 
		HttpSession mysession=request.getSession();
		String name=String.valueOf(mysession.getAttribute("name"));
		String pwd=String.valueOf(mysession.getAttribute("email"));
		String no=request.getParameter("no");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
			 
		// 클라이언트가 수정한 데이터를 VO에 저장 
		BoardVO vo = new BoardVO();
		vo.setNo(Integer.parseInt(no));
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		
		FreeDAO.freeUpdateData(vo);		
		
		return "redirect:fdetail.do?no="+no;
	}
	
	@RequestMapping("views/template/main/freply_ok.do")
	public String nreply_ok(HttpServletRequest request, HttpServletResponse response){
		try
		   {
			  request.setCharacterEncoding("UTF-8");   
		   }catch(Exception ex){}
		   
		   String bno=request.getParameter("bno");
		   String pno=request.getParameter("pno");
		   String msg=request.getParameter("msg");
		   HttpSession session=request.getSession();
		   String email=(String)session.getAttribute("email");
		   String name=(String)session.getAttribute("name");
		   
		   Map map=new HashMap();
		   map.put("pBno", Integer.parseInt(bno));
		   map.put("pPno", Integer.parseInt(pno));
		   map.put("pId", email);
		   map.put("pName", name);
		   map.put("pMsg", msg);
		   // DAO
		   FreeReplyDAO.freereplyInsert(map);
		   return "redirect:fdetail.do?no="+bno;
	   }
	
	@RequestMapping("views/template/main/fdelete.do")
	public String reply_delete(HttpServletRequest request, HttpServletResponse response){
		String no=request.getParameter("no");
		request.setAttribute("no", no);
		request.setAttribute("jsp", "../../board/free/fdelete.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/fdelete_ok.do")
	public String reply_delete_ok(HttpServletRequest request, HttpServletResponse response){
		String no=request.getParameter("no");
		HttpSession session=request.getSession();
		String email=String.valueOf(session.getAttribute("email"));
		System.out.println("email="+email);
		boolean bCheck=FreeDAO.freeDelete(Integer.parseInt(no), email);
		request.setAttribute("bCheck", bCheck);
		return "../../board/free/fdelete_ok.jsp";
	}
	
	@RequestMapping("views/template/main/freereply_delete.do")
	   public String free_reply_delete(HttpServletRequest request,HttpServletResponse response)
	   {
		   String no=request.getParameter("no");
		   String bno=request.getParameter("bno");
		   Map map=new HashMap();
		   map.put("pNo", Integer.parseInt(no));
		   FreeReplyDAO.freereplyDelete(map);
		   return "redirect:fdetail.do?no="+bno;
	   }
	@RequestMapping("views/template/main/freereply_update.do")
	   public String free_reply_update(HttpServletRequest request,HttpServletResponse response)
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
		   
		   FreeReplyDAO.freereplyUpdate(map);
		   return "redirect:fdetail.do?no="+bno;
	   }
	@RequestMapping("views/template/main/freereply_reply.do")
	   public String free_reply_reply_insert(HttpServletRequest request,HttpServletResponse response)
	   {
		   try
		   {
			  request.setCharacterEncoding("UTF-8");   
		   }catch(Exception ex){}
		   
		   String bno=request.getParameter("bno");
		   String pno=request.getParameter("pno");
		   String msg=request.getParameter("msg");
		   HttpSession session=request.getSession();
		   String id=(String)session.getAttribute("email");
		   String name=(String)session.getAttribute("name");
		   
		   Map map=new HashMap();
		   map.put("pBno", Integer.parseInt(bno));
		   map.put("pPno", Integer.parseInt(pno));
		   map.put("pId", id);
		   map.put("pName", name);
		   map.put("pMsg", msg);
		   // DAO
		   FreeReplyDAO.freereplyReplyInsert(map);
		   return "redirect:fdetail.do?no="+bno;
	   }
}






