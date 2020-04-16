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
import vo.MemberVo;

public class MemberDao {

	
	SqlSessionFactory factory;
	
	//Single-ton : 객체1개만 생성해서 서비스하자
	static MemberDao single = null;

	public static MemberDao getInstance() {
		if (single == null)
			single = new MemberDao();
		return single;
	}
	
	
	public MemberDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//목록조회
	public List<MemberVo> selectList() {

		List<MemberVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("member.member_list");
		
		sqlSession.close();
			
		return list;
	}
	
	public MemberVo selectOne(int idx) {

		MemberVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("member.member_one_idx",idx);
		
		sqlSession.close();

		return vo;
	}
	
	public MemberVo selectOne(String id) {

		MemberVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("member.member_one_id",id);
		
		sqlSession.close();

		return vo;

	}
	
	public int insert(MemberVo vo) {
		int res = 0;
		//                                      true : auto commit 
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("member.member_insert",vo);
		
		sqlSession.close();
		
		return res;
	}

	public int delete(int idx) {
		int res = 0;
		//                                      true : auto commit 
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.delete("member.member_delete",idx);
		
		sqlSession.close();
		
		return res;
	}

	public int update(MemberVo vo) {
		int res = 0;
		//                                      true : auto commit 
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.delete("member.member_update",vo);
		
		sqlSession.close();
		
		return res;
	}
	
	
	
	
}
