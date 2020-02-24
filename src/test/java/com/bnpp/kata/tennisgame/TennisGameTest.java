package com.bnpp.kata.tennisgame;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class TennisGameTest {

	private static final String FIFTEEN_LOVE = "Fifteen Love";
	private static final String LOVE_ALL = "Love All";
	private TennisGame tennisGame;

	@Test
	public void scoreShouldBeLoveAllBeforeTennisGameBegins() {
		tennisGame = new TennisGame();
		assertThat(tennisGame.getScore(), is(LOVE_ALL));
	}

	@Test
	public void scoreShouldBeFifteenLoveWhenFirstPlayerWinsOnePoint() {
		Player firstPlayer = new Player();
		Player secondPlayer = new Player();
		tennisGame = new TennisGame(firstPlayer, secondPlayer);
		firstPlayer.winsPoint();
		assertThat(tennisGame.getScore(), is(FIFTEEN_LOVE));
	}

	@Test
	public void scoreShouldBeLoveFifteenWhenSecondPlayerWinsOnePoint() {
		Player firstPlayer = new Player();
		Player secondPlayer = new Player();
		tennisGame = new TennisGame(firstPlayer, secondPlayer);
		secondPlayer.winsPoint();
		assertThat(tennisGame.getScore(), is("Love Fifteen"));
	}

}
