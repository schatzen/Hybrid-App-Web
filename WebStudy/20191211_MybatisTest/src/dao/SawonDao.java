package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVo;

public class SawonDao {
	//single-ton : ��ü1���� ���� ����
	static SawonDao single = null;

	//SessionFactory�����ϴ� ��ü
	SqlSessionFactory factory;
	
	public SawonDao() {
		super();
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static SawonDao getInstance() {

		if (single == null)
			single = new SawonDao();

		return single;
	}

	public List<SawonVo> selectList() {
		// TODO Auto-generated method stub
		
		List<SawonVo> list = null;
		//1.SqlSession(Mybatis�۾�����)
		SqlSession sqlSession = factory.openSession();
		//2.�۾�����  mapper�� ���ǵ� namespace.id
		list = sqlSession.selectList("sawon.sawon_list");		
		//3.��ȯ(���������δ� Connection��ȯ)
		sqlSession.close();
		
		return list;
	}
	
	public List<SawonVo> selectList(int deptno) {
		// TODO Auto-generated method stub
		
		List<SawonVo> list = null;
		//1.SqlSession(Mybatis�۾�����)
		SqlSession sqlSession = factory.openSession();
		//2.�۾�����  mapper�� ���ǵ� namespace.id
		list = sqlSession.selectList("sawon.sawon_list_deptno", deptno);		
		//3.��ȯ(���������δ� Connection��ȯ)
		sqlSession.close();
		
		return list;
	}
	
	public List<SawonVo> selectList(String sajob) {
		// TODO Auto-generated method stub
		
		List<SawonVo> list = null;
		//1.SqlSession(Mybatis�۾�����)
		SqlSession sqlSession = factory.openSession();
		//2.�۾�����  mapper�� ���ǵ� namespace.id
		list = sqlSession.selectList("sawon.sawon_list_sajob", sajob);		
		//3.��ȯ(���������δ� Connection��ȯ)
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		//1.SqlSession(Mybatis�۾�����)
		SqlSession sqlSession = factory.openSession();
		//2.�۾�����  mapper�� ���ǵ� namespace.id
		list = sqlSession.selectList("sawon.sawon_list_sapay", map);		
		//3.��ȯ(���������δ� Connection��ȯ)
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectSahireList(Map map) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		//1.SqlSession(Mybatis�۾�����)
		SqlSession sqlSession = factory.openSession();
		//2.�۾�����  mapper�� ���ǵ� namespace.id
		list = sqlSession.selectList("sawon.sawon_list_sahire", map);		
		//3.��ȯ(���������δ� Connection��ȯ)
		sqlSession.close();
		
		return list;
	}
	
		
	
}
