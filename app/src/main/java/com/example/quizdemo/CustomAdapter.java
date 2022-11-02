package com.example.quizdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<CategoriesType> {

  public CustomAdapter(Context context, ArrayList<CategoriesType> categoriesTypeArrayList){

    super(context,0);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    return  initView(position,convertView,parent);
  }


    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      return  initView(position,convertView,parent);
    }

    public View initView(int position,View convertView,ViewGroup parent){

      if (convertView==null){
          convertView= LayoutInflater.from(getContext()).inflate(R.layout.dropdown_item,parent,false);
      }

        TextView textView=convertView.findViewById(R.id.dropDownItem);

      CategoriesType type=getItem(position);

      if (type!=null){
        textView.setText(type.getApiValue());
      }

      return convertView;
    }
}
