/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ud07_biblioteca;

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
        int op = 0;
        String nombreBiblioteca, nombreSocio, dni;
        
        Calendar fechaAlta=Calendar.getInstance();
        Biblioteca biblio;
        Socios socio;

        do {
            menu();
            System.out.print("Elige una opción: ");
            op = teclado.nextInt();

            teclado.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Introduce nombre biblioteca: ");
                    nombreBiblioteca = teclado.nextLine();

                    biblio = new Biblioteca(nombreBiblioteca);
                    break;
                    
                case 2:
                    System.out.print("DNI: ");
                    dni=teclado.nextLine();
                    System.out.println("Nombre: ");
                    nombreSocio=teclado.nextLine();
                    
                    socio=new Socios(dni, nombreSocio, fechaAlta);
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (op != 0);
    }

    public static void menu() {
        System.out.println("1- Dar de alta la biblioteca\n"
                + "	2- Dar de alta un socio\n"
                + "	3- Dar de alta un libro\n"
                + "	4- Préstamo de libros\n"
                + "	5- Listado de socios que todavía no han devuelto los libros\n"
                + "	6- Listado de libros por género");
    }

}
