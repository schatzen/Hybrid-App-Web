package com.tj.fcmtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MobileMemberDao;
import myutil.FCMUtil;
import vo.MobileMemberVo;

@Controller
public class FCMRestfulController {

	
	@Autowired
	ServletContext application;
	
	
	MobileMemberDao  mobile_member_dao;

	public void setMobile_member_dao(MobileMemberDao mobile_member_dao) {
		this.mobile_member_dao = mobile_member_dao;
	}
	
	//전체조회(서버용)
	@RequestMapping(value="/mobile_member/list.do",method=RequestMethod.GET)
	public String selectList(Model model) {
		
		List<MobileMemberVo> list = mobile_member_dao.selectList();
		
		//request binding
		model.addAttribute("list", list);
		
		
		return "mobile_member/mobile_member_list";
	}
	
	//선택된 모바일기기에 메시지 전송
	@RequestMapping("/mobile_member/send_message.do")
	public String send_message(
			String title,
			String content,
			@RequestParam("idx")  int [] idx_array) {
		
		String tokenPath = application.getRealPath("resources/google/myfcmproject-aedd7-firebase-adminsdk-dim1b-483db85433.json");
		List<String> token_list = new ArrayList<String>();
		
		//for(int i=0;i<idx_array.length;i++) {
		for(int idx : idx_array) {
			MobileMemberVo vo = mobile_member_dao.selectOne(idx);
			if(vo.getDevice_token()!=null && !vo.getDevice_token().isEmpty())
			  token_list.add(vo.getDevice_token());
		}
		
		//FCM 전송
		FCMUtil.send_all_FCM(tokenPath, token_list, title, content);
			
		
		
		
		return "redirect:list.do";
	}
	
	
	
	//전체조회(Mobile용)
	//  url = http://localhost:9090/fcmtest/mobile_members
	//  uri =                      /fcmtest/mobile_members
	@RequestMapping(value="/mobile_members",method=RequestMethod.GET)
	@ResponseBody
	public Map selectList(){
		
		List<MobileMemberVo> list = mobile_member_dao.selectList();
		Map map = new HashMap();
		map.put("list", list);
		
		return map;
	}
	
	// 요청URI :  /fcmtest/mobile_member/id/one
	@RequestMapping(value="/mobile_member/id/{id}",method=RequestMethod.GET)
	@ResponseBody
	public MobileMemberVo selectOne(@PathVariable("id") String id){
		
		MobileMemberVo vo = mobile_member_dao.selectOne(id);
		
		if(vo==null)
			vo = new MobileMemberVo();
		
		return vo;
	}
	
	// 요청URI :  /fcmtest/mobile_member/idx/1
	@RequestMapping(value="/mobile_member/idx/{idx}",method=RequestMethod.GET)
	@ResponseBody
	public MobileMemberVo selectOne(@PathVariable("idx") int idx){
		
		MobileMemberVo vo = mobile_member_dao.selectOne(idx);
		
		if(vo==null)
			vo = new MobileMemberVo();
		
		return vo;
	}
	
	
	// 추가(POST)
	// 요청URI :  /fcmtest/mobile_member
	@RequestMapping(value="/mobile_member",method=RequestMethod.POST)
	@ResponseBody
	public Map insert(@RequestBody  MobileMemberVo vo){
		
		Map map  = new HashMap();
		
		//중복 id 체크
		MobileMemberVo user = mobile_member_dao.selectOne(vo.getId());
		
		if(user!=null) {//id가 사용중
			map.put("result", 0);
			map.put("reason", "use_id");
			return map;
		}
		
		
		int res = mobile_member_dao.insert(vo);
		
		map.put("result", res);
		
		return map;
	}
	
	
	// 수정(PUT)
	// 요청URI :  /fcmtest/mobile_member/device_token
	@RequestMapping(value="/mobile_member/device_token",
			        method=RequestMethod.PUT)
	@ResponseBody
	public Map update_device_token(@RequestBody  MobileMemberVo vo){
		
		int res = mobile_member_dao.update_device_token(vo);
		
		Map map  = new HashMap();
		map.put("result", res);
		
		return map;
	}
	
	// 삭제(DELETE)
	@RequestMapping(value="/mobile_member/{idx}",
			        method=RequestMethod.DELETE)
	@ResponseBody
	public Map delete(@PathVariable("idx") int idx){
	
		int res = mobile_member_dao.delete(idx);
		
		Map map  = new HashMap();
		map.put("result", res);
		
		return map;
	}
	
	
}
