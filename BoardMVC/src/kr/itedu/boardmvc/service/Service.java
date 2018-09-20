package kr.itedu.boardmvc.service;

import java.util.ArrayList;

import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.BoardDAO;

public class Service {

	public int getPage(int btype, int pagecount){

		BoardDAO dao = BoardDAO.getInstance();
		int pagenum = dao.getPage(btype, pagecount);
		
		return pagenum;
	}
	
	public ArrayList<BoardVO> getBoardList(int btype) {
		ArrayList<BoardVO> result = null;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getBoardList(btype);
		
		return result;
	} 

	public BoardVO getBoardDetail(int btype, int num) {
		BoardVO vo = null;

		BoardDAO dao = BoardDAO.getInstance();

		vo = dao.getBoardDetail(btype, num);

		return vo;
	}
	
	public void insert(int btype, String title, String content) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.insert(btype, title, content);
		
	}	
	
	public ArrayList<BoardVO> getBoardPage(int btype, int pg, int pagecount){
		
		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		result = dao.getBoardPage(btype, pg, pagecount);
		
		System.out.println(result.get(0).getRegDate());
		
		return result;
	}
	
	public void update(int btype, int no, String title, String content) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.update(btype, no, title, content);
		
	}	
	
	public void delete (int btype, int no) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.delete(btype, no);
		System.out.println("?????");
		
	}	

}
