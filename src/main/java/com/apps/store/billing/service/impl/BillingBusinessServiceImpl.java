package com.apps.store.billing.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.store.billing.model.BillInvoice;
import com.apps.store.billing.model.Customer;
import com.apps.store.billing.model.Product;
import com.apps.store.billing.model.ShoppingCartDetails;
import com.apps.store.billing.service.BillingBusinessService;
import com.apps.store.billing.service.CustomerCacheInitializer;
import com.apps.store.billing.utils.BillingDiscounts;
import com.apps.store.billing.utils.ProductCategories;

@Service
public class BillingBusinessServiceImpl implements BillingBusinessService {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(BillingBusinessServiceImpl.class);

	private CustomerCacheInitializer customerCacheInitializer;

	@Autowired
	public BillingBusinessServiceImpl(CustomerCacheInitializer customerCacheInitializer) {
		this.customerCacheInitializer = customerCacheInitializer;
	}

	@Override
	public Customer getCustomerDetailsById(Long customerId) {
		return customerCacheInitializer.getCustomerMap().get(customerId);
	}

	@Override
	public BillInvoice generateBillingInvoice(ShoppingCartDetails shoppingCartDetails) {
		LOGGER.info("Generating the billing Invoice");
		Customer customer = customerCacheInitializer.getCustomerMap().get(shoppingCartDetails.getCustomerId());
		if (customer != null) {
			double userBasedDiscount = getDiscountsByCustomerType(customer);
	        double totalDiscountApplied = 0.0d;
	        double totalBillAmount = 0.0d;

			for (Product p : shoppingCartDetails.getProducts()) {
				totalBillAmount += getDiscountedProductPrice(p);
				totalDiscountApplied += getDiscountOnProductPrice(p);
			}
			
			totalDiscountApplied += totalBillAmount * userBasedDiscount;
			totalBillAmount *= (1 - userBasedDiscount);
			return new BillInvoice(UUID.randomUUID(), customer, shoppingCartDetails.getProducts(),
					LocalDateTime.now(), totalBillAmount, totalDiscountApplied);
		}
		return null;
	}

	/**
	 * Get the discounts on Products
	 * @param product
	 * @return
	 */
	private double getDiscountedProductPrice(Product product) {
		return product.getQuantity() * product.getUnitPrice() - getDiscountOnProductPrice(product);
	}

	/**
	 * Get discounts based on Product Category
	 * @param product
	 * @return
	 */
	private double getDiscountOnProductPrice(Product product) {
		return product.getQuantity() * product.getUnitPrice()
				* ((product.getProductType().equals(ProductCategories.GROCERY.toString())) ? 0
						: BillingDiscounts.NOT_GROCERY.getDiscount());
	}

	private double getDiscountsByCustomerType(Customer customer) {
		double discountPercentage = 0.0d;
		switch (customer.getCustomerType()) {
		case AFFILIATE:
			discountPercentage = BillingDiscounts.AFFILIATE.getDiscount();
			break;
		case CUSTOMER:
			if (ChronoUnit.YEARS.between(customer.getNoOfYears(), LocalDateTime.now()) > 2) {
				discountPercentage = BillingDiscounts.CUSTOMER.getDiscount();
			}
			break;
		case EMPLOYEE:
			discountPercentage = BillingDiscounts.EMPLOYEE.getDiscount();
			break;
		}
		return discountPercentage;
	}

}
