package service;

import java.util.List;

import vo.SawonVo;

public interface SawonService {

	List<SawonVo> selectList();
	List<SawonVo> selectList_Deptno(int deptno);
}
