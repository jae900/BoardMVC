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

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
		
		Service service = new Service();
		
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int num = Utils.getParamInt(request.getParameter("no"));
		BoardVO vo = service.getBoardDetail(btype, num);
		request.setAttribute("page", "viewcontent");
		request.setAttribute("btype", btype);
		request.setAttribute("vo", vo);
		
		ArrayList<CommentVO> cdata= service.getComment(btype, num);
		request.setAttribute("cdata", cdata);
		int commentCnt = cdata.size();
		request.setAttribute("commentCnt", commentCnt);
		
		
		
		return forward;
	}
}