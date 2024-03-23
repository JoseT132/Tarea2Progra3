
import java.util.*;
public class Hexadecimal {

  
    public static void main(String[] args) {
        //Desarrolle un programa en Java para convertir un numero de decimal a hexadecimal.
      Scanner dato= new Scanner (System.in);
      System.out.println("Por favor ingrese un numero");
      
      int numeroDecimal=dato.nextInt();
      String resultado=convertirDecimalaHexadecimal(numeroDecimal);
      
      System.out.printf("%d (10)=%s (16)\n", numeroDecimal, resultado);
      
    }
    public static String  convertirDecimalaHexadecimal(int numeroDecimal){
        int residuo;
        String hexadecimal= " ";
        char[] hexadecimales= { '0', '1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        
        while (numeroDecimal>0){
            residuo =numeroDecimal %16;
            hexadecimal=hexadecimales[residuo]+hexadecimal;
            
            numeroDecimal/=16;
        }
        return hexadecimal;
    }
    
}
