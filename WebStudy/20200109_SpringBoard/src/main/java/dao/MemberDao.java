package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVo;

public interface MemberDao {

	public MemberVo selectOne(String id);

	public int insert(MemberVo vo);

	public int delete(int idx);

	public MemberVo selectOne(int idx);

	public int update(MemberVo vo);

	public List<MemberVo> selectList();
		
}
