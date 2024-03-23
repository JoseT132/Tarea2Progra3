
package tarea2_progra3;
import java.util.*;

public class Burbuja {
    private int[] numeros;

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }
    public void OrdenaBurbuja(){
        Scanner dato = new Scanner(System.in);
        System.out.println("Ingrese los valores separados por coma");
        String entrada = dato.nextLine();
        String[] partes = entrada.split(",");
        numeros = new int[partes.length];

        for (int i = 0; i < partes.length; i++) {
            numeros[i] = Integer.parseInt(partes[i].trim()); //Se eliminan los espacios en blanco 
        }
        int tamanio=numeros.length;
        // Se ejecuta el bucle dos veces , uno para el array y el otro para comparaciones
        for(int i=0; i<tamanio-1;i++){
            //generar registro de intercambios
            boolean intercambio= false;
            for (int j=0; j<tamanio -i-1; j++){
                //ordenamiento en forma descendente
                if (numeros[j]> numeros[j+1]){
                    //Intercambio
                    int temp=numeros[j];
                    numeros[j]=numeros[j+1];
                    numeros[j+1]=temp;
                   
                    intercambio=true;
                   
                }
            }
            //si no hay mas intercambios en la ultima comparacion , el array esta ordenado
            if(!intercambio){
                break;
            }
                
        }
    }
    public void arregloOrdenado(){
        System.out.println("Valores ordenados");
        for (int numero: numeros){
            System.out.println(numero);
        }
    }
}
