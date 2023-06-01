package com.sonic.fixtures.game;

public class Player {
	private int id;
	private String name;

	public Player(int _id, String _name) {
		id = _id;
		name = _name;
	}

	public Player(int _id) {
		id = _id;
		name = "Team " + id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String _name) {
		name = _name;
	}

	public void printf() {
		System.out.println(name);
	}
}
