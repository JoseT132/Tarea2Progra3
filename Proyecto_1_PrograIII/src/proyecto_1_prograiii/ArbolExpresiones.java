package proyecto_1_prograiii;

import java.util.*;

public class ArbolExpresiones {
    Nodo raiz;

    ArbolExpresiones() {
        raiz = null;
    }
    
      class Nodo {
        char valor;
        Nodo izquierdo, derecho;

        public Nodo(char valor) {
            this.valor = valor;
            izquierdo = derecho = null;
        }
    }

    void insertar(char valor) {
        raiz = insertarRecursiva(raiz, valor);
    }

    private Nodo insertarRecursiva(Nodo nodo, char valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursiva(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursiva(nodo.derecho, valor);
        }

        return nodo;
    }

    void insertarN(char valor) {
        raiz = new Nodo(valor);
    }

    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.valor + ", ");
            inorden(nodo.derecho);
        }
    }

  
}


