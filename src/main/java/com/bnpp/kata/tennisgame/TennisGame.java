package com.bnpp.kata.tennisgame;

public class TennisGame {

	private static final String LOVE_FIFTEEN = "Love Fifteen";
	private static final String FIFTEEN_LOVE = "Fifteen Love";
	private static final String LOVE_ALL = "Love All";
	private Player firstPlayer;
	private Player secondPlayer;

	public TennisGame() {
	}

	public TennisGame(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
	}

	public String getScore() {

		String gameScore;

		if (firstPlayer != null && secondPlayer != null) {
			if (firstPlayer.getPoints() == 1 && secondPlayer.getPoints() == 0) {
				gameScore = FIFTEEN_LOVE;
			} else if (firstPlayer.getPoints() == 0
					&& secondPlayer.getPoints() == 1) {
				gameScore = LOVE_FIFTEEN;
			} else {
				gameScore = LOVE_ALL;

			}
		} else {
			gameScore = LOVE_ALL;
		}
		return gameScore;
	}
}
