package com.apps.store.billing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.apps.store.billing.service.CustomerCacheInitializer;

/**
 * This class is responsible for loading the initial data during startup of the service.
 * @author Mohamed Shamshuddin
 *
 */
@Component
public class ApplicationListeners implements ApplicationListener<ApplicationReadyEvent>{

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListeners.class);
	
	@Autowired
	private CustomerCacheInitializer customerCacheInitializer;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		//Initialize the customer map.
		LOGGER.info("Service start up initialize");
		customerCacheInitializer.initialize(); 
	}

	
}
