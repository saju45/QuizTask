package com.example.quizdemo;

import java.util.ArrayList;

public class DataModel {

    public String category;
    public String id;
    public String correctAnswer;
    public ArrayList<String> incorrectAnswers;
    public String question;
    public ArrayList<String> tags;
    public String type;
    public String difficulty;
    public ArrayList<Object> regions;

    public DataModel() {
    }

    public DataModel(String category, String id, String correctAnswer, ArrayList<String> incorrectAnswers, String question, ArrayList<String> tags, String type, String difficulty, ArrayList<Object> regions) {
        this.category = category;
        this.id = id;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
        this.question = question;
        this.tags = tags;
        this.type = type;
        this.difficulty = difficulty;
        this.regions = regions;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public ArrayList<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(ArrayList<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public ArrayList<Object> getRegions() {
        return regions;
    }

    public void setRegions(ArrayList<Object> regions) {
        this.regions = regions;
    }
}
