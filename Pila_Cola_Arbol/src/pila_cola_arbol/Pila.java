
package pila_cola_arbol;

import java.util.*;

public class Pila {
    private Stack<Integer> pilita = new Stack<>();
    private List<Integer> lista = new ArrayList<>();
    private Scanner dato = new Scanner(System.in);

    public void agregarElemento() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese un valor a la Pila:");
            int valor = dato.nextInt();
            pilita.push(valor);
            lista.add(valor);
            System.out.println("Valor agregado exitosamente.");

            System.out.println("¿Desea agregar otro valor? S/N");
            String seleccion = dato.next();
            if (seleccion.equalsIgnoreCase("N")) {
                continuar = false;
            }
        }
    }

    public void eliminarValor() {
        boolean continuar = true;

        while (continuar) {
            if (!pilita.isEmpty()) {
                System.out.println("Pila antes de la eliminacion: " + pilita);
                pilita.pop();
                System.out.println("Pila luego de la eliminacion: " + pilita);
                lista.remove(lista.size() - 1);
            } else {
                System.out.println("La pila está vacía. No hay elementos para eliminar.");
            }

            System.out.println("¿Desea eliminar otro valor? S/N");
            String seleccion = dato.next();
            if (seleccion.equalsIgnoreCase("N")) {
                continuar = false;
            }
        }
    }

    public void buscarValor() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese el valor que desea buscar:");
            int busqueda = dato.nextInt();
            if (lista.contains(busqueda)) {
                System.out.println("Se encontró el valor en la pila.");
            } else {
                System.out.println("No se encontró el valor en la pila.");
            }

            System.out.println("¿Desea buscar otro valor? S/N");
            String seleccion = dato.next();
            if (seleccion.equalsIgnoreCase("N")) {
                continuar = false;
            }
        }
    }
}
