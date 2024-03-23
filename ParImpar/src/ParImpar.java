
import java.util.Scanner;

public class ParImpar {


    public static void main(String[] args) {
    //Desarrolle un programa en Java que permita leer un valor cualquiera N y escriba si dicho número es par o impar.
    float resultado=0;
    System.out.println("Bienvenido a la calculadora de numeros pares e impares");
    Scanner dato= new Scanner (System.in);
    System.out.println("Ingrese un numero ");
    int num= dato.nextInt();
    
   resultado= num % 2 ;
   
   if (resultado == 0){
       System.out.println("El numero es Par");
   }else{
       System.out.println("El numero es Impar");
   }
}
}
