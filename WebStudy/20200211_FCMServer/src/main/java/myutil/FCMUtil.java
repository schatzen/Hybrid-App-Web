package myutil;

import java.io.FileInputStream;
import java.util.List;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.BatchResponse;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.MulticastMessage;


public class FCMUtil {
    public static void send_FCM(
    		String tokenPath,
    		String tokenId, 
    		String title, 
    		String content) {
        try {    
            //������ json ���� ��� �Է�
            FileInputStream refreshToken = new FileInputStream(tokenPath);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
                    .setDatabaseUrl("https://myfcmproject-aedd7.firebaseio.com")
                    .build();
            
            //Firebase ó�� ȣ��ÿ��� initializing ó��
            if(FirebaseApp.getApps().isEmpty()) { 
                FirebaseApp.initializeApp(options);
            }
            
            //String registrationToken = �ȵ���̵� ��ū �Է�;
            String registrationToken = tokenId;

            //message �ۼ�
            Message msg = Message.builder()
                        .setAndroidConfig(
                        		AndroidConfig.builder()
                                             .setTtl(3600 * 1000) // 1 hour in milliseconds
                                             .setPriority(AndroidConfig.Priority.NORMAL)
                                             .setNotification(AndroidNotification.builder()
                                             .setTitle(title)
                                             .setBody(content)
                                             .setIcon("stock_ticker_update")
                                             .setColor("#f45342")
                                             .build()
                                          ).build())
                        .setToken(registrationToken)
                        .build();

            //�޼����� FirebaseMessaging �� ������
            String response = FirebaseMessaging.getInstance().send(msg);
            //��� ���
            System.out.println("Successfully sent message: " + response);
                 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void send_all_FCM(
    		String tokenPath,
    		List <String> token_list, 
    		String title, 
    		String content) {
    	
    	     
        try {    
            //������ json ���� ��� �Է�
            FileInputStream refreshToken = new FileInputStream(tokenPath);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
                    .setDatabaseUrl("https://myfcmproject-aedd7.firebaseio.com")
                    .build();
            
            //Firebase ó�� ȣ��ÿ��� initializing ó��
            if(FirebaseApp.getApps().isEmpty()) { 
                FirebaseApp.initializeApp(options);
            }
            
            //String registrationToken = �ȵ���̵� ��ū �Է�;
	
            MulticastMessage message = MulticastMessage.builder()
            		.setAndroidConfig(AndroidConfig.builder()
	                                             .setTtl(3600 * 1000) // 1 hour in milliseconds
	                                             .setPriority(AndroidConfig.Priority.NORMAL)
	                                             .setNotification(AndroidNotification.builder()
	                                             .setTitle(title)
	                                             .setBody(content)
	                                             .setIcon("stock_ticker_update")
	                                             .setColor("#f45342")
	                                             .build()
	                                          ).build())
            	    .addAllTokens(token_list)
            	    .build();
	        //�޼����� FirebaseMessaging �� ������
	        //String response = FirebaseMessaging.getInstance().sendMulticast(msg);
	        BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
	        //��� ���
	        System.out.println("Successfully sent message: " + response);
          
                 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}