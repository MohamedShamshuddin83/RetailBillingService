package com.apps.store.billing.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is responsible for generating the Billing Invoice.
 * @author 
 *
 */
@Getter
@Setter
public class BillInvoice {

	/**
	 * Universal Unique Identifier for Invoice number
	 */
	private final UUID uuid;
	
	/**
	 * Customer object
	 */
	private final Customer customer;
	
	/**
	 * List of products shopped
	 */
	private final List<Product> products;
	
	/**
	 * Local Date & Time
	 */
    private final LocalDateTime localDateTime;
    
    /**
     * Bill Amount
     */
    private final double amount;
    
    /**
     * Discount applied on amount
     */
    private final double discount;
    
    
    /**
     * Class constructor
     * @param uuid
     * @param localDateTime
     * @param amount
     * @param discount
     */
    public BillInvoice(UUID uuid, Customer customer, List<Product> products, LocalDateTime localDateTime, double amount, double discount) {
    	this.uuid = uuid;
    	this.customer = customer;
    	this.products = products;
    	this.localDateTime = localDateTime;
    	this.amount = amount;
    	this.discount = discount;
	}


	@Override
	public String toString() {
		return "BillInvoice [uuid=" + uuid + ", customer=" + customer + ", product=" + products + ", localDateTime="
				+ localDateTime + ", amount=" + amount + ", discount=" + discount + "]";
	}

    
}
