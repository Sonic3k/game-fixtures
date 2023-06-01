package com.sonic.fixtures.game;

import java.util.*;

public class Round {
	private int id;
	private List<Match> matchs;

	public Round(int _id, List<Match> _matchs) {
		id = _id;
		matchs = _matchs;
	}

	public Match getMatch(int pos) {
		return matchs.get(pos);
	}

	public int getId() {
		return id;
	}

	public int getDimension() {
		return matchs.size();
	}

	public void printf() {
		int dimension = matchs.size();
		if (dimension < 1)
			return;
		System.out.println("Round " + id + " :");
		for (int i = 0; i < dimension; i++) {
			Match match = matchs.get(i);
			match.printf();
		}
		System.out.println();
	}
}
