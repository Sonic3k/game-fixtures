package com.sonic.fixtures.game;

import java.util.*;

import com.sonic.fixtures.utils.DrawBox;

public class GroupStage {
	private List<Group> groups;
	private int thisIndex;

	public GroupStage() {
		groups = new ArrayList<Group>();
		thisIndex = 0;
	}

	public void setNumberOfGroups(int number) {
		char title = 'A';
		for (int i = 0; i < number; i++) {
			Group group = new Group(i, "Group " + title);
			groups.add(group);
			title++;
		}
	}

	public void drawGroups(List<DrawBox<Player>> listPots) {
		try {
			for (DrawBox<Player> pot : listPots) {
				while (!pot.isEmpty()) {
					Group group = groups.get(thisIndex);
					group.addPlayer(pot.pick());
					getNextGroupIndex();
				}
			}
		} catch (Exception e) {
			System.out.println("[Draw Groups]" + e.toString());
		}
	}

	public void setFixtures() {
		for (Group group : groups) {
			group.setFixtures();
		}
	}

	private void getNextGroupIndex() {
		int num = groups.size();
		try {
			if (thisIndex >= num - 1)
				thisIndex = 0;
			else
				thisIndex++;
		} catch (Exception e) {
			System.out.println("[Get next group index]" + e.toString());
		}
	}

	// ----------------------------------Print------------------------------------------------

	public void printf() {
		for (Group group : groups) {
			group.printf();
		}
	}

	public void printListPlayer() {
		for (Group group : groups) {
			group.printListPlayers();
		}
	}
}
