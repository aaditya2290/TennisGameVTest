package com.bnpp.kata.tennisgame;

public class TennisGame {

	private static final int POINTS_DIFFERENCE_FOR_WIN = 2;
	private static final int POINTS_FOR_WIN = 4;
	private static final String WINS = " Wins";
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

		if (isFirstPlayerPointsEqualToPointsForWin()
				&& isFirstPlayerLeadGreaterThanOrEqualToPointsDifferenceForWin()) {
			gameScore = firstPlayer.getName() + WINS;
		} else if (isAdvantage()) {
			gameScore = ADVANTAGE + getNameOfPlayerHavingAdvantage();
		} else if (isDeuce()) {
			gameScore = DEUCE;
		} else if (isPlayerPointsEqual()) {
			gameScore = firstPlayer.getScore() + ALL;
		} else {
			gameScore = firstPlayer.getScore() + " " + secondPlayer.getScore();
		}
		return gameScore;
	}

	private boolean isFirstPlayerLeadGreaterThanOrEqualToPointsDifferenceForWin() {
		return firstPlayer.getPoints() - secondPlayer.getPoints() >= POINTS_DIFFERENCE_FOR_WIN;
	}

	private boolean isFirstPlayerPointsEqualToPointsForWin() {
		return firstPlayer.getPoints() == POINTS_FOR_WIN;
	}

	private boolean isDeuce() {
		return isPlayerPointsEqual()
				&& isFirstPlayerPointsGreaterThanOrEqualToPointsForDeuce();
	}

	private boolean isPlayerPointsEqual() {
		return firstPlayer.getPoints() == secondPlayer.getPoints();
	}

	private boolean isFirstPlayerPointsGreaterThanOrEqualToPointsForDeuce() {
		return firstPlayer.getPoints() >= POINTS_FOR_DEUCE;
	}

	private boolean isAdvantage() {
		return isAdvantageFirstPlayer() || isAdvantageSecondPlayer();
	}

	private boolean isAdvantageSecondPlayer() {
		boolean isAdvantage = isFirstPlayerPointsGreaterThanOrEqualToPointsForDeuce()
				&& isSecondPlayerLeadEqualToPointsDifferenceForAdvantage();
		secondPlayer.setAdvantage(isAdvantage);
		return isAdvantage;
	}

	private boolean isSecondPlayerLeadEqualToPointsDifferenceForAdvantage() {
		return secondPlayer.getPoints() - firstPlayer.getPoints() == POINTS_DIFFERENCE_FOR_ADVANTAGE;
	}

	private boolean isAdvantageFirstPlayer() {
		boolean isAdvantage = isSecondPlayerPointsGreaterThanOrEqualToPointsForDeuce()
				&& isFirstPlayerLeadEqualToPointsDifferenceForAdvantage();
		firstPlayer.setAdvantage(isAdvantage);
		return isAdvantage;
	}

	private boolean isFirstPlayerLeadEqualToPointsDifferenceForAdvantage() {
		return firstPlayer.getPoints() - secondPlayer.getPoints() == POINTS_DIFFERENCE_FOR_ADVANTAGE;
	}

	private boolean isSecondPlayerPointsGreaterThanOrEqualToPointsForDeuce() {
		return secondPlayer.getPoints() >= POINTS_FOR_DEUCE;
	}

	private String getNameOfPlayerHavingAdvantage() {
		if (firstPlayer.isAdvantage()) {
			return firstPlayer.getName();
		} else {
			return secondPlayer.getName();
		}
	}

}
