package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.VisitVo;

public class VisitDao {
	
	// Mybatis ��ü
	SqlSessionFactory factory;
	
	// Single-ton: ��ü 1���� �����ؼ� ����
	static VisitDao single = null;

	public static VisitDao getInstance() {
		if (single == null)
			single = new VisitDao();
		return single;
	}
	
	public VisitDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	// ���� ��ȸ
	public List<VisitVo> selectList() {
		List<VisitVo> list = null;
		// 1.�۾���ü ��������
		SqlSession sqlSession = factory.openSession();
		// 2.�۾�
		list = sqlSession.selectList("visit.visit_list");
		// 3.��ȯ�ϱ�
		sqlSession.close();
		
		return list;
	}
	
	public List<VisitVo> selectList(Map map) {
		List<VisitVo> list = null;
		// 1.�۾���ü ��������
		SqlSession sqlSession = factory.openSession();
		// 2.�۾�
		list = sqlSession.selectList("visit.visit_list_condition", map);
		// 3.��ȯ�ϱ�
		sqlSession.close();
		
		return list;
	}
	
	// ���� 1�� ��������(idx�� �ش�Ǵ� �Խñ�)
	public VisitVo selectOne(int idx) {
		VisitVo vo = null;
		// 1.�۾���ü ������
		SqlSession sqlSession = factory.openSession();
		// 2.�۾�
		vo = sqlSession.selectOne("visit.visit_one", idx);
		// 2-1.Ʈ����� ó��
		sqlSession.commit();
		// 3.��ȯ�ϱ�
		sqlSession.close();
		
		return vo;
	}
	
	// ���� �߰�
	public int insert(VisitVo vo) {
		int res = 0;
		// 1.�۾���ü ������
		SqlSession sqlSession = factory.openSession();
		// 2.�۾�
		res = sqlSession.insert("visit.visit_insert", vo);
		// 2-1.Ʈ����� ó��
		sqlSession.commit();
		// 3.��ȯ�ϱ�
		sqlSession.close();
		
		return res;
	}
	
	// ���ϼ���
	public int update(VisitVo vo) {
		int res = 0;
		// 1.�۾���ü ������
		SqlSession sqlSession = factory.openSession();
		// 2.�۾�
		res = sqlSession.update("visit.visit_update", vo);
		// 2-1.Ʈ����� ó��
		sqlSession.commit();
		// 3.��ȯ�ϱ�
		sqlSession.close();
		
		return res;
	}
	
	// ���� ����
	public int delete(int idx) {
		int res = 0;
		// 1.�۾���ü ������
		SqlSession sqlSession = factory.openSession(true);
		// openSession(boolean) => true�ָ� ���� commit�ȴ�
		// 2.�۾�
		res = sqlSession.delete("visit.visit_delete", idx);
		// 2-1.Ʈ����� ó��
		sqlSession.commit();
		// 3.��ȯ�ϱ�
		sqlSession.close();
		
		return res;
	}

}
