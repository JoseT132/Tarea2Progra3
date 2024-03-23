package tarea2_progra3;

import java.util.Scanner;

public class RadixSort {

    private int[] numeros;

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    public void radixsort() {
        Scanner dato = new Scanner(System.in);
        System.out.println("Ingrese los valores separados por coma");
        String entrada = dato.nextLine();
        String[] partes = entrada.split(",");
        numeros = new int[partes.length];

        for (int i = 0; i < partes.length; i++) {
            numeros[i] = Integer.parseInt(partes[i].trim()); //Se eliminan los espacios en blanco     
        }
        //Encontrar el numero mayor
        int mayor = encuentramaximo(numeros);
        // contar por counting sort cada digito 
        for (int posicion = 1; mayor / posicion > 0; posicion *= 10) {
            cuentasort(posicion);
        }
    }

    private void cuentasort(int posicion) {
        int n = numeros.length;// cuenta el tamaño del arreglo
        int[] salida = new int[n];
        int[] contador = new int[10];

// contar cuantas veces aparece cada numero
        for (int i = 0; i < n; i++) {
            contador[(numeros[i] / posicion) % 10]++;
        }
        //Calcular la posicion de los digitos
        for (int i = 1; i < 10; i++) {
            contador[i] += contador[i - 1];
        }
        // Arreglo ya ordenado
        for (int i = n - 1; i >= 0; i--) {
            salida[contador[(numeros[i] / posicion) % 10] - 1] = numeros[i];
            contador[(numeros[i] / posicion) % 10]--;
        }
        // copiar el arreglo de salida
        System.arraycopy(salida, 0, numeros, 0, n);
    }

    private int encuentramaximo(int[] numeros) {
        int maximo = numeros[0];
        for (int numero : numeros) {
            if (numero > maximo) {
                maximo = numero;
            }
        }
        return maximo;
    }

    public void arregloOrdenado() {
        System.out.println("Valores ordenados");
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}
