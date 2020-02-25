package com.bnpp.kata.tennisgame;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.bnpp.kata.tennisgame.exceptions.InvalidPointsException;

public class TennisGameTest {

	private static final String PLAYER_POINTS_ARE_INVALID = "Player points are invalid";
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

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void setUp() {
		firstPlayer = new Player("Pete Sampras");
		secondPlayer = new Player("Andre Agassi");
		tennisGame = new TennisGame(firstPlayer, secondPlayer);
	}

	@Test
	public void scoreShouldBeLoveAllBeforeTennisGameBegins()
			throws InvalidPointsException {
		assertThat(tennisGame.getScore(), is(LOVE_ALL));
	}

	@Test
	public void scoreShouldBeFifteenLoveWhenFirstPlayerWinsOnePoint()
			throws InvalidPointsException {
		firstPlayer.winsPoint();
		assertThat(tennisGame.getScore(), is(FIFTEEN_LOVE));
	}

	@Test
	public void scoreShouldBeLoveFifteenWhenSecondPlayerWinsOnePoint()
			throws InvalidPointsException {
		secondPlayer.winsPoint();
		assertThat(tennisGame.getScore(), is(LOVE_FIFTEEN));
	}

	@Test
	public void scoreShouldBeFifteenAllWhenBothPlayersWinOnePoint()
			throws InvalidPointsException {
		firstPlayer.winsPoint();
		secondPlayer.winsPoint();
		assertThat(tennisGame.getScore(), is(FIFTEEN_ALL));
	}

	@Test
	public void scoreShouldBeFortyThirtyWhenFirstPlayerWinsThreePointsAndSecondPlayerWinsTwoPoints()
			throws InvalidPointsException {
		firstPlayer.winsPoints(3);
		secondPlayer.winsPoints(2);
		assertThat(tennisGame.getScore(), is(FORTY_THIRTY));
	}

	@Test
	public void scoreShouldBeDeuceWhenBothPlayersWinThreePoints()
			throws InvalidPointsException {
		firstPlayer.winsPoints(3);
		secondPlayer.winsPoints(3);
		assertThat(tennisGame.getScore(), is(DEUCE));
	}

	@Test
	public void scoreShouldBeDeuceWhenBothPlayersWinSevenPoints()
			throws InvalidPointsException {
		firstPlayer.winsPoints(7);
		secondPlayer.winsPoints(7);
		assertThat(tennisGame.getScore(), is(DEUCE));
	}

	@Test
	public void scoreShouldBeAdvantageSecondPlayerWhenFirstPlayerWinsThreePointsAndSecondPlayerWinsFourPoints()
			throws InvalidPointsException {
		firstPlayer.winsPoints(3);
		secondPlayer.winsPoints(4);
		assertThat(tennisGame.getScore(),
				is(ADVANTAGE + secondPlayer.getName()));
	}

	@Test
	public void scoreShouldBeAdvantageSecondPlayerWhenFirstPlayerWinsTenPointsAndSecondPlayerWinsElevenPoints()
			throws InvalidPointsException {
		firstPlayer.winsPoints(10);
		secondPlayer.winsPoints(11);
		assertThat(tennisGame.getScore(),
				is(ADVANTAGE + secondPlayer.getName()));
	}

	@Test
	public void scoreShouldBeAdvantageFirstPlayerWhenFirstPlayerWinsSixPointsAndSecondPlayerWinsFivePoints()
			throws InvalidPointsException {
		firstPlayer.winsPoints(6);
		secondPlayer.winsPoints(5);
		assertThat(tennisGame.getScore(), is(ADVANTAGE + firstPlayer.getName()));
	}

	@Test
	public void scoreShouldBeFirstPlayerWinsWhenFirstPlayerWinsFourPointsAndSecondPlayerWinsOnePoint()
			throws InvalidPointsException {
		firstPlayer.winsPoints(4);
		secondPlayer.winsPoints(1);
		assertThat(tennisGame.getScore(), is(firstPlayer.getName() + WINS));
	}

	@Test
	public void scoreShouldBeFirstPlayerWinsWhenFirstPlayerWinsTenPointsAndSecondPlayerWinsEightPoints()
			throws InvalidPointsException {
		firstPlayer.winsPoints(10);
		secondPlayer.winsPoints(8);
		assertThat(tennisGame.getScore(), is(firstPlayer.getName() + WINS));
	}

	@Test
	public void scoreShouldBeSecondPlayerWinsWhenFirstPlayerWinsThreePointsAndSecondPlayerWinsFivePoints()
			throws InvalidPointsException {
		firstPlayer.winsPoints(3);
		secondPlayer.winsPoints(5);
		assertThat(tennisGame.getScore(), is(secondPlayer.getName() + WINS));
	}

	@Test
	public void scoreShouldThrowInvalidPointsExceptionWhenFirstPlayerWinsSevenPointsAndSecondPlayerWinsTenPoints()
			throws InvalidPointsException {

		exceptionRule.expect(InvalidPointsException.class);
		exceptionRule.expectMessage(PLAYER_POINTS_ARE_INVALID);

		firstPlayer.winsPoints(7);
		secondPlayer.winsPoints(10);
		tennisGame.getScore();
	}

}
