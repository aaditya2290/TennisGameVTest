package com.bnpp.kata.tennisgame;

public class TennisGame {

	private static final String FIFTEEN_LOVE = "Fifteen Love";
	private static final String LOVE_ALL = "Love All";
	private Player firstPlayer;

	public TennisGame() {
	}

	public TennisGame(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public String getScore() {

		String gameScore;

		if (firstPlayer != null && firstPlayer.getPoints() == 1) {
			gameScore = FIFTEEN_LOVE;
		} else {
			gameScore = LOVE_ALL;
		}
		return gameScore;
	}

}
