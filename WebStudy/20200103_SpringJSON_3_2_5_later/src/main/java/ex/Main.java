package ex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

class User{
	String name;
	int    age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}

public class Main 
{
 
    public static void main(String[] args) throws IOException
    {
        ObjectMapper obm  = new ObjectMapper();
    
 
        /** Json���ڿ� -> Map */
        String jsonStr = "{ \"name\" : \"��\" , \"age\" : 28 }";
        Map<String, Object > map = new HashMap<String, Object>();
        map = obm.readValue(jsonStr, new TypeReference<Map<String, Object>>()  {});
        System.out.println("jsonString -> map : " + map);
        System.out.println("------------------------------------------------");
        
        /**Map -> Json���ڿ� */
        Map<String ,Object> map2 = new HashMap<String, Object>();
        map2.put("name", "�̴Ϲ̴�");
        map2.put("age", 100 );
        String jsonStr2 = obm.writerWithDefaultPrettyPrinter().writeValueAsString(map2);
        System.out.println("map -> jsonString : " + jsonStr2);
        System.out.println("------------------------------------------------");
 
        
        /** json���ڿ� -> javaObject */
        User user = obm.readValue(jsonStr, User.class);
        
        /**javaObject -> json���ڿ� */
        User user1 = new User();
        user1.setName("�Ļ�");
        user1.setAge(3);
        
        String user1Str =  obm.writeValueAsString(user1);
        System.out.println(user1Str);
        System.out.println("------------------------------------------------");
        
        /**List<Object> -> Json���ڿ� */
        List<User> userList = new ArrayList<User>();
        
        User u1 = new User();
        u1.setName("dodo");
        u1.setAge(38);
        userList.add(u1);
        
        User u2 = new User();
        u2.setName("����");
        u2.setAge(20);
        userList.add(u2);
        
        User u3 = new User();
        u3.setName("����");
        u3.setAge(10);
        userList.add(u3);
        
        String userListStr = obm.writeValueAsString(userList);        
        System.out.println(userListStr);
        System.out.println("------------------------------------------------");
        /** JsonList���ڿ� -> List<Object> */
        List<User> userList2 = obm.readValue(userListStr, new TypeReference<List<User>>(){});
 
                
    }
    
}//CLASS END
