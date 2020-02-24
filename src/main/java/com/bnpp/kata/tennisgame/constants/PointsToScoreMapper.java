package com.bnpp.kata.tennisgame.constants;

import java.util.HashMap;
import java.util.Map;

public class PointsToScoreMapper {

	private static final String FIFTEEN = "Fifteen";
	private static final String LOVE = "Love";
	private static final Map<Integer, String> pointsToScore = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 1L;
		{
			put(0, LOVE);
			put(1, FIFTEEN);
			put(2, "Thirty");
			put(3, "Forty");
		}
	};

	public static String getScore(int points) {
		return pointsToScore.get(points);
	}

}
