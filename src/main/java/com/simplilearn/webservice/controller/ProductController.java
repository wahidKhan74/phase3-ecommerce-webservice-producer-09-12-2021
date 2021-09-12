package com.simplilearn.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.Product;
import com.simplilearn.webservice.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("/products/{id}")
	public Product getOneProduct(@PathVariable(value="id") long id){
		Product product = productRepo.findById(id).get();
		return product;
	}
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		List<Product> products = productRepo.findAll();
		return products;
	}
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product productObj){
		Product product = productRepo.save(productObj);
		return product;
	}
	
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable(value="id") long id, @RequestBody Product productObj){
		// find a product
		Product fetchProduct = productRepo.findById(id).get();
		//set all updating fields
		fetchProduct.setDescription(productObj.getDescription());
		fetchProduct.setPrice(productObj.getPrice());
		fetchProduct.setName(productObj.getName());
		
		Product product = productRepo.save(fetchProduct);
		return product;
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteOneProduct(@PathVariable(value="id") long id){
		Product product = productRepo.findById(id).get();
		productRepo.delete(product);
	}
}
