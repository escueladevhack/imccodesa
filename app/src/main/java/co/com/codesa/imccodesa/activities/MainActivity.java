package co.com.codesa.imccodesa.activities;

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

        AutenticacionFragment autenticacionFragment = new AutenticacionFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, autenticacionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
