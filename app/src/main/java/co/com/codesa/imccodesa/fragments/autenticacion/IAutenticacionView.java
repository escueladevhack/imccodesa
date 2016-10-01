package co.com.codesa.imccodesa.fragments.autenticacion;

/**
 * Created by jggomezt on 30/09/2016.
 */

public interface IAutenticacionView {

    void mostrarLoading();
    void ocultarLoading();
    void ingresar();
    void crearCuenta();
    void goToCrearCuenta();
    void goToHistorialMC();
    void mostrarErrorAutenticacion(Exception ex);

}
