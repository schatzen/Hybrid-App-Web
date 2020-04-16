package util;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import vo.BookVo;

public class NaverSearchUtil {

	static String clientId     = "B6P5_6lUk9ZoZlmT93CT";
	static String clientSecret = "8jHC8rFrhH";

	
	
	public static List<BookVo> search_book(String book_name,int start,int display) throws Exception{
		
		List<BookVo> list = new ArrayList<BookVo>();
		
		//Naver에 전송할 도서명(한글/특수문자)을 인코딩해서 요청
		book_name = URLEncoder.encode(book_name, "utf-8");
		
		
		String urlStr = 
				String.format("https://openapi.naver.com/v1/search/book.xml?"
						    + "query=%s&start=%d&display=%d", 
						           book_name,start,display
						);

		URL url = new URL(urlStr);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		//발급받은 ID
		connection.setRequestProperty("X-Naver-Client-Id", clientId); 
		//발급받은 PW
		connection.setRequestProperty("X-Naver-Client-Secret", clientSecret); 
		// 받을요청타입
		connection.setRequestProperty("Content-Type", "application/xml"); 
		connection.connect();

			
		SAXBuilder builder = new SAXBuilder();
		Document   doc = builder.build (connection.getInputStream());

		Element  root = doc.getRootElement();
		List<Element>     book_list = root.getChild("channel").getChildren("item");

		for(Element item : book_list){
			
			String title 	= item.getChildText("title");
			//System.out.println(title);
			String link  	= item.getChildText("link");
			String image 	= item.getChildText("image");
			String author	= item.getChildText("author");
			String publisher= item.getChildText("publisher");
			String pubdate 	= item.getChildText("pubdate");
			String description = item.getChildText("description");
			
			int price = 0;
			int discount = 0;
			
			try {
				price = Integer.parseInt(item.getChildText("price"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				discount = Integer.parseInt(item.getChildText("discount"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			BookVo vo = new BookVo(title, link, image, author, price, discount, publisher, pubdate, description);
			
			list.add(vo);
			
		}
		return list;
	}
}



