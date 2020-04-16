package com.tj.bbs;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CKEditorImageUploadController {

	@Autowired
	ServletContext application;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value="/ckeditorImageUpload.do",
			        produces="text/json; charset=utf-8;")
	@ResponseBody
	public String upload(@RequestParam("upload")  MultipartFile upload) throws Exception {
		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);
		
		String fileName = "";
		if(upload.isEmpty()==false) {
			fileName = upload.getOriginalFilename();
			
			File f = new File(abs_path,fileName);
			//����ȭ���� �ִ°��
			if(f.exists()) {
				long t = System.currentTimeMillis();
				fileName = String.format("%d_%s", t,fileName);
				
				f = new File(abs_path,fileName);
			}
			upload.transferTo(f);
		}
		
		
		//��������� ����
		 String url = request.getRequestURL().toString().replaceAll("/ckeditorImageUpload.do", "");
         //System.out.println(url);
         
         String fileUrl = url + web_path + fileName;//url���
         String sendData = String.format("{\"filename\" : \"%s\", \"uploaded\" : 1, \"url\":\"%s\"}", 
         		                                         fileName,       fileUrl
         		);
		
		return sendData;
	}
	
	
	
	
}
