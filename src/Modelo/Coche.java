package Modelo;

import java.time.LocalDate;

public class Coche {
    private String matricula;
    private LocalDate fechaMatricula;
    private float precio;

    public Coche(String matricula, LocalDate fechaMatricula, float precio) {
        this.matricula = matricula;
        this.fechaMatricula = fechaMatricula;
        this.precio = precio;
    }

    public Coche() {
    }

    public String getMatricula() {return matricula;}
    public void setMatricula(String matricula) {this.matricula = matricula;}
    public LocalDate getFechaMatricula() {return fechaMatricula;}
    public void setFechaMatricula(LocalDate fechaMatricula) {this.fechaMatricula = fechaMatricula;}
    public float getPrecio() {return precio;}
    public void setPrecio(float precio) {this.precio = precio;}

    @Override
    public String toString() {
        return "Coche{" + "matricula=" + matricula + ", fechaMatricula=" + fechaMatricula + ", precio=" + precio + '}';
    }
    
    
}
