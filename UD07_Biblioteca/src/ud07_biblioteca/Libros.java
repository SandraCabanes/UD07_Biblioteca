/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ud07_biblioteca;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author mati
 */
public class Libros {
    private String titulo;
    private String autor;
    private String ISBN;
    private Calendar añoPublicacion;
    private String genero;
    private ArrayList<Prestamos> prestamo;

    public Libros() {
    }

    public Libros(String titulo, String autor, String ISBN, Calendar añoPublicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.añoPublicacion = añoPublicacion;
        this.genero = genero;
        this.prestamo=new ArrayList<Prestamos>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Calendar getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(Calendar añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<Prestamos> getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(ArrayList<Prestamos> prestamo) {
        this.prestamo = prestamo;
    }
    
    
}
