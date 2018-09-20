package kr.itedu.boardmvc.service;

import java.util.ArrayList;

import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.BoardDAO;

public class Service {

	public ArrayList<BoardVO> getBoardList(int btype) {
		ArrayList<BoardVO> result = null;
		BoardDAO dao = BoardDAO.getInstance();

		result = dao.getBoardList(btype);

		System.out.println(result.get(1).getTitle());
		return result;
	} 

	public BoardVO getBoardDetail(int btype, int num) {
		BoardVO vo = null;

		BoardDAO dao = BoardDAO.getInstance();

		vo = dao.getBoardDetail(btype, num);

		return vo;
	}
	
	public int insert(int btype, String title, String content) {
		int no = 0;
		BoardDAO dao = BoardDAO.getInstance();
		no = dao.insert(btype, title, content);
		return no;
		
	}	

}
