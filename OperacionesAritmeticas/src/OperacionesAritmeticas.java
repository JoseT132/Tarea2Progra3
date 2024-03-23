
import java.util.Scanner;


public class OperacionesAritmeticas {


    public static void main(String[] args) {
   int suma, resta, multiplicacion , division ;
        
        System.out.println("Bienvenido a la calculadora de Operaciones Aritmeticas");
        Scanner dato= new Scanner (System.in);
        System.out.println("Ingrese el primer valor ");
        int num1 =dato.nextInt();
        System.out.println("Ingrese el segundo valor");
        int num2 = dato.nextInt();
        
        suma=num1+num2;
        resta=num1-num2;
        multiplicacion=num1*num2;
        division=num1/num2;
        
        System.out.println("El resultado de la suma es ="+suma);
        System.out.println("El resultado de la resta es ="+resta);
        System.out.println("El resultado de la multiplicacion es ="+multiplicacion);
        System.out.println("El resultado de la division es ="+division);
    }
    
}
