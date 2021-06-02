package chab.dog.basededatos.Controllers;

import android.content.Context;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

import java.util.List;

import chab.dog.basededatos.Interfaces.IApiDemo;
import chab.dog.basededatos.Models.User;
import chab.dog.basededatos.OpenHelper.APIConstants;
/*import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;*/

public class UserController {
    Context ctx;

    public UserController(Context c){
        ctx = c;
    }

    public List<User> GetAllUsers(){


        return null;
    }
}
