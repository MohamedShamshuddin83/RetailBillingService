package com.apps.store.billing.utils;

public enum BillingDiscounts {
	
	NOT_GROCERY(0.05), CUSTOMER(0.05), AFFILIATE(0.1), EMPLOYEE(0.3);

	private final double discount;

	BillingDiscounts(double discount) {
		this.discount = discount;
	}

	public double getDiscount() {
		return discount;
	}
}
