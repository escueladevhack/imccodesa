package co.com.codesa.imccodesa.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.com.codesa.imccodesa.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculateImcFragment extends Fragment {
    @Bind(R.id.txtNombre)
    EditText txtNombre;
    @Bind(R.id.txtPeso)
    EditText txtPeso;
    @Bind(R.id.txtEstatura)
    EditText txtEstatura;
    @Bind(R.id.txtResultadoImc)
    EditText txtResultadoImc;

    public CalculateImcFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        appCompatActivity.getSupportActionBar().setTitle(R.string.calcular_imc);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculate_imc, container, false);

        ButterKnife.bind(this, view);

        return view;
    }


}
