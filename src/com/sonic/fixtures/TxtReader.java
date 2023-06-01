package com.sonic.fixtures;

import java.io.FileInputStream;
import java.util.*;

import com.sonic.fixtures.game.*;

public class TxtReader {
	private static final String leagueTeamsPath = "data\\LeagueTeams";

	public static List<Player> teamsReader() {
		List<Player> players = null;
		try {
			FileInputStream is = new FileInputStream(leagueTeamsPath);
			Scanner input = new Scanner(is);
			String line;
			players = new ArrayList<Player>();
			int i = 1;
			while (input.hasNext()) {
				line = input.nextLine();
				if (!line.trim().isEmpty()) {
					Player player = new Player(i, line.trim());
					players.add(player);
					i++;
				}
			}
		} catch (Exception e) {
			System.out.println("[Txt Players Reader] " + e.getMessage());
		}
		return players;
	}
}
