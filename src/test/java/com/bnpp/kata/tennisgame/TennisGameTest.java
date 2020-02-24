package com.bnpp.kata.tennisgame;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class TennisGameTest {

	TennisGame tennisGame;

	@Test
	public void scoreShouldBeLoveAllBeforeTennisGameBegins() {
		tennisGame = new TennisGame();
		assertThat(tennisGame.getScore(), is("Love All"));
	}

}
