   

package com.mycompany.promedio;

import java.util.Scanner;

public class Promedio {

    public static void main(String[] args) {
        
 //Desarrolle un programa en Java que lea n cantidad de calificaciones y muestre al final el promedio de ellas, asÃ­ mismo,
//cuantas calificaciones fueron aprobadas y cuantas reprobadas

   
    int suma=0;
    float promedio=0;
    int notas=1;
    
    System.out.println ("Bienvenido a la calculadora de promedios ");
     Scanner dato = new Scanner (System.in);
    System.out.println ("Ingrese la cantidad de valores a operar");
    int n = dato.nextInt();//cantidad de notas 
    
    while (notas<= n){
     System.out.println("Ingrese una calificaciÃ³n");
       int num = dato.nextInt();
       suma=suma+num;
       notas++;
      }
     promedio=(suma/n);
     System.out.println("El promedio de las calificaciones es ="+promedio);
     if (promedio>=61){
        System.out.println("El alumno aprobo");
     }else {
       System.out.println("El alumno reprobo");
     }
    }
}

