package service;

import java.util.Map;

import vo.ProductVo;

public interface ProductService {

	Map selectList();
	int insert_in(ProductVo vo) throws Exception;//입고등록
	int insert_out(ProductVo vo) throws Exception;//출고등록
	
	int delete_in(int idx) throws Exception; //입고삭제
	int delete_out(int idx) throws Exception;//출고삭제
	
}
