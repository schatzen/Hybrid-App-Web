package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVo;

public class VisitDao {
	
	
	SqlSession sqlSession;
	
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// ���� ��ȸ
	public List<VisitVo> selectList() {
		List<VisitVo> list = null;
		/*/		Spring�� ����
		 * 		Spring ��ü
		 * 		SqlSessionTemplate��� : 1)openSession()	3)close()
		 * // 1.�۾���ü �������� SqlSession sqlSession = factory.openSession();
		 */
		// 2.�۾�
		list = sqlSession.selectList("visit.visit_list");
		/*		Spring�� ����
		 * // 3.��ȯ�ϱ� sqlSession.close();
		 */
		
		return list;
	}
	
	
	public List<VisitVo> selectList(Map map) {
		List<VisitVo> list = null;
		
		// 2.�۾�
		list = sqlSession.selectList("visit.visit_list_condition", map);
				
		return list;
	}
	
	// ���� 1�� ��������(idx�� �ش�Ǵ� �Խñ�)
	public VisitVo selectOne(int idx) {
		VisitVo vo = null;
		
		// 2.�۾�
		vo = sqlSession.selectOne("visit.visit_one", idx);
				
		return vo;
	}
	
	// ���� �߰�
	public int insert(VisitVo vo) {
		int res = 0;
		
		// 2.�۾�
		res = sqlSession.insert("visit.visit_insert", vo);
				
		return res;
	}
	
	// ���ϼ���
	public int update(VisitVo vo) {
		int res = 0;
		
		// 2.�۾�
		res = sqlSession.update("visit.visit_update", vo);
		
		return res;
	}
	
	// ���� ����
	public int delete(int idx) {
		int res = 0;
		// 2.�۾�
		res = sqlSession.delete("visit.visit_delete", idx);
		
		return res;
	}

}
