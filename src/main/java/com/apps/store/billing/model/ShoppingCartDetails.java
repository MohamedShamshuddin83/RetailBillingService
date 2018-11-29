package com.apps.store.billing.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartDetails implements Serializable{

	/**
	 * Universal Unique Identifier for Invoice number
	 */
	private Long cartId;
	
	private Long customerId;
	
	private List<Product> products;

	@Override
	public String toString() {
		return "ShoppingCartDetails [cartId=" + cartId + ", customerId=" + customerId + ", products=" + products + "]";
	}
	
}
