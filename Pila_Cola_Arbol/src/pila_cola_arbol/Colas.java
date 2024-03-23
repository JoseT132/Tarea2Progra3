
package pila_cola_arbol;
import java.util.*;


public class Colas {
 LinkedList colita= new LinkedList(); 
 Scanner dato= new Scanner (System.in);
 private List<Integer> lista = new ArrayList<>();
 
 public void agregarElemento() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese un valor a la Cola:");
            int valor = dato.nextInt();
            colita.offer(valor);
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
            if (!colita.isEmpty()) {
                System.out.println("Cola antes de la eliminacion: " + colita);
                colita.poll();
                System.out.println("Cola luego de la eliminacion: " + colita);
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
                System.out.println("Se encontró el valor en la cola.");
            } else {
                System.out.println("No se encontró el valor en la cola.");
            }

            System.out.println("¿Desea buscar otro valor? S/N");
            String seleccion = dato.next();
            if (seleccion.equalsIgnoreCase("N")) {
                continuar = false;
            }
        }
    }
}

