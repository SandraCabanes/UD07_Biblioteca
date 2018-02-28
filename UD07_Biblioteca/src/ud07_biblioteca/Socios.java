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
    private String id;
    private String nombre;
    private Calendar fechaAlta;

    public Socios() {
    }

    public Socios(String id, String nombre, Calendar fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Socios{" + "id=" + id + ", nombre=" + nombre + ", fechaAlta=" + fechaAlta.getTime() + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
