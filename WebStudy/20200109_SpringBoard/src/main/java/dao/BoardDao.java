package dao;

import java.util.List;
import java.util.Map;

import vo.BoardVo;

public interface BoardDao {

	List<BoardVo> selectList();
	List<BoardVo> selectList(Map map);
	BoardVo selectOne(int idx);
	
	int selectRowTotal(Map map);
	
	
	int  insert(BoardVo vo);
	int  update(BoardVo vo);
	int  delete(int idx);
	int  reply(BoardVo vo);
	
	
	//��ȸ������
	int  update_readhit(int idx);
	
	//step����
	int  update_step(BoardVo vo);
	
}
