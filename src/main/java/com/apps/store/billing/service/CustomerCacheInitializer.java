package com.apps.store.billing.service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.apps.store.billing.model.Customer;
import com.apps.store.billing.utils.CustomerType;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class CustomerCacheInitializer {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerCacheInitializer.class);

	/**
	 * Map to hold the initial customer details during startup of the application.
	 */
	private Map<Long, Customer> customerMap;
	
	/**
	 * Initialize the Customer Map
	 * @throws Exception
	 */
	public void initialize(){
		LOGGER.info("Initializing the Customer Map");
		this.customerMap = new ConcurrentHashMap<>();
		customerMap.put(1L,
				new Customer(1L, "Scott", "1234567891", "Dubai", CustomerType.CUSTOMER, LocalDateTime.now()));
		customerMap.put(2L,
				new Customer(2L, "Brian", "1234567892", "Mumbai", CustomerType.AFFILIATE, LocalDateTime.now()));
		customerMap.put(3L,
				new Customer(3L, "Miguel", "1234567893", "Delhi", CustomerType.EMPLOYEE, LocalDateTime.now()));
		
		// LocalDateTime.of() method is a factory method to create LocalDateTime with specific date and time
		LocalDateTime timeGreaterThan2Years = LocalDateTime.of(2015, Month.JANUARY, 1, 0, 0, 0);
		customerMap.put(4L,
				new Customer(4L, "Mohammed", "1234567894", "Bangalore", CustomerType.EMPLOYEE, timeGreaterThan2Years));
	}
}
