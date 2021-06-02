package chab.dog.dogoapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import chab.dog.dogoapp.R;
import chab.dog.dogoapp.fragments.ConfiguracionFragment;
import chab.dog.dogoapp.fragments.HeadlinesFragment;
import chab.dog.dogoapp.fragments.InicioFragment;
import chab.dog.dogoapp.fragments.PerfilFragment;
import chab.dog.dogoapp.interfaces.IComunicaFragement;

public class HomeActivity extends AppCompatActivity implements
        IComunicaFragement,
        InicioFragment.OnDashSelectListener {


    BottomNavigationView navMenu;

    private final static String CHANNEL_ID = "NOTIFICACION";
    private final static int NOTIFICATION_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /**/
        navMenu = findViewById(R.id.navMenu);
        navMenu.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new InicioFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            // By using switch we can easily get
            // the selected fragment
            // by using there id.
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.inicioFragment:
                    selectedFragment = new InicioFragment();
                    break;
                case R.id.perfilFragment:
                    selectedFragment = new PerfilFragment();
                    break;
                case R.id.configuracionFragment:
                    selectedFragment = new ConfiguracionFragment();
                    break;
            }
            // It will help to replace the
            // one fragment to other.
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment, selectedFragment)
                    .commit();
            return true;
        }
    };
    /*@Override
    public void onClick(View v) {
        Class goTo;
        switch (v.getId()){
            case R.id.cwCupones :
                goTo = CuponesActivity.class; break;
            case R.id.cwMenu :
                goTo = MenuActivity.class; break;
            case R.id.cwHistorial :
                goTo = HistorialActivity.class; break;
            case R.id.cwOrdenar :
                goTo = OrdenarActivity.class; break;
            default:
                return;

        }
        Intent i = new Intent(HomeActivity.this, goTo);
        startActivity(i);
    }*/


    public void showToast(){
        Toast.makeText(HomeActivity.this,"No tienes cupones!", Toast.LENGTH_LONG).show();
    }

    public void showDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Sin cupones")
                .setMessage("No tienes cupones, ¿deseas agregar cupones?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(HomeActivity.this, CuponesActivity.class);
                        startActivity(i);

                    }
                }).setNegativeButton("No",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                //cupones.setText("No tienes cupones");
            }
        }).show();
    }

    public void launchNotification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notificacion";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_action_name);
        builder.setContentTitle("Notificación android");
        builder.setContentText("Quieres más cupones");
        builder.setColor(Color.RED );
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setLights(Color.YELLOW,1000,1000);
        builder.setVibrate(new long[]{1000,1000,1000,1000,1000});
        builder.setDefaults(Notification.DEFAULT_SOUND);

        NotificationManagerCompat notificationManagerCompat =  NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
    }

    @Override
    public void verCupones() {

    }

    @Override
    public void verMenu() {

    }

    @Override
    public void verHistorial() {

    }

    @Override
    public void hacerPedido() {

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof InicioFragment) {
            InicioFragment inicioFragment = (InicioFragment) fragment;
            inicioFragment.setOnDashSelectListener(this);
        }
    }

    @Override
    public void onItemSelectec() {

    }




    /*public void validateInput(){
        Drawable dr = getResources().getDrawable(R.drawable.cupon);
        dr.setBounds(0, 0, 50, 50);
        if(editText.getText().toString().isEmpty())
            editText.setError("Campo requerido",dr);
            // editText.setCompoundDrawablesWithIntrinsicBounds(null,null, dr, null);
    }*/
}
