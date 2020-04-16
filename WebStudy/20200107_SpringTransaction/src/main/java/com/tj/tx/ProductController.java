package com.tj.tx;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ProductService;
import vo.ProductVo;


@Controller
public class ProductController {

	ProductService product_service;
	
	public void setProduct_service(ProductService product_service) {
		this.product_service = product_service;
	}



	@RequestMapping("/product/list.do")
	public String list(Model model) {
		
		//���(�԰�/���/���)��������
		Map map = product_service.selectList();

		//request binding...
		model.addAttribute("map", map);
		
		return "product/product_list";
	}
	
	@RequestMapping("/product/insert_in.do")
	public String insert_in(ProductVo vo) {
		
		try {
			
			//�԰�ó��
			int res = product_service.insert_in(vo);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "redirect:list.do";
	}
	
	@RequestMapping("/product/insert_out.do")
	public String insert_out(ProductVo vo,Model model) {
		
		try {
			
			//���ó��
			int res = product_service.insert_out(vo);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			//             "remain_not"  or "remain_lack"
			String message = e.getMessage();
			//DispatcherServlet�� �������� Model
			// redirect: parameter���=> list.do?error=remain_not
			// forward : request binding
			model.addAttribute("error", message);
			
		}
		
		return "redirect:list.do";
	}
	
	@RequestMapping("/product/delete_in.do")
	public String delete_in(int idx) {
		
		try {
			
			//�԰����
			int res = product_service.delete_in(idx);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		return "redirect:list.do";
	}
	
	
	
	
	
	
}
