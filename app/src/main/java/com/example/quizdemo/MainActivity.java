package com.example.quizdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView,autoDifficulty;
    Button start;
    ArrayList<CategoriesType> list;
    private CustomAdapter customAdapter;
    String categoriesItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=new ArrayList<>();
        String[] categories=new String[]{"Arts & Literature","Film & TV","Food & Drink","General Knowledge","Geography","History","Music","Science","Society & Culture","Sport & Leisure"};
        String[] categoriesChild=new String[]{"arts_and_literature","film_and_tv","food_and_drink","general_knowledge","geography","history","music","science","society_and_culture","sport_and_leisure"};
        String[] difficulty=new String[]{"hard","medium","easy"};



        list.add(new CategoriesType("Arts & Literature","arts_and_literature"));
        list.add(new CategoriesType("Film & TV","film_and_tv"));
        list.add(new CategoriesType("Food & Drink","food_and_drink"));
        list.add(new CategoriesType("General Knowledge","general_knowledge"));
        list.add(new CategoriesType("Geography","geography"));
        list.add(new CategoriesType("History","history"));
        list.add(new CategoriesType("Music","music"));
        list.add(new CategoriesType("Science","science"));
        list.add(new CategoriesType("Society & Culture","society_and_culture"));
        list.add(new CategoriesType("Sport & Leisure","sport_and_leisure"));




        Call<List<CategoriesModel>> call=Retrofit_Client
                .getInstance()
                .getApi()
                .fetchCategories();


        call.enqueue(new Callback<List<CategoriesModel>>() {
            @Override
            public void onResponse(Call<List<CategoriesModel>> call, Response<List<CategoriesModel>> response) {

                if (response.isSuccessful()){

                    Toast.makeText(MainActivity.this, "categories : "+response.body().size(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<CategoriesModel>> call, Throwable t) {

                Log.e("TAG", "onFailure: "+t.getMessage());
           //     Toast.makeText(MainActivity.this, "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String>adapter=new ArrayAdapter<>(
                this,
                R.layout.dropdown_item
                ,categories
        );

        ArrayAdapter<String>adapter2=new ArrayAdapter<>(
                this,
                R.layout.dropdown_item
                ,difficulty
        );


       autoCompleteTextView=findViewById(R.id.titleExponse);
       autoDifficulty=findViewById(R.id.difficulty);
       start=findViewById(R.id.start);


       customAdapter=new CustomAdapter(this,list);
        Spinner spinner=findViewById(R.id.spinnerId);
        spinner.setAdapter(customAdapter);
        autoCompleteTextView.setAdapter(adapter);
        autoDifficulty.setAdapter(adapter2);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (position==0){
                    categoriesItem="arts_and_literature";
                }else if (position==1){
                   categoriesItem="film_and_tv" ;
                }else if (position==2){
                    categoriesItem="food_and_drink";
                }else if (position==3){
                    categoriesItem="general_knowledge";
                }else if (position==4){
                    categoriesItem="geography";
                }else if (position==5){
                    categoriesItem="history";
                }else if (position==6){
                    categoriesItem="music";
                }else if (position==7){
                    categoriesItem="science";
                }else if (position==8){
                    categoriesItem="society_and_culture";
                }else if (position==9){
                    categoriesItem="sport_and_leisure";
                }

                Toast.makeText(MainActivity.this, "Categories : "+autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (autoCompleteTextView.getText().toString().equals("") || autoCompleteTextView.getText().toString().equals("Categories")){
                    Toast.makeText(MainActivity.this, "Please Choose Categories", Toast.LENGTH_SHORT).show();
                }
                else if (autoDifficulty.getText().toString().equals("")|| autoDifficulty.getText().toString().equals("difficulty")){
                    Toast.makeText(MainActivity.this, "Please choose difficulty level", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent(MainActivity.this,QuizActivity.class);
                    intent.putExtra("categories",categoriesItem);
                    intent.putExtra("difficulty",autoDifficulty.getText().toString());
                    startActivity(intent);
                }

            }
        });
    }
}