package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Item.class).verify();
	}

	@Test
	public void testId() {
		Item item = new Item("item", 100);

		item.setId(2L);

		assertEquals(2L, item.getId().longValue());
	}

	@Test
	public void testName() {
		Item item = new Item("item", 100);

		item.setName("new item");

		assertEquals("new item", item.getName());
	}

	@Test
	public void testValue() {
		Item item = new Item("item", 100);

		item.setValue(50);

		assertEquals(50, item.getValue());
	}

}
