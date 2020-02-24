package com.bnpp.kata.tennisgame;

import com.bnpp.kata.tennisgame.constants.PointsToScoreMapper;

public class Player {

	private String name;
	private int points;
	private boolean isAdvantage;
	private boolean isWinner;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void winsPoint() {
		points++;
	}

	public void winsPoints(int points) {
		setPoints(points);
	}

	public String getScore() {
		return PointsToScoreMapper.getScore(points);
	}

	public int getPoints() {
		return points;
	}

	public boolean isAdvantage() {
		return isAdvantage;
	}

	public void setAdvantage(boolean isAdvantage) {
		this.isAdvantage = isAdvantage;
	}

	public boolean isWinner() {
		return isWinner;
	}

	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}

	private void setPoints(int points) {
		this.points = points;
	}

}
