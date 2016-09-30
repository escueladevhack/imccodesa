package co.com.codesa.imccodesa.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
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
public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.HistorialHolder> {
    private ArrayList<Persona> dataSource;
    private Context context;

    public HistorialAdapter(Context context, ArrayList<Persona> dataSource) {
        this.context = context;
        this.dataSource = dataSource;
    }

    /**
     * 1. Infla el layout sobre el cual se van a mostrar los datos
     * 2. Crear una instancia del holder con la vista inflada
     * */
    @Override
    public HistorialAdapter.HistorialHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Paso 1
        View view = inflater.inflate(R.layout.view_item_historial, parent, false);

        //Paso 2
        HistorialHolder historialHolder = new HistorialHolder(view);

        return historialHolder;
    }

    /**
     * 1. Obtiene la objeto del datasource en con el indice position
     * 2. Muestra los datos del obteto usando viewHolder
     * */
    @Override
    public void onBindViewHolder(HistorialAdapter.HistorialHolder holder, int position) {
        //Paso 1
        Persona persona = dataSource.get(position);

        //Paso 2
        //holder.itemView.setBackgroundColor(position%2==0 ? Color.LTGRAY: Color.WHITE);
        holder.lblNombre.setText(persona.getNombre());
        holder.lblAltura.setText(String.valueOf(persona.getAltura()));
        holder.lblPeso.setText(String.valueOf(persona.getPeso()));
        holder.lblImc.setText(String.valueOf(persona.getImc()));
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public static class HistorialHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.lblNombre)
        TextView lblNombre;
        @Bind(R.id.lblAltura)
        TextView lblAltura;
        @Bind(R.id.lblPeso)
        TextView lblPeso;
        @Bind(R.id.lblImc)
        TextView lblImc;

        public HistorialHolder(View view) {
            super(view);

            //Infla los componentes donde se va a mostrar la informacion
            ButterKnife.bind(this, view);

            //TextView lblNombre = (TextView)view.findViewById(R.id.lblNombre);
            //TextView lblAltura = (TextView)view.findViewById(R.id.lblAltura);
            //TextView lblPeso = (TextView)view.findViewById(R.id.lblPeso);
            //TextView lblImc = (TextView)view.findViewById(R.id.lblImc);
        }


    }
}
