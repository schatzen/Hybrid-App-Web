package action;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import vo.PersonVo;

/**
 * Servlet implementation class PersonXmlParserAction
 */
@WebServlet("/list.do")
public class PersonXmlParserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<PersonVo> list = new ArrayList<PersonVo>();
		
		try {
			//XML Parser: SAXBuilder
			SAXBuilder builder = new SAXBuilder();
			URL url = new URL("http://192.168.0.20:9090/20191210_XmlTest/person.xml");
			Document doc = builder.build(url);
			
			// root:  <persons>
			Element root = doc.getRootElement();
			
			//root의 자식요소(Element)를 목록을 구함
			List<Element> p_list = root.getChildren("person");
			for(Element p : p_list) {
				
				String name     = p.getChildText("name");
				String nickname = p.getChild("name").getAttributeValue("nickname");
				
				int age = 0;
				
				try {
					String str_age  = p.getChildText("age");
					age = Integer.parseInt(str_age);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				
				String tel 		= p.getChildText("tel");
				String hometel 	= p.getChild("tel").getAttributeValue("hometel");
				
				PersonVo vo = new PersonVo(name, nickname, age, tel, hometel);
				list.add(vo);
			}
			
			
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//request binding
		request.setAttribute("list", list);

		//dispatcher(forward)
		String forward_page = "person_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}
}