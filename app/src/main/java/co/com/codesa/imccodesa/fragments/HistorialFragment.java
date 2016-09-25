package co.com.codesa.imccodesa.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.com.codesa.imccodesa.R;
import co.com.codesa.imccodesa.adapters.HistorialAdapter;
import co.com.codesa.imccodesa.model.Persona;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistorialFragment extends Fragment {
    @Bind(R.id.lstHistorial)
    ListView lstHistorial;
    ArrayList<Persona> listPersonas;

    public HistorialFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_historial, container, false);

        ButterKnife.bind(this, view);

        listPersonas = new ArrayList<>(0);
        listPersonas.add(new Persona("Persona 1", 167, 60, 15));
        listPersonas.add(new Persona("Persona 2", 170, 70, 22));
        listPersonas.add(new Persona("Persona 3", 180, 75, 25));

        HistorialAdapter adapter = new HistorialAdapter(getContext(), listPersonas);
        lstHistorial.setAdapter(adapter);

        return view;
    }

}
