package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ProductVo;

public class ProductDao {

	//Mybatis객체
	SqlSessionFactory factory;
	
	//Single-ton : 객체1개만 생성해서 서비스하자
	static ProductDao single = null;

	public static ProductDao getInstance() {
		if (single == null)
			single = new ProductDao();
		return single;
	}
	
	public ProductDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//카테고리별 목록조회
	public List<ProductVo> selectList(String category){
		
		List<ProductVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		//                            namepace.mapper_id   , parameter
		list = sqlSession.selectList("product.product_list", category);
		
		sqlSession.close();
				
		return list;
		
	}

	public ProductVo selectOne(int idx) {
		// TODO Auto-generated method stub
		ProductVo  vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("product.product_one", idx);
		
		sqlSession.close();
		
		return vo;
	}

	public int insert(ProductVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		// Mybatis : DML=> Transaction처리가 된다
		//           openSession(true) <= auto commit                             
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("product.product_insert", vo);
		
		//sqlSession.commit(); <= 위에서 auto commit되어있기 때문에 생략
		sqlSession.close();
		
		return res;
	}

	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		// Mybatis : DML=> Transaction처리가 된다
		//           openSession(true) <= auto commit                             
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.delete("product.product_delete", idx);
		
		sqlSession.close();
		
		return res;
	}

	public int update(ProductVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		// Mybatis : DML=> Transaction처리가 된다
		//           openSession(true) <= auto commit                             
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.update("product.product_update", vo);
		
		sqlSession.close();
		
		return res;
	}

	public int update_filename(ProductVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		// Mybatis : DML=> Transaction처리가 된다
		//           openSession(true) <= auto commit                             
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.update("product.product_update_filename", vo);
		
		sqlSession.close();
		
		return res;
	}
	
	
	
	
}
