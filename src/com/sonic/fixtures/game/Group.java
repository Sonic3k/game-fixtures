package com.sonic.fixtures.game;

import java.util.*;

public class Group {
	private int id;
	private String title;
	private List<Player> players;
	private List<Round> rounds;

	public Group(int _id, String _title) {
		id = _id;
		title = _title;
		players = new ArrayList<Player>();
		rounds = new ArrayList<Round>();
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void setPlayers(List<Player> _players) {
		players = _players;
	}

	public void setFixtures() {
		rounds = Fixtures.autoSetFixtures(players);
	}

	// ---------------------------Test Print----------------------------

	public void printf() {
		int dimension = rounds.size();
		if (dimension < 1)
			return;
		System.out.println(title + "\n");
		for (Round round : rounds) {
			round.printf();
		}
		System.out.println();
	}

	public void printListPlayers() {
		System.out.println(title + " :\n");
		for (Player player : players) {
			System.out.println(player.getName());
		}
		System.out.println();
	}
}
