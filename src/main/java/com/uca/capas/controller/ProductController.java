package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Product;

@Controller
public class ProductController {
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/productos")
	public ModelAndView compra() {
		ModelAndView mav = new ModelAndView();
		productos.add(new Product(0,"Litro de leche",30));
		productos.add(new Product(1,"Pechuga de pollo",15));
		productos.add(new Product(2,"Caramelo Skittle",10));
		productos.add(new Product(3,"Bebida Coca cola",50));
		productos.add(new Product(4,"Silla plegable",3));
		mav.setViewName("productos");
		mav.addObject("producto", new Product());
		mav.addObject("productos", productos);
		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product producto) {
		ModelAndView mav = new ModelAndView();
	
		if((producto.getCantidad()) <= productos.get(producto.getId()).getCantidad()) {
			mav.setViewName("compra");
			mav.addObject("productox", productos.get(producto.getId()).getNombre());
		}else {
			mav.setViewName("error");
			mav.addObject("productox", productos.get(producto.getId()).getNombre());
		}
		return mav;
	}
	
	
}
