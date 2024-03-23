
import java.util.*;
        
public class MayorMenor {


    public static void main(String[] args) {
        float mayor=0;
        float menor=0;
    System.out.println("Ingrese la cantidad de numeros a evaluar ");
    Scanner dato= new Scanner (System.in);
    int valores = dato.nextInt();
    int contador=1;
    
    while (contador<=valores){
      System.out.println("Ingrese un número");
      float numero = dato.nextInt();
     
      if (contador==1){
        mayor=numero;
        menor=numero;
      } else {
          if (numero>mayor ){
              mayor=numero;
          }else {
              if (numero<menor){
                  menor=mayor;
              }
          }
      }
     contador++;  
    }
    
    System.out.println("El numero mayor es ="+mayor);
    System.out.println("El numero menor es ="+menor);
    }
    
}
