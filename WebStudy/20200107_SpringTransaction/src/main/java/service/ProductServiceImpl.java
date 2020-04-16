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
		
		List in_list  		= product_dao_in.list();//�԰���
		List out_list 		= product_dao_out.list();//�����
		List remain_list 	= product_dao_remain.list();//�����
		
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
		//�԰���
		res = product_dao_in.insert(vo);
		
		//���ó��
		
		//����Ͽ� ���� �԰�� ��ǰ�� �ֳ�?
		ProductVo remainVo = product_dao_remain.selectOne(vo.getName());
		if(remainVo==null) {
			//�԰��Ͽ� ������ ���� ���
			res = res * product_dao_remain.insert(vo);
			
		}else {//������ ����
			//������     = ������          + �԰����
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
		//�����
		res = product_dao_out.insert(vo);
		
		//���ó��
		//����Ͽ� ���� ����� ��ǰ�� �ֳ�?
		ProductVo remainVo = product_dao_remain.selectOne(vo.getName());
		if(remainVo==null) {
			//����� ��ǰ�� ���°��
			throw new Exception("remain_not");
		}
		
		// ������ > ������
		if(vo.getCnt()> remainVo.getCnt()) {
			throw new Exception("remain_lack");
		}
		
		//����ó�� : ������ = ������ - ������
		int remain_cnt = remainVo.getCnt() - vo.getCnt();
		remainVo.setCnt(remain_cnt);
		
		res = product_dao_remain.update(remainVo);
		
		
		return res;
	}

	@Override
	public int delete_in(int idx) throws Exception {
		// TODO Auto-generated method stub
		//�԰������ ��ǰ�������
		ProductVo  vo = product_dao_in.selectOne(idx);
		//�԰����
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
		//�������� ��ǰ�������
		ProductVo  vo = product_dao_out.selectOne(idx);
		//������
		int res = product_dao_out.delete(idx);
		
		ProductVo remainVo = product_dao_remain.selectOne(vo.getName());
			
		int remain_cnt = remainVo.getCnt() + vo.getCnt();
		remainVo.setCnt(remain_cnt);
		
		res = product_dao_remain.update(remainVo);
				
		return 0;
	}

}
