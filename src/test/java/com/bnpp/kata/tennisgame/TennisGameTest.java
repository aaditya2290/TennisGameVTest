package com.bnpp.kata.tennisgame;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class TennisGameTest {

	private static final String LOVE_ALL = "Love All";
	TennisGame tennisGame;

	@Test
	public void scoreShouldBeLoveAllBeforeTennisGameBegins() {
		tennisGame = new TennisGame();
		assertThat(tennisGame.getScore(), is(LOVE_ALL));
	}

}
