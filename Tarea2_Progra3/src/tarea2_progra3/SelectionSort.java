package tarea2_progra3;

import java.util.*;

public class SelectionSort {

    private int[] numeros;

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    public void ordenaSort() {
        Scanner dato = new Scanner(System.in);
        System.out.println("Ingrese los valores separados por coma");
        String entrada = dato.nextLine();
        String[] partes = entrada.split(",");
        numeros = new int[partes.length];

        for (int i = 0; i < partes.length; i++) {
            numeros[i] = Integer.parseInt(partes[i].trim()); //Se eliminan los espacios en blanco 
        }

        int n = numeros.length; //N de numero de elementos
        //Los limites entre el array ordenado y desordenado se va desplazando a la derecha (el algoritmo crece en cada iteracion]
        for (int i = 0; i < n - 1; i++) {
            //encontrar el numero mas pequeño 
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (numeros[j] < numeros[i]){
                min = j;
                }
                //Intercambiar el elemento con valor mínimo por la primera posición del array no ordenado
                 
                int temp = numeros[min];
                numeros[min] = numeros[i];
                numeros[i] = temp;
            }
        }
    }
    public void arregloOrdenado(){
        int n= numeros.length;
        System.out.println();
        for (int i=0; i<n; i++){
            System.out.println(numeros[i]+" ");
            
        }
    }
    
}

