package com.example.quizdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class QuizActivity extends AppCompatActivity {

    ArrayList<DataModel> list;
    TextView question,scoreText,questionCounterTextview,categoriesText,difficultyText;
    int score=0;
    List<DataModel> data;
    private int questionCounterTotal;
    private int questionCounter=1;
    ArrayList<String> incorrectAns;
    private boolean answer=false;
    int currentCount=1;


    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Button buttonConfirmNext;

    String difficultyResponse;
    String  categoriesResponse;

    ArrayList<String> ctg;

    String isCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        init();
        ctg=new ArrayList<>();
        list=new ArrayList<>();
        Intent intent=getIntent();
        String categories=intent.getStringExtra("categories");
        String difficulty=intent.getStringExtra("difficulty");

        if (!categories.isEmpty() && !difficulty.isEmpty()){

            difficultyText.setVisibility(View.VISIBLE);
            difficultyText.setText("Difficulty : "+difficulty);

            categoriesText.setVisibility(View.VISIBLE);
            categoriesText.setText("Categories : "+categories);
        }





        Call<List<DataModel>> call=Retrofit_Client
                .getInstance()
                .getApi()
                .fetchAllQuestion(5,categories,difficulty);

        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {

                if (response.isSuccessful()){

                    data=response.body();


                   for (int i=0; i<data.size(); i++){

                       categoriesResponse=data.get(i).category;

                       if (categories.equals(categoriesResponse)){
                           ctg.add(categoriesResponse);
                       }

                       question.setText(data.get(i).question);
                       questionCounterTotal=data.size();
                       questionCounterTextview.setText("Question : 1/"+questionCounterTotal);
                     //radioButton1.setText(data.get(i).correctAnswer);
                       // Toast.makeText(QuizActivity.this, "Answer : "+data.get(i).correctAnswer, Toast.LENGTH_SHORT).show();

                       isCorrect=data.get(i).correctAnswer;
                       incorrectAns=data.get(i).incorrectAnswers;
                       incorrectAns.add(data.get(i).correctAnswer);


                       for (int j=0; j<incorrectAns.size();j++ ){

                           radioButton1.setText(incorrectAns.get(3));
                           radioButton2.setText(incorrectAns.get(0));
                           radioButton3.setText(incorrectAns.get(1));
                           radioButton4.setText(incorrectAns.get(2));

                       }
                      // Toast.makeText(QuizActivity.this, "question : "+data.get(i).question, Toast.LENGTH_SHORT).show();
                   }
                }
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {

                Toast.makeText(QuizActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (radioButton1.isChecked() || radioButton2.isChecked() || radioButton3.isChecked()|| radioButton4.isChecked()) {

                    checkAnswer();
                    showNextQuestion();

                } else {
                    Toast.makeText(QuizActivity.this, "please select an answer", Toast.LENGTH_SHORT).show();
                }

                /*if (radioButton1.isChecked()){
                    radioButton1.setSelected(false);
                    radioButton1.setChecked(false);

                }else {
                    radioButton1.setSelected(true);
                    radioButton1.setSelected(true);
                }*/
               /* if (!answer) {
                    if (radioButton1.isChecked() || radioButton2.isChecked() || radioButton3.isChecked()) {

                        checkAnswer();

                    } else {
                        Toast.makeText(QuizActivity.this, "please select an answer", Toast.LENGTH_SHORT).show();
                    }

                }else {

                    showNextQuestion();
                 //   Toast.makeText(QuizActivity.this, " test", Toast.LENGTH_SHORT).show();

                }*/
            }

        });

    }
    public void init(){

        question=findViewById(R.id.text_view_question);
        radioGroup=findViewById(R.id.radio_group);
        radioButton1=findViewById(R.id.radio_button1);
        radioButton2=findViewById(R.id.radio_button2);
        radioButton3=findViewById(R.id.radio_button3);
        radioButton4=findViewById(R.id.radio_button4);
        scoreText=findViewById(R.id.scoreTextViewId);
        questionCounterTextview=findViewById(R.id.questionCountTextId);
        categoriesText=findViewById(R.id.text_view_categories);
        difficultyText=findViewById(R.id.text_view_difficulty);
        buttonConfirmNext=findViewById(R.id.button_comfirm_next);
    }

    public void checkAnswer(){
        RadioButton rbSelected=findViewById(radioGroup.getCheckedRadioButtonId());
        if (rbSelected.getText()==isCorrect && score<5 && questionCounter<=questionCounterTotal){

          // int count=score+5;
            score++;
            scoreText.setText("Correct : "+score);
        }

    }

    public void showNextQuestion(){

        if (questionCounter<questionCounterTotal){

            question.setText(data.get(questionCounter).question);
            if (questionCounter==0)
            {
                questionCounterTextview.setText("Question :"+2+"/"+questionCounterTotal);
            }else {
               currentCount++;
                questionCounterTextview.setText("Question :"+currentCount+"/"+questionCounterTotal);

            }

            ArrayList<String> optionList=new ArrayList<>();
            isCorrect=data.get(questionCounter).correctAnswer;
            optionList=data.get(questionCounter).incorrectAnswers;

            for (int i=0;i<optionList.size();i++){
                radioButton1.setText(optionList.get(3));
                radioButton2.setText(optionList.get(0));
                radioButton3.setText(optionList.get(1));
                radioButton4.setText(optionList.get(2));
            }

            questionCounter++;
        }else {

            Intent intent=new Intent(QuizActivity.this,ScoreActivity.class);
            intent.putExtra("score",score);
            startActivity(intent);
            finish();
            Toast.makeText(this, "Finish", Toast.LENGTH_SHORT).show();
        }


    }

}