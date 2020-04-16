package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVo;

public class MemberDaoImpl implements MemberDao{

	//Setter Injection
	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public MemberVo selectOne(String id) {
		// TODO Auto-generated method stub
		MemberVo vo = null;
		
		vo = sqlSession.selectOne("member.member_one_id", id);
		
		return vo;
	}

	public int insert(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		res = sqlSession.insert("member.member_insert",vo);
		return res;
	}

	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;
		res = sqlSession.delete("member.member_delete",idx);
		return res;
	}

	public MemberVo selectOne(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.member_one", idx);
	}

	public int update(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		res = sqlSession.update("member.member_update",vo);
		return res;
	}

	public List<MemberVo> selectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("member.member_list");
	}
	
	
}
