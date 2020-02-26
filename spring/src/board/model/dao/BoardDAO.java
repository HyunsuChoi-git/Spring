package board.model.dao;

import java.util.List;

import board.model.vo.BoardVO;

public interface BoardDAO {
	// 게시글 저장
	public BoardVO insertArticle(BoardVO vo) throws Exception;
	// 전체글 개수 검색
	public int getArticleCount() throws Exception;
	// 게시글 범위지정해 가져오기
	public List getArticles(int start, int end) throws Exception;
	// 게시글 한개 정보 가져오기
	public BoardVO getArticle(int num) throws Exception;
	// 게시글 수정용으로 글 한개 정보 가져오기 (조회수 안올라감)
	public BoardVO getArticleForUpdate(int num) throws Exception;
	// 게시글 수정하기
	public int updateArticle(BoardVO vo) throws Exception;
	// 게시글 삭제
	public int deleteArticle(int num, String passwd) throws Exception;
}
