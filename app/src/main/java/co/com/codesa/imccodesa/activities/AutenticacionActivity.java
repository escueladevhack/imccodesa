package co.com.codesa.imccodesa.activities;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

public class AutenticacionActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ProgressDialog progress;

    @Bind(R.id.txtLoginUsuario)
    EditText txtLoginUsuario;

    @Bind(R.id.txtLoginPassword)
    EditText txtLoginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autenticacion);

        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
    }

    @OnClick(R.id.btnLoginIngresar)
    public void clikIngresar() {

        progress = ProgressDialog.show(this, "Procesando", "Comprobando datos de ingreso...");

        String email = txtLoginUsuario.getText().toString();
        String password = txtLoginPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(RegistroActivity.class.getName(), "Resultado Log In : " + task.isSuccessful());

                        if (task.isSuccessful()) {
                            Intent intent = new Intent(AutenticacionActivity.this, ListaIMCActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(AutenticacionActivity.this, task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }

                        progress.dismiss();
                    }
                });

    }

    @OnClick(R.id.btnLoginCrearCuenta)
    public void clikCrearCuenta() {
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }

}
