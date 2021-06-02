package chab.dog.dogoapp.dao;

import android.content.Context;
import android.widget.Toast;

import chab.dog.dogoapp.comun.RetrofitConst;
import chab.dog.dogoapp.interfaces.IAPIApp;
import chab.dog.dogoapp.models.UserSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserSessionDAO {
    UserSession user;
    Context ctx;

    UserSessionDAO(Context c){
        ctx = c;
    }

    public String registrarUsuario(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitConst.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IAPIApp api = retrofit.create(IAPIApp.class);
        Call<UserSession> call = api.signUp();
        call.enqueue(new Callback<UserSession>() {
            @Override
            public void onResponse(Call<UserSession> call, Response<UserSession> response) {
                if(!response.isSuccessful())
                    Toast.makeText(ctx, "Code: " + response.code(),Toast.LENGTH_SHORT).show();

                UserSession user = response.body();

            }

            @Override
            public void onFailure(Call<UserSession> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Code: " + t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        return null;
    }
}
