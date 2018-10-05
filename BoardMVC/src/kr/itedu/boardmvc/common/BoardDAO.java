package kr.itedu.boardmvc.common;

import static kr.itedu.boardmvc.common.DBConnector.close;
import static kr.itedu.boardmvc.common.DBConnector.getConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.CommentVO;

public class BoardDAO {
	private static BoardDAO dao;
	
	private BoardDAO() {} //private 생성자
	
	public static BoardDAO getInstance() { //싱글톤 패턴
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
		
	public ArrayList<BoardVO> getBoardList(int btype){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		
		String query = " Select * from board"+btype
				+ " order by no desc ";
		
		try {
			conn = getConn();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				BoardVO vo = new BoardVO();
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String regDate=rs.getString("regDate");
				
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setRegDate(regDate);	
				result.add(vo);
			}
			
		} catch(SQLException e) {
			//TODO : 예외처리
		} catch (Exception e) {
			//TODO : 예외처리
		} finally {
			close(conn, ps, rs);
		}		
		
		return result;
	}
	
	public BoardVO getBoardDetail(int btype, int num){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		BoardVO vo = new BoardVO();
		
		String query = " Select * from board"+btype
				+ " where no = ? ";
		
		try {
			conn = getConn();
			ps=conn.prepareStatement(query);
			ps.setInt(1, num);
			rs=ps.executeQuery();
			
			while(rs.next()) {				
				
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String regDate=rs.getString("regDate");
				
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setRegDate(regDate);
			}
			
		} catch(SQLException e) {
			//TODO : 예외처리
		} catch (Exception e) {
			//TODO : 예외처리
		} finally {
			close(conn, ps, rs);
		}		
		
		return vo;
	}
	
	public void insert(int btype, String title, String content){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
						
		String query = " insert into board"+btype+" (no, title, content) values "
				+ " ((select nvl(max(no),0)+1 from board"+btype+"), ?, ? ) " ;
		
		try {
			conn = getConn();
			ps=conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, content);
			
			ps.executeQuery();
			
			System.out.println("삽입완료");
			
		} catch(SQLException e) {
			//TODO : 예외처리
		} catch (Exception e) {
			//TODO : 예외처리
		} finally {
			close(conn, ps, rs);
		}		
	}
	
	public int getPage(int btype, int pagecount){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int pagenum = 0 ;
						
		String query = " select ceil(count(no)/"+pagecount+") as pagenum from board"+btype ;
		
		try {
			conn = getConn();
			ps=conn.prepareStatement(query);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				pagenum = rs.getInt("pagenum");
			}
						
		} catch(SQLException e) {
			//TODO : 예외처리
		} catch (Exception e) {
			//TODO : 예외처리
		} finally {
			close(conn, ps, rs);
		}
		return pagenum;
	}
	
	public ArrayList<BoardVO> getBoardPage(int btype, int pg, int pagecount){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		
		String query = " select * from (select rownum as rnum, z.* from " 
				+ " (select * from board"+btype+" order by no desc) "
				+ " z where rownum <= "+((pg-1)*pagecount+pagecount)+") "
				+ " where rnum >= "+((pg-1)*pagecount+1) ;
		
		try {
			conn = getConn();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				BoardVO vo = new BoardVO();
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String regDate=rs.getString("regDate");
				
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setRegDate(regDate);	
				result.add(vo);
			}
			
			
		} catch(SQLException e) {
			//TODO : 예외처리
		} catch (Exception e) {
			//TODO : 예외처리
		} finally {
			close(conn, ps, rs);
		}		
		
		return result;
	}
	
	public void update(int btype, int no, String title, String content){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
						
		String query = "update board"+btype+" SET title = ?, content = ? where no = ?" ;
		
		try {
			conn = getConn();
			ps=conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, no);
			
			ps.executeQuery();
			
			System.out.println("수정완료");
			
		} catch(SQLException e) {
			//TODO : 예외처리
		} catch (Exception e) {
			//TODO : 예외처리
		} finally {
			close(conn, ps, rs);
		}		
	}
	
	public void delete(int btype, int no){
		Connection conn = null;
		PreparedStatement ps = null;
						
		String query = " delete from board"+btype+" where no="+no ;
		
		try {
			conn = getConn();
			ps=conn.prepareStatement(query);
			
			ps.execute();
			
			System.out.println("삭제완료");
			
		} catch(SQLException e) {
			//TODO : 예외처리
		} catch (Exception e) {
			//TODO : 예외처리
		} finally {
			close(conn, ps);
		}		
	}
	
	public void insertComment(int btype, int no, String t_comment){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
						
		String query = " insert into t_comment (cid, btype, no, t_comment) values "
				+ " ((select nvl(max(cid),0)+1 from t_comment), ?, ?, ? ) " ;
		
		try {
			conn = getConn();
			ps=conn.prepareStatement(query);
			ps.setInt(1, btype);
			ps.setInt(2, no);
			ps.setString(3, t_comment);
			
			ps.executeQuery();
			
			System.out.println("삽입완료");
			
		} catch(SQLException e) {
			//TODO : 예외처리
		} catch (Exception e) {
			//TODO : 예외처리
		} finally {
			close(conn, ps, rs);
		}		
	}
	
	public ArrayList<CommentVO> getComment(int btype, int no){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<CommentVO> result = new ArrayList<CommentVO>();
		
		String query = " Select * from t_comment where btype=? and no=?"
				+ " order by cid ";
		
		try {
			conn = getConn();
			ps=conn.prepareStatement(query);
			ps.setInt(1, btype);
			ps.setInt(2, no);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				CommentVO cvo = new CommentVO();
				
				int cid = rs.getInt("cid");
				int num = rs.getInt("no");
				int btyp = rs.getInt("btype");
				String t_comment = rs.getString("t_comment");
				String cregdate=rs.getString("cregdate");
				
				cvo.setCid(cid);
				cvo.setNo(num);
				cvo.setBtype(btyp);
				cvo.setT_comment(t_comment);
				cvo.setCregdate(cregdate);
				
				result.add(cvo);
			}
			
		} catch(SQLException e) {
			//TODO : 예외처리
		} catch (Exception e) {
			//TODO : 예외처리
		} finally {
			close(conn, ps, rs);
		}		
		
		return result;
	}
	
	public void deleteComment(int btype, int no) {
		Connection conn = null;
		PreparedStatement ps = null;
						
		String query = " delete from t_comment where btype=?, no=? ";
		
		try {
			conn = getConn();
			ps=conn.prepareStatement(query);
			ps.setInt(1, btype);
			ps.setInt(2, no);
			
			ps.executeQuery();
			
			System.out.println("삭제완료");
			
		} catch(SQLException e) {
			//TODO : 예외처리
		} catch (Exception e) {
			//TODO : 예외처리
		} finally {
			close(conn, ps);
		}		
	}
		
}
