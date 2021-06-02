package chab.dog.dogoapp.interfaces;

import chab.dog.dogoapp.comun.RetrofitConst;
import chab.dog.dogoapp.models.UserSession;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IAPIApp {

    //Registro
    @POST("accounts:signUp")
    Call<UserSession> signUp(@Query("key") String key);

    @PUT("profiles/{uid}.json")
    Call<UserSession> createProfile(@Path("uid") String uid, @Body UserSession user);
    //Login
    @POST("accounts:signInWithPassword")
    Call<UserSession> signIn(@Query("key") String key);

    @GET("profiles/{uid}.json")
    Call<UserSession> getUserSession(@Path("uid") String uid);
}
