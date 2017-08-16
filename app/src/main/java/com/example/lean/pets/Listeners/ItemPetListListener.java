package com.example.lean.pets.Listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.lean.pets.Activitys.PetDetailActivity;

/**
 * Created by LEAN on 15/08/2017.
 */

public class ItemPetListListener implements AdapterView.OnItemClickListener{
    Context context;
    public  ItemPetListListener(Context context){
        this.context = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent goToPetDetailIntent =  new Intent(context, PetDetailActivity.class);
        context.startActivity(goToPetDetailIntent);
    }
}
