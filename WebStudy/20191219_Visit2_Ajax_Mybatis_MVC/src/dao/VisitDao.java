package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.VisitVo;

public class VisitDao {
	
	// Mybatis 객체
	SqlSessionFactory factory;
	
	// Single-ton: 객체 1개만 생성해서 서비스
	static VisitDao single = null;

	public static VisitDao getInstance() {
		if (single == null)
			single = new VisitDao();
		return single;
	}
	
	public VisitDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	// 방명록 조회
	public List<VisitVo> selectList() {
		List<VisitVo> list = null;
		// 1.작업객체 가져오기
		SqlSession sqlSession = factory.openSession();
		// 2.작업
		list = sqlSession.selectList("visit.visit_list");
		// 3.반환하기
		sqlSession.close();
		
		return list;
	}
	
	public List<VisitVo> selectList(Map map) {
		List<VisitVo> list = null;
		// 1.작업객체 가져오기
		SqlSession sqlSession = factory.openSession();
		// 2.작업
		list = sqlSession.selectList("visit.visit_list_condition", map);
		// 3.반환하기
		sqlSession.close();
		
		return list;
	}
	
	// 방명록 1건 가져오기(idx에 해당되는 게시글)
	public VisitVo selectOne(int idx) {
		VisitVo vo = null;
		// 1.작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		// 2.작업
		vo = sqlSession.selectOne("visit.visit_one", idx);
		// 2-1.트랜잭션 처리
		sqlSession.commit();
		// 3.반환하기
		sqlSession.close();
		
		return vo;
	}
	
	// 방명록 추가
	public int insert(VisitVo vo) {
		int res = 0;
		// 1.작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		// 2.작업
		res = sqlSession.insert("visit.visit_insert", vo);
		// 2-1.트랜잭션 처리
		sqlSession.commit();
		// 3.반환하기
		sqlSession.close();
		
		return res;
	}
	
	// 방명록수정
	public int update(VisitVo vo) {
		int res = 0;
		// 1.작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		// 2.작업
		res = sqlSession.update("visit.visit_update", vo);
		// 2-1.트랜잭션 처리
		sqlSession.commit();
		// 3.반환하기
		sqlSession.close();
		
		return res;
	}
	
	// 방명록 삭제
	public int delete(int idx) {
		int res = 0;
		// 1.작업객체 얻어오기
		SqlSession sqlSession = factory.openSession(true);
		// openSession(boolean) => true주면 오토 commit된다
		// 2.작업
		res = sqlSession.delete("visit.visit_delete", idx);
		// 2-1.트랜잭션 처리
		sqlSession.commit();
		// 3.반환하기
		sqlSession.close();
		
		return res;
	}

}
