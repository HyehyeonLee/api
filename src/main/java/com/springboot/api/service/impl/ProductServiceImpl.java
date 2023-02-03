package com.springboot.api.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.springboot.api.dto.ProductDto;
import com.springboot.api.dto.ProductResponseDto;
import com.springboot.api.mapper.product.ProductMapper;
import com.springboot.api.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductMapper productMapper;
	
	@Override
	public ArrayList<ProductResponseDto> selectAllProduct() {
		return productMapper.selectAllProduct();
	}
	
	@Override
	public ProductResponseDto selectProduct(int number) {
		return productMapper.selectProduct(number);
	}

	@Override
	public ArrayList<ProductResponseDto> saveProduct(ArrayList<ProductDto> products) {
		ArrayList<ProductResponseDto> list = new ArrayList<>();
		if(!products.isEmpty()) {
			for(int i = 0; i<products.size(); i++) {
				ProductDto productDto = products.get(i);
				productMapper.saveProduct(productDto);
				
				ProductResponseDto responseDto = new ProductResponseDto();
				responseDto.setCreated_at(productDto.getCreated_at());
				responseDto.setName(productDto.getName());
				responseDto.setPrice(productDto.getPrice());
				responseDto.setStock(productDto.getStock());
				responseDto.setUpdated_at(productDto.getUpdated_at());
				
				list.add(responseDto);
			}
		}
		
		return list;
	}

	@Override
	public ArrayList<ProductResponseDto> updateProduct(ArrayList<ProductDto> products) {
		ArrayList<ProductResponseDto> list = new ArrayList<>();
		if(!products.isEmpty()) {
			for(int i = 0; i<products.size(); i++) {
				ProductDto productDto = products.get(i);
				productMapper.updateProduct(productDto);
				
				ProductResponseDto responseDto = new ProductResponseDto();
				responseDto.setCreated_at(productDto.getCreated_at());
				responseDto.setName(productDto.getName());
				responseDto.setPrice(productDto.getPrice());
				responseDto.setStock(productDto.getStock());
				responseDto.setUpdated_at(productDto.getUpdated_at());
				
				list.add(responseDto);
			}
		}
		
		return list;
	}

}
