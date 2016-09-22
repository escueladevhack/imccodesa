package co.com.codesa.imccodesa.activities;

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

public class RegistroActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ProgressDialog progress;

    @Bind(R.id.txtRegistroUsuario)
    EditText txtRegistroUsuario;

    @Bind(R.id.txtRegistroPassword)
    EditText txtRegistroPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
    }

    @OnClick(R.id.btnRegistroCrearCuenta)
    public void clickRegistroCrearCuenta() {

        progress = ProgressDialog.show(this, "Procesando", "Creando la cuenta..");

        mAuth.createUserWithEmailAndPassword(txtRegistroUsuario.getText().toString(),
                txtRegistroPassword.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(RegistroActivity.class.getName(), "Tarea completa: " + task.isSuccessful());

                        if (task.isSuccessful()) {
                            Intent intent = new Intent(RegistroActivity.this, ListaIMCActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(RegistroActivity.this, task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }

                        progress.dismiss();

                    }
                });
    }
}
