
package promedionotas;

import java.util.*;

public class PromedioNotas {

   
    public static void main(String[] args) {
        // Desarrolle un programa en Java que permita calcular Promedio de Notas; finaliza cuando N = 0.
        float suma=0; int contador=0;
        float num=1, promedio=0 ;
        Scanner dato=new Scanner (System.in);
        
        while (num >0){
        System.out.println("Por favor ingrese una nota");
        num= dato.nextInt();
        if (num>0){
        suma=suma+num;
        contador++;
        promedio=(suma/contador); 
        }
        
    }
        if (contador==0){
            System.out.println("El promedio de las calificaciones es 0");
        }else{
        
            System.out.println("El promedio de las calificaciones es "+promedio);
         }
        
        }
        
    }
    
