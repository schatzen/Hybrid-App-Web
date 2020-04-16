package com.tj.gallery;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.PhotoDao;
import vo.MemberVo;
import vo.PhotoVo;

@Controller
public class PhotoController {

	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ServletContext application;
	
	
	
	PhotoDao photo_dao;

	public void setPhoto_dao(PhotoDao photo_dao) {
		this.photo_dao = photo_dao;
	}
	
	//목록조회
	@RequestMapping("/photo/list.do")
	public String list(Model model) {
		
		List<PhotoVo> list = photo_dao.selectList();
		//request binding
		model.addAttribute("list", list);
		return "photo/photo_list";
	}
	
	//입력폼
	@RequestMapping("/photo/insert_form.do")
	public String insert_form() {
		
		return "photo/photo_insert_form";
	}
	
	@RequestMapping("/photo/insert.do")
	public String insert(PhotoVo vo,
			             @RequestParam("photo") MultipartFile photo) throws Exception {
		
		String web_path = "/resources/upload/";
		//상대경로->절대경로 
		String abs_path = application.getRealPath(web_path);
		//System.out.println(abs_path);
		String filename = "no_file";
		
		//업로드된 화일이 있으면
		if(photo.isEmpty()==false) {
			//업로드된 화일명
			filename = photo.getOriginalFilename();
			
			File f = new File(abs_path, filename);
			
			//동일화일이 있는지 검사
			if(f.exists()) {
				//현재 시스템 시간(milisecond)
				long t = System.currentTimeMillis();
	            //                  123456789_a.jpg      			
				filename = String.format("%d_%s", t,filename);
				f = new File(abs_path, filename);
			}
			
			//임시업로된 화일 -> 지정된 위치로 복사
			photo.transferTo(f);
			
		}
		
		//DB저장시 \r\n => <br>
		//String content = vo.getP_content().replaceAll("\n", "<br>")
		//		                          .replaceAll("\r", "");
		//vo.setP_content(content);
		
		
		//화일명..
		vo.setP_filename(filename);
		
		//ip
		String ip = request.getRemoteAddr();
		vo.setP_ip(ip);
		
		
		//사용자 idx
		MemberVo user = (MemberVo)session.getAttribute("user");
		int m_idx = user.getIdx();
		vo.setM_idx(m_idx);

		
		int res = photo_dao.insert(vo);
		
		return "redirect:list.do";
	}
	
	
	@RequestMapping(value="/photo/photo_one.do",produces="text/plain;charset=utf-8;")
	@ResponseBody
	public String photo_one(int p_idx) {
		
		PhotoVo vo = photo_dao.selectOne(p_idx);
		
		
		//JSON Data생성과정에서 문제 발생
		//전송데이터중  " , \n , \r의 내용이 포함되어있을경우 처리
		String p_subject = vo.getP_subject().replaceAll("\"", "\'");
		String p_content = vo.getP_content().replaceAll("\"", "\'")
				                            .replaceAll("\n","")
				                            .replaceAll("\r","");
		
				
		/*
		 * if(p_content.contains("\n")) System.out.println("--Enter--");
		 * if(p_content.contains("\r")) System.out.println("--Carrige Return--");
		 */
		
		String jsonStr = 
				String.format("{\"p_subject\":\"%s\",\"p_content\":\"%s\",\"p_filename\":\"%s\" }", 
				                       p_subject,
				                       p_content,
				                       vo.getP_filename()
				);
		
		//jsonStr = jsonStr.replaceAll("\r", "");
		//System.out.println(jsonStr);
		
		return jsonStr;
	}
	
	//삭제
	@RequestMapping("/photo/delete.do")
	public String delete(int p_idx) {
		
		//화일삭제를 위해서 해당게시물정보 1건 얻기
        PhotoVo  vo = photo_dao.selectOne(p_idx);
        
        //절대경로 구하기
        String web_path="/resources/upload/";
        //웹상대경로->절대경로 구하기
        String abs_path=application.getRealPath(web_path);
		
		//화일삭제
		File  f = new File(abs_path, vo.getP_filename());
		f.delete();
		
		//DB delete
		int res = photo_dao.delete(p_idx);
		
		
		return "redirect:list.do";
	}
	
	
	
	
	
	
	
}
