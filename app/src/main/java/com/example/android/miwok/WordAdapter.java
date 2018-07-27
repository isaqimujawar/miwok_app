package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    public int mColorResourceId;
    public WordAdapter(@NonNull Context context, ArrayList<Word> objects,int colorResourceId) {
        super(context,0, objects);
        this.mColorResourceId = colorResourceId;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       //check for reusuable view
        View listItemView = convertView;
        //if null the inflate the xml file and store it in listItemView
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        //This is where we get the actual object which contains the data
        // get the instance of the currentWord in the given position of the ArrayList
        Word currentWord = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.my_image);
        if (currentWord.hasImage()){
            //setImage to the image resource
            imageView.setImageResource(currentWord.getImageResourceId());
            //explicitly set the visibility
            imageView.setVisibility(View.VISIBLE);
        }else{
            imageView.setVisibility(View.GONE);
        }

        //find the textView and setText with the getter methods
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwokTextView);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.defaultTextView);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        //set color of the text_container linearLayout
        LinearLayout textContainer = (LinearLayout) listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);

        //return the listItemView to the ListView (it is a type of AdapterView)
        return listItemView;
    }
}