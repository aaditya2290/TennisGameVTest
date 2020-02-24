package com.bnpp.kata.tennisgame;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {

	private static final String WINS = " Wins";
	private static final String ADVANTAGE = "Advantage ";
	private static final String DEUCE = "Deuce";
	private static final String FORTY_THIRTY = "Forty Thirty";
	private static final String FIFTEEN_ALL = "Fifteen All";
	private static final String LOVE_FIFTEEN = "Love Fifteen";
	private static final String FIFTEEN_LOVE = "Fifteen Love";
	private static final String LOVE_ALL = "Love All";
	private TennisGame tennisGame;
	private Player firstPlayer;
	private Player secondPlayer;

	@Before
	public void setUp() {
		firstPlayer = new Player("Pete Sampras");
		secondPlayer = new Player("Andre Agassi");
		tennisGame = new TennisGame(firstPlayer, secondPlayer);
	}

	@Test
	public void scoreShouldBeLoveAllBeforeTennisGameBegins() {
		assertThat(tennisGame.getScore(), is(LOVE_ALL));
	}

	@Test
	public void scoreShouldBeFifteenLoveWhenFirstPlayerWinsOnePoint() {
		firstPlayer.winsPoint();
		assertThat(tennisGame.getScore(), is(FIFTEEN_LOVE));
	}

	@Test
	public void scoreShouldBeLoveFifteenWhenSecondPlayerWinsOnePoint() {
		secondPlayer.winsPoint();
		assertThat(tennisGame.getScore(), is(LOVE_FIFTEEN));
	}

	@Test
	public void scoreShouldBeFifteenAllWhenBothPlayersWinOnePoint() {
		firstPlayer.winsPoint();
		secondPlayer.winsPoint();
		assertThat(tennisGame.getScore(), is(FIFTEEN_ALL));
	}

	@Test
	public void scoreShouldBeFortyThirtyWhenFirstPlayerWinsThreePointsAndSecondPlayerWinsTwoPoints() {
		firstPlayer.winsPoints(3);
		secondPlayer.winsPoints(2);
		assertThat(tennisGame.getScore(), is(FORTY_THIRTY));
	}

	@Test
	public void scoreShouldBeDeuceWhenBothPlayersWinThreePoints() {
		firstPlayer.winsPoints(3);
		secondPlayer.winsPoints(3);
		assertThat(tennisGame.getScore(), is(DEUCE));
	}

	@Test
	public void scoreShouldBeDeuceWhenBothPlayersWinSevenPoints() {
		firstPlayer.winsPoints(7);
		secondPlayer.winsPoints(7);
		assertThat(tennisGame.getScore(), is(DEUCE));
	}

	@Test
	public void scoreShouldBeAdvantageSecondPlayerWhenFirstPlayerWinsThreePointsAndSecondPlayerWinsFourPoints() {
		firstPlayer.winsPoints(3);
		secondPlayer.winsPoints(4);
		assertThat(tennisGame.getScore(),
				is(ADVANTAGE + secondPlayer.getName()));
	}

	@Test
	public void scoreShouldBeAdvantageSecondPlayerWhenFirstPlayerWinsTenPointsAndSecondPlayerWinsElevenPoints() {
		firstPlayer.winsPoints(10);
		secondPlayer.winsPoints(11);
		assertThat(tennisGame.getScore(),
				is(ADVANTAGE + secondPlayer.getName()));
	}

	@Test
	public void scoreShouldBeAdvantageFirstPlayerWhenFirstPlayerWinsSixPointsAndSecondPlayerWinsFivePoints() {
		firstPlayer.winsPoints(6);
		secondPlayer.winsPoints(5);
		assertThat(tennisGame.getScore(), is(ADVANTAGE + firstPlayer.getName()));
	}

	@Test
	public void scoreShouldBeFirstPlayerWinsWhenFirstPlayerWinsFourPointsAndSecondPlayerWinsOnePoint() {
		firstPlayer.winsPoints(4);
		secondPlayer.winsPoints(1);
		assertThat(tennisGame.getScore(), is(firstPlayer.getName() + WINS));
	}

	@Test
	public void scoreShouldBeFirstPlayerWinsWhenFirstPlayerWinsTenPointsAndSecondPlayerWinsEightPoints() {
		firstPlayer.winsPoints(10);
		secondPlayer.winsPoints(8);
		assertThat(tennisGame.getScore(), is(firstPlayer.getName() + WINS));
	}

}
