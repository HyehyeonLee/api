package com.springboot.api.dto;

import lombok.Data;

@Data
public class ProductCreateDto {
	private String name;
	private int price;
	private int stock;
}
