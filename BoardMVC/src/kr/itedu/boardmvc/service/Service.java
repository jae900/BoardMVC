package kr.itedu.boardmvc.service;

import java.util.ArrayList;

import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.CommentVO;
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
		
		return result;
	}
	
	public void update(int btype, int no, String title, String content) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.update(btype, no, title, content);
		
	}	
	
	public void delete (int btype, int no) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.delete(btype, no);
		
	}	
	
	public void insertComment(int btype, int no, String t_comment) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.insertComment(btype, no, t_comment);		
	}
	
	public ArrayList<CommentVO> getComment(int btype, int no) {
		BoardDAO dao = BoardDAO.getInstance();
		
		return dao.getComment(btype, no); 
	}
	
	public void deleteComment() {
		
	}
}
