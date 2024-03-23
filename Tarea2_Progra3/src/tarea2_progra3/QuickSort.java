package tarea2_progra3;

import java.util.Scanner;

public class QuickSort {

    private int[] numeros;

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    public void quicksort() {
        Scanner dato = new Scanner(System.in);
        System.out.println("Ingrese los valores separados por coma");
        String entrada = dato.nextLine();
        String[] partes = entrada.split(",");
        numeros = new int[partes.length];

        for (int i = 0; i < partes.length; i++) {
            numeros[i] = Integer.parseInt(partes[i].trim()); //Se eliminan los espacios en blanco     
        }
        //llamo al metodo privado
        quicksort(0, numeros.length-1);
    }

    private void quicksort(int izq, int der) {
        if (izq < der) {
            int indiceP = particion(izq, der);
            quicksort(izq, indiceP - 1); // ordena el arreglo izquierdo
            quicksort(indiceP + 1, der); //ordena el arreglo derecho
        }
    }

    private int particion(int izq, int der) {
        int pivote = numeros[izq]; // toma el primer valor como pivote
        int i = izq + 1; // elementos mayores
        int j = der; // elementos menores
        while (i <= j && numeros[i] <= pivote) {
            i++;
        }
        while (i <= j && numeros[j] > pivote) {
            j--;
        }
        // si no se encuentran elementos se intercambian
        if (i < j) {
            int temp = numeros[i];
            numeros[i] = numeros[j];
            numeros[j] = temp;
        }
        // colocar el pivote 
        int temp = numeros[izq];
        numeros[izq] = numeros[j];
        numeros[j] = temp;

        return j; //devuelbe la posicion del pivote 
    }

    public void arregloOrdenado() {
        System.out.println("Valores ordenados");
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}
