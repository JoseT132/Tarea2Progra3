package tarea3;

import java.util.*;

public class NodoA {

    private int n; // numero de claves en los nodos
    private boolean hoja; // verifica si el nodo es una hoja 
    private int clave[]; // almacena las claves del arbol 
    private NodoA hijo[]; // arreglo que referencia a los hijos

    public NodoA(int t) {
        n = 0;
        hoja = true;
        clave = new int[((2 * t) - 1)];
        hijo = new NodoA[(2 * t)];
    }

    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(clave[i] + "|");

            } else {
                System.out.print(clave[i]);
            }
        }
        System.out.print("]");
    }

    public int encontrar(int k) { // k de key o clave 
        for (int i = 0; i < n; i++) {
            if (clave[i] == k) {
                return i;
            }
        }
        return -1;
    }
}
