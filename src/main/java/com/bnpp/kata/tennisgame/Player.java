package com.bnpp.kata.tennisgame;

import com.bnpp.kata.tennisgame.constants.PointsToScoreMapper;

public class Player {

	private int points;

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

}
