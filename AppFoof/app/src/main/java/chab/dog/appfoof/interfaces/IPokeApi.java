package chab.dog.appfoof.interfaces;

import java.util.List;

import chab.dog.appfoof.models.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IPokeApi {
    @GET("pokemon")
    Call<List<Pokemon>> getPokemons();
}
