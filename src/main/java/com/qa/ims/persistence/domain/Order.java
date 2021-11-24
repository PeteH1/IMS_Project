package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private Long id;
	private Long customerId;
	private int totalCost;

	public Order(Long customerId) {
		this.customerId = customerId;
	}

	public Order(Long id, Long customerId) {
		this.id = id;
		this.customerId = customerId;
	}

	public Order(Long id, Long customerId, int totalCost) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.totalCost = totalCost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(id, other.id);
	}

}