package com.springboot.api.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.ProductCreateDto;
import com.springboot.api.dto.ProductDto;
import com.springboot.api.dto.ProductResponseDto;
import com.springboot.api.service.ProductService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/pr-api")
public class ProductController {
	
	private final ProductService productService;
	
//	@Autowired
//	public ProductController(ProductService productService) {
//		this.productService = productService;
//	}
	
	@GetMapping("/all")
	public ResponseEntity<ArrayList<ProductResponseDto>> getAllProduct(){
		ArrayList<ProductResponseDto> list = productService.selectAllProduct();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("/{number}")
	public ResponseEntity<ProductResponseDto> getProduct(@PathVariable int number){
		try {
			ProductResponseDto dto = productService.selectProduct(number);
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
	}
	
	@PostMapping("/products")
	public ResponseEntity<ArrayList<ProductResponseDto>> saveProduct(@RequestBody ArrayList<ProductCreateDto> products){
		ArrayList<ProductDto> dtoList = new ArrayList<>();
		
		for(ProductCreateDto product : products) {
			String date = String.valueOf(LocalDateTime.now());
			ProductDto dto = new ProductDto();
			dto.setCreated_at(date);
			dto.setName(product.getName());
			dto.setPrice(product.getPrice());
			dto.setStock(product.getStock());
			dto.setUpdated_at(date);
			dtoList.add(dto);
		}
		ArrayList<ProductResponseDto> savedList = productService.saveProduct(dtoList);
		
		if(savedList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(savedList);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(savedList);
		}
	}
	
	@PutMapping("/products/{number}")
	public ResponseEntity<ArrayList<ProductResponseDto>> updateProduct(@RequestBody ArrayList<ProductDto> products){
		return null;
	}
	
}
