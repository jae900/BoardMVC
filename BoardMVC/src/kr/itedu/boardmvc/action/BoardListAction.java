package kr.itedu.boardmvc.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.CommentVO;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.Service;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
		
		Service service = new Service();
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int pagecount = 15;
		int pagenum = service.getPage(btype, pagecount);
		int pg = Utils.getParamInt(request.getParameter("pg"));
		int num = Utils.getParamInt(request.getParameter("no"));
		System.out.println(pagenum);
		
		
		ArrayList<BoardVO> data = service.getBoardPage(btype, pg, pagecount);
		request.setAttribute("title", Var.TITLES[btype-1]);
		request.setAttribute("page", "boardlist");
		request.setAttribute("content", "boardList");
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);
		request.setAttribute("pagenum", pagenum);
		request.setAttribute("pg", pg);
		
		ArrayList<CommentVO> cdata= service.getComment(btype, num);
		request.setAttribute("cdata", cdata);
		int commentCnt = cdata.size();
		request.setAttribute("commentCnt", commentCnt);
		
		return forward;
	}

}
