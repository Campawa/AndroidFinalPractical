package com.example.chelsi.androidfinalpractical;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Chelsi on 2/25/2018.
 */

public class DogViewholder extends RecyclerView.ViewHolder{

    ImageView aDogPic;

    public DogViewholder(View itemView) {
        super(itemView);

        aDogPic = itemView.findViewById(R.id.dogPhoto);
    }

    public void bind(String s) {
    }
}
