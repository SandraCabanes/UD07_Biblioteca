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
public class Prestamos {
    private Calendar fechaPrestamo;
    private Calendar fechaDevolucion;
    private Socios socio;

    public Prestamos() {
    }

    public Prestamos(Calendar fechaPrestamo, Calendar fechaDevolucion, Socios socio) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.socio = socio;
    }

    @Override
    public String toString() {
        return "Prestamos{" + "fechaPrestamo=" + fechaPrestamo.getTime() + ", fechaDevolucion=" + fechaDevolucion.getTime() + ", socio=" + socio + '}';
    }
    
    

    public Calendar getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Calendar fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Calendar getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Calendar fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }
    
    
}
