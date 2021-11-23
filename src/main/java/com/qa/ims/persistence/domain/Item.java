package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private Long id;
	private String name;
	private int value;

	public Item(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public Item(Long id, String name, int value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return " ID: " + id + "   Name: " + name + "   Value: " + value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && value == other.value;
	}

}
