package co.com.codesa.imccodesa.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.BufferedReader;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.com.codesa.imccodesa.R;
import co.com.codesa.imccodesa.model.Persona;

/**
 * Created by krlosf on 24/09/16.
 */
public class HistorialAdapter extends BaseAdapter {
    private ArrayList<Persona> dataSource;
    private Context context;

    public HistorialAdapter(Context context, ArrayList<Persona> dataSource) {
        this.context = context;
        this.dataSource = dataSource;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return dataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(R.layout.view_item_historial, null);
        view.setBackgroundColor(i%2==0 ? Color.LTGRAY: Color.WHITE);
        //TextView lblNombre = (TextView)view.findViewById(R.id.lblNombre);
        //TextView lblAltura = (TextView)view.findViewById(R.id.lblAltura);
        //TextView lblPeso = (TextView)view.findViewById(R.id.lblPeso);
        //TextView lblImc = (TextView)view.findViewById(R.id.lblImc);

        Persona persona = (Persona) getItem(i);
        HistorialHolder historialHolder = new HistorialHolder(view, persona);

        return view;
    }


    static class HistorialHolder {
        @Bind(R.id.lblNombre)
        TextView lblNombre;
        @Bind(R.id.lblAltura)
        TextView lblAltura;
        @Bind(R.id.lblPeso)
        TextView lblPeso;
        @Bind(R.id.lblImc)
        TextView lblImc;

        public HistorialHolder(View view, Persona persona) {
            ButterKnife.bind(this, view);

            lblNombre.setText(persona.getNombre());
            lblAltura.setText(String.valueOf(persona.getAltura()));
            lblPeso.setText(String.valueOf(persona.getPeso()));
            lblImc.setText(String.valueOf(persona.getImc()));
        }
    }
}
