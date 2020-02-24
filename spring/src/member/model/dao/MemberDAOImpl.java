package member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import member.model.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void insertMember(MemberVO vo) throws Exception {
		sqlSession.insert("member.insertMember", vo);
	}

	@Override
	public int idPwCheck(MemberVO vo) throws Exception {
		
		int check = (Integer)sqlSession.selectOne("member.idPwCheck", vo);
		
		return check;
	}

	@Override
	public List selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectMember(String id) throws Exception {
		
		MemberVO vo = sqlSession.selectOne("member.selectMember", id);
		
		return vo;
	}

	@Override
	public void updateMember(MemberVO vo) throws Exception {
		sqlSession.update("member.updateMember", vo);
	}

	@Override
	public void deleteMember(String id) throws Exception {
		sqlSession.delete("member.deleteMember", id);
	}

	@Override
	public int idAvailCheck(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
