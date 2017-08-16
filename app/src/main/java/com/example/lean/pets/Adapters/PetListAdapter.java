package com.example.lean.pets.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lean.pets.R;

import java.util.List;

import com.example.lean.pets.Models.Pet;

/**
 * Created by LEAN on 15/08/2017.
 */

public class PetListAdapter extends BaseAdapter {

    private Context context;
    private List<Pet> petList;

    public PetListAdapter(List<Pet> pets, Context context){
        this.context = context;
        this.petList = pets;
    }

    @Override
    public int getCount() {
        return this.petList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.petList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder viewHolder;

        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.item_pet_list_layout, null);

            viewHolder = new ViewHolder();
            viewHolder.namePet = (TextView)row.findViewById(R.id.textView);

            row.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) row.getTag();
        Pet currentPet = petList.get(position);
        if(currentPet.getName()!= null){
            if(!currentPet.getName().trim().equals("")) {
                viewHolder.namePet.setText(currentPet.getName());
            } else {
                viewHolder.namePet.setText(R.string.nothing_name);
            }
        } else {
            viewHolder.namePet.setText(R.string.nothing_name);
        }
        return row;
    }

    public class ViewHolder {
        public TextView namePet;

    }
}
