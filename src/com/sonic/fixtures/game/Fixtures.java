package com.sonic.fixtures.game;

import java.util.*;

import com.sonic.polygonGraph.Polygon;
import com.sonic.polygonGraph.RedLine;

public class Fixtures {
	public static List<Round> autoSetFixtures(List<Player> players) {
		List<Round> rounds = new ArrayList<Round>();
		int dimension = players.size();
		if (dimension < 3)
			return null;
		try {
			if (dimension % 2 == 0) {
				Polygon polygon = new Polygon(dimension - 1);
				for (int i = 0; i < dimension - 1; i++) {
					List<Match> matchs = new ArrayList<Match>();
					List<RedLine> redLines = polygon.getRedLines(i + 1);
					for (RedLine redLine : redLines) {
						Player player1 = players.get(redLine.getNodeData1() - 1);
						Player player2 = null;
						if (redLine.getNodeData2() != 0) {
							player2 = players.get(redLine.getNodeData2() - 1);
						} else
							player2 = players.get(dimension - 1);
						matchs.add(new Match(player1, player2));
					}
					rounds.add(new Round(i + 1, matchs));
				}
			} else {
				Polygon polygon = new Polygon(dimension);
				for (int i = 0; i < dimension; i++) {
					List<Match> matchs = new ArrayList<Match>();
					List<RedLine> redLines = polygon.getRedLines(i + 1);
					for (RedLine redLine : redLines) {
						if (redLine.getNodeData2() == 0)
							continue;
						Player player1 = players.get(redLine.getNodeData1() - 1);
						Player player2 = players.get(redLine.getNodeData2() - 1);
						Match match = new Match(player1, player2);
						matchs.add(match);
					}
					rounds.add(new Round(i + 1, matchs));
				}
			}
		} catch (Exception e) {
			System.out.println("[autoSetFixtures] " + e.getMessage());
		}

		return rounds;
	}
}
