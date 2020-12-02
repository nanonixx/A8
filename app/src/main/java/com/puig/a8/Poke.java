package com.puig.a8;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Poke {

    public static Api api = new Retrofit.Builder()
            .baseUrl("https://firestore.googleapis.com/v1/projects/pokeipa/databases/(default)/documents/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api.class);

    public interface Api {
        @GET("pokemon")
        Call<Pokemons> obtenerPokemon();
    }

    class Pokemons {
        List<Pokemon> documents;
    }

    class Pokemon {
        String name;
        Fields fields;
    }

    class Fields {
        StringValue imagen;
        StringValue nombre;
        IntValue nivel;
    }

    class StringValue {
        String stringValue;
    }

    class IntValue {
        String intValue;
    }

}
