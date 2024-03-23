
package com.mycompany.impinterface;

import java.util.Scanner;


public class Carniceria {
    public static void main (String args []){
        Scanner dato= new Scanner (System.in);
        System.out.println("Bienvenido a la carniceria");
        Producto p1= new Producto ();
        System.out.println("Ingrese el nombre del producto");
        String nombre=dato.nextLine();
        p1.setNombre(nombre);
        
    }
}
