package com.tj.fileupload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVo;
import vo.PhotoVo2;

@Controller
public class FileUploadController {

	
	//�ڵ�����(DispatcherServlet�� �ڵ�����)
	@Autowired
	ServletContext application;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	
	//�Է��� ����
	@RequestMapping("/insert_form.do")
	public String insert_form() {
		
		return "insert_form";
	}
	
	//�Է���2 ����
	@RequestMapping("/insert_form2.do")
	public String insert_form2() {
		
		return "insert_form2";
	}
	
	
	
	//������ �ޱ�
	//  upload1.do?title=����&photo=aa.jpg
	@RequestMapping("/upload1.do")
	public String upload1(String title,
			              @RequestParam("photo") MultipartFile photo,
			              Model model) throws Exception{
		String web_path = "/resources/upload/";
		//�����->������ 
		String abs_path = application.getRealPath(web_path);
		System.out.println(abs_path);
		
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
		
		//����� : request binding
		model.addAttribute("title", title);
		model.addAttribute("filename", filename);
		
		
		return "result_upload1";
	}
	
	//��ü�� �ޱ�
	//��ü���� �Ӽ����� parameter��� �����ؾߵȴ�
    //  upload2.do?title=����&photo=aa.jpg
	@RequestMapping("/upload2.do")
	public String upload2(PhotoVo vo,Model model) throws Exception{
		String web_path = "/resources/upload/";
		//�����->������ 
		String abs_path = application.getRealPath(web_path);
		//System.out.println(abs_path);
		
		String filename = "no_file";
		
		//���ε�� ȭ���� ������
		MultipartFile photo = vo.getPhoto();
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
			
			vo.setFilename(filename);
			
		}
		
		//����� : request binding
		model.addAttribute("vo", vo);
		
		return "result_upload2";
	}

	
	//������ �ޱ�
	//  upload1.do?title=����&photo=a.jpg&photo=b.jpg
	@RequestMapping("/upload3.do")
	public String upload3(String title,
			              @RequestParam("photo") MultipartFile [] photo_array,
			              Model model) throws Exception{
		String web_path = "/resources/upload/";
		//�����->������ 
		String abs_path = application.getRealPath(web_path);
		System.out.println(abs_path);
		
		String filename1 = "no_file";
		String filename2 = "no_file";
		
		//for(MultipartFile photo : photo_array) {
		for(int i=0;i<photo_array.length;i++) {
			MultipartFile photo = photo_array[i];
			String filename="";
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
			
			if(i==0)
				filename1 = filename;
			else if(i==1)
				filename2 = filename;
		}
		
		
		
		//����� : request binding
		model.addAttribute("title", title);
		model.addAttribute("filename1", filename1);
		model.addAttribute("filename2", filename2);
		
		
		return "result_upload3";
	}
	
	
	@RequestMapping("/upload4.do")
	public String upload4(PhotoVo2 vo,Model model) throws Exception{
		String web_path = "/resources/upload/";
		//�����->������ 
		String abs_path = application.getRealPath(web_path);
		//System.out.println(abs_path);
		
		String filename = "no_file";
		//���ε�� ȭ���� ������
		MultipartFile [] photo_array = vo.getPhoto();
		
		for(int i=0;i<photo_array.length;i++) {
			MultipartFile photo = photo_array[i];
			
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
				if(i==0)
				    vo.setFilename1(filename);
				else
					vo.setFilename2(filename);
				
			}
		}
		
		//����� : request binding
		model.addAttribute("vo", vo);
		
		return "result_upload4";
	}
	
	
}
