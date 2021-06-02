package chab.dog.appfoof.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import chab.dog.appfoof.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        var intent : Intent =  Intent(this, MainActivity::class.java);
        startActivity(intent);
        finish(); // evitar regresar a éste activity
    }
}
