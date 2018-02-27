/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ud07_biblioteca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int op = 0, añoPublicacion, copias = 0;
        String nombreBiblioteca, nombreSocio, dni, titulo, autor, ISBN, genero;
        boolean disponible=false;
        
        Calendar fechaAlta = Calendar.getInstance();
        Calendar fechaPrestamo=Calendar.getInstance();
        Calendar fechaDevolucion=Calendar.getInstance();
        
        Biblioteca biblio = null;
        Socios socioActivo;
        Libros libroActivo;
        Prestamos prestamo;

        do {
            menu();
            System.out.print("Elige una opción: ");
            op = teclado.nextInt();

            teclado.nextLine(); //buffer

            switch (op) {
                case 1:
                    System.out.print("Introduce nombre biblioteca: ");
                    nombreBiblioteca = teclado.nextLine();

                    biblio = new Biblioteca(nombreBiblioteca);
                    break;

                case 2:
                    do {
                        System.out.print("DNI: ");
                        dni = teclado.nextLine();
                        socioActivo = biblio.buscarSocio(dni);
                    } while (socioActivo != null);

                    System.out.println("Nombre: ");
                    nombreSocio = teclado.nextLine();

                    socioActivo = new Socios(dni, nombreSocio, fechaAlta);
                    break;

                case 3:

                    do {
                        System.out.print("ISBN: ");
                        ISBN = teclado.nextLine();
                        libroActivo = biblio.buscarLibro(ISBN);
                    } while (libroActivo != null);

                    System.out.print("Título: ");
                    titulo = teclado.nextLine();
                    System.out.print("Autor: ");
                    autor = teclado.nextLine();
                    System.out.print("Año de publicación: ");
                    añoPublicacion = teclado.nextInt();
                    teclado.nextLine(); //buffer
                    System.out.print("Género [fantasía, histórica, romántica, suspense, juvenil]: ");
                    genero = teclado.nextLine();

                    libroActivo = new Libros(titulo, autor, ISBN, añoPublicacion, genero);
                    break;

                case 4:
                    System.out.print("DNI: ");
                    dni = teclado.nextLine();
                    socioActivo = biblio.buscarSocio(dni);
                    if (socioActivo != null) {
                        biblio.mostrarLibros();
                        System.out.print("ISBN: ");
                        ISBN = teclado.nextLine();
                        libroActivo = biblio.buscarLibro(ISBN);
                        if (libroActivo != null) {
                            disponible=biblio.comprobarCopias(libroActivo);
                            if(disponible){
                                libro.modificarDevolucion(fechaPrestamo);
                                
                                prestamo=new Prestamos(fechaPrestamo, fechaDevolucion, socioActivo);
                            }else{
                                System.out.println("No hay copias disponibles, vuelve a intentarlo otro día");
                            }
                        } else {
                            System.out.println("El libro no está disponible en la biblioteca");
                        }
                    } else {
                        System.out.println("El socio no está registrado en la biblioteca");
                    }
                    break;

                case 5:

                    System.out.print("ISBN: ");
                    ISBN = teclado.nextLine();
                    libroActivo = biblio.buscarLibro(ISBN);
                    if (libroActivo != null) {
                        System.out.print("Copias a añadir: ");
                        copias = teclado.nextInt();
                        libroActivo.setCopias(copias);
                    } else {
                        System.out.println("El libro no está disponible en la biblioteca");
                    }
                    break;

                case 6:

                    break;

                case 7:
                    System.out.print("Género [fantasía, histórica, romántica, suspense, juvenil]: ");
                    genero = teclado.nextLine();
                    ArrayList<Libros> generoLibros = new ArrayList<Libros>();
                    generoLibros = biblio.listadoGeneros(genero);
                    mostrarListadoGenero(generoLibros);
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (op != 0);
    }

    public static void menu() {
        System.out.println("1- Dar de alta la biblioteca\n"
                + "2- Dar de alta un socio\n"
                + "3- Dar de alta un libro\n"
                + "4- Préstamo de libros\n"
                + "5- Añadir copias\n"
                + "6- Listado de socios que todavía no han devuelto los libros\n"
                + "7- Listado de libros por género");
    }

    public static void mostrarListadoGenero(ArrayList<Libros> generoLibros) {
        for (Libros libro : generoLibros) {
            System.out.println(libro);
        }
    }

}
