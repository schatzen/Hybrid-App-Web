package com.tj.fcmtest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import myutil.FCMUtil;

@Controller
public class FCMController {

	@Autowired
	ServletContext application;

	
	List<String> token_list = new ArrayList<String>();
	
	//http://localhost:9090/fcmtest/send_token.do?token=ssdfsdfsdf
	@RequestMapping(value = "/send_token.do")
	@ResponseBody
	public String send_token(String token) {
		
		System.out.println(token);
		
		if(!token_list.contains(token))
			token_list.add(token);
				
		
		return "success";
	}
		

	@RequestMapping(value = "/send_fcm_all.do")
	@ResponseBody
	public String send_fcm_all(String title,String content) throws Exception {
	      
			//console.firebase.google.com에서 받은 JSON화일
			String tokenPath = application.getRealPath("resources/google/myfcmproject-aedd7-firebase-adminsdk-dim1b-483db85433.json"); 

			//Android폰에서 받는 토큰값
	        //String tokenId="c2VSFkXz0dQ:APA91bFJrgShUbYHY87yXRY7pgNtIeXRMW7rhoueCPpsOgsm4QTJmrK7tRmQKoCUP-fZAG8xBLUNXQJrhMo3EFqJ8EgRNi0xMRW5_zXAG1bojGfIx3Ayhvqy0EURPAI5Rq4hkFvedFAJ";
	        
	        
	        //String title="Hi~~";
	        //String content="잘 지내고 있냐!!!!";
	      
	        FCMUtil fcmUtil = new FCMUtil();
	        
	        fcmUtil.send_all_FCM(tokenPath,token_list, title, content);
	      
	        return "success";
	}


    //http://localhost:9090/fcmtest/send_fcm.do?title=test&content=hi~
	@RequestMapping(value = "/send_fcm.do")
	@ResponseBody
	public String send_fcm(String title,String content) throws Exception {
	      
			//console.firebase.google.com에서 받은 JSON화일
			String tokenPath = application.getRealPath("resources/google/myfcmproject-aedd7-firebase-adminsdk-dim1b-483db85433.json"); 

			//Android폰에서 받는 토큰값
	        String tokenId="c2VSFkXz0dQ:APA91bFJrgShUbYHY87yXRY7pgNtIeXRMW7rhoueCPpsOgsm4QTJmrK7tRmQKoCUP-fZAG8xBLUNXQJrhMo3EFqJ8EgRNi0xMRW5_zXAG1bojGfIx3Ayhvqy0EURPAI5Rq4hkFvedFAJ";
	        
	        
	        //String title="Hi~~";
	        //String content="잘 지내고 있냐!!!!";
	      
	        FCMUtil fcmUtil = new FCMUtil();
	        
	        fcmUtil.send_FCM(tokenPath,tokenId, title, content);
	      
	        return "success";
	}
}
