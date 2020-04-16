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
	
	//�����ȸ
	@RequestMapping("/photo/list.do")
	public String list(Model model) {
		
		List<PhotoVo> list = photo_dao.selectList();
		//request binding
		model.addAttribute("list", list);
		return "photo/photo_list";
	}
	
	//�Է���
	@RequestMapping("/photo/insert_form.do")
	public String insert_form() {
		
		return "photo/photo_insert_form";
	}
	
	@RequestMapping("/photo/insert.do")
	public String insert(PhotoVo vo,
			             @RequestParam("photo") MultipartFile photo) throws Exception {
		
		String web_path = "/resources/upload/";
		//�����->������ 
		String abs_path = application.getRealPath(web_path);
		//System.out.println(abs_path);
		String filename = "no_file";
		
		//���ε�� ȭ���� ������
		if(photo.isEmpty()==false) {
			//���ε�� ȭ�ϸ�
			filename = photo.getOriginalFilename();
			
			File f = new File(abs_path, filename);
			
			//����ȭ���� �ִ��� �˻�
			if(f.exists()) {
				//���� �ý��� �ð�(milisecond)
				long t = System.currentTimeMillis();
	            //                  123456789_a.jpg      			
				filename = String.format("%d_%s", t,filename);
				f = new File(abs_path, filename);
			}
			
			//�ӽþ��ε� ȭ�� -> ������ ��ġ�� ����
			photo.transferTo(f);
			
		}
		
		//DB����� \r\n => <br>
		//String content = vo.getP_content().replaceAll("\n", "<br>")
		//		                          .replaceAll("\r", "");
		//vo.setP_content(content);
		
		
		//ȭ�ϸ�..
		vo.setP_filename(filename);
		
		//ip
		String ip = request.getRemoteAddr();
		vo.setP_ip(ip);
		
		
		//����� idx
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
		
		
		//JSON Data������������ ���� �߻�
		//���۵�������  " , \n , \r�� ������ ���ԵǾ�������� ó��
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
	
	//����
	@RequestMapping("/photo/delete.do")
	public String delete(int p_idx) {
		
		//ȭ�ϻ����� ���ؼ� �ش�Խù����� 1�� ���
        PhotoVo  vo = photo_dao.selectOne(p_idx);
        
        //������ ���ϱ�
        String web_path="/resources/upload/";
        //�������->������ ���ϱ�
        String abs_path=application.getRealPath(web_path);
		
		//ȭ�ϻ���
		File  f = new File(abs_path, vo.getP_filename());
		f.delete();
		
		//DB delete
		int res = photo_dao.delete(p_idx);
		
		
		return "redirect:list.do";
	}
	
	
	
	
	
	
	
}
