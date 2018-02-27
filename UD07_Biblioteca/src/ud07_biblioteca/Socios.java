/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ud07_biblioteca;

import java.util.Calendar;

/**
 *
 * @author mati
 */
public class Socios {
    private String dni;
    private String nombre;
    private Calendar fechaAlta;

    public Socios() {
    }

    public Socios(String dni, String nombre, Calendar fechaAlta) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Socios{" + "dni=" + dni + ", nombre=" + nombre + ", fechaAlta=" + fechaAlta.getTime() + '}';
    }

    
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Calendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    
}
