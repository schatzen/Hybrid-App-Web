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
		
		//목록(입고/재고/출고)가져오기
		Map map = product_service.selectList();

		//request binding...
		model.addAttribute("map", map);
		
		return "product/product_list";
	}
	
	@RequestMapping("/product/insert_in.do")
	public String insert_in(ProductVo vo) {
		
		try {
			
			//입고처리
			int res = product_service.insert_in(vo);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "redirect:list.do";
	}
	
	@RequestMapping("/product/insert_out.do")
	public String insert_out(ProductVo vo,Model model) {
		
		try {
			
			//출고처리
			int res = product_service.insert_out(vo);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			//             "remain_not"  or "remain_lack"
			String message = e.getMessage();
			//DispatcherServlet에 전달해준 Model
			// redirect: parameter사용=> list.do?error=remain_not
			// forward : request binding
			model.addAttribute("error", message);
			
		}
		
		return "redirect:list.do";
	}
	
	@RequestMapping("/product/delete_in.do")
	public String delete_in(int idx) {
		
		try {
			
			//입고삭제
			int res = product_service.delete_in(idx);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		return "redirect:list.do";
	}
	
	
	
	
	
	
}
