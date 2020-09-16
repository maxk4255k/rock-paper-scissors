package com.example.rockpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    //private String getNameString;
    //private String getNameStrongEndGame;

    private TextView getName;
    private TextView scoreTextUser;
    private TextView scoreTextAi;
    private TextView textUserWinOrLose;

    private Button rockButton;
    private Button paperButton;
    private Button scisssorsButton;

    private ImageView imageViewUserResult;
    private ImageView imageViewAIResult;
    private ImageView userCharecter;

    private int UserRock = 0;
    private int UserPaper = 1;
    private int UserScissors = 2;
    private int AIRock = 0;
    private int AIPaper = 1;
    private int AIScissors = 2;
    private int UserScore = 0;
    private int AIScore = 0;
    private int getNumCha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        rockButton = (Button) findViewById(R.id.rockButton);
        paperButton = (Button) findViewById(R.id.paperButton);
        scisssorsButton = (Button) findViewById(R.id.scissorsButton);

        imageViewUserResult = (ImageView) findViewById(R.id.imageViewUserResult);
        imageViewAIResult = (ImageView) findViewById(R.id.imageViewAIResult);
        userCharecter = (ImageView) findViewById(R.id.userCharecter);

        scoreTextUser = (TextView) findViewById(R.id.scoreIntUser);
        scoreTextAi = (TextView) findViewById(R.id.scoreIntAi);
        textUserWinOrLose = (TextView) findViewById(R.id.textUserWinOrLose);
        getName = (TextView) findViewById(R.id.getName);

        //getNameString = getIntent().getExtras().getString("fromSelectClass");
        //getNameStrongEndGame = getIntent().getExtras().getString("sendNametoGameActivity");
        getNumCha = getIntent().getExtras().getInt("numCha");
        userCharecterImage();
        getName.setText(MainActivity.inputNameString);
        //getName.setText(getNameStrongEndGame);
        buttonEffect(rockButton);
        buttonEffect(paperButton);
        buttonEffect(scisssorsButton);

        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewUserResult.setImageResource(R.drawable.newrock);
                imageViewUserResult.setRotation(55);
                final int[] Value = roll(UserRock);
                rockButton.setEnabled(false);
                paperButton.setEnabled(false);
                scisssorsButton.setEnabled(false);
                final Handler handler = new Handler();
                Timer timer2 = new Timer();
                TimerTask testing = new TimerTask() {
                    public void run() {
                        handler.post(new Runnable() {
                            public void run() {
                                imageViewUserResult.setImageDrawable(null);
                                imageViewAIResult.setImageDrawable(null);
                                paperButton.setEnabled(true);
                                scisssorsButton.setEnabled(true);
                                rockButton.setEnabled(true);
                                imageViewUserResult.setRotation(10);
                                imageViewUserResult.setImageResource(R.drawable.newrock);
                                imageViewAIResult.setImageResource(R.drawable.newrock);
                                imageViewAIResult.setRotation(-10);
                                scoreTextAi.setText(String.valueOf(Value[0]));
                                scoreTextUser.setText(String.valueOf(Value[1]));
                                textUserWinOrLose.setText(null);
                                checkScoreToWinOrLose();
                            }
                        });
                    }
                };
                timer2.schedule(testing, 1800);
            }
        });
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewUserResult.setImageResource(R.drawable.newpaper);
                imageViewUserResult.setRotation(55);
                final int[] Value = roll(UserPaper);
                scisssorsButton.setEnabled(false);
                rockButton.setEnabled(false);
                paperButton.setEnabled(false);
                final Handler handler = new Handler();
                Timer timer2 = new Timer();
                TimerTask testing = new TimerTask() {
                    public void run() {
                        handler.post(new Runnable() {
                            public void run() {
                                imageViewUserResult.setImageDrawable(null);
                                imageViewAIResult.setImageDrawable(null);
                                scisssorsButton.setEnabled(true);
                                rockButton.setEnabled(true);
                                paperButton.setEnabled(true);
                                imageViewUserResult.setRotation(10);
                                imageViewUserResult.setImageResource(R.drawable.newrock);
                                imageViewAIResult.setImageResource(R.drawable.newrock);
                                imageViewAIResult.setRotation(-10);
                                scoreTextAi.setText(String.valueOf(Value[0]));
                                scoreTextUser.setText(String.valueOf(Value[1]));
                                textUserWinOrLose.setText(null);
                                checkScoreToWinOrLose();
                            }
                        });
                    }
                };
                timer2.schedule(testing, 1800);
            }
        });
        scisssorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewUserResult.setImageResource(R.drawable.newscissors);
                imageViewUserResult.setRotation(55);
                final int[] Value = roll(UserScissors);
                rockButton.setEnabled(false);
                paperButton.setEnabled(false);
                scisssorsButton.setEnabled(false);
                final Handler handler = new Handler();
                Timer timer2 = new Timer();
                TimerTask testing = new TimerTask() {
                    public void run() {
                        handler.post(new Runnable() {
                            public void run() {
                                imageViewUserResult.setImageDrawable(null);
                                imageViewAIResult.setImageDrawable(null);
                                rockButton.setEnabled(true);
                                paperButton.setEnabled(true);
                                scisssorsButton.setEnabled(true);
                                imageViewUserResult.setRotation(10);
                                imageViewUserResult.setImageResource(R.drawable.newrock);
                                imageViewAIResult.setImageResource(R.drawable.newrock);
                                imageViewAIResult.setRotation(-10);
                                scoreTextAi.setText(String.valueOf(Value[0]));
                                scoreTextUser.setText(String.valueOf(Value[1]));
                                textUserWinOrLose.setText(null);
                                checkScoreToWinOrLose();
                            }
                        });
                    }
                };
                timer2.schedule(testing, 1800);
            }
        });
    }
    private void userCharecterImage(){
        if (getNumCha == 1){
            userCharecter.setImageResource(R.drawable.happiness);
        }else if (getNumCha == 2){
            userCharecter.setImageResource(R.drawable.girl);
        }else if (getNumCha == 3){
            userCharecter.setImageResource(R.drawable.boy1);
        }else if (getNumCha == 4){
            userCharecter.setImageResource(R.drawable.boy);
        }else if (getNumCha == 5){
            userCharecter.setImageResource(R.drawable.dinosaur);
        }else  if (getNumCha == 6){
            userCharecter.setImageResource(R.drawable.bear);
        }
    }
    public static Random random = new Random();

    private int[] roll(int button){
        int AIresultINT = random.nextInt(3);
        if (AIresultINT == AIRock){
            imageViewAIResult.setImageResource(R.drawable.newrock);
            imageViewAIResult.setRotation(-55);
        } else if (AIresultINT == AIPaper){
            imageViewAIResult.setImageResource(R.drawable.newpaper);
            imageViewAIResult.setRotation(-55);
        } else if (AIresultINT == AIScissors){
            imageViewAIResult.setImageResource(R.drawable.newscissors);
            imageViewAIResult.setRotation(-55);
        }

        if (button == AIresultINT){
            textUserWinOrLose.setText("เสมอ");
        }else if (button == UserRock){
            if (AIresultINT == AIPaper){
                AIScore++;
                textUserWinOrLose.setText("คุณแพ้");
            }else if (AIresultINT == AIScissors){
                UserScore++;
                textUserWinOrLose.setText("คุณชนะ");
            }
        }else if (button == UserPaper){
            if (AIresultINT == AIRock){
                UserScore++;
                textUserWinOrLose.setText("คุณชนะ");
            }else if (AIresultINT == AIScissors){
                AIScore++;
                textUserWinOrLose.setText("คุณแพ้");
            }
        }else if (button == UserScissors){
            if (AIresultINT == AIRock){
                AIScore++;
                textUserWinOrLose.setText("คุณแพ้");
            }else if (AIresultINT == AIPaper){
                UserScore++;
                textUserWinOrLose.setText("คุณชนะ");
            }
        }return new int[] {AIScore,UserScore};
    }

    private static void buttonEffect(View button){
        button.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(Color.parseColor("#A6000000"), PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
    }
    private void checkScoreToWinOrLose(){
        if (UserScore == 5) {
            getWinnerActivity();
        }else if (AIScore == 5){
            getLoseActivity();
        }
    }
    private void getWinnerActivity(){
        Intent intent = new Intent(GameActivity.this,Winner.class);
        //intent.putExtra("endGame",getNameString);
        startActivity(intent);
    }
    private void getLoseActivity(){
        Intent intent = new Intent(GameActivity.this,Lose.class);
        startActivity(intent);
    }
}
