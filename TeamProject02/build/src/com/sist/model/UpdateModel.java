package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;

public class UpdateModel implements Model{

	@Override
	public String execute(HttpServletRequest request) {
		
		String no=request.getParameter("no");
		System.out.println(no);
		BoardVO vo=BoardDAO.boardUpdateData(Integer.parseInt(no));
		request.setAttribute("vo", vo);
		
		return "board/update.jsp";
	}
}
