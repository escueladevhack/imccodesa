package co.com.codesa.imccodesa.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.com.codesa.imccodesa.R;
import co.com.codesa.imccodesa.fragments.AutenticacionFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
