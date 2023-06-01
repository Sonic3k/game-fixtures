package com.sonic.fixtures.league;

import java.util.*;

import com.sonic.fixtures.game.*;

public class LeagueFixtures {
	private static LeagueFixtures instance;
	private List<Player> players;
	private List<Round> rounds;

	private LeagueFixtures() {
		players = new ArrayList<Player>();
		rounds = new ArrayList<Round>();
	}

	public static LeagueFixtures getInstance() {
		if (instance == null)
			instance = new LeagueFixtures();

		return instance;
	}

	public void setPlayers(int numberOfPlayers) {
		players.clear();
		players = new ArrayList<Player>();
		for (int i = 0; i < numberOfPlayers; i++)
			players.add(new Player(i + 1));
	}

	public void setPlayers(List<Player> _players) {
		players = _players;
	}

	public Player getPlayer(int pos) {
		return players.get(pos);
	}

	public int getPlayerDimension() {
		return players.size();
	}

	// ------------------------------------Create
	// Fixtures-----------------------------------

	public void autoSetFixtures() {
		rounds = Fixtures.autoSetFixtures(players);
	}

	// -----------------------------------Print------------------------------------------------

	public void printf() {
		try {
			if (rounds.size() < 1)
				System.out.println("Fixtures not set.");
			for (Round round : rounds) {
				round.printf();
			}
		} catch (Exception e) {
			System.out.println("[League printf] " + e.getMessage());
		}
	}

}
