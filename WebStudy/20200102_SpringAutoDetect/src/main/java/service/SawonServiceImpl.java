package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SawonDao;
import vo.SawonVo;

@Service("sawon_service")
public class SawonServiceImpl implements SawonService {

	//자동엮기(연결:Injection)
	@Autowired
	SawonDao sawon_dao;
	
	public SawonServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("--SawonServiceImpl()--");
	}
	
	@Override
	public List<SawonVo> selectList() {
		// TODO Auto-generated method stub
		return sawon_dao.selectList();
	}

	@Override
	public List<SawonVo> selectList_Deptno(int deptno) {
		// TODO Auto-generated method stub
		return null;
	}

}
