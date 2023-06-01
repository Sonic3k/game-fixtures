package com.sonic.fixtures;

import java.util.*;

import com.sonic.fixtures.game.*;
import com.sonic.fixtures.league.LeagueFixtures;
import com.sonic.fixtures.utils.DrawBox;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			setLeague();
			// setGroupStage();
		} catch (Exception e) {
			System.out.println("[Test] " + e.getMessage());
		}
	}

	private static void setLeague() {
		LeagueFixtures league = LeagueFixtures.getInstance();
		DrawBox<Player> box = new DrawBox<Player>();
		box.add(TxtReader.teamsReader());
		league.setPlayers(box.pickAll());
		league.autoSetFixtures();
		league.printf();
	}

	private static void setGroupStage() {
		int num = 8;
		List<Player> players = TxtReader.teamsReader();
		List<DrawBox<Player>> listPots = new ArrayList<DrawBox<Player>>();
		listPots.add(new DrawBox<Player>());
		int potIndex = 0;
		for (Player player : players) {
			DrawBox<Player> pot = listPots.get(potIndex);
			pot.add(player);
			if (pot.getDimension() >= num) {
				listPots.add(new DrawBox<Player>());
				potIndex++;
			}
		}

		GroupStage groupStage = new GroupStage();
		groupStage.setNumberOfGroups(8);
		groupStage.drawGroups(listPots);
		groupStage.setFixtures();
		groupStage.printf();
	}

}
