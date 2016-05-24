package com.nao.sabina.projectnao;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // references to our images
    private Integer[] mThumbIds = { R.drawable.sitting_nao, R.drawable.waving_nao,R.drawable.army_walk, R.drawable.blank, R.drawable.cool_position, R.drawable.hello_jesus,
    R.drawable.i_am_strong, R.drawable.reagie_dance, R.drawable.robot_dance, R.drawable.sing, R.drawable.squat, R.drawable.waage, R.drawable.yoga_lesson1
    , R.drawable.yoga_lesson2, R.drawable.yoga_lesson3};
    private CharSequence[] mContents = {"Sit Down", "Wave Right Arm", "Army Walk", "Plank", "Cool Position", "Cross", "I Am Strong", "Regie Dance", "Robot Dance",
            "Sing", "Squat", "Waage", "Yoga Lesson 1", "Yoga Lesson 2", "Yoga Lesson 3"};

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return this.mThumbIds[position];
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(350, 350));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(15, 15, 15, 15);
        } else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(mContext).load(mThumbIds[position]).fit().centerInside().into(imageView);

        imageView.setContentDescription(mContents[position]);
        return imageView;
    }

}
