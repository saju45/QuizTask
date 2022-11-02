package com.example.quizdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;


public interface Api {


    @GET("questions?")
    Call<List<DataModel>> fetchAllQuestion(@Query("limit") int limit,@Query("categories")String categories,@Query("difficulty")String difficulty);

    @GET("categories")
    Call<List<CategoriesModel>> fetchCategories();




}
