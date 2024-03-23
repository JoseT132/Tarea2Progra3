package tareaii_prograiii;
import java.util.Scanner;

public class Heapsort {

    public static void main(String[] args) {
        Heapsort heapSort = new Heapsort();
        heapSort.sort();
    }

    public void sort() {
        Scanner scanner = new Scanner(System.in);
        int Cant, i = 0;
        System.out.println("Ingrese la cantidad de datos a ordenar:");
        Cant = scanner.nextInt();
        int Orden[] = new int[Cant];
        for (i = 0; i < Cant; i++) {
            System.out.println("Ingrese el numero " + (i + 1) + ":");
            Orden[i] = scanner.nextInt();
        }

        heapSort(Orden);

        System.out.println("Arreglo ordenado:");
        for (int num : Orden) {
            System.out.print(num + " ");
        }
    }

    public static void heapSort(int arr[]) {
        int n = arr.length;
        // Constructor heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // Extraer elementos del heap uno por uno
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final del arreglo
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llamar a heapify en el montículo reducido
            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int n, int i) {
        // Inicializar largest como el nodo actual
        int largest = i;
        // Calcular los índices de los hijos izquierdo y derecho
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        // Si el hijo izquierdo existe y es mayor que el nodo actual
        if (l < n && arr[l] > arr[largest]) {
            largest = l; // Actualizar largest para que sea el hijo izquierdo
        }
        // Si el hijo derecho existe y es mayor que el nodo actual más grande
        if (r < n && arr[r] > arr[largest]) {
            largest = r; // Actualizar largest para que sea el hijo derecho
        }
        // Si largest ya no es el nodo actual, es decir, si hay un hijo mayor
        if (largest != i) {
            // Intercambiar los valores del nodo actual y el mayor hijo
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Llamar recursivamente a heapify en el subárbol afectado
            heapify(arr, n, largest);
        }
    }
}