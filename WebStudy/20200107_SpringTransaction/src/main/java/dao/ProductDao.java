package dao;

import java.util.List;

import vo.ProductVo;

public interface ProductDao {

	List<ProductVo> list();
	
	ProductVo selectOne(int idx);
	ProductVo selectOne(String name);
		
	int insert(ProductVo vo) throws Exception;
	int update(ProductVo vo) throws Exception;
	int delete(int idx) throws Exception;
}

