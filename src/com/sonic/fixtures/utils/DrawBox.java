package com.sonic.fixtures.utils;

import java.util.*;

public class DrawBox<Item> {
	private List<Item> items;
	private Random random;

	public DrawBox() {
		items = new ArrayList<Item>();
		random = new Random();
	}

	public void add(Item item) {
		items.add(item);
	}

	public void add(List<Item> additionalItems) {
		items.addAll(additionalItems);
	}

	public int getDimension() {
		return items.size();
	}

	public boolean isEmpty() {
		int dimension = items.size();
		if (dimension < 1)
			return true;
		else
			return false;
	}

	public Item pick() {
		int dimension = items.size();
		if (dimension < 1)
			return null;
		else {
			int index = random.nextInt(dimension);
			Item item = items.get(index);
			items.remove(index);
			return item;
		}
	}

	public List<Item> suffle() {
		int dimension = items.size();
		if (dimension < 1)
			return null;
		else {
			for (int i = 0; i < dimension; i++) {
				int index2 = random.nextInt(dimension);
				swap(i, index2);
			}
			return items;
		}
	}

	public List<Item> pickAll() {
		int dimension = items.size();
		if (dimension < 1)
			return null;
		else {
			for (int i = 0; i < dimension; i++) {
				int index2 = random.nextInt(dimension);
				swap(i, index2);
			}
			List<Item> newItems = new ArrayList<Item>();
			newItems.addAll(items);
			items.clear();
			return newItems;
		}
	}

	public void remove() {
		int dimension = items.size();
		if (dimension < 1)
			return;
		else {
			int index = random.nextInt(dimension);
			items.remove(index);
		}
	}

	public void clear() {
		items.clear();
	}

	private void swap(int index1, int index2) {
		Item temp = items.get(index1);
		items.set(index1, items.get(index2));
		items.set(index2, temp);
	}
}
