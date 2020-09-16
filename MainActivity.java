package com.example.rockpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText inputName;
    private Button buttonLetgo;
    public static String inputNameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputName = (EditText) findViewById(R.id.inputName);
        buttonLetgo = (Button) findViewById(R.id.buttonLetgo);
        buttonLetgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputNameString = inputName.getText().toString();
                getSelectChaActivity();
            }
        });
        }
        public void getSelectChaActivity(){
            Intent intent = new Intent(MainActivity.this,selectCharacter.class);
            //intent.putExtra("inputName",inputNameString);
            startActivity(intent);
        }
    }

