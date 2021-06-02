package chab.dog.basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import chab.dog.basededatos.Interfaces.IApiDemo;
import chab.dog.basededatos.Models.User;
import chab.dog.basededatos.OpenHelper.APIConstants;
import chab.dog.basededatos.OpenHelper.SQLite_OpenHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    SQLite_OpenHelper dbHlpr;
    SQLiteDatabase db;
    TextView result;
    EditText nombre,edad,idUsr;
    Button btnGuardar, btnConsultar, btnEditar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHlpr = new SQLite_OpenHelper(getApplicationContext());

        nombre = findViewById(R.id.name);
        edad = findViewById(R.id.age);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnConsultar = findViewById(R.id.btnConsultar);
        btnEditar = findViewById(R.id.btnEditar);
        result = findViewById(R.id.txtAll);
        idUsr = findViewById(R.id.idUser);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(createUser(UIToUser())+"");
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //retrieveUsers();

                //getAllUsers();
                getUser();
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateUser(UIToUser());
            }
        });

    }

    private User UIToUser(){

        return new User(Integer.parseInt(edad.getText().toString()), nombre.getText().toString());
    }

    public long createUser(User user){
        db = dbHlpr.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name",user.getNombre());
        values.put("age",user.getAge());

        return db.insert("users",null,values);
    }

    public void retrieveUsers(){
        User usuario = new User();
        db = dbHlpr.getReadableDatabase();
        String [] campos = new String [] {"id","name","age"};
        String[] clausulas = new String[] {idUsr.getText().toString()};
        Cursor c = db.query("users",campos,"id=?",clausulas,null,null,null);
        if(!c.moveToFirst()){
            Toast.makeText(this,"No existe el usuario",Toast.LENGTH_SHORT).show();
            return;
        }
        do{
            usuario.setId(c.getInt(0));
            usuario.setNombre(c.getString(1));
            usuario.setAge(c.getInt(2));
        }
        while (c.moveToNext());
        UserToUI(usuario);
    }

    private void UserToUI(User u){
        edad.setText(u.getAge()+"");
        nombre.setText(u.getNombre());
        idUsr.setText(u.getId()+"");
    }

    public void UpdateUser(User u){
        db = dbHlpr.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",u.getNombre());
        values.put("age",u.getAge());

        String clausula = "id = ?";
        String [] args = {u.getId()+""};

        db.update("users",values,clausula,args);

    }

    public void getAllUsers(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConstants.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IApiDemo api = retrofit.create(IApiDemo.class);
        Call<List<User>> call = api.getAllUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Codigo: "+response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }
                List<User> users = response.body();

                result.setText("");

                for(User user : users){
                    String content = "";
                    content+= String.format("id: %s\n",user.getId());
                    content+= String.format("name: %s\n",user.getNombre());
                    content+= String.format("edad: %s\n\n",user.getAge());
                    result.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

    public void getUser(){
        int id = Integer.parseInt(idUsr.getText().toString());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConstants.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IApiDemo api = retrofit.create(IApiDemo.class);
        Call<User> usuario = api.getUser(id);
        usuario.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Codigo: "+response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }
                User u = response.body();
                result.setText("");

                String content = "";
                content+= String.format("id: %s\n",u.getId());
                content+= String.format("name: %s\n",u.getNombre());
                content+= String.format("edad: %s\n\n",u.getAge());
                result.append(content);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

}
