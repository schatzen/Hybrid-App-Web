package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ProductDao;
import dao.Product_Remain_DaoImpl;
import vo.ProductVo;

public class ProductServiceImpl implements ProductService{

	ProductDao product_dao_in;
	ProductDao product_dao_out;
	ProductDao product_dao_remain;
	
	
	public void setProduct_dao_in(ProductDao product_dao_in) {
		this.product_dao_in = product_dao_in;
	}

	public void setProduct_dao_out(ProductDao product_dao_out) {
		this.product_dao_out = product_dao_out;
	}

	public void setProduct_dao_remain(ProductDao product_dao_remain) {
		this.product_dao_remain = product_dao_remain;
	}

	@Override
	public Map selectList() {
		// TODO Auto-generated method stub
		
		List in_list  		= product_dao_in.list();//입고목록
		List out_list 		= product_dao_out.list();//출고목록
		List remain_list 	= product_dao_remain.list();//재고목록
		
		Map map = new HashMap();
		
		map.put("in_list", in_list);
		map.put("out_list", out_list);
		map.put("remain_list", remain_list);
		
		return map;
	}

	@Override
	public int insert_in(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		int res = 0;
		//입고등록
		res = product_dao_in.insert(vo);
		
		//재고처리
		
		//재고목록에 현재 입고된 상품이 있냐?
		ProductVo remainVo = product_dao_remain.selectOne(vo.getName());
		if(remainVo==null) {
			//입고목록에 없으면 새로 등록
			res = res * product_dao_remain.insert(vo);
			
		}else {//있으면 수정
			//재고수량     = 재고수량          + 입고수량
			int remain_cnt = remainVo.getCnt() + vo.getCnt();
			remainVo.setCnt(remain_cnt);
			
			res = res * product_dao_remain.update(remainVo);
		}
		
		return res;
	}

	@Override
	public int insert_out(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		int res = 0;
		//출고등록
		res = product_dao_out.insert(vo);
		
		//재고처리
		//재고목록에 현재 출고할 상품이 있냐?
		ProductVo remainVo = product_dao_remain.selectOne(vo.getName());
		if(remainVo==null) {
			//출고할 상품이 없는경우
			throw new Exception("remain_not");
		}
		
		// 출고수량 > 재고수량
		if(vo.getCnt()> remainVo.getCnt()) {
			throw new Exception("remain_lack");
		}
		
		//정상처리 : 재고수량 = 재고수량 - 출고수량
		int remain_cnt = remainVo.getCnt() - vo.getCnt();
		remainVo.setCnt(remain_cnt);
		
		res = product_dao_remain.update(remainVo);
		
		
		return res;
	}

	@Override
	public int delete_in(int idx) throws Exception {
		// TODO Auto-generated method stub
		//입고취소할 상품정보얻기
		ProductVo  vo = product_dao_in.selectOne(idx);
		//입고취소
		int res = product_dao_in.delete(idx);
		
		ProductVo remainVo = product_dao_remain.selectOne(vo.getName());
		
		int remain_cnt = remainVo.getCnt() - vo.getCnt();
		remainVo.setCnt(remain_cnt);
		
		res = product_dao_remain.update(remainVo);
		
		return res;
	}

	@Override
	public int delete_out(int idx) throws Exception {
		// TODO Auto-generated method stub
		//출고취소할 상품정보얻기
		ProductVo  vo = product_dao_out.selectOne(idx);
		//출고취소
		int res = product_dao_out.delete(idx);
		
		ProductVo remainVo = product_dao_remain.selectOne(vo.getName());
			
		int remain_cnt = remainVo.getCnt() + vo.getCnt();
		remainVo.setCnt(remain_cnt);
		
		res = product_dao_remain.update(remainVo);
				
		return 0;
	}

}
