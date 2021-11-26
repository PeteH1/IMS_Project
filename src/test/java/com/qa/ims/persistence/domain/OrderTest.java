package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Order.class).verify();
	}

	@Test
	public void testId() {
		Order order = new Order(1L);

		order.setId(2L);

		assertEquals(2L, order.getId().longValue());
	}

	@Test
	public void testCustomerId() {
		Order order = new Order(1L, 1L);

		order.setCustomerId(2L);

		assertEquals(2L, order.getCustomerId().longValue());
	}

	@Test
	public void testTotalCost() {
		Order order = new Order(1L, 1L, 100);

		order.setTotalCost(50);

		assertEquals(50, order.getTotalCost());
	}

	@Test
	public void testToString() {
		Order order = new Order(1L, 1L, 100);
		String expected = "Order [id=1, customerId=1, totalCost=100]";

		assertEquals(expected, order.toString());
	}

}
