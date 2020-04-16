package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.DBService;
import service.MyBatisConnector;
import vo.PhotoVo;

public class PhotoDao {

	SqlSessionFactory factory;
	
	//Single-ton : 객체1개만 생성해서 서비스하자
	static PhotoDao single = null;

	public static PhotoDao getInstance() {
		if (single == null)
			single = new PhotoDao();
		return single;
	}
	
	
	public PhotoDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	
	//목록조회
	public List<PhotoVo> selectList() {

		List<PhotoVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("photo.photo_list");
		
		sqlSession.close();
		
		return list;
	}
	
	
	public PhotoVo selectOne(int p_idx) {

		PhotoVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("photo.photo_one",p_idx);
		
		sqlSession.close();
		
		return vo;
	}
	
	//추가
	public int insert(PhotoVo vo) {
		int res = 0;
		//                                       auto commit
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("photo.photo_insert",vo);
		
		sqlSession.close();
		return res;
	}
	
	
	//삭제
	public int delete(int p_idx) {
		int res = 0;
		//                                       auto commit
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("photo.photo_delete",p_idx);
		
		sqlSession.close();
		
		return res;
	}
	
	//수정
	public int update(PhotoVo vo) {
		int res = 0;
		//                                       auto commit
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("photo.photo_update",vo);
		
		sqlSession.close();
		
		return res;
	}
	
	
	
	
}
