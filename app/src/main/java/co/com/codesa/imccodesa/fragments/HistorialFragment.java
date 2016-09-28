package co.com.codesa.imccodesa.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
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
    //ListView lstHistorial;
    //GridView lstHistorial;
    RecyclerView lstHistorial;
    ArrayList<Persona> listPersonas;
    private boolean showAsList;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;

    public HistorialFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_historial, container, false);

        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);

        showAsList = true;
        listPersonas = new ArrayList<>(0);
        listPersonas.add(new Persona("Persona 1", 167, 60, 15));
        listPersonas.add(new Persona("Persona 2", 170, 70, 22));
        listPersonas.add(new Persona("Persona 3", 180, 75, 25));
        listPersonas.add(new Persona("Persona 4", 180, 75, 25));
        listPersonas.add(new Persona("Persona 5", 180, 75, 25));
        listPersonas.add(new Persona("Persona 6", 180, 75, 25));
        listPersonas.add(new Persona("Persona 7", 180, 75, 25));

        gridLayoutManager = new GridLayoutManager(getContext(), 3);
        linearLayoutManager = new LinearLayoutManager(getContext());
        HistorialAdapter adapter = new HistorialAdapter(getContext(), listPersonas);
        lstHistorial.setAdapter(adapter);
        //lstHistorial.setHasFixedSize(true);
        lstHistorial.setLayoutManager(linearLayoutManager);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.historial, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.show_as) {
            //se esta mostrando como lista, cambia a grid
            if(showAsList) {
                showAsList = false;
                item.setIcon(R.drawable.ic_action_grid);
                lstHistorial.setLayoutManager(gridLayoutManager);
            } else {
                //se esta mostrando como grid, cambia a lista
                showAsList = true;
                item.setIcon(R.drawable.ic_action_list);
                lstHistorial.setLayoutManager(linearLayoutManager);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
