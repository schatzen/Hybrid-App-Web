package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MobileMemberVo;

public class MobileMemberDaoImpl implements MobileMemberDao{

	
	SqlSession sqlSession;
	
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<MobileMemberVo> selectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mobile_member.mobile_member_list");
	}

	@Override
	public MobileMemberVo selectOne(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mobile_member.mobile_member_one_id", id);
	}

	@Override
	public MobileMemberVo selectOne(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mobile_member.mobile_member_one_idx", idx);
	}

	@Override
	public int insert(MobileMemberVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("mobile_member.mobile_member_insert", vo);
	}

	@Override
	public int update_device_token(MobileMemberVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("mobile_member.mobile_member_update_device_token", vo);
	}

	@Override
	public int delete(int idx) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MobileMemberVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
