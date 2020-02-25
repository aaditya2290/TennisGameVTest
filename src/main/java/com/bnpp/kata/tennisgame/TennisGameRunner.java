package com.bnpp.kata.tennisgame;

import java.util.logging.Logger;

import com.bnpp.kata.tennisgame.exceptions.InvalidPointsException;

public class TennisGameRunner {

	private static final int VALID_ARGS_LENGTH = 4;
	private static final String INVALID_ARGUMENTS_ERROR = "Please enter atleast 4 command line arguments in the format given below: \n FirstPlayerName FirstPlayerScore SecondPlayerName SecondPlayerScore";
	private static final Logger logger = Logger
			.getLogger(TennisGameRunner.class.getName());

	public static void main(String args[]) {

		try {
			if (args.length != VALID_ARGS_LENGTH) {
				throw new IllegalArgumentException(INVALID_ARGUMENTS_ERROR);
			} else {
				String firstPlayerName = args[0];
				int firstPlayerPoints = Integer.parseInt(args[1]);
				String secondPlayerName = args[2];
				int secondPlayerPoints = Integer.parseInt(args[3]);

				Player firstPlayer = new Player(firstPlayerName);
				Player secondPlayer = new Player(secondPlayerName);

				TennisGame game = new TennisGame(firstPlayer, secondPlayer);

				firstPlayer.winsPoints(firstPlayerPoints);
				secondPlayer.winsPoints(secondPlayerPoints);

				logger.info(game.getScore());
			}
		} catch (IllegalArgumentException | InvalidPointsException e) {
			logger.info(e.getMessage());
		}
	}

}