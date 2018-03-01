/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ud07_biblioteca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;

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
        String nombreBiblioteca, nombreSocio, idSocio, titulo, autor, ISBN, genero;
        boolean disponible = false;
        int año, mes, dia;

        Calendar fechaAlta = Calendar.getInstance();
        Calendar fechaPrestamo = Calendar.getInstance();
        Calendar fechaDevolucion = Calendar.getInstance();

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
                        System.out.print("ID: ");
                        idSocio = teclado.nextLine();
                        socioActivo = biblio.buscarSocio(idSocio);
                    } while (socioActivo != null);

                    System.out.print("Nombre: ");
                    nombreSocio = teclado.nextLine();

                    socioActivo = new Socios(idSocio, nombreSocio, fechaAlta);
                    biblio.añadirSocio(socioActivo);
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
                    biblio.añadirLibro(libroActivo);
                    break;

                case 4:
                    System.out.print("ID: ");
                    idSocio = teclado.nextLine();
                    socioActivo = biblio.buscarSocio(idSocio);
                    if (socioActivo != null) {
                        biblio.mostrarLibros();
                        System.out.print("ISBN: ");
                        ISBN = teclado.nextLine();
                        libroActivo = biblio.buscarLibro(ISBN);
                        if (libroActivo != null) {
                            disponible = biblio.comprobarCopias(libroActivo);
                            if (disponible) {
                                fechaDevolucion.add(Calendar.DATE, 7);
//                                fechaDevolucion.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
                                prestamo = new Prestamos(fechaPrestamo, fechaDevolucion, socioActivo);
                                libroActivo.añadirPrestamo(prestamo);
                                System.out.println("La fecha de devolución es el: " + fechaDevolucion.getTime());
                            } else {
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
                    System.out.print("ID: ");
                    idSocio = teclado.nextLine();
                    socioActivo = biblio.buscarSocio(idSocio);
                    if (socioActivo != null) {
                        biblio.mostrarLibros();
                        System.out.print("ISBN: ");
                        ISBN = teclado.nextLine();
                        libroActivo = biblio.buscarLibro(ISBN);
                        if (libroActivo != null) {
                            libroActivo.añadirCopias(1);
                        } else {
                            System.out.println("El libro no está disponible en la biblioteca");
                        }
                    } else {
                        System.out.println("El socio no está registrado en la biblioteca");
                    }
                    break;

                case 6:

                    System.out.print("ISBN: ");
                    ISBN = teclado.nextLine();
                    libroActivo = biblio.buscarLibro(ISBN);
                    if (libroActivo != null) {
                        System.out.print("Copias a añadir: ");
                        copias = teclado.nextInt();
                        libroActivo.añadirCopias(copias);
                        System.out.println("Actualmente hay " + libroActivo.getCopias() + " copias existentes.");
                    } else {
                        System.out.println("El libro no está disponible en la biblioteca");
                    }
                    break;

                case 7:

                    System.out.println("Año: ");
                    año = teclado.nextInt();
                    System.out.println("Mes: ");
                    mes = teclado.nextInt();
                    System.out.println("Día: ");
                    dia = teclado.nextInt();

                    fechaDevolucion.set(año, mes, dia);

                    ArrayList<Socios> devoluciones = new ArrayList<Socios>();

                    devoluciones = biblio.listadoDevoluciones(fechaDevolucion);
                    mostrarDevoluciones(devoluciones);

                    break;

                case 8:
                    System.out.print("Género [fantasía, histórica, romántica, suspense, juvenil]: ");
                    genero = teclado.nextLine();
                    ArrayList<Libros> generoLibros = new ArrayList<Libros>();
                    generoLibros = biblio.listadoGeneros(genero);
                    mostrarListadoGenero(generoLibros);
                    break;

                case 9:
                    biblio.mostrarLibros();
                    break;

                case 10:
                    biblio = new Biblioteca("Municipal");

                    socioActivo = new Socios("123", "Marta", fechaAlta);
                    biblio.añadirSocio(socioActivo);

                    socioActivo = new Socios("456", "Juan", fechaAlta);
                    biblio.añadirSocio(socioActivo);

                    libroActivo = new Libros("Los pilares de la tierra", "Ken Follett", "147", 1987, "histórica");
                    biblio.añadirLibro(libroActivo);

                    libroActivo = new Libros("Neverwhere", "Neil Gaiman", "258", 2000, "fantasía");
                    biblio.añadirLibro(libroActivo);

                    libroActivo = new Libros("El Resplandor", "Stephen King", "369", 1990, "suspense");
                    biblio.añadirLibro(libroActivo);

                    libroActivo = new Libros("Harry Potter y la piedra filosofal", "J.K.Rowling", "789", 1990, "juvenil");
                    biblio.añadirLibro(libroActivo);

                    prestamo = new Prestamos(fechaPrestamo, fechaDevolucion.getInstance(), socioActivo);
                    libroActivo.añadirPrestamo(prestamo);

                    break;

                case 0:
                    System.out.println("Saliendo");
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
                + "5- Devolver libro\n"
                + "6- Añadir copias\n"
                + "7- Lista de socios que tienen devoluciones pendientes\n"
                + "8- Listado de libros por género\n"
                + "9- Lista de libros disponibles\n"
                + "10- Cargar datos automáticamente");
    }

    public static void mostrarListadoGenero(ArrayList<Libros> generoLibros) {
        for (Libros libro : generoLibros) {
            System.out.println(libro);
        }
    }

    public static void mostrarDevoluciones(ArrayList<Socios> devoluciones) {
        for (Socios dev : devoluciones) {
            System.out.println(dev);
        }
    }

}
