package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrdersItemsDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrdersItems;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO orderDAO;

	@Mock
	private OrdersItemsDAO ordersItemsDAO;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testReadAllOne() {
		Mockito.when(utils.getInt()).thenReturn(1);

		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L, 100));

		Mockito.when(orderDAO.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(orderDAO, Mockito.times(1)).readAll();
	}

	@Test
	public void testReadAllTwo() {
		Mockito.when(utils.getInt()).thenReturn(2);
		Mockito.when(utils.getLong()).thenReturn(1L);

		List<Order> orders = new ArrayList<>();
		Order order = new Order(1L, 1L, 100);
		orders.add(new Order(1L, 1L, 100));

		Mockito.when(orderDAO.read(1L)).thenReturn(order);

		assertEquals(orders, controller.readAll());

		Mockito.verify(orderDAO, Mockito.times(1)).read(1L);
	}

	@Test
	public void testReadAllThree() {
		Mockito.when(utils.getInt()).thenReturn(3);
		Mockito.when(utils.getLong()).thenReturn(1L);

		List<OrdersItems> ordersItems = new ArrayList<>();

		Mockito.when(ordersItemsDAO.readAll(1L)).thenReturn(ordersItems);

		assertEquals(ordersItems, controller.readAll());

		Mockito.verify(ordersItemsDAO, Mockito.times(1)).readAll(1L);
	}

	@Test
	public void testCreateOne() {
		Mockito.when(utils.getInt()).thenReturn(1);
		Mockito.when(utils.getLong()).thenReturn(1L);

		Order order = new Order(1L, 1L);

		Mockito.when(orderDAO.create(new Order(1L))).thenReturn(order);
		Mockito.when(orderDAO.readLatest()).thenReturn(order);

		assertEquals(order, controller.create());

		Mockito.verify(orderDAO, Mockito.times(1)).create(new Order(1L));
	}

	@Test
	public void testCreateTwo() {
		Mockito.when(utils.getInt()).thenReturn(2, 100);
		Mockito.when(utils.getLong()).thenReturn(1L, 1L);

		Order order = new Order(1L, 1L, 1000);
		OrdersItems orderItems = new OrdersItems(1L, 1L, 1L, 100);

		Mockito.when(ordersItemsDAO.create(new OrdersItems(1L, 1L, 100))).thenReturn(orderItems);
		Mockito.when(ordersItemsDAO.readLatest()).thenReturn(orderItems);
		Mockito.when(orderDAO.read(1L)).thenReturn(order);

		assertEquals(order, controller.create());
	}

	@Test
	public void testDeleteOne() {
		final long ID = 1L;

		Mockito.when(utils.getInt()).thenReturn(1);
		Mockito.when(utils.getLong()).thenReturn(1L);

		Mockito.when(orderDAO.delete(ID)).thenReturn(1);

		assertEquals(1, controller.delete());
	}

	@Test
	public void testDeleteTwo() {
		final long ID = 1L;

		Mockito.when(utils.getInt()).thenReturn(2);
		Mockito.when(utils.getLong()).thenReturn(1L);

		Mockito.when(ordersItemsDAO.delete(ID)).thenReturn(1);

		assertEquals(1, controller.delete());

	}

}
