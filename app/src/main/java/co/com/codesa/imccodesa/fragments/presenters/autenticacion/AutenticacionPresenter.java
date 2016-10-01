package co.com.codesa.imccodesa.fragments.presenters.autenticacion;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import co.com.codesa.imccodesa.fragments.autenticacion.IAutenticacionView;

/**
 * Created by jggomezt on 30/09/2016.
 */

public class AutenticacionPresenter implements IAutenticacionPresenter {

    private IAutenticacionView view;
    private FirebaseAuth mAuth;
    private Activity context;

    public AutenticacionPresenter(IAutenticacionView view, Activity context) {
        this.view = view;
        this.context = context;
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void ingresar(String email, String password) {

        view.mostrarLoading();

        final String emailtmp = email;

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            SharedPreferences sp = context.getSharedPreferences("user_data", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putBoolean("isActived", true);
                            editor.putString("email", emailtmp);
                            editor.commit();

                            view.goToHistorialMC();

                        } else {
                            view.mostrarErrorAutenticacion(task.getException());
                        }

                        view.ocultarLoading();
                    }
                });
    }

    @Override
    public void crearCuenta() {
        view.goToCrearCuenta();
    }
}
