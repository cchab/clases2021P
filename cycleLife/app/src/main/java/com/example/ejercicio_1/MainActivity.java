package com.example.ejercicio_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String tag  = "cycle";

    TextView txt_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"_onCreate",Toast.LENGTH_SHORT).show();
        txt_v = findViewById(R.id.txt_hola);
        Log.d(tag,"_onCreate");

    }
    @Override
    protected void  onPause(){
        super.onPause();
        Toast.makeText(this,"_onPause",Toast.LENGTH_SHORT).show();
        Log.d(tag,"_onPause");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this,"_onStart",Toast.LENGTH_SHORT).show();
        Log.d(tag,"_onStart");
        //txt_v.setText("Activa");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this,"_onResume",Toast.LENGTH_SHORT).show();
        Log.d(tag,"_onResume");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this,"_onStop",Toast.LENGTH_SHORT).show();
        Log.d(tag,"_onStop");
        txt_v.setText("Fuera de foco");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this,"_onRestart",Toast.LENGTH_SHORT).show();
        Log.d(tag,"_onRestart");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"_onDestroy",Toast.LENGTH_SHORT).show();
        Log.d(tag,"_onDestroy");
    }
}
