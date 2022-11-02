package com.example.quizdemo;

public class CategoriesType {

    String apiValue,uiValue;

    public CategoriesType(String apiValue, String uiValue) {
        this.apiValue = apiValue;
        this.uiValue = uiValue;
    }

    public String getApiValue() {
        return apiValue;
    }

    public void setApiValue(String apiValue) {
        this.apiValue = apiValue;
    }

    public String getUiValue() {
        return uiValue;
    }

    public void setUiValue(String uiValue) {
        this.uiValue = uiValue;
    }
}
