package com.bnpp.kata.tennisgame.constants;

import java.util.HashMap;
import java.util.Map;

public class PointsToScoreMapper {

	private static final Map<Integer, String> pointsToScore = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 1L;
		{
			put(0, "Love");
			put(1, "Fifteen");
		}
	};

	public static String getScore(int points) {
		return pointsToScore.get(points);
	}

}
