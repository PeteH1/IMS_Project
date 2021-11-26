package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrdersItems;
import com.qa.ims.utils.DBUtils;

public class OrdersItemsDAO implements Dao<OrdersItems> {

	/* This class only needs to read, add & remove rows from orders_items table */

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public OrdersItems modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		Long orderId = resultSet.getLong("order_id");
		Long itemId = resultSet.getLong("item_id");
		int quantity = resultSet.getInt("quantity");
		return new OrdersItems(id, orderId, itemId, quantity);
	}

	public List<OrdersItems> readAll(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM orders_items WHERE order_id = ?");) {
			statement.setLong(1, orderId);
			List<OrdersItems> ordersItems = new ArrayList<>();
			try (ResultSet resultSet = statement.executeQuery();) {
				while (resultSet.next()) {
					ordersItems.add(modelFromResultSet(resultSet));
				}
				return ordersItems;
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public OrdersItems readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders_items ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrdersItems read(Long id) {
		return null;
	}

	// Add items to Order using this method
	@Override
	public OrdersItems create(OrdersItems ordersItems) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders_items(order_id, item_id, quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, ordersItems.getOrderId());
			statement.setLong(2, ordersItems.getItemId());
			statement.setInt(3, ordersItems.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getStackTrace());
		}
		return null;
	}

	// Does nothing
	@Override
	public OrdersItems update(OrdersItems t) {
		return null;
	}

	// Remove items from Order here
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders_items WHERE id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public List<OrdersItems> readAll() {
		return null;
	}

}
