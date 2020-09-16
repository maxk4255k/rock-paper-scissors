package com.example.rockpaper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class selectCharacter extends AppCompatActivity {
    //private ImageView character1;
    private ImageView selectcha1;
    private ImageView selectcha2;
    private ImageView selectcha3;
    private ImageView selectcha4;
    private ImageView selectcha5;
    private ImageView selectcha6;
    private Button buttonSelect1;
    private Button buttonSelect2;
    private Button buttonSelect3;
    private Button buttonSelect4;
    private Button buttonSelect5;
    private Button buttonSelect6;
    private Button buttonPlay;

    private String getNameFromMain;
    private String getNameEndGame;
    private int numberCharecter;

    int myColor = Color.parseColor("#3F51B5");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_character);
        selectcha1 = (ImageView) findViewById(R.id.selectcha1);
        selectcha2 = (ImageView) findViewById(R.id.selectcha2);
        selectcha3 = (ImageView) findViewById(R.id.selectcha3);
        selectcha4 = (ImageView) findViewById(R.id.selectcha4);
        selectcha5 = (ImageView) findViewById(R.id.selectcha5);
        selectcha6 = (ImageView) findViewById(R.id.selectcha6);

        buttonSelect1 = (Button) findViewById(R.id.buttonSelect1);
        buttonSelect2 = (Button) findViewById(R.id.buttonSelect2);
        buttonSelect3 = (Button) findViewById(R.id.buttonSelect3);
        buttonSelect4 = (Button) findViewById(R.id.buttonSelect4);
        buttonSelect5 = (Button) findViewById(R.id.buttonSelect5);
        buttonSelect6 = (Button) findViewById(R.id.buttonSelect6);
        buttonPlay = (Button) findViewById(R.id.buttonPlay);

        selectcha1.setVisibility(View.INVISIBLE);
        selectcha2.setVisibility(View.INVISIBLE);
        selectcha3.setVisibility(View.INVISIBLE);
        selectcha4.setVisibility(View.INVISIBLE);
        selectcha5.setVisibility(View.INVISIBLE);
        selectcha6.setVisibility(View.INVISIBLE);

        //getNameFromMain = getIntent().getExtras().getString("inputName");
        //getNameEndGame = getIntent().getExtras().getString("sendNametoChaActivity");

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberCharecter = getCharecter();
                if (getCharecter()>0){
                    getGameActivity();
                }else {
                    alertDialog();
                }
            }
        });
        buttonSelect1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectIFCha(1);
            }
        });
        buttonSelect2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectIFCha(2);
            }
        });
        buttonSelect3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectIFCha(3);
            }
        });
        buttonSelect4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectIFCha(4);
            }
        });
        buttonSelect5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectIFCha(5);
            }
        });
        buttonSelect6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectIFCha(6);
            }
        });

    }
    private void getGameActivity(){
        Intent intent = new Intent(selectCharacter.this, GameActivity.class);
        intent.putExtra("fromSelectClass",getNameFromMain);
        intent.putExtra("sendNametoGameActivity",getNameEndGame);
        intent.putExtra("numCha",numberCharecter);
        startActivity(intent);
    }

    private int getCharecter(){
        int numberCharecter = 0;
        if (selectcha1.getVisibility() == View.VISIBLE){
            numberCharecter = 1;
        }else if (selectcha2.getVisibility() == View.VISIBLE){
            numberCharecter = 2;
        }else if (selectcha3.getVisibility() == View.VISIBLE){
            numberCharecter = 3;
        }else if (selectcha4.getVisibility() == View.VISIBLE){
            numberCharecter = 4;
        }else if (selectcha5.getVisibility() == View.VISIBLE){
            numberCharecter = 5;
        }else if (selectcha6.getVisibility() == View.VISIBLE){
            numberCharecter = 6;
        }
        return numberCharecter;
    }

    private void alertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(selectCharacter.this);
        builder.setTitle("");
        builder.setMessage("กรุณาเลือกตัวละคร");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }


    public void demo(int button) {
        if (button == 1) {
            if (selectcha2.getVisibility() == View.VISIBLE) {
                selectcha2.setVisibility(View.INVISIBLE);
                selectcha1.setVisibility(View.VISIBLE);
            }
        }
    }

    public void selectIFCha(int button) {
        if (button == 1) {
            if (selectcha2.getVisibility() == View.VISIBLE) {
                selectcha2.setVisibility(View.INVISIBLE);
                selectcha1.setVisibility(View.VISIBLE);
            } else if (selectcha3.getVisibility() == View.VISIBLE) {
                selectcha3.setVisibility(View.INVISIBLE);
                selectcha1.setVisibility(View.VISIBLE);
            } else if (selectcha4.getVisibility() == View.VISIBLE) {
                selectcha4.setVisibility(View.INVISIBLE);
                selectcha1.setVisibility(View.VISIBLE);
            } else if (selectcha5.getVisibility() == View.VISIBLE) {
                selectcha5.setVisibility(View.INVISIBLE);
                selectcha1.setVisibility(View.VISIBLE);
            } else if (selectcha6.getVisibility() == View.VISIBLE) {
                selectcha6.setVisibility(View.INVISIBLE);
                selectcha1.setVisibility(View.VISIBLE);
            } else {
                selectcha1.setVisibility(View.VISIBLE);
            }
        }
            if (button == 2) {
                if (selectcha1.getVisibility() == View.VISIBLE) {
                    selectcha1.setVisibility(View.INVISIBLE);
                    selectcha2.setVisibility(View.VISIBLE);
                } else if (selectcha3.getVisibility() == View.VISIBLE) {
                    selectcha3.setVisibility(View.INVISIBLE);
                    selectcha2.setVisibility(View.VISIBLE);
                } else if (selectcha4.getVisibility() == View.VISIBLE) {
                    selectcha4.setVisibility(View.INVISIBLE);
                    selectcha2.setVisibility(View.VISIBLE);
                } else if (selectcha5.getVisibility() == View.VISIBLE) {
                    selectcha5.setVisibility(View.INVISIBLE);
                    selectcha2.setVisibility(View.VISIBLE);
                } else if (selectcha6.getVisibility() == View.VISIBLE) {
                    selectcha6.setVisibility(View.INVISIBLE);
                    selectcha2.setVisibility(View.VISIBLE);
                } else {
                    selectcha2.setVisibility(View.VISIBLE);
                }
            }
        if (button == 3) {
            if (selectcha1.getVisibility() == View.VISIBLE) {
                selectcha1.setVisibility(View.INVISIBLE);
                selectcha3.setVisibility(View.VISIBLE);
            } else if (selectcha2.getVisibility() == View.VISIBLE) {
                selectcha2.setVisibility(View.INVISIBLE);
                selectcha3.setVisibility(View.VISIBLE);
            } else if (selectcha4.getVisibility() == View.VISIBLE) {
                selectcha4.setVisibility(View.INVISIBLE);
                selectcha3.setVisibility(View.VISIBLE);
            } else if (selectcha5.getVisibility() == View.VISIBLE) {
                selectcha5.setVisibility(View.INVISIBLE);
                selectcha3.setVisibility(View.VISIBLE);
            } else if (selectcha6.getVisibility() == View.VISIBLE) {
                selectcha6.setVisibility(View.INVISIBLE);
                selectcha3.setVisibility(View.VISIBLE);
            } else {
                selectcha3.setVisibility(View.VISIBLE);
            }
        }
        if (button == 4) {
            if (selectcha1.getVisibility() == View.VISIBLE) {
                selectcha1.setVisibility(View.INVISIBLE);
                selectcha4.setVisibility(View.VISIBLE);
            } else if (selectcha2.getVisibility() == View.VISIBLE) {
                selectcha2.setVisibility(View.INVISIBLE);
                selectcha4.setVisibility(View.VISIBLE);
            } else if (selectcha3.getVisibility() == View.VISIBLE) {
                selectcha3.setVisibility(View.INVISIBLE);
                selectcha4.setVisibility(View.VISIBLE);
            } else if (selectcha5.getVisibility() == View.VISIBLE) {
                selectcha5.setVisibility(View.INVISIBLE);
                selectcha4.setVisibility(View.VISIBLE);
            } else if (selectcha6.getVisibility() == View.VISIBLE) {
                selectcha6.setVisibility(View.INVISIBLE);
                selectcha4.setVisibility(View.VISIBLE);
            } else {
                selectcha4.setVisibility(View.VISIBLE);
            }
        }
        if (button == 5) {
            if (selectcha1.getVisibility() == View.VISIBLE) {
                selectcha1.setVisibility(View.INVISIBLE);
                selectcha5.setVisibility(View.VISIBLE);
            } else if (selectcha2.getVisibility() == View.VISIBLE) {
                selectcha2.setVisibility(View.INVISIBLE);
                selectcha5.setVisibility(View.VISIBLE);
            } else if (selectcha3.getVisibility() == View.VISIBLE) {
                selectcha3.setVisibility(View.INVISIBLE);
                selectcha5.setVisibility(View.VISIBLE);
            } else if (selectcha4.getVisibility() == View.VISIBLE) {
                selectcha4.setVisibility(View.INVISIBLE);
                selectcha5.setVisibility(View.VISIBLE);
            } else if (selectcha6.getVisibility() == View.VISIBLE) {
                selectcha6.setVisibility(View.INVISIBLE);
                selectcha5.setVisibility(View.VISIBLE);
            } else {
                selectcha5.setVisibility(View.VISIBLE);
            }
        }
        if (button == 6) {
            if (selectcha1.getVisibility() == View.VISIBLE) {
                selectcha1.setVisibility(View.INVISIBLE);
                selectcha6.setVisibility(View.VISIBLE);
            } else if (selectcha2.getVisibility() == View.VISIBLE) {
                selectcha2.setVisibility(View.INVISIBLE);
                selectcha6.setVisibility(View.VISIBLE);
            } else if (selectcha3.getVisibility() == View.VISIBLE) {
                selectcha3.setVisibility(View.INVISIBLE);
                selectcha6.setVisibility(View.VISIBLE);
            } else if (selectcha4.getVisibility() == View.VISIBLE) {
                selectcha4.setVisibility(View.INVISIBLE);
                selectcha6.setVisibility(View.VISIBLE);
            } else if (selectcha5.getVisibility() == View.VISIBLE) {
                selectcha5.setVisibility(View.INVISIBLE);
                selectcha6.setVisibility(View.VISIBLE);
            } else {
                selectcha6.setVisibility(View.VISIBLE);
            }
        }
        }
    }