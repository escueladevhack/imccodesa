package co.com.codesa.imccodesa.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import co.com.codesa.imccodesa.R;
import co.com.codesa.imccodesa.fragments.autenticacion.AutenticacionFragment;

public class MainActivity extends AppCompatActivity implements
        FragmentManager.OnBackStackChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Obtener el toolbar del layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Pasamos el toolbar para usarlo como ActionBar
        setSupportActionBar(toolbar);

        getSupportFragmentManager().addOnBackStackChangedListener(this);
        SharedPreferences sp = getSharedPreferences("user_data", Context.MODE_PRIVATE);

        if(sp.getBoolean("isActived", false)) {
            Intent intent = new Intent(this, ListaActivity.class);
            startActivity(intent);
            finish();
        } else {
            AutenticacionFragment autenticacionFragment = new AutenticacionFragment();

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, autenticacionFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        //Verificamos si hay 2 o mas fragments en la pila
        if(getSupportFragmentManager().getBackStackEntryCount() >= 2) {
            //Sacamos de la pila el ultimo elemento (ir al fragment anterior)
            getSupportFragmentManager().popBackStackImmediate();

            if(getSupportFragmentManager().getBackStackEntryCount() == 1) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                getSupportActionBar().setHomeButtonEnabled(false);
            }
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Si se presiono la flecha back
        if(item.getItemId() == android.R.id.home) {
            //Se realiza la misma logica del boton back fisico del dispositivo
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackStackChanged() {
        if(getSupportFragmentManager().getBackStackEntryCount() >= 2) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
