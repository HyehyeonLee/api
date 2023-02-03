package com.springboot.api.service;

import java.util.ArrayList;


import com.springboot.api.dto.ProductDto;
import com.springboot.api.dto.ProductResponseDto;

public interface ProductService {
	public ArrayList<ProductResponseDto> selectAllProduct();
	
	public ProductResponseDto selectProduct(int number);
	
	public ArrayList<ProductResponseDto> saveProduct(ArrayList<ProductDto> products);
	
	public ArrayList<ProductResponseDto> updateProduct(ArrayList<ProductDto> products);
}
