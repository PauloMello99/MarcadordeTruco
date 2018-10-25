package br.edu.fatec.aula1.marcadordetruco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private TextView scoreTeamATextView;
    private int scoreTeamA;
    private TextView scoreTeamBTextView;
    private int scoreTeamB;
    private Button buttonOneA;
    private Button buttonThreeA;
    private Button buttonSixA;
    private Button buttonNineA;
    private Button buttonTwelveA;
    private Button buttonOneB;
    private Button buttonThreeB;
    private Button buttonSixB;
    private Button buttonNineB;
    private Button buttonTwelveB;
    private Button buttonReset;
    private Button backA;
    private Button backB;
    private Stack stackA = new Stack();
    private Stack stackB = new Stack();
    private int scoreMinusA, scoreMinusB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreTeamA = 0;
        scoreTeamB = 0;
        scoreTeamBTextView = findViewById(R.id.score_team_b);
        scoreTeamATextView = findViewById(R.id.score_team_a);
        buttonOneA = findViewById(R.id.buttonAddOneA);
        buttonOneB = findViewById(R.id.buttonAddOneB);
        buttonThreeA = findViewById(R.id.buttonAddThreeA);
        buttonThreeB = findViewById(R.id.buttonAddThreeB);
        buttonSixA = findViewById(R.id.buttonAddSixA);
        buttonSixB = findViewById(R.id.buttonAddSixB);
        buttonNineA = findViewById(R.id.buttonAddNineA);
        buttonNineB = findViewById(R.id.buttonAddNineB);
        buttonTwelveA = findViewById(R.id.buttonAddTwelveA);
        buttonTwelveB = findViewById(R.id.buttonAddTwelveB);
        buttonReset = findViewById(R.id.buttonReset);
        backA = findViewById(R.id.stackA);
        backB = findViewById(R.id.stackB);
    }

    public void addOneTeamA(View v) {
        addScore("A",1);
    }

    public void addOneTeamB(View v) {
        addScore("B",1);
    }

    public void addThreeTeamA(View v) {
        addScore("A",3);
    }

    public void addThreeTeamB(View v) {
        addScore("B",3);
    }

    public void addSixTeamA(View v) {
        addScore("A",6);
    }

    public void addSixTeamB(View v) {
        addScore("B",6);
    }

    public void addNineTeamA(View v) {
        addScore("A",9);
    }

    public void addNineTeamB(View v) {
        addScore("B",9);
    }

    public void addTwelveTeamA(View v) { addScore("A",12); }

    public void addTwelveTeamB(View v) {
        addScore("B",12);
    }

    public void reset(View v)
    {
        buttonOneA.setEnabled(true);
        buttonOneB.setEnabled(true);
        buttonThreeA.setEnabled(true);
        buttonThreeB.setEnabled(true);
        buttonSixA.setEnabled(true);
        buttonSixB.setEnabled(true);
        buttonNineA.setEnabled(true);
        buttonNineB.setEnabled(true);
        buttonTwelveA.setEnabled(true);
        buttonTwelveB.setEnabled(true);
        scoreTeamA =0;
        scoreTeamB =0;
        scoreTeamATextView.setText(String.valueOf(scoreTeamA));
        scoreTeamBTextView.setText(String.valueOf(scoreTeamB));
        while(!stackA.empty()){
            stackA.pop();
        }
        while(!stackB.empty()){
            stackB.pop();
        }
    }

    public void addScore(String team, int score)
    {
        if(team.equals("A"))
        {
            stackA.push(score);
            scoreTeamA += score;
            if(scoreTeamA>=12) {
                scoreTeamA=12;
                gameover();
                Toast.makeText(this, "Grupo A ganhou!!!", Toast.LENGTH_SHORT).show();
            }
            scoreTeamATextView.setText(String.valueOf(scoreTeamA));
        }
        else
        {
            stackB.push(score);
            scoreTeamB += score;
            if(scoreTeamB>=12)
            {
                scoreTeamB=12;
                gameover();
                Toast.makeText(this, "Grupo B ganhou!!!", Toast.LENGTH_SHORT).show();
            }
            scoreTeamBTextView.setText(String.valueOf(scoreTeamB));
        }
    }

    public void gameover()
    {
        buttonOneA.setEnabled(false);
        buttonOneB.setEnabled(false);
        buttonThreeA.setEnabled(false);
        buttonThreeB.setEnabled(false);
        buttonSixA.setEnabled(false);
        buttonSixB.setEnabled(false);
        buttonNineA.setEnabled(false);
        buttonNineB.setEnabled(false);
        buttonTwelveA.setEnabled(false);
        buttonTwelveB.setEnabled(false);
        backA.setEnabled(false);
        backB.setEnabled(false);
    }

    public void stackAtA(View view) {
        minusScoreA();
    }

    public void stackAtB(View view) {
        minusScoreB();
    }

    public void minusScoreA() {
        if (!stackA.empty()) {
            backA.setEnabled(true);
            scoreMinusA = Integer.parseInt(String.valueOf(stackA.lastElement()));
            scoreTeamA = scoreTeamA - scoreMinusA;
            stackA.pop();
            scoreTeamATextView.setText(String.valueOf(scoreTeamA));
        }
    }

    public void minusScoreB() {
        if (!stackB.empty()) {
            backB.setEnabled(true);
            scoreMinusB = Integer.parseInt(String.valueOf(stackB.lastElement()));
            scoreTeamB = scoreTeamB - scoreMinusB;
            stackB.pop();
            scoreTeamBTextView.setText(String.valueOf(scoreTeamB));
        }
    }
}
