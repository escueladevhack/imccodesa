package co.com.codesa.imccodesa.fragments.autenticacion;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.codesa.imccodesa.R;
import co.com.codesa.imccodesa.activities.ListaActivity;
import co.com.codesa.imccodesa.fragments.RegistroFragment;
import co.com.codesa.imccodesa.fragments.presenters.autenticacion.AutenticacionPresenter;
import co.com.codesa.imccodesa.fragments.presenters.autenticacion.IAutenticacionPresenter;

public class AutenticacionFragment extends Fragment
        implements IAutenticacionView {

    private IAutenticacionPresenter autenticacionPresenter;
    private ProgressDialog progress;

    @Bind(R.id.txtLoginUsuario)
    EditText txtLoginUsuario;

    @Bind(R.id.txtLoginPassword)
    EditText txtLoginPassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_autenticacion, null);

        ButterKnife.bind(this, view);
        //Se obtiene el activity en la que esta incluido el fragment
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        //Se obtiene el toolbar del activity y se modifica el titulo
        appCompatActivity.getSupportActionBar().setTitle(R.string.btn_login_ingresar);

        autenticacionPresenter = new AutenticacionPresenter(this, getActivity());

        return view;
    }

    @Override
    public void mostrarLoading() {
        progress = ProgressDialog.show(getContext(), "Procesando", "Comprobando datos de ingreso...");
    }

    @Override
    public void ocultarLoading() {
        progress.dismiss();
    }

    @OnClick(R.id.btnLoginIngresar)
    @Override
    public void ingresar() {
        String email = txtLoginUsuario.getText().toString().trim();
        String password = txtLoginPassword.getText().toString().trim();
        autenticacionPresenter.ingresar(email, password);
    }

    @OnClick(R.id.btnLoginCrearCuenta)
    @Override
    public void crearCuenta() {
        autenticacionPresenter.crearCuenta();
    }

    @Override
    public void goToCrearCuenta() {
        RegistroFragment registroFragment = new RegistroFragment();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, registroFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void goToHistorialMC() {
        Intent intent = new Intent(getActivity(), ListaActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void mostrarErrorAutenticacion(Exception ex) {
        Toast.makeText(getContext(), ex.getMessage(),
                Toast.LENGTH_SHORT).show();
    }
}
