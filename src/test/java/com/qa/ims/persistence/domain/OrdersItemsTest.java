package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrdersItemsTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(OrdersItems.class).verify();
	}

	@Test
	public void testId() {
		OrdersItems ordersItems = new OrdersItems(1L, 1L, 10);

		ordersItems.setId(2L);

		assertEquals(2L, ordersItems.getId().longValue());
	}

	@Test
	public void testOrderId() {
		OrdersItems ordersItems = new OrdersItems(1L, 1L, 1L, 10);

		ordersItems.setOrderId(2L);

		assertEquals(2L, ordersItems.getOrderId().longValue());
	}

	@Test
	public void testItemId() {
		OrdersItems ordersItems = new OrdersItems(1L, 1L, 1L, 10);

		ordersItems.setItemId(2L);

		assertEquals(2L, ordersItems.getItemId().longValue());
	}

	@Test
	public void testQuantity() {
		OrdersItems ordersItems = new OrdersItems(1L, 1L, 1L, 10);

		ordersItems.setQuantity(5);

		assertEquals(5, ordersItems.getQuantity());
	}

	@Test
	public void testToString() {
		OrdersItems ordersItems = new OrdersItems(1L, 1L, 1L, 10);
		String expected = "OrdersItems [id=1, orderId=1, itemId=1, quantity=10]";

		assertEquals(expected, ordersItems.toString());
	}

}
