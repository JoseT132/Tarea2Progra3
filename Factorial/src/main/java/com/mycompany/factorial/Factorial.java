
package com.mycompany.factorial;

import java.util.*;

public class Factorial {

    public static void main(String[] args) {
       System.out.println ("Bienvenido a la calculadora factorial");
       System.out.println ("Por favor ingrese un numero ");
       int num;
       int factorial=1;
       Scanner dato= new Scanner (System.in);
       num=dato.nextInt();
       
       if(num ==0&& num==1){
           System.out.println("El factorial es = 1");
       }else{
           for(int i=1;i<=num;i++){
       factorial=factorial*i;
         
        }
       }
       
       System.out.println("El factorial es ="+factorial);
       
    
    }       
}


