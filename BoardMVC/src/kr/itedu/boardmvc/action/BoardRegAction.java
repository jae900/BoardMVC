package kr.itedu.boardmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.Service;

public class BoardRegAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);

		String flag = request.getParameter("flag");
		int no = Utils.getParamInt(request.getParameter("no"));
		
		Service service = new Service();
		int btype = Utils.getParamInt(request.getParameter("btype"));	
		
		if (flag == null) {
			if (no == 0) {
				request.setAttribute("page", "write");
			} else {
				request.setAttribute("page", "write");
				int num = Utils.getParamInt(request.getParameter("no"));
				BoardVO vo = service.getBoardDetail(btype, num);
				request.setAttribute("btype", btype);
				request.setAttribute("vo", vo);
			}
		} else {
			if (no == 0) {
				forward.setRedirect(true);
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				service.insert(btype, title, content);
				request.setAttribute("page", "boardlist");
				forward.setPath("boardList.bo?btype="+btype+"&pg=1");
			} else {
				int pg = Utils.getParamInt(request.getParameter("pg"));
				forward.setRedirect(true);
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				service.update(btype, no, title, content);
				request.setAttribute("page", "viewcontent");
				forward.setPath("boardDetail.bo?btype="+btype+"&pg="+pg+"&no="+no);
			}
		}

		return forward;
	}
}
