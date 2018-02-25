package com.example.chelsi.androidfinalpractical;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Chelsi on 2/25/2018.
 */

public class DogAdapter extends RecyclerView.Adapter<DogViewholder>{

    private List<String> dogList;

    public DogAdapter(List<String> dogList){
        this.dogList =dogList;
    }

    @Override
    public DogViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dog_itemview, parent, false);
        return new DogViewholder(view);
    }

    @Override
    public void onBindViewHolder(DogViewholder holder, int position) {
        holder.bind(getDogList().get(position));
    }

    @Override
    public int getItemCount() {
        return getDogList().size();
    }
    public List <String> getDogList() {
        return dogList;
    }

}
