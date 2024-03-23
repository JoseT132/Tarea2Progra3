package tareaii_prograiii;

import java.util.Scanner;

public class CountingSort {

    private int[] numeros;

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    public void countingsort() {
        Scanner dato = new Scanner(System.in);
        System.out.println("Ingrese los valores separados por coma");
        String entrada = dato.nextLine();
        String[] partes = entrada.split(",");
        numeros = new int[partes.length];

        for (int i = 0; i < partes.length; i++) {
            numeros[i] = Integer.parseInt(partes[i].trim()); //Se eliminan los espacios en blanco     
        }
        int maximo = encuentramaximo(numeros);// busca el maximo valor implementado el metodo privado
        int[] contador = new int[maximo + 1];

        // contar cuantas veces aparece cada numero
        for (int valores : numeros) {
            contador[valores]++;
        }
        // formar el arreglo ya ordenado 
        int salida = 0;
        for (int i = 0; i < contador.length; i++) {
            while (contador[i] > 0) {
                numeros[salida] = i;
                salida++;
                contador[i]--;
            }
        }
        arregloOrdenado(); // Impresion de los valores
    }

    //encuentro el valor mas grande para realizar las comparaciones
    private int encuentramaximo(int[] arreglo) {
        int maximo = arreglo[0];
        for (int numero : arreglo) {
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
