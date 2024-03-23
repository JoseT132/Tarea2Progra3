
package com.mycompany.problema6;

import java.util.*;

public class Problema6 {

    public static void main(String[] args) {
     int  edad, nino=0, joven=0, adulto=0, adultoM=0, encuestados;
     float peso=0, peso_nino=0, peso_joven=0, peso_adulto=0,peso_adultoM=0;
     float promedio_nino=0, promedio_joven=0, promedio_adulto=0, promedio_adultoM=0;
     System.out.println("Ingrese la cantidad de encuestados");
     Scanner dato=new Scanner (System.in);
     encuestados=dato.nextInt();
     
     for( int i=1; i<=encuestados;i++){
         System.out.println("Persona no."+i);
         System.out.println("Ingrese la edad");
         edad=dato.nextInt();
         System.out.println("Ingrese el peso");
         peso=dato.nextFloat();
         
         if(edad<0){
             System.out.println("La edad ingresada no es valida");
         }else{
             if(edad<=12){
                 peso_nino=peso_nino+peso;
                 nino=nino+1;
                 promedio_nino=peso_nino/nino;
             }else{
                 if(edad<=29){
                     peso_joven=peso_joven+peso;
                     joven=joven+1;
                     promedio_joven=peso_joven/joven;
                 }else{
                     if(edad<=59){
                         peso_adulto=peso_adulto+peso;
                         adulto=adulto+1;
                         promedio_adulto=peso_adulto/adulto;
                     }else{
                         peso_adultoM=peso_adultoM+peso;
                         adultoM++;
                         promedio_adultoM=peso_adultoM/adultoM;
                         
                     }
                 }
             }
         }
     }
     
     System.out.println("El peso promedio de niños de 0 a 12 es="+promedio_nino);
     System.out.println("El peso promedio de jovenes de 13 a 29 es="+promedio_joven);
     System.out.println("El peso promedio de adultos de 30 a 59 es="+promedio_adulto);
     System.out.println("El peso promedio de adultos mayores de 60 a 100 es="+promedio_adultoM);
       }
       
       
    }

