package com.springboot.api.mapper.product;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.api.dto.ProductDto;
import com.springboot.api.dto.ProductResponseDto;


@Mapper
public interface ProductMapper {
	public ArrayList<ProductResponseDto> selectAllProduct();
	
	public ProductResponseDto selectProduct(int number);
	
//	public createProduct();
	public void saveProduct(ProductDto productDto);
	
	public void updateProduct(ProductDto productDto);
}
