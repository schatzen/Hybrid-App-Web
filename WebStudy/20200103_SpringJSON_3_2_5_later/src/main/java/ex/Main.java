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
    
 
        /** Json문자열 -> Map */
        String jsonStr = "{ \"name\" : \"민\" , \"age\" : 28 }";
        Map<String, Object > map = new HashMap<String, Object>();
        map = obm.readValue(jsonStr, new TypeReference<Map<String, Object>>()  {});
        System.out.println("jsonString -> map : " + map);
        System.out.println("------------------------------------------------");
        
        /**Map -> Json문자열 */
        Map<String ,Object> map2 = new HashMap<String, Object>();
        map2.put("name", "미니미니");
        map2.put("age", 100 );
        String jsonStr2 = obm.writerWithDefaultPrettyPrinter().writeValueAsString(map2);
        System.out.println("map -> jsonString : " + jsonStr2);
        System.out.println("------------------------------------------------");
 
        
        /** json문자열 -> javaObject */
        User user = obm.readValue(jsonStr, User.class);
        
        /**javaObject -> json문자열 */
        User user1 = new User();
        user1.setName("식빵");
        user1.setAge(3);
        
        String user1Str =  obm.writeValueAsString(user1);
        System.out.println(user1Str);
        System.out.println("------------------------------------------------");
        
        /**List<Object> -> Json문자열 */
        List<User> userList = new ArrayList<User>();
        
        User u1 = new User();
        u1.setName("dodo");
        u1.setAge(38);
        userList.add(u1);
        
        User u2 = new User();
        u2.setName("동길");
        u2.setAge(20);
        userList.add(u2);
        
        User u3 = new User();
        u3.setName("통통");
        u3.setAge(10);
        userList.add(u3);
        
        String userListStr = obm.writeValueAsString(userList);        
        System.out.println(userListStr);
        System.out.println("------------------------------------------------");
        /** JsonList문자열 -> List<Object> */
        List<User> userList2 = obm.readValue(userListStr, new TypeReference<List<User>>(){});
 
                
    }
    
}//CLASS END
