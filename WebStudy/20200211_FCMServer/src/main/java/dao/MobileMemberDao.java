package dao;

import java.util.List;

import vo.MobileMemberVo;

public interface MobileMemberDao {
	
	List<MobileMemberVo> selectList();
	MobileMemberVo selectOne(String id);
	MobileMemberVo selectOne(int idx);
	int insert(MobileMemberVo vo);
	int update(MobileMemberVo vo);
	int update_device_token(MobileMemberVo vo);
	int delete(int idx);

}
