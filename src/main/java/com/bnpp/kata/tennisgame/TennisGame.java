package com.bnpp.kata.tennisgame;

public class TennisGame {

	private static final String ALL = " All";
	private Player firstPlayer;
	private Player secondPlayer;

	public TennisGame(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
	}

	public String getScore() {

		String gameScore;

		if (isPlayerPointsEqual()) {
			if (firstPlayer.getPoints() == 3) {
				gameScore = "Deuce";
			} else {

				gameScore = firstPlayer.getScore() + ALL;
			}
		} else {
			gameScore = firstPlayer.getScore() + " " + secondPlayer.getScore();
		}
		return gameScore;
	}

	private boolean isPlayerPointsEqual() {
		return firstPlayer.getPoints() == secondPlayer.getPoints();
	}
}
