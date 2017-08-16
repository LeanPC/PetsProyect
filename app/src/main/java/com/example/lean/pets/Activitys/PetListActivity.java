package com.example.lean.pets.Activitys;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import com.example.lean.pets.Adapters.PetListAdapter;
import com.example.lean.pets.Interfaces.PetService;
import com.example.lean.pets.Listeners.ItemPetListListener;
import com.example.lean.pets.Models.Pet;
import com.example.lean.pets.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PetListActivity extends AppCompatActivity {
    private List<Pet> petList;
    private ListView petListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);
        petListView = (ListView) findViewById(R.id.listView);
        petListView.setVisibility(View.GONE);

        getAllPetList();
    }

    void getAllPetList(){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PetService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PetService service = retrofit.create(PetService.class);
        Call<List<Pet>> listPets = service.getPets();

        final ProgressDialog dialog = ProgressDialog.show(PetListActivity.this, "", getResources().getString(R.string.loading), true);
        dialog.onStart();

        listPets.enqueue(new Callback<List<Pet>>() {
            @Override
            public void onResponse(Call<List<Pet>> call, Response<List<Pet>> response) {
                dialog.dismiss();

                if(response.isSuccessful()) {
                    petList = response.body();

                    initializePetList();
                } else {
                    showAlertError();
                }

            }

            @Override
            public void onFailure(Call<List<Pet>> call, Throwable throwable) {
                dialog.dismiss();
                showAlertError();
            }
        });
    }

    void initializePetList(){
        petListView.setVisibility(View.VISIBLE);
        petListView.setAdapter(new PetListAdapter(petList, this));
        petListView.setOnItemClickListener(new ItemPetListListener(this));
    }

    void showAlertError(){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setMessage(getResources().getString(R.string.error));
        alertBuilder.setPositiveButton(getResources().getString(R.string.accept),new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertBuilder.show();
    }
}
