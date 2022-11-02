package com.example.quizdemo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CategoriesModel {
    @SerializedName("Arts & Literature")
    public ArrayList<String> artsLiterature;
    @SerializedName("Film & TV")
    public ArrayList<String> filmTV;
    @SerializedName("Food & Drink")
    public ArrayList<String> foodDrink;
    @SerializedName("General Knowledge")
    public ArrayList<String> generalKnowledge;
    @SerializedName("Geography")
    public ArrayList<String> geography;
    @SerializedName("History")
    public ArrayList<String> history;
    @SerializedName("Music")
    public ArrayList<String> music;
    @SerializedName("Science")
    public ArrayList<String> science;
    @SerializedName("Society & Culture")
    public ArrayList<String> societyCulture;
    @SerializedName("Sport & Leisure")
    public ArrayList<String> sportLeisure;


    public CategoriesModel() {
    }

    public CategoriesModel(ArrayList<String> artsLiterature, ArrayList<String> filmTV, ArrayList<String> foodDrink, ArrayList<String> generalKnowledge, ArrayList<String> geography, ArrayList<String> history, ArrayList<String> music, ArrayList<String> science, ArrayList<String> societyCulture, ArrayList<String> sportLeisure) {
        this.artsLiterature = artsLiterature;
        this.filmTV = filmTV;
        this.foodDrink = foodDrink;
        this.generalKnowledge = generalKnowledge;
        this.geography = geography;
        this.history = history;
        this.music = music;
        this.science = science;
        this.societyCulture = societyCulture;
        this.sportLeisure = sportLeisure;
    }

    public ArrayList<String> getArtsLiterature() {
        return artsLiterature;
    }

    public void setArtsLiterature(ArrayList<String> artsLiterature) {
        this.artsLiterature = artsLiterature;
    }

    public ArrayList<String> getFilmTV() {
        return filmTV;
    }

    public void setFilmTV(ArrayList<String> filmTV) {
        this.filmTV = filmTV;
    }

    public ArrayList<String> getFoodDrink() {
        return foodDrink;
    }

    public void setFoodDrink(ArrayList<String> foodDrink) {
        this.foodDrink = foodDrink;
    }

    public ArrayList<String> getGeneralKnowledge() {
        return generalKnowledge;
    }

    public void setGeneralKnowledge(ArrayList<String> generalKnowledge) {
        this.generalKnowledge = generalKnowledge;
    }

    public ArrayList<String> getGeography() {
        return geography;
    }

    public void setGeography(ArrayList<String> geography) {
        this.geography = geography;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }

    public ArrayList<String> getMusic() {
        return music;
    }

    public void setMusic(ArrayList<String> music) {
        this.music = music;
    }

    public ArrayList<String> getScience() {
        return science;
    }

    public void setScience(ArrayList<String> science) {
        this.science = science;
    }

    public ArrayList<String> getSocietyCulture() {
        return societyCulture;
    }

    public void setSocietyCulture(ArrayList<String> societyCulture) {
        this.societyCulture = societyCulture;
    }

    public ArrayList<String> getSportLeisure() {
        return sportLeisure;
    }

    public void setSportLeisure(ArrayList<String> sportLeisure) {
        this.sportLeisure = sportLeisure;
    }
}
