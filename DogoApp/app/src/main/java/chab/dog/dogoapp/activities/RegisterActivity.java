package chab.dog.dogoapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import chab.dog.dogoapp.R;
import chab.dog.dogoapp.comun.RetrofitConst;
import chab.dog.dogoapp.interfaces.IAPIApp;
import chab.dog.dogoapp.models.UserSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }



    public void getUserSession(){

    }
}
