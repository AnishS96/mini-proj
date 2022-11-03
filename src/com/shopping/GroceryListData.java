package com.shopping;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class GroceryListData {
	private String userName;
	private int password;
	private int amount;
	private ArrayList<String> list = new ArrayList<String>();
	private LinkedHashMap<String, Integer> vegetables = new LinkedHashMap<String, Integer>();
	private LinkedHashMap<String, Integer> fruits = new LinkedHashMap<String, Integer>();
	private LinkedHashMap<String, Integer> dairy = new LinkedHashMap<String, Integer>();
	private TreeMap<String, Integer> cart = new TreeMap<String, Integer>();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public ArrayList<String> getList() {
		return list;
	}

	public LinkedHashMap<String, Integer> getFruits() {
		return fruits;
	}

	public LinkedHashMap<String, Integer> getVegetables() {
		return vegetables;
	}

	public LinkedHashMap<String, Integer> getDairy() {
		return dairy;
	}

	public TreeMap<String, Integer> getCart() {
		return cart;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}