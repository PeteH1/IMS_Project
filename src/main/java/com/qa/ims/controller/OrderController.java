package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrdersItemsDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrdersItems;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private OrdersItemsDAO ordersItemsDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, OrdersItemsDAO ordersItemsDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.ordersItemsDAO = ordersItemsDAO;
		this.utils = utils;
	}

	// Add extra option to read a specific order, then for 1 & 2, print with total
	// cost using JOIN & SUM - give ALIAS to total_cost column
	@Override
	public List<Order> readAll() {
		boolean flag = true;
		while (flag) {
			LOGGER.info(
					"Would you like to:\n Press 1) View all orders\n Press 2) View a specific order\n Press 3) View items in an order");
			int input = utils.getInt();
			if (input == 1) {
				List<Order> orders = orderDAO.readAll();
				for (Order order : orders) {
					LOGGER.info(order);
				}
				return orders;
			} else if (input == 2) {
				LOGGER.info("Please enter the id of the order you would like to view");
				Long orderId = utils.getLong();
				List<Order> singleOrder = new ArrayList<>();
				singleOrder.add(orderDAO.read(orderId));
				LOGGER.info(singleOrder);
				return singleOrder;
			} else if (input == 3) {
				LOGGER.info("Please enter the id of the order you would like to view items for");
				Long orderId = utils.getLong();
				List<OrdersItems> ordersItems = ordersItemsDAO.readAll(orderId);
				for (OrdersItems ordersItem : ordersItems) {
					LOGGER.info(ordersItem);
				}
				return new ArrayList<>();
			}
		}
		return new ArrayList<>();
	}

	@Override
	public Order create() {
		boolean flag = true;
		while (flag) {
			LOGGER.info("Would you like to:\n Press 1) Create an order\n Press 2) Add an item to an order");
			int input = utils.getInt();
			if (input == 1) {
				LOGGER.info("Please enter the customer id for this order");
				Long customerId = utils.getLong();
				Order order = orderDAO.create(new Order(customerId));
				LOGGER.info("Order created");
				return order;
			} else if (input == 2) {
				LOGGER.info("Please enter the order id you would like to add items to");
				Long orderId = utils.getLong();
				LOGGER.info("Please enter the item id you would like to add to the order");
				Long itemId = utils.getLong();
				LOGGER.info("Please enter the quantity you would like to add to the order");
				int quantity = utils.getInt();
				ordersItemsDAO.create(new OrdersItems(orderId, itemId, quantity));
				return orderDAO.read(orderId);
			} else {
				LOGGER.info("Please select 1 or 2");
			}
		}
		return null;
	}

	@Override
	public Order update() {
		return null;
	}

	@Override
	public int delete() {
		boolean flag = true;
		while (flag) {
			LOGGER.info("Would you like to:\n Press 1) Delete an order\n Press 2) Delete an item from an order");
			int input = utils.getInt();
			if (input == 1) {
				LOGGER.info("Please enter the id of the order you would like to delete");
				Long id = utils.getLong();
				flag = false;
				return orderDAO.delete(id);
			} else if (input == 2) {
				LOGGER.info("Please enter the id of the OrderItem you would like to delete");
				Long id = utils.getLong();
				flag = false;
				return ordersItemsDAO.delete(id);
			} else {
				LOGGER.info("Please select 1 or 2");
			}
		}
		return 0;

	}

}