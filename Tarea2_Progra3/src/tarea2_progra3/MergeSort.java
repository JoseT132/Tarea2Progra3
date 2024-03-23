package tarea2_progra3;

import java.util.Scanner;

public class MergeSort {

    private int[] numeros;

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    public void mergeSort() {
        Scanner dato = new Scanner(System.in);
        System.out.println("Ingrese los valores separados por coma");
        String entrada = dato.nextLine();
        String[] partes = entrada.split(",");
        numeros = new int[partes.length];

        for (int i = 0; i < partes.length; i++) {
            numeros[i] = Integer.parseInt(partes[i].trim()); //Se eliminan los espacios en blanco     
        }
        int[] ayudante = new int[numeros.length];
        mergesort(this.numeros, ayudante, 0, numeros.length - 1);
    }
    private void mergesort(int[] numeros , int[] ayudante , int izquierda, int derecha){
        if(izquierda<derecha){
            int medio = izquierda +(derecha-izquierda)/2;
            //ordenar mitad izquierda
            mergesort( numeros , ayudante, izquierda, medio);
            //ordena mitad derecha
            mergesort(numeros , ayudante, medio +1 , derecha);
            // combinar las mitades 
            merge(numeros, ayudante , izquierda, medio , derecha);
        }
    }
    private void merge(int[] numeros, int[] ayudante, int izquierda, int medio, int derecha){
     //copiar al arreglo auxiliar
     for (int i= izquierda ; i <= derecha ; i++){
         ayudante[i]=numeros[i];
     }
     int ayudanteizquierdo= izquierda;
     int ayudantederecho= medio +1;
     int valoractual= izquierda;
     
     //Iterar sobre el auxiliar 
     //Comparar las mitades
     while(ayudanteizquierdo <= medio && ayudantederecho <=derecha){
         if(ayudante[ayudanteizquierdo]<=ayudante[ayudantederecho]){
             numeros[valoractual]=ayudante[ayudanteizquierdo];
             ayudanteizquierdo++;
         }else{
             numeros[valoractual]=ayudante[ayudantederecho];
             ayudantederecho++;
         }
         valoractual++;
     }
     //copiar elementos restantes si los hubieran 
      while(ayudanteizquierdo <= medio){
          numeros[valoractual]= ayudante[ayudanteizquierdo];
          valoractual++;
          ayudanteizquierdo++;
      }
    }
      public void arregloOrdenado() {
        System.out.println("Valores ordenados");
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}
