package com.example.quizdemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_Client {

    private static String BASE_URL="https://the-trivia-api.com/api/";
    private static Retrofit_Client retrofitClient;
    private static Retrofit retrofit;

    private OkHttpClient.Builder builder=new OkHttpClient.Builder();
    private HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();

    private Retrofit_Client()
    {

        Gson gson=new GsonBuilder()
                .setLenient()
                .create();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);


        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
    }

    public static synchronized Retrofit_Client getInstance()
    {
        if (retrofitClient==null)
        {
            retrofitClient=new Retrofit_Client();
        }
        return retrofitClient;
    }

    public Api getApi()
    {
        return retrofit.create(Api.class);
    }
}
