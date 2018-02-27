/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ud07_biblioteca;

import java.util.ArrayList;

/**
 *
 * @author mati
 */
public class Biblioteca {
    private String nombre;
    private ArrayList<Libros> libros;
    private ArrayList<Socios> socios;

    public Biblioteca() {
    }

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros=new ArrayList<Libros>();
        this.socios=new ArrayList<Socios>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Libros> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libros> libros) {
        this.libros = libros;
    }

    public ArrayList<Socios> getSocios() {
        return socios;
    }

    public void setSocios(ArrayList<Socios> socios) {
        this.socios = socios;
    }
    
}
