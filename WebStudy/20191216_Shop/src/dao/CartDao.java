package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CartVo;

public class CartDao {

	SqlSessionFactory factory;
		
	//Single-ton : 객체1개만 생성해서 서비스하자
	static CartDao single = null;

	public static CartDao getInstance() {
		if (single == null)
			single = new CartDao();
		return single;
	}
	
	public CartDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//장바구니 조회
	public List<CartVo> selectList(int m_idx){
		List<CartVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		//                            mapper선언 
		list = sqlSession.selectList("cart.cart_list",m_idx);
		
		sqlSession.close();
				
		return list;
	}
	
	//유저별 장바구니 총계
	public int selectAmountTotal(int m_idx) {
		int total_amount = 0;
		
		SqlSession sqlSession = factory.openSession();
		//                             
		total_amount = sqlSession.selectOne("cart.cart_total_amount",m_idx);
		
		sqlSession.close();
		
		
		return total_amount;
	}

	public int update(CartVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		//                                   true: auto commit
		SqlSession sqlSession = factory.openSession(true);
		//                             
		res = sqlSession.update("cart.cart_update",vo);
		
		sqlSession.close();
				
		return res;
	}

	public int delete(int c_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		//                                   true: auto commit
		SqlSession sqlSession = factory.openSession(true);
		//                             
		res = sqlSession.update("cart.cart_delete",c_idx);
		
		sqlSession.close();
				
		return res;
	}

	public CartVo selectOne(CartVo vo) {
		// TODO Auto-generated method stub
		
		CartVo resVo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		resVo = sqlSession.selectOne("cart.cart_one", vo);
		
		sqlSession.close();
				
		return resVo;
	}

	public int insert(CartVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		//                                   true: auto commit
		SqlSession sqlSession = factory.openSession(true);
		//                             
		res = sqlSession.insert("cart.cart_insert",vo);
		
		sqlSession.close();
				
		return res;
	}
	
	
	
	
}
