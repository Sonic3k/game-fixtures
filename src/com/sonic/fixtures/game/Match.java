package com.sonic.fixtures.game;

public class Match {
	private Player player1;
	private Player player2;

	public Match(Player _player1, Player _player2) {
		player1 = _player1;
		player2 = _player2;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void printf() {
		System.out.println(player1.getName() + " - " + player2.getName());
	}
}
