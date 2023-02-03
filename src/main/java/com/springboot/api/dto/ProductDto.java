package com.springboot.api.dto;

import lombok.Data;

@Data
public class ProductDto {
	private String created_at;
	private String name;
	private int price;
	private int stock;
	private String updated_at;
	
}
