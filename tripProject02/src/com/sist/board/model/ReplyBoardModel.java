package com.sist.board.model;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.board.dao.BoardVO;
import com.sist.board.dao.ReplyBoardDAO;

@Controller
public class ReplyBoardModel {

	@RequestMapping("views/template/main/list.do")
	public String reply_list(HttpServletRequest request, HttpServletResponse response)
	{
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=15;
		int start = rowSize*(curpage-1)+1;
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		
		List<BoardVO> list=ReplyBoardDAO.replyListData(map);
		int totalpage=ReplyBoardDAO.replyTotalPage();
		
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		
		request.setAttribute("jsp", "../../board/reply/list.jsp"); // main에 include시킴 
		return "index.jsp";
	}
	
	
	
	@RequestMapping("views/template/main/detail.do")
	public String reply_detail(HttpServletRequest request, HttpServletResponse response)
	{
		String no = request.getParameter("no");
		
		BoardVO vo = ReplyBoardDAO.replyDetailData(Integer.parseInt(no));
		vo=ReplyBoardDAO.hitIncrement(Integer.parseInt(no));
				
		request.setAttribute("vo", vo);		
		
		request.setAttribute("jsp", "../../board/reply/detail.jsp"); // main에 include시킴 
		return "index.jsp";
		
	}
	
	@RequestMapping("views/template/main/insert.do")
	public String reply_insert(HttpServletRequest request, HttpServletResponse response)
	{		
		request.setAttribute("jsp", "../../board/reply/insert.jsp"); // main에 include시킴 
		return "index.jsp";
	}
	
	// [새 글 작성] 
	@RequestMapping("views/template/main/insert_ok.do")
	public String reply_insert_ok(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex){}
		
		
		// 클라이언트가 입력한 데이터를 가지고 와야...
		String name=request.getParameter("name");
		String subject=request.getParameter("name");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		
		// 클라이언트가 입력해준 데이터 VO에 저장 
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);	
		
		// VO를 INSERT 하게 mapper에서 수행 
		ReplyBoardDAO.replyInsertData(vo);
		
		return "redirect:list.do";
	}
	
	// [글 수정] - 기존 글의 데이터 가져옴 
	@RequestMapping("views/template/main/update.do")
	public String reply_update(HttpServletRequest request, HttpServletResponse response)
	{
		// 요청 데이터 갖고 온다
		String no = request.getParameter("no");
				
		// DAO - 해당 글의 데이터 보여준다. 
		BoardVO vo=ReplyBoardDAO.replyDetailData((Integer.parseInt(no)));	
		
		request.setAttribute("vo", vo);		
				
		request.setAttribute("jsp", "../../board/reply/update.jsp"); // main에 include시킴 
		return "index.jsp";
	}
	
	
	// [글 수정] - 비번 체크 
	@RequestMapping("views/template/reply/password_check.do")
	public String reply_password_check(HttpServletRequest request, HttpServletResponse response)
	{
		// 클라이언트 데이터 
		String no=request.getParameter("no");
		String user_input_pwd=request.getParameter("pwd"); // 클라이언트가 입력한 데이터  
		System.out.println("user_input_pwd="+user_input_pwd);
		
		// 클라이언트가 입력한 비번과 DB의 실제비번이 같은지 확인
		String db_pwd=ReplyBoardDAO.replyGetPassword(Integer.parseInt(no)); // 이게 수행이 안 됨 
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
		
		return "../../board/reply/password_check.jsp";
	}
	
	
	// [글 수정] - 실제 수정. update.
	@RequestMapping("views/template/main/update_ok.do")
	public String reply_update_ok(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex){}
		
		// 클라이언트가 수정한 데이터를 가지고 와서 
		String no=request.getParameter("no");
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");  // 사용자가 입력한 비번을 가지고 와서 
			 
		// 클라이언트가 수정한 데이터를 VO에 저장 
		BoardVO vo = new BoardVO();
		vo.setNo(Integer.parseInt(no));
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		
		ReplyBoardDAO.replyUpdateData(vo);		
		
		return "redirect:detail.do?no="+no;
	}
	
	@RequestMapping("views/template/main/reply.do")
	public String reply_reply(HttpServletRequest request, HttpServletResponse response){
		String pno=request.getParameter("no");
		request.setAttribute("pno", pno);
		request.setAttribute("jsp", "../../board/reply/reply.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/reply_ok.do")
	public String reply_ok(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		String no=request.getParameter("no");
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");  
		String pno=request.getParameter("pno");
			 
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
	
		ReplyBoardDAO.replyReplyInsert(Integer.parseInt(pno), vo);
		//.do = method 호출
		return "redirect:list.do";      //reply_jsp() 를 다시 실행해서 데이터 요청하는 코딩실행
	}
	
	@RequestMapping("views/template/main/delete.do")
	public String reply_delete(HttpServletRequest request, HttpServletResponse response){
		String no=request.getParameter("no");
		request.setAttribute("no", no);
		request.setAttribute("jsp", "../../board/reply/delete.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/delete_ok.do")
	public String reply_delete_ok(HttpServletRequest request, HttpServletResponse response){
		String no=request.getParameter("no");
		String pwd=request.getParameter("pwd");
		//DAO
		boolean bCheck=ReplyBoardDAO.replyDelete(Integer.parseInt(no), pwd);
		request.setAttribute("bCheck", bCheck);
		return "../../board/reply/delete_ok.jsp";
	}
}






