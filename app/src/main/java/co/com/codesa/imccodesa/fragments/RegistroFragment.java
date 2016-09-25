package co.com.codesa.imccodesa.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.codesa.imccodesa.R;
import co.com.codesa.imccodesa.activities.ListaActivity;

public class RegistroFragment extends Fragment {

    private FirebaseAuth mAuth;
    private ProgressDialog progress;

    @Bind(R.id.txtRegistroUsuario)
    EditText txtRegistroUsuario;

    @Bind(R.id.txtRegistroPassword)
    EditText txtRegistroPassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_registro, null);

        ButterKnife.bind(this, view);

        mAuth = FirebaseAuth.getInstance();

        return view;
    }

    @OnClick(R.id.btnRegistroCrearCuenta)
    public void clickRegistroCrearCuenta() {

        progress = ProgressDialog.show(getContext(), "Procesando", "Creando la cuenta..");

        mAuth.createUserWithEmailAndPassword(txtRegistroUsuario.getText().toString(),
                txtRegistroPassword.getText().toString())
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(RegistroFragment.class.getName(), "Tarea completa: " + task.isSuccessful());

                        if (task.isSuccessful()) {
                            Intent intent = new Intent(getContext(), ListaActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }

                        progress.dismiss();

                    }
                });
    }
}
