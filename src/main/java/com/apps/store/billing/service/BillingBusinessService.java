package com.apps.store.billing.service;

import org.springframework.stereotype.Service;

import com.apps.store.billing.model.BillInvoice;
import com.apps.store.billing.model.Customer;
import com.apps.store.billing.model.ShoppingCartDetails;

@Service
public interface BillingBusinessService {
	
	/**
	 * Get customer details by ID
	 * @param jsId
	 * @return
	 */
	Customer getCustomerDetailsById(Long customerId);
	
	/**
	 * Generate the Invoice using the Bill details
	 * @return
	 */
	BillInvoice generateBillingInvoice(ShoppingCartDetails shoppingCartDetails);
}
