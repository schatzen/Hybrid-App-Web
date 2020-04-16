package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ProductVo;

public class ProductDao {

	//Mybatis��ü
	SqlSessionFactory factory;
	
	//Single-ton : ��ü1���� �����ؼ� ��������
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
	
	//ī�װ��� �����ȸ
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
		
		// Mybatis : DML=> Transactionó���� �ȴ�
		//           openSession(true) <= auto commit                             
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("product.product_insert", vo);
		
		//sqlSession.commit(); <= ������ auto commit�Ǿ��ֱ� ������ ����
		sqlSession.close();
		
		return res;
	}

	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		// Mybatis : DML=> Transactionó���� �ȴ�
		//           openSession(true) <= auto commit                             
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.delete("product.product_delete", idx);
		
		sqlSession.close();
		
		return res;
	}

	public int update(ProductVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		// Mybatis : DML=> Transactionó���� �ȴ�
		//           openSession(true) <= auto commit                             
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.update("product.product_update", vo);
		
		sqlSession.close();
		
		return res;
	}

	public int update_filename(ProductVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		// Mybatis : DML=> Transactionó���� �ȴ�
		//           openSession(true) <= auto commit                             
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.update("product.product_update_filename", vo);
		
		sqlSession.close();
		
		return res;
	}
	
	
	
	
}
