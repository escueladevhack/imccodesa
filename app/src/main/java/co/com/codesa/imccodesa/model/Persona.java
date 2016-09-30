package co.com.codesa.imccodesa.model;

/**
 * Created by krlosf on 24/09/16.
 */
public class Persona {
    private String nombre;
    private double altura;
    private double peso;
    private double imc;

    public Persona() {
    }

    public Persona(String nombre, double altura, double peso, double imc) {
        this.nombre = nombre;
        this.altura = altura;
        this.peso = peso;
        this.imc = imc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }
}
