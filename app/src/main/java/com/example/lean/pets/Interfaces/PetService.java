package com.example.lean.pets.Interfaces;

import java.util.List;

import com.example.lean.pets.Models.Pet;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by LEAN on 14/08/2017.
 */

public interface PetService {

    public static final String BASE_URL = "http://petstore.swagger.io/v2/";

    @GET("pet/findByStatus?status=available")
    Call<List<Pet>> getPets();

    @GET("pet/{petId}")
    Call<Pet> getDetailPet(@Path("petId") String petId);
}
