package tarea2_progra3;

import java.util.*;

public class InsertionSort {

    private int[] numeros;

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    public void InsertaSort() {
        Scanner dato = new Scanner(System.in);
        System.out.println("Ingrese los valores separados por coma");
        String entrada = dato.nextLine();
        String[] partes = entrada.split(",");
        numeros = new int[partes.length];

        for (int i = 0; i < partes.length; i++) {
            numeros[i] = Integer.parseInt(partes[i].trim()); //Se eliminan los espacios en blanco     
        }
        int n = numeros.length;
        for (int i = 1; i < n; i++) {
            int mayor = numeros[i];
            int j = i - 1;

            // Mover los elementos mayores a la derecha
            while (j >= 0 && numeros[j] > mayor) {
                numeros[j + 1] = numeros[j];
                j=j-1;

            }
            numeros[j + 1] = mayor;
        }
    }

    public void arregloOrdenado() {
        System.out.println("Valores ordenados");
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}
