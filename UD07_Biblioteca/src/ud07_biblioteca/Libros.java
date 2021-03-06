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
    private int añoPublicacion;
    private String genero;
    private int copias;
    private ArrayList<Prestamos> prestamo;

    public Libros() {
    }

    public Libros(String titulo, String autor, String ISBN, int añoPublicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.añoPublicacion = añoPublicacion;
        this.genero = genero;
        this.copias = 2;
        this.prestamo = new ArrayList<Prestamos>();
    }
    
    public void añadirCopias(int copias){
        this.copias+=copias;
        
    }

    public void añadirPrestamo(Prestamos p){
        prestamo.add(p);
        this.copias--;
    }
    
    public void mostrarPrestamos(){
        for (Prestamos prestamos : prestamo) {
            System.out.println(prestamos);
        }
    }
    
    public ArrayList listarDevoluciones(Calendar fechaDevolucion){
        ArrayList<Socios> listaSocios=new ArrayList<Socios>();
        for (Prestamos prestamos : prestamo) {
            if(prestamos.getFechaDevolucion().after(fechaDevolucion)){
                Socios s=prestamos.getSocio();
                listaSocios.add(s);
            }
        }
        return listaSocios;
    }
    
    @Override
    public String toString() {
        return "Libros{" + "titulo=" + titulo + ", autor=" + autor + ", ISBN=" + ISBN + ", a\u00f1oPublicacion=" + añoPublicacion + ", genero=" + genero + ", prestamo=" + prestamo + '}';
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

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public int getCopias() {
        return copias;
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

    public void setCopias(int copias) {
        this.copias = copias;
    }
    
    

}
