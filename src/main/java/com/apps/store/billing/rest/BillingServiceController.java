package com.apps.store.billing.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.store.billing.model.BillInvoice;
import com.apps.store.billing.model.ShoppingCartDetails;
import com.apps.store.billing.service.BillingBusinessService;


@RestController
@RequestMapping("/billing")
public class BillingServiceController {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(BillingServiceController.class);

	private BillingBusinessService billingBusinessService;

	@Autowired
	public BillingServiceController(BillingBusinessService billingBusinessService) {
		this.billingBusinessService = billingBusinessService;
	}

	/**
	 * Generate Billing invoide
	 * @param jobSeekerTransactionDetailsEntity
	 * @return
	 */
	@PostMapping("/generateBillingInvoice")
	public ResponseEntity<BillInvoice> generateBillingInvoice(
			@Valid @RequestBody ShoppingCartDetails shoppingCartDetails) {
		return ResponseEntity
				.ok(billingBusinessService.generateBillingInvoice(shoppingCartDetails));
	}

}
