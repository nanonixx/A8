package com.puig.a8;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokeViewModel extends AndroidViewModel {
    public PokeViewModel(@NonNull Application application) {
        super(application);
    }

    MutableLiveData<Poke.Pokemons> respuestaMutableLiveData = new MutableLiveData<>();

    void obtenerPokemon() {
        Poke.api.obtenerPokemon().enqueue(new Callback<Poke.Pokemons>() {

            @Override
            public void onResponse(Call<Poke.Pokemons> call, Response<Poke.Pokemons> response) {
                respuestaMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Poke.Pokemons> call, Throwable t) {

            }
        });
    }
}
