package Controlador;

import Modelo.Coche;
import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JLabel;

public class listaCoche {
    private ArrayList<Coche> lista;
    int indice;
    public listaCoche() {
        this.lista = new ArrayList<>();
        this.indice = 0;
    }
    
    public boolean esVacia(){
       if (lista.isEmpty()){
           return true;
       }
       return false;
    }
    public void avanzar(){
        if (indice < lista.size() - 1) {
            indice++;
        }
    }
    
    public void retroceder(){
        if (indice > 0) {
            indice--;
        }
    }
    
    public void irAPrimero(){
        indice = 0;
    }
    
    public void irAlUltimo(){
        if (!lista.isEmpty()) {
            indice = lista.size() - 1;
        }
    }
    public Coche obtenerCocheActual() {
        if (lista.isEmpty() || indice < 0 || indice >= lista.size()) {
            return null;
        }
        return lista.get(indice);
    }
    
    public boolean añadirCoche(String matricula,LocalDate fechaMat,float precio,JLabel lblError){
        if (ControlDeErrores.validarCoche(fechaMat,precio, lblError)) {
            lista.add(new Coche(matricula,fechaMat,precio));
            indice = lista.size() - 1;
            return true;
        }
        return false;
    }
    
    public static class ControlDeErrores{
        public static boolean validarCoche(LocalDate fechaMat, float precio, JLabel lblMensaje) {

            int anio = fechaMat.getYear();
            if (anio < 1990 || anio > 2026) {
                mostrarError(lblMensaje, "Error: El año debe estar entre 1900 y 2015.");
                return false;
            }

            if (precio < 0 || precio > 150.000) {
                mostrarError(lblMensaje, "Error: Los puntos deben estar entre 0 y 1000.");
                return false;
            }

            lblMensaje.setText("");
            return true;
        }
        
        private static void mostrarError(JLabel lblMensaje, String mensaje) {
            lblMensaje.setForeground(Color.RED);
            lblMensaje.setText(mensaje);
        }
    }
}
