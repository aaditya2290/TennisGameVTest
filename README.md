# Tennis Game

This Tennis Game KATA is being implemented in Java with Maven and JUnit following TDD (Test Driven Development) approach. It is a program which takes the player names and player points as input and returns the score for the tennis game. 
Here tennis game has been condensed into a set where there are 4 possible scores for a player:

0-Love

1-Fifteen

2-Thirty

3-Forty

If both players have same score then it is represented as [Player Score] All. Eg. Love All, Thirty All as long as no player exceeds 2 points. The first player to score 4 points with a lead of 2 or more points wins the same. There are two exceptional score scenarios also possible in a game:

Deuce - Both players score same number of points and their points are greater than or equal to 3 (score:Forty).

Advantage - Player points are greater than or equal to 3 and one player leads by a single point.The leading player has the advantage.

Eg. If first player has 5 points and second player has 6 points, the game score will be Advantage second player.

## Prerequisities:

1. Java - Version 1.6 or higher
2. Maven - Dependency management
3. JUnit - Version 4.12 (added in pom.xml)
4. Eclipse or any other IDE which supports Java (optional)
