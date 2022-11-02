package com.example.quizdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreText;
    Button home;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreText=findViewById(R.id.scoreText);
        home=findViewById(R.id.homeBtn);

        Intent intent=getIntent();

        score=intent.getIntExtra("score",0);

        scoreText.setText("Total : "+score*5+"/"+"25");

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ScoreActivity.this,MainActivity.class));
                finish();

            }
        });
    }
}