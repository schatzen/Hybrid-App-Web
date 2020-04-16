package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ProductVo;

public class Product_Out_DaoImpl implements ProductDao{

	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ProductVo> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product_out.product_list");
	}

	@Override
	public int insert(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("product_out.product_insert", vo);
	}

	@Override
	public int update(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("product_out.product_update", vo);
	}

	@Override
	public int delete(int idx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("product_out.product_delete", idx);
	}
	
	@Override
	public ProductVo selectOne(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("product_out.product_one_idx",idx);
	}

	@Override
	public ProductVo selectOne(String name) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("product_out.product_one_name",name);
	}

}
