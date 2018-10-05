package kr.itedu.boardmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.action.Action;
import kr.itedu.boardmvc.action.BoardDeleteAction;
import kr.itedu.boardmvc.action.BoardDetailAction;
import kr.itedu.boardmvc.action.BoardListAction;
import kr.itedu.boardmvc.action.BoardRegAction;
import kr.itedu.boardmvc.action.CommentDeleteAction;
import kr.itedu.boardmvc.action.CommentRegAction;
import kr.itedu.boardmvc.action.HomeAction;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardFrontController() {
		super();
	}

	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String reqURI = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String command = reqURI.substring(ctxPath.length());

		Action action = null;
		ActionForward forward = null;

		if (command.equals("/boardList.bo")) {
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO:예외처리
				e.printStackTrace();
			}
		} else if (command.equals("/boardDetail.bo")) {
			action = new BoardDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO:예외처리
				e.printStackTrace();
			}
		} else if (command.equals("/home.bo")) {
			action = new HomeAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO:예외처리
				e.printStackTrace();
			}
		} else if (command.equals("/boardReg.bo")) {

			action = new BoardRegAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO:예외처리
				e.printStackTrace();
			}

		} else if (command.equals("/boardDel.bo")) {

			action = new BoardDeleteAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO:예외처리
				e.printStackTrace();
			}

		} else if (command.equals("/commentReg.bo")) {

			action = new CommentRegAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO:예외처리
				e.printStackTrace();
			}

		} else if (command.equals("/commentDelete.bo")) {

			action = new CommentDeleteAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO:예외처리
				e.printStackTrace();
			}

		} 

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		} else {
			// TODO: 없는 주소값 에러페이지 디스플레이 처리
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProc(request, response);
	}

}
