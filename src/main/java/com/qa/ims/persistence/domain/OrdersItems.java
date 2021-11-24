package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrdersItems {

	private Long id;
	private Long orderId;
	private Long itemId;
	private int quantity;

	public OrdersItems(Long orderId, Long itemId, int quantity) {
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
	}

	public OrdersItems(Long id, Long orderId, Long itemId, int quantity) {
		this.id = id;
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrdersItems [id=" + id + ", orderId=" + orderId + ", itemId=" + itemId + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemId, orderId, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdersItems other = (OrdersItems) obj;
		return Objects.equals(id, other.id) && Objects.equals(itemId, other.itemId)
				&& Objects.equals(orderId, other.orderId) && quantity == other.quantity;
	}

}
