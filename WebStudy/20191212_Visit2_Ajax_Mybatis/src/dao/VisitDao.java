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

	//Mybatis객체
	SqlSessionFactory factory;
	
	//Single-ton : 객체1개만 생성해서 서비스하자
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
	
	
	
	//방명록 조회
	public List<VisitVo> selectList() {

		List<VisitVo> list = null;
		//1.작업 객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		//2.작업                      namespace.id 
		list = sqlSession.selectList("visit.visit_list");
		//3.반환
		sqlSession.close();
		return list;
	}
	
	public List<VisitVo> selectList(Map map) {
		// TODO Auto-generated method stub
		
		List<VisitVo> list = null;
		//1.작업 객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업                      namespace.id 
		list = sqlSession.selectList("visit.visit_list_condition",map);
		
		//3.반환
		sqlSession.close();
		
		return list;
	}
	
	
	// idx에 해당되는 게시글 1건 얻어오기
	public VisitVo selectOne(int idx) {

		VisitVo vo = null;
		
		//1.작업 객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업                      namespace.id 
		vo = sqlSession.selectOne("visit.visit_one",idx);
		
		//3.반환
		sqlSession.close();

		return vo;
	}
	
	//방명록 추가
	public int insert(VisitVo vo) {
		int res = 0;
		
		//1.작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행           네임스페이스.호출ID , Parameter
		res = sqlSession.insert("visit.visit_insert", vo);		
		
		//2-1.트랜잭션 처리
		sqlSession.commit();
		
		//3.반환
		sqlSession.close();
		
		return res;
	}
	
	//수정
	public int update(VisitVo vo) {
		int res = 0;
		
		//1.작업객체 얻어오기
		//      openSession(boolean) : true<- auto commit
		//                        
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행           네임스페이스.호출ID , Parameter
		res = sqlSession.delete("visit.visit_update", vo);		
		
		//3.반환
		sqlSession.close();
				

		return res;
	}
	
	//--삭제
	public int delete(int idx) {
		int res = 0;
		
		//1.작업객체 얻어오기
		//      openSession(boolean) : true<- auto commit
		//                        
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행           네임스페이스.호출ID , Parameter
		res = sqlSession.delete("visit.visit_delete", idx);		
		
		//3.반환
		sqlSession.close();
				
		return res;
	}

	
	
	
	
	
}
