package com.example.egretguillaumetpfinal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyService
{
    @GET("all")
    Call<List<Pays>> getProducts();

}
