
package com.mycompany.problema8;
import java.util.*;

public class Problema8 {

    public static void main(String[] args) {
        Scanner dato=new Scanner (System.in);
        int opcion=0;
       do{
        System.out.println("Bienvenido a la calculadora, por favor elija una opcion"); 
        System.out.println("Digite la opción que desea ejecutar");
        System.out.println("1.Multiplicacion");
        System.out.println("2.Division");
        System.out.println("3.Salir del programa");
        opcion=dato.nextInt();
        
        
           switch (opcion){
            case 1:
              multiplicacion ();
                break;
            case 2:
                division();
                break;
            case 3:
                break;
        }   
       }while (opcion!=3);
        
    }
    
    
   
    static void multiplicacion (){
     System.out.println("Ingrese el primer numero");
     Scanner valor=new Scanner (System.in);
     int num1=valor.nextInt();
     System.out.println("Ingrese el segundo numero");
     int num2=valor.nextInt();
     int sumatoria=0;
     for(int i=1 ;i<=num1;i++){
     sumatoria=sumatoria+num2;
     }
     System.out.println("El resultado de la multiplicación es ="+sumatoria);
    }

    
    static void division(){
    System.out.println("Ingrese el primer numero");
    Scanner valor=new Scanner (System.in);
    int num1=valor.nextInt();
    System.out.println("Ingrese el segundo numero");
    int num2=valor.nextInt();
    int cociente=0, dividendo=num1;
    while(dividendo>0){
      dividendo=dividendo-num2;
        cociente++;
    }
    System.out.println("El resultado de la division es ="+cociente);   
  }
}



