package com.apps.store.billing.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product implements Serializable{

	/**
	 * Universal Unique Identifier for Invoice number
	 */
	private Long productId;
	
	/**
	 * Product Name
	 */
    private String productName;
    
    /**
     * Quantity
     */
    private int quantity;
    
    /**
     * Product Categories
     */
    private String productType;
    
    /**
     * Product Unit price
     */
    private double unitPrice;
    
	@Override
	public String toString() {
		return "Product [uuid=" + productId + ", name=" + productName + ", quantity=" + quantity + ", productType=" + productType + ", unitPrice="
				+ unitPrice + "]";
	}
    
    
}
