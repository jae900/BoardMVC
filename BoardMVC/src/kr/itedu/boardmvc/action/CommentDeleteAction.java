package kr.itedu.boardmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.service.Service;

public class CommentDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();		
		
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int no = Utils.getParamInt(request.getParameter("no"));
		int pg = Utils.getParamInt(request.getParameter("pg"));
		
		Service service = new Service();		
		service.delete(btype, no);
		
		forward.setRedirect(true);
		forward.setPath("boardDetail.bo?btype="+btype+"&pg="+pg+"&no="+no);
		
		return forward;
	}

}
