package tec.isc.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public String texto = "Hola mundo";
    int count = 0;
    TextView txt_hola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_hola = findViewById(R.id.txt_hola1);
    }

    public void suma(View v){
        count++;
        txt_hola.setText("Clicks "+count);
    }

    public void resta(View v){

        if(count==0){

            Toast.makeText(this,"No puedes restar",Toast.LENGTH_SHORT).show();
        }
        else{
            count--;
            txt_hola.setText("Clicks "+count);
        }
    }
}
