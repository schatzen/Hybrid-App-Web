package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.PhotoVo;

public class PhotoDao {

	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<PhotoVo> selectList() {
		// TODO Auto-generated method stub
		List<PhotoVo> list = null;
		
		list = sqlSession.selectList("photo.photo_list");
		
		return list;
	}

	public int insert(PhotoVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		res = sqlSession.insert("photo.photo_insert", vo);
		
		return res;
	}

	public PhotoVo selectOne(int p_idx) {
		// TODO Auto-generated method stub
		PhotoVo vo = null;
		
		vo = sqlSession.selectOne("photo.photo_one", p_idx);
		
		return vo;
	}

	public int delete(int p_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		res = sqlSession.delete("photo.photo_delete", p_idx);
		
		return res;
	}
	
}
