package co.com.codesa.imccodesa.fragments;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.codesa.imccodesa.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculateImcFragment extends Fragment {

    private CharSequence[] opciones = null;
    private final int SELECT_IMAGEN = 200;
    private Uri pathImagenPerfil;

    @Bind(R.id.txtNombre)
    EditText txtNombre;

    @Bind(R.id.txtPeso)
    EditText txtPeso;

    @Bind(R.id.txtEstatura)
    EditText txtEstatura;

    @Bind(R.id.txtResultadoImc)
    EditText txtResultadoImc;

    @Bind(R.id.imgPerfil)
    ImageView imgPerfil;

    public CalculateImcFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        appCompatActivity.getSupportActionBar().setTitle(R.string.calcular_imc);

        View view = inflater.inflate(R.layout.fragment_calculate_imc, container, false);

        ButterKnife.bind(this, view);

        opciones = new CharSequence[]{
                getResources().getString(R.string.opcion_imagen_perfil_galeria),
                getResources().getString(R.string.opcion_imagen_perfil_camara)
        };

        return view;
    }

    @OnClick(R.id.btnCalcular)
    public void clickCalcularIMC() {

        double peso = Double.parseDouble(txtPeso.getText().toString());
        double estatura = Double.parseDouble(txtEstatura.getText().toString());

        double imc = peso / Math.pow(estatura, 2);

        txtResultadoImc.setText(String.valueOf(imc));
    }

    @OnClick(R.id.fabAddImagenPerfil)
    public void clickAddImagenPerfil() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.opcion_imagen_perfil_titulo);

        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (opciones[which].equals(
                        getResources().getString(R.string.opcion_imagen_perfil_camara)
                )) {
                    //TODO llamar camara
                } else {
                    Intent intent = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(
                            intent.createChooser(intent, "Selecciona tu imagen"),
                            SELECT_IMAGEN);
                }

            }
        });

        builder.show();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECT_IMAGEN) {
            if (resultCode == Activity.RESULT_OK) {
                pathImagenPerfil = data.getData();
                Picasso.with(getActivity()).load(pathImagenPerfil)
                        .resize(600, 600).centerCrop().into(imgPerfil);
            }
        }

    }
}
