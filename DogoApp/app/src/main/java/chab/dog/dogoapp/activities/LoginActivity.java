package chab.dog.dogoapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;

import chab.dog.dogoapp.R;

public class LoginActivity extends AppCompatActivity {
    Button login;
    TextView registrar,txtEmail,txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences preferences = getSharedPreferences("sesion", Context.MODE_PRIVATE);
        if(!preferences.getString("email","").equals(""))
            goToHome();
        login = findViewById(R.id.btnLogin);
        registrar = findViewById(R.id.lblRegistro);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == R.id.btnLogin || actionId == EditorInfo.IME_NULL)
                {
                    return true;
                }
                return false;
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Consultar si existe el usuario
                SharedPreferences preferencias = getSharedPreferences("sesion",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("email",txtEmail.getText().toString());
                editor.putString("password",txtPassword.getText().toString());
                editor.commit();
                goToHome();

            }
        });
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotToRegister();
            }
        });
    }

    private void goToHome(){
        Intent i = new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(i);

    }

    private void gotToRegister(){
        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);
    }
}
