package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.DBService;
import service.MyBatisConnector;
import vo.VisitVo;

public class VisitDao {

	//Mybatis��ü
	SqlSessionFactory factory;
	
	//Single-ton : ��ü1���� �����ؼ� ��������
	static VisitDao single = null;

	public static VisitDao getInstance() {
		if (single == null)
			single = new VisitDao();
		return single;
	}
	
	public VisitDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	
	
	//���� ��ȸ
	public List<VisitVo> selectList() {

		List<VisitVo> list = null;
		//1.�۾� ��ü ������
		SqlSession sqlSession = factory.openSession();
		//2.�۾�                      namespace.id 
		list = sqlSession.selectList("visit.visit_list");
		//3.��ȯ
		sqlSession.close();
		return list;
	}
	
	public List<VisitVo> selectList(Map map) {
		// TODO Auto-generated method stub
		
		List<VisitVo> list = null;
		//1.�۾� ��ü ������
		SqlSession sqlSession = factory.openSession();
		
		//2.�۾�                      namespace.id 
		list = sqlSession.selectList("visit.visit_list_condition",map);
		
		//3.��ȯ
		sqlSession.close();
		
		return list;
	}
	
	
	// idx�� �ش�Ǵ� �Խñ� 1�� ������
	public VisitVo selectOne(int idx) {

		VisitVo vo = null;
		
		//1.�۾� ��ü ������
		SqlSession sqlSession = factory.openSession();
		
		//2.�۾�                      namespace.id 
		vo = sqlSession.selectOne("visit.visit_one",idx);
		
		//3.��ȯ
		sqlSession.close();

		return vo;
	}
	
	//���� �߰�
	public int insert(VisitVo vo) {
		int res = 0;
		
		//1.�۾���ü ������
		SqlSession sqlSession = factory.openSession();
		
		//2.�۾�����           ���ӽ����̽�.ȣ��ID , Parameter
		res = sqlSession.insert("visit.visit_insert", vo);		
		
		//2-1.Ʈ����� ó��
		sqlSession.commit();
		
		//3.��ȯ
		sqlSession.close();
		
		return res;
	}
	
	//����
	public int update(VisitVo vo) {
		int res = 0;
		
		//1.�۾���ü ������
		//      openSession(boolean) : true<- auto commit
		//                        
		SqlSession sqlSession = factory.openSession(true);
		
		//2.�۾�����           ���ӽ����̽�.ȣ��ID , Parameter
		res = sqlSession.delete("visit.visit_update", vo);		
		
		//3.��ȯ
		sqlSession.close();
				

		return res;
	}
	
	//--����
	public int delete(int idx) {
		int res = 0;
		
		//1.�۾���ü ������
		//      openSession(boolean) : true<- auto commit
		//                        
		SqlSession sqlSession = factory.openSession(true);
		
		//2.�۾�����           ���ӽ����̽�.ȣ��ID , Parameter
		res = sqlSession.delete("visit.visit_delete", idx);		
		
		//3.��ȯ
		sqlSession.close();
				
		return res;
	}

	
	
	
	
	
}
