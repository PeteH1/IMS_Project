package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Order(1L, 1L), DAO.readLatest());
	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L, 10000));
		assertEquals(orders, DAO.readAll());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order(1L, 1L, 10000), DAO.read(ID));
	}

	@Test
	public void testReadFail() {
		assertEquals(null, DAO.read(null));
	}

	@Test
	public void testCreate() {
		final Order created = new Order(2L, 1L);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testCreateFail() {
		assertEquals(null, DAO.create(null));
	}

	@Test
	public void testUpdate() {
		assertEquals(null, DAO.update(null));
	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}

}
