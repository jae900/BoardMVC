package kr.itedu.boardmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.Service;

public class CommentRegAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
		
		int no = Utils.getParamInt(request.getParameter("no"));		
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int pg = Utils.getParamInt(request.getParameter("pg"));
		
		Service service = new Service();
		
		forward.setRedirect(true);
		String t_comment = request.getParameter("t_comment");
		service.insertComment(btype, no, t_comment);
		request.setAttribute("page", "viewcontent");
		forward.setPath("boardDetail.bo?btype="+btype+"&pg="+pg+"&no="+no);
		
		return forward;
	}

}
