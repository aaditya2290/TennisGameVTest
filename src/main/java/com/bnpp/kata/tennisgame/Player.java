package com.bnpp.kata.tennisgame;

import com.bnpp.kata.tennisgame.constants.PointsToScoreMapper;

public class Player {

	private String name;
	private int points;
	private boolean isAdvantage;

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

	private void setPoints(int points) {
		this.points = points;
	}

	public boolean isAdvantage() {
		return isAdvantage;
	}

	public void setAdvantage(boolean isAdvantage) {
		this.isAdvantage = isAdvantage;
	}

}
