package com.apps.store.billing.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.apps.store.billing.utils.CustomerType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

	private final Long customerId;
	private final String name;
	private final String contactNumber;
	private final String address;
	private final CustomerType customerType;
	private final LocalDateTime noOfYears;

	public Customer(Long customerId, String name, String contactNumber, String address, CustomerType customerType,
			LocalDateTime noOfYears) {
		this.customerId = customerId;
		this.name = name;
		this.contactNumber = contactNumber;
		this.address = address;
		this.customerType = customerType;
		this.noOfYears = noOfYears;
	}

	@Override
	public String toString() {
		return "Customer [uuid=" + customerId + ", name=" + name + ", contactNumber=" + contactNumber + ", address=" + address
				+ ", customerType=" + customerType + ", noOfYears=" + noOfYears + "]";
	}

}
