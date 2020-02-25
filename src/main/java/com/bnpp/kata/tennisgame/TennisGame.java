package com.bnpp.kata.tennisgame;

import com.bnpp.kata.tennisgame.exceptions.InvalidPointsException;

public class TennisGame {

	private static final String PLAYER_POINTS_ARE_INVALID = "Player points are invalid";
	private static final String WINS = " Wins";
	private static final String ADVANTAGE = "Advantage ";
	private static final String DEUCE = "Deuce";
	private static final String ALL = " All";

	private static final int POINTS_DIFFERENCE_FOR_ADVANTAGE = 1;
	private static final int POINTS_DIFFERENCE_FOR_WIN = 2;
	private static final int POINTS_FOR_DEUCE = 3;
	private static final int POINTS_FOR_WIN = 4;

	private Player firstPlayer;
	private Player secondPlayer;

	public TennisGame(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
	}

	public String getScore() throws InvalidPointsException {

		String gameScore;

		if (firstPlayer.getPoints() > POINTS_FOR_WIN
				&& firstPlayer.getPoints() - secondPlayer.getPoints() > POINTS_DIFFERENCE_FOR_WIN
				|| secondPlayer.getPoints() > POINTS_FOR_WIN
				&& secondPlayer.getPoints() - firstPlayer.getPoints() > POINTS_DIFFERENCE_FOR_WIN) {
			throw new InvalidPointsException(PLAYER_POINTS_ARE_INVALID);
		} else if (isWin()) {
			gameScore = getNameOfWinningPlayer() + WINS;
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

	private boolean isWin() {
		return isFirstPlayerWins() || isSecondPlayerWins();
	}

	private boolean isSecondPlayerWins() {
		boolean isWinner = isSecondPlayerPointsEqualToPointsForWin()
				&& isSecondPlayerLeadGreaterThanOrEqualToPointsDifferenceForWin()
				|| isSecondPlayerPointsGreaterThanPointsForWin()
				&& isSecondPlayerLeadEqualToPointsDifferenceForWin();
		secondPlayer.setWinner(isWinner);
		return isWinner;
	}

	private boolean isSecondPlayerLeadEqualToPointsDifferenceForWin() {
		return secondPlayer.getPoints() - firstPlayer.getPoints() == POINTS_DIFFERENCE_FOR_WIN;
	}

	private boolean isSecondPlayerPointsGreaterThanPointsForWin() {
		return secondPlayer.getPoints() > POINTS_FOR_WIN;
	}

	private boolean isSecondPlayerLeadGreaterThanOrEqualToPointsDifferenceForWin() {
		return secondPlayer.getPoints() - firstPlayer.getPoints() >= POINTS_DIFFERENCE_FOR_WIN;
	}

	private boolean isSecondPlayerPointsEqualToPointsForWin() {
		return secondPlayer.getPoints() == POINTS_FOR_WIN;
	}

	private boolean isFirstPlayerWins() {
		boolean isWinner = isFirstPlayerPointsEqualToPointsForWin()
				&& isFirstPlayerLeadGreaterThanOrEqualToPointsDifferenceForWin()
				|| isFirstPlayerPointsGreaterThanPointsForWin()
				&& isFirstPlayerLeadEqualToPointsDifferenceForWin();
		firstPlayer.setWinner(isWinner);
		return isWinner;
	}

	private boolean isFirstPlayerLeadEqualToPointsDifferenceForWin() {
		return firstPlayer.getPoints() - secondPlayer.getPoints() == POINTS_DIFFERENCE_FOR_WIN;
	}

	private boolean isFirstPlayerPointsGreaterThanPointsForWin() {
		return firstPlayer.getPoints() > POINTS_FOR_WIN;
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

	private String getNameOfWinningPlayer() {
		if (firstPlayer.isWinner()) {
			return firstPlayer.getName();
		} else {
			return secondPlayer.getName();
		}
	}

}
