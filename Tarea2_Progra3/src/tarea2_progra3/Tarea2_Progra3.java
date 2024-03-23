
package tarea2_progra3;
import static java.lang.System.exit;
import java.util.*;

public class TareaII_PrograIII {

    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);
        //Agrego mis clases
        SelectionSort sort = new SelectionSort();
        Burbuja bubble = new Burbuja();
        InsertionSort insertarS = new InsertionSort();
        MergeSort merge = new MergeSort();
        QuickSort quick = new QuickSort();
        CountingSort counting = new CountingSort();
        RadixSort radix = new RadixSort();
        Heapsort Heapsort = new Heapsort();
        BucketSort BucketSort = new BucketSort();

        System.out.println("Selecion el metodo que desea utilizar");
        System.out.println("1.Selecion Sort ");
        System.out.println("2.Bubble Sort ");
        System.out.println("3. Insercion Sort ");
        System.out.println("4. Merge Sort ");
        System.out.println("5. Quick Sort ");
        System.out.println("6. Heap Sort ");
        System.out.println("7. Counting Sort ");
        System.out.println("8. Radix Sort ");
        System.out.println("9. Bucket sort  ");
        System.out.println("10. Salir ");
        int opcion = dato.nextInt();

        //creo un pequeño menu de opciones
        switch (opcion) {
            case 1:
                sort.ordenaSort();
                sort.arregloOrdenado();
                break;
            case 2:
                bubble.OrdenaBurbuja();
                bubble.arregloOrdenado();
                break;
            case 3:
                insertarS.InsertaSort();
                insertarS.arregloOrdenado();
                break;
            case 4:
                merge.mergeSort();
                merge.arregloOrdenado();
                break;
            case 5:
                quick.quicksort();
                quick.arregloOrdenado();
                break;
            case 6:
                Heapsort.main(args);
                break;
            case 7:
                counting.countingsort();
                counting.arregloOrdenado();
                break;
            case 8:
                radix.radixsort();
                radix.arregloOrdenado();
                break;
            case 9:
                BucketSort.main(args);
                break;
            case 10:
                exit(0);
                break;
            default:
                System.out.println("Ha seleccionado una opcion invalida");
                break;
        }
    }
}
