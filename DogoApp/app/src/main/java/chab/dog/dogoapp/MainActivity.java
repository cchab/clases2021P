package chab.dog.dogoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

import chab.dog.dogoapp.activities.HomeActivity;
import chab.dog.dogoapp.activities.LoginActivity;

public class MainActivity extends Activity {

    ProgressBar progress;
    Handler handler = new Handler();
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = findViewById(R.id.progressBar);
        threadMethod();

    }

    public void timerMethod(){
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                progress.setProgress(100);
                finish();
            }
        };
        Timer time = new Timer();
        time.schedule(tarea,7000);
    }

    public void threadMethod(){
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i <= 100){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progress.setProgress(i);
                        }
                    });
                    i++;
                    try{
                        Thread.sleep(50);
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                    if(i == 100){
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
        hilo.start();
    }
}
