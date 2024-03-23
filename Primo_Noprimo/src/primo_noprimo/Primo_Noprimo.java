
package primo_noprimo;

import java.util.*;

public class Primo_Noprimo {

    public static void main(String[] args) {
        //Desarrolle un programa en Java que permita leer un valor entero positivo N y determinar si es primo o no.
        int num, contador=1 , Dcontador=0;
        System.out.println("Por favor ingrese un numero");
        Scanner dato=new Scanner (System.in);
        num=dato.nextInt();
        
        while (contador<=num){
            if (num % contador==0){
                Dcontador++;
            }
            contador++;
        }
        if (Dcontador==2){
            System.out.println("El numero ingresado es primo");
        }else {
           System.out.println("El numero ingresado no es primo");
        }
    }
    
}
