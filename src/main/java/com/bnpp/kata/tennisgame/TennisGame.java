package com.bnpp.kata.tennisgame;

public class TennisGame {

	private static final int POINTS_DIFFERENCE_FOR_ADVANTAGE = 1;
	private static final String ADVANTAGE = "Advantage ";
	private static final int POINTS_FOR_DEUCE = 3;
	private static final String DEUCE = "Deuce";
	private static final String ALL = " All";
	private Player firstPlayer;
	private Player secondPlayer;

	public TennisGame(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
	}

	public String getScore() {

		String gameScore;

		if (firstPlayer.getPoints() == POINTS_FOR_DEUCE
				&& secondPlayer.getPoints() - firstPlayer.getPoints() == POINTS_DIFFERENCE_FOR_ADVANTAGE) {
			gameScore = ADVANTAGE + secondPlayer.getName();
		} else if (isPlayerPointsEqual()) {
			if (isFirstPlayerPointsGreaterThanOrEqualToPointsForDeuce()) {
				gameScore = DEUCE;
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

	private boolean isFirstPlayerPointsGreaterThanOrEqualToPointsForDeuce() {
		return firstPlayer.getPoints() >= POINTS_FOR_DEUCE;
	}

}
