package com.example.android.tennisscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int setPlayerA = 0;
    int setPlayerB = 0;
    int gamePlayerA = 0;
    int gamePlayerB = 0;
    int pointsPlayerA = 0;
    int pointsPlayerB = 0;
    int aceA = 0;
    int aceB = 0;
    String points = "Points";
    String win = "Winner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForPlayerAPoints(0);
        displayForPlayerBPoints(0);

    }

    /**
     * Resets the score for both players.
     */
    public void reset(View view) {
        pointsPlayerA = 0;
        pointsPlayerB = 0;
        gamePlayerA = 0;
        gamePlayerB = 0;
        setPlayerA = 0;
        setPlayerB = 0;
        aceA = 0;
        aceB = 0;
        displayForAceA(aceA);
        displayForAceB(aceB);
        displayForPlayerAPoints(pointsPlayerA);
        displayForPlayerBPoints(pointsPlayerB);
        displayForPlayerAGame(gamePlayerA);
        displayForPlayerBGame(gamePlayerB);
        displayForPlayerASet(setPlayerA);
        displayForPlayerBSet(setPlayerB);
        Button playerA = (Button) findViewById(R.id.addA);
        playerA.setEnabled(true);
        Button playerB = (Button) findViewById(R.id.addB);
        playerB.setEnabled(true);

    }

    /**
     * Counts points,games,sets for Player A.
     */
    public void pointTrackerA(View view) {

        pointsPlayerA++;
        displayForPlayerAPoints(pointsPlayerA);

        if (gamePlayerA != 6 || gamePlayerB != 6) {


            if (pointsPlayerA == 1) {
                displayForPlayerAPoints(15);
            }
            if (pointsPlayerA == 2) {
                displayForPlayerAPoints(30);
            }
            if (pointsPlayerA == 3) {
                displayForPlayerAPoints(40);
            }

            if (pointsPlayerA >= 4 && pointsPlayerA >= pointsPlayerB + 2) {

                gamePlayerA++;
                displayForPlayerAGame(gamePlayerA);
                pointsPlayerA = 0;
                pointsPlayerB = 0;
                displayForPlayerAPoints(pointsPlayerA);
                displayForPlayerBPoints(pointsPlayerB);

                if (gamePlayerA > 5 && gamePlayerA >= gamePlayerB + 2) {
                    setPlayerA++;
                    displayForPlayerASet(setPlayerA);
                }
                if (gamePlayerB > 5 && gamePlayerB >= gamePlayerA + 2) {
                    setPlayerB++;
                    displayForPlayerBSet(setPlayerB);
                }
                if (gamePlayerA > 5 && gamePlayerA >= gamePlayerB + 2) {
                    gamePlayerA = 0;
                    gamePlayerB = 0;
                    pointsPlayerA = 0;
                    pointsPlayerB = 0;
                    displayForPlayerAGame(gamePlayerA);
                    displayForPlayerBGame(gamePlayerB);
                    displayForPlayerAPoints(pointsPlayerA);
                    displayForPlayerBPoints(pointsPlayerB);
                }
                if (setPlayerA == 3) {
                    displayForPlayerASetWin(win);
                    Button player2 = findViewById(R.id.addA);
                    player2.setEnabled(false);
                    Button player1 = findViewById(R.id.addB);
                    player1.setEnabled(false);
                }
            }

            if (pointsPlayerA >= 4 && pointsPlayerA == pointsPlayerB + 1) {
                if (pointsPlayerA == pointsPlayerB + 1) {
                    String Ad = "Ad for Player A";
                    displayForPlayerA(Ad);
                }
            }
            if (pointsPlayerA >= 4 && pointsPlayerA == pointsPlayerB) {
                displayForPlayerAPoints(40);
                displayForPlayerBPoints(40);
            }

        }
        if (gamePlayerA == 6 && gamePlayerB == 6) {

            points = "Tie - break";
            displayForPoints(points);

            if (pointsPlayerA > 6 && pointsPlayerA >= pointsPlayerB + 2) {
                setPlayerA++;
                displayForPlayerASet(setPlayerA);
            }
            if (pointsPlayerB > 6 && pointsPlayerB >= pointsPlayerA + 2) {
                setPlayerB++;
                displayForPlayerBSet(setPlayerB);
            }
            if (pointsPlayerA > 6 && pointsPlayerA >= pointsPlayerB + 2) {
                gamePlayerA = 0;
                gamePlayerB = 0;
                pointsPlayerA = 0;
                pointsPlayerB = 0;
                points = "Points";
                displayForPoints(points);
                displayForPlayerAGame(gamePlayerA);
                displayForPlayerBGame(gamePlayerB);
                displayForPlayerAPoints(pointsPlayerA);
                displayForPlayerBPoints(pointsPlayerB);
            }
        }
    }

    /**
     * Counts points,games,sets for Player B.
     */
    public void pointTrackerB(View view) {

        pointsPlayerB++;
        displayForPlayerBPoints(pointsPlayerB);

        if (gamePlayerA != 6 || gamePlayerB != 6) {


            if (pointsPlayerB == 1) {
                displayForPlayerBPoints(15);
            }
            if (pointsPlayerB == 2) {
                displayForPlayerBPoints(30);
            }
            if (pointsPlayerB == 3) {
                displayForPlayerBPoints(40);
            }

            if (pointsPlayerB >= 4 && pointsPlayerB >= pointsPlayerA + 2) {

                gamePlayerB = gamePlayerB + 1;
                displayForPlayerBGame(gamePlayerB);
                pointsPlayerA = 0;
                pointsPlayerB = 0;
                displayForPlayerAPoints(pointsPlayerA);
                displayForPlayerBPoints(pointsPlayerB);

                if (gamePlayerB > 5 && gamePlayerB >= gamePlayerA + 2) {
                    setPlayerB++;
                    displayForPlayerBSet(setPlayerB);
                }
                if (gamePlayerA > 5 && gamePlayerA >= gamePlayerB + 2) {
                    setPlayerA++;
                    displayForPlayerASet(setPlayerA);
                }
                if (gamePlayerB > 5 && gamePlayerB >= gamePlayerA + 2) {
                    gamePlayerA = 0;
                    gamePlayerB = 0;
                    pointsPlayerA = 0;
                    pointsPlayerB = 0;
                    displayForPlayerAGame(gamePlayerA);
                    displayForPlayerBGame(gamePlayerB);
                    displayForPlayerAPoints(pointsPlayerA);
                    displayForPlayerBPoints(pointsPlayerB);
                }
                if (setPlayerB == 3) {
                    displayForPlayerBSetWin(win);
                    Button playerB = findViewById(R.id.addB);
                    playerB.setEnabled(false);
                    Button playerA = findViewById(R.id.addA);
                    playerA.setEnabled(false);
                }
            }

            if (pointsPlayerB >= 4 && pointsPlayerB == pointsPlayerA + 1) {
                if (pointsPlayerB == pointsPlayerA + 1) {
                    String Ad = "Ad for Player B";
                    displayForPlayerB(Ad);
                }
            }
            if (pointsPlayerB >= 4 && pointsPlayerB == pointsPlayerA) {
                displayForPlayerAPoints(40);
                displayForPlayerBPoints(40);
            }

        }
        if (gamePlayerA == 6 && gamePlayerB == 6) {

            points = "Tie - break";
            displayForPoints(points);


            if (pointsPlayerB > 6 && pointsPlayerB >= pointsPlayerA + 2) {
                setPlayerB++;
                displayForPlayerBSet(setPlayerB);
            }
            if (pointsPlayerA > 6 && pointsPlayerA >= pointsPlayerB + 2) {
                setPlayerA++;
                displayForPlayerASet(setPlayerA);
            }
            if (pointsPlayerB > 6 && pointsPlayerB >= pointsPlayerA + 2) {
                gamePlayerA = 0;
                gamePlayerB = 0;
                pointsPlayerA = 0;
                pointsPlayerB = 0;
                points = "Points";
                displayForPoints(points);
                displayForPlayerAGame(gamePlayerA);
                displayForPlayerBGame(gamePlayerB);
                displayForPlayerAPoints(pointsPlayerA);
                displayForPlayerBPoints(pointsPlayerB);
            }
        }
    }

    /**
     * Keeps record of service aces for Player A.
     */
    public void aceTrackerA(View view) {
        aceA++;
        displayForAceA(aceA);
    }

    /**
     * Keeps record of service aces for Player B.
     */
    public void aceTrackerB(View view) {
        aceB++;
        displayForAceB(aceB);
    }

    /**
     * Displays aces for Player A.
     */
    public void displayForAceA(int aceA) {
        TextView textView = (TextView) findViewById(R.id.ace_a);
        textView.setText(String.valueOf(aceA));
    }

    /**
     * Displays aces for Player B.
     */
    private void displayForAceB(int aceB) {
        TextView textView = (TextView) findViewById(R.id.ace_b);
        textView.setText(String.valueOf(aceB));
    }

    /**
     * Displays Ad for Player A.
     */
    private void displayForPlayerA(String Ad) {
        TextView textView = (TextView) findViewById(R.id.player_a_score);
        textView.setText(String.valueOf(Ad));
    }

    /**
     * Displays Ad for Player B.
     */
    private void displayForPlayerB(String Ad) {
        TextView textView = (TextView) findViewById(R.id.player_b_score);
        textView.setText(String.valueOf(Ad));
    }

    /**
     * Displays Points or Tie-Break depending.
     */
    private void displayForPoints(String Ad) {
        TextView textView = (TextView) findViewById(R.id.points);
        textView.setText(String.valueOf(points));
    }

    /**
     * Displays the given score(points) for PlayerA.
     */
    public void displayForPlayerAPoints(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score(points) for PlayerB.
     */
    public void displayForPlayerBPoints(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Player A set.
     */
    public void displayForPlayerASet(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_set);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays WINNER for Player A if he has won 3 sets.
     */
    public void displayForPlayerASetWin(String win) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_set);
        scoreView.setText(String.valueOf(win));
    }

    /**
     * Displays the given score for Player B set.
     */
    public void displayForPlayerBSet(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_set);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays WINNER for Player B if he has won 3 sets.
     */
    public void displayForPlayerBSetWin(String win) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_set);
        scoreView.setText(String.valueOf(win));
    }

    /**
     * Displays the given score for Player A game.
     */
    public void displayForPlayerAGame(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_game);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Player B game.
     */
    public void displayForPlayerBGame(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_game);
        scoreView.setText(String.valueOf(score));
    }

}
