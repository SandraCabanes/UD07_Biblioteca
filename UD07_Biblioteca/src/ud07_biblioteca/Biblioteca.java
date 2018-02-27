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
    
    public void añadirLibro(Libros l){
        libros.add(l);
    }
    
    public void mostrarLibros(){
        for (Libros libro : libros) {
            System.out.println(libro);
        }
    }
    
    public Socios buscarSocio(String dni){
        for (Socios s : socios) {
            if(s.getDni().equalsIgnoreCase(dni)){
                return s;
            }
        }
        return null;
    }
    
    public Libros buscarLibro(String ISBN){
        for (Libros libro : libros) {
            if(libro.getISBN().equalsIgnoreCase(ISBN)){
                return libro;
            }
        }
        return null;
    }
    
    public boolean comprobarCopias(Libros libroActivo){
        if(libroActivo.getCopias()>0){
            return true;
        }
        return false;
    }
    
    public ArrayList listadoGeneros(String genero){
        ArrayList<Libros> generoLibros=new ArrayList<Libros>();
        for (Libros listadoLibros : libros) {
            if(listadoLibros.getGenero().equalsIgnoreCase(genero)){
                generoLibros.add(listadoLibros);
            }
        }
        return generoLibros;
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
