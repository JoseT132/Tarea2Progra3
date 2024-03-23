
package mesdia;

import java.util.*;

public class MesDia {
    
    public static void main(String[] args) {
        //Desarrolle un programa en Java que permita determinar a partir de un número de días, ingresado por pantalla, ¿Cuántos
//años, meses, semanas y días?; constituyen el número de días proporcionado utilizando la estructura While.
        int dias=0, contador=1;
        float anio=0, mes=0 , semanas=0;
        Scanner dato =new Scanner (System.in);
        
        while (contador>0){
           System.out.println("Ingrese el numero de Días"); 
            dias=dato.nextInt();
            if (dias>0){
                anio=dias/364;
                mes=anio*12;
                semanas=anio*52;
                        
            }
            contador=contador-1;
        }
        
        System.out.println("El numero de años es ="+anio );
        System.out.println("El numero de meses es ="+mes );
        System.out.println("El numero de semanas es ="+semanas );
        System.out.println("El numero de dias es ="+dias );
    }
    
}
