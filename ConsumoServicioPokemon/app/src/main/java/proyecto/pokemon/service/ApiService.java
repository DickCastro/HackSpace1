package proyecto.pokemon.service;

import java.util.ArrayList;
import java.util.List;

import proyecto.pokemon.entity.PokemonEntity;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Victor Casas on 15/02/2016.
 */
public interface ApiService {
    @GET("/lista_pokemons.php")
    void getPokemons(Callback<List<PokemonEntity>> response);


}
