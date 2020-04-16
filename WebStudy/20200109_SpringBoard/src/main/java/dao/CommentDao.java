package dao;

import java.util.List;
import java.util.Map;

import vo.CommentVo;

public interface CommentDao {

	List<CommentVo> selectList(int b_idx);
	List<CommentVo> selectList(Map map);
	
	int selectRowTotal(int b_idx);
	
	
	int  insert(CommentVo vo);
	int  delete(int idx);
	//�Խù��� �޸� ��� ����
	int  delete_all(int b_idx);
	int  update(CommentVo vo);
		
}
