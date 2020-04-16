package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import vo.DeptVo;

public class DeptDao {

	SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<DeptVo> selectList() {
		// TODO Auto-generated method stub
		
		List<DeptVo> list = null;
		
		//SqlSessionTemplate(spring)
		//  selectList()사용
		//  메소드내부에서 openSession() -> 사용 -> sqlSession.close()
		
		list = sqlSession.selectList("dept.dept_list");
		
		return list;
	}
	
	
	
	
	
}
