package com.sist.board.model;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.board.dao.BoardVO;
import com.sist.board.dao.NoticeDAO;
import com.sist.board.dao.QnaDAO;

@Controller
public class QnaModel {
	@RequestMapping("views/template/main/qna.do")
	public String qna_list(HttpServletRequest request, HttpServletResponse response)
	{
		String npage=request.getParameter("npage");
		if(npage==null)
			npage="1";
		int ncurpage=Integer.parseInt(npage);
		Map nmap=new HashMap();
		int nrowSize=3;
		int nstart=nrowSize*(ncurpage-1)+1;    //nstart=3*(1-1)+1; = 3 
		int nend = nrowSize*ncurpage;          //nend=3*1         = 3 
		nmap.put("nstart", nstart);
		nmap.put("nend", nend);
		
		List replyList=new ArrayList();
		int replyCount = 0;
		List<BoardVO> nlist=NoticeDAO.noticeListData(nmap);
		for(int i = 0; i < nlist.size(); i++){
			replyCount = NoticeDAO.noticecount(nlist.get(i).getNo());
			replyList.add(replyCount);
		}
		request.setAttribute("countList", replyList);
		int ntotalpage=NoticeDAO.noticeTotalPage();
		request.setAttribute("nlist", nlist);
		request.setAttribute("ncurpage", ncurpage);
		request.setAttribute("ntotalpage", ntotalpage);
		
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
		
		//List<BoardVO> alist //e개의 공지사항-
		List<BoardVO> list=QnaDAO.qnaListData(map);//start부터 end까지 자유게시판 가져온다
		int totalpage=QnaDAO.qnaTotalPage();
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		
		request.setAttribute("jsp", "../../board/qna/qnalist.jsp");
		//request.setAttribute("jsp", "../../board/qna/qnalist.jsp"); 
		return "index.jsp";
	}
	
	
	
	@RequestMapping("views/template/main/qna_detail.do")
	public String qna_detail(HttpServletRequest request, HttpServletResponse response)
	{
		String no = request.getParameter("no");
		
		BoardVO vo = QnaDAO.qnaDetailData(Integer.parseInt(no));
		vo=QnaDAO.hitIncrement(Integer.parseInt(no));
				
		request.setAttribute("vo", vo);		
		
		request.setAttribute("jsp", "../../board/qna/detail.jsp"); // main에 include시킴 
		return "index.jsp";
		
	}
	
	@RequestMapping("views/template/main/qnainsert.do")
	public String qna_insert(HttpServletRequest request, HttpServletResponse response)
	{		
		request.setAttribute("jsp", "../../board/qna/insert.jsp"); // main에 include시킴 
		return "index.jsp";
	}
	
	// [새 글 작성] 
	@RequestMapping("views/template/main/qna_insert_ok.do")
	public String qna_insert_ok(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex){}
		
		// 클라이언트가 입력한 데이터를 가지고 와야...
		//String name=request.getParameter("name");
		
		HttpSession mysession=request.getSession();
		String name=String.valueOf(mysession.getAttribute("name"));
		String pwd=String.valueOf(mysession.getAttribute("email"));
		System.out.println("세션네임="+name);
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		//String pwd=request.getParameter("pwd");
		
		// 클라이언트가 입력해준 데이터 VO에 저장 
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);	
		
		// VO를 INSERT 하게 mapper에서 수행 
		QnaDAO.qnaInsertData(vo);
		
		return "redirect:qna.do";
	}
	
	// [글 수정] - 기존 글의 데이터 가져옴 
	@RequestMapping("views/template/main/qna_update.do")
	public String qna_update(HttpServletRequest request, HttpServletResponse response)
	{
		// 요청 데이터 갖고 온다
		String no = request.getParameter("no");
				
		// DAO - 해당 글의 데이터 보여준다. 
		BoardVO vo=QnaDAO.qnaDetailData((Integer.parseInt(no)));	
		
		request.setAttribute("vo", vo);		
				
		request.setAttribute("jsp", "../../board/qna/update.jsp"); // main에 include시킴 
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
		String db_pwd=QnaDAO.replyGetPassword(Integer.parseInt(no)); // 이게 수행이 안 됨 
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
	@RequestMapping("views/template/main/qna_update_ok.do")
	public String qna_update_ok(HttpServletRequest request, HttpServletResponse response)
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
		
		QnaDAO.qnaUpdateData(vo);		
		
		return "redirect:qna_detail.do?no="+no;
	}
	
	@RequestMapping("views/template/main/qna_reply.do")
	public String reply_reply(HttpServletRequest request, HttpServletResponse response){
		String pno=request.getParameter("no");
		request.setAttribute("pno", pno);
		request.setAttribute("jsp", "../../board/qna/reply.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/qna_reply_ok.do")
	public String reply_ok(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		String no=request.getParameter("no");
		HttpSession mysession=request.getSession();
		String name=String.valueOf(mysession.getAttribute("name"));
		String pwd=String.valueOf(mysession.getAttribute("email"));
		//String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		//String pwd=request.getParameter("email");  
		String pno=request.getParameter("pno");
			 
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
	
		QnaDAO.qnaReplyInsert(Integer.parseInt(pno), vo);
		//.do = method 호출
		return "redirect:qna.do";      //reply_jsp() 를 다시 실행해서 데이터 요청하는 코딩실행
	}
	
	@RequestMapping("views/template/main/qna_delete.do")
	public String reply_delete(HttpServletRequest request, HttpServletResponse response){
		String no=request.getParameter("no");
		request.setAttribute("no", no);
		request.setAttribute("jsp", "../../board/qna/delete.jsp");
		return "index.jsp";
	}
	
	@RequestMapping("views/template/main/qna_delete_ok.do")
	public String reply_delete_ok(HttpServletRequest request, HttpServletResponse response){
		String no=request.getParameter("no");
		HttpSession mysession=request.getSession();
		String email=String.valueOf(mysession.getAttribute("email"));
		//DAO
		boolean bCheck=QnaDAO.qnaDelete(Integer.parseInt(no), email);
		request.setAttribute("bCheck", bCheck);
		return "../../board/qna/delete_ok.jsp";
	}
}






