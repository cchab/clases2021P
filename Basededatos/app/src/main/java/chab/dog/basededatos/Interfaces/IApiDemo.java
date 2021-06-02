package chab.dog.basededatos.Interfaces;

import java.util.List;

import chab.dog.basededatos.Models.Employee;
import chab.dog.basededatos.Models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IApiDemo {

   @GET("user")
   Call<List<User>> getAllUsers();

    @GET("user/{id}")
    Call<User> getUser(@Path("id") int id);
}
