package com.puig.a8;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class PokemonFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PokeViewModel pokeViewModel = new ViewModelProvider(this).get(PokeViewModel.class);

        pokeViewModel.obtenerPokemon();

        pokeViewModel.respuestaMutableLiveData.observe(getViewLifecycleOwner(), new Observer<Poke.Pokemons>() {
            @Override
            public void onChanged(Poke.Pokemons pokemons) {
                for(Poke.Pokemon p: pokemons.documents)
                Log.e("POKE", p.fields.nombre.stringValue);
            }
        });
    }


}