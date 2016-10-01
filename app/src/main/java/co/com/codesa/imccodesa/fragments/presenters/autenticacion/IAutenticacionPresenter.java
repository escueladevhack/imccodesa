package co.com.codesa.imccodesa.fragments.presenters.autenticacion;

/**
 * Created by jggomezt on 30/09/2016.
 */

public interface IAutenticacionPresenter {

    void ingresar(String email, String password);
    void crearCuenta();

}
