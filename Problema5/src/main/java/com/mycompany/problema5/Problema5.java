
package com.mycompany.problema5;

import java.util.*;

public class Problema5 {

    public static void main(String[] args) {
       //El sueldo por hora será de Q.8
    
       System.out.println("Bienvenido , ingrese el número de horas laboradas");
       Scanner dato=new Scanner (System.in);
       float hora=dato.nextFloat();
       double salarioL; //salario liquido
       double IGGS, ISR , salarioB;//salario+bonificacion+horaextra
       double salarioN; //Salario neto
       double horaX;// hora extra
       double salariox;// pago por horas extra
       if (hora<=40){
           
           salarioL=hora*8;
           salarioB=salarioL+250;
           IGGS=salarioB*0.0483;
           ISR=salarioB*0.05;
           salarioN=salarioB-(IGGS+ISR);
           
           System.out.println("Salario por horas laboradas ="+salarioL);
           System.out.println("Salario por horas extras = 0");
           System.out.println("Bonificación Decreto 78-89 = 250");
           System.out.println("Total salario+bonicacion="+salarioB);
           System.out.println("Descuento IGGS="+IGGS);
           System.out.println("Descuento ISR="+ISR);
           System.out.println("Total a devengar="+salarioN);
       }else{
           horaX=hora-40;
           salarioL=(hora-horaX)*8;
           salariox=horaX*8*1.5;
           salarioB=salarioL+250+salariox;
           IGGS=salarioB*0.0483;
           ISR=salarioB*0.05;
           salarioN=salarioB-(IGGS+ISR);
           
           
           System.out.println("Salario por horas laboradas ="+salarioL);
            System.out.println("Horas extras laboradas = "+horaX);
           System.out.println("Salario por horas extras ="+salariox);
           System.out.println("Bonificación Decreto 78-89 = 250");
           System.out.println("Total salario+horas extras+bonicacion="+salarioB);
           System.out.println("Descuento IGGS="+IGGS);
           System.out.println("Descuento ISR="+ISR);
           System.out.println("Total a devengar="+salarioN);
           
       }
       
    }
}

