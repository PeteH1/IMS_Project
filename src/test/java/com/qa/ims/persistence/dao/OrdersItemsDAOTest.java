package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.OrdersItems;
import com.qa.ims.utils.DBUtils;

public class OrdersItemsDAOTest {

	private final OrdersItemsDAO DAO = new OrdersItemsDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final OrdersItems created = new OrdersItems(2L, 1L, 1L, 50);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<OrdersItems> expected = new ArrayList<>();
		expected.add(new OrdersItems(1L, 1L, 1L, 100));
		assertEquals(expected, DAO.readAll(1L));
	}

	@Test
	public void testReadLatest() {
		assertEquals(new OrdersItems(1L, 1L, 1L, 100), DAO.readLatest());
	}

	@Test
	public void testRead() {
		assertEquals(null, DAO.read(null));
	}

	@Test
	public void testUpdate() {
		assertEquals(null, DAO.update(null));
	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}

	@Test
	public void testReadAlltwo() {
		assertEquals(null, DAO.readAll());
	}

}
