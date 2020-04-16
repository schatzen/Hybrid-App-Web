package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVo;

public class DeptDaoImpl implements DeptDao {

	SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}




	@Override
	public List<DeptVo> selectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("dept.dept_list");
	}

}
