package com.bnpp.kata.tennisgame;

public class TennisGame {

	private static final String LOVE_ALL = "Love All";
	private Player firstPlayer;
	private Player secondPlayer;

	public TennisGame(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
	}

	public String getScore() {

		String gameScore;

		if (firstPlayer.getPoints() == 0 && secondPlayer.getPoints() == 0) {
			gameScore = LOVE_ALL;
		} else {
			gameScore = firstPlayer.getScore() + " " + secondPlayer.getScore();
		}
		return gameScore;
	}
}
