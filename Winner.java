package com.example.rockpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Winner extends AppCompatActivity {
    private Button button;
    //private String getNameString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        button = (Button) findViewById(R.id.buttonLose);
        //getNameString = getIntent().getExtras().getString("endGame");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCharacterActivity();
            }
        });
    }
    private void getCharacterActivity(){
        Intent intent = new Intent(Winner.this,selectCharacter.class);
        //intent.putExtra("sendNametoChaActivity",getNameString);
        startActivity(intent);
    }
}
