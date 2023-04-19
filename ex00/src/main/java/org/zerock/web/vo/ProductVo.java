package org.zerock.web.vo;

import lombok.Data;

@Data
public class ProductVo {
	
	private String name;
	private double price;
	
	public ProductVo(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return getName() + " " + getPrice();
	}
	
	
}
