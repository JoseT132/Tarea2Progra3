package tarea2_progra3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BucketSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de datos a ordenar:");
        int Cant = scanner.nextInt();
        float Orden[] = new float[Cant];
        for (int i = 0; i < Cant; i++) {
            System.out.println("Ingrese el dato " + (i + 1) + ":");
            Orden[i] = scanner.nextFloat();
        }

        sort(Orden);
        System.out.println("Matriz despues de ordenar:");
        printArray(Orden);
    }

    public static void sort(float[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int n = arr.length;
        ArrayList<Float>[] buckets = new ArrayList[n];

        // Create empty buckets
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Add elements to buckets
        for (float num : arr) {
            // Calculate the index of the bucket
            int index = (int) (n * num);
            if (index >= n) {
                index = n - 1;
            }
            buckets[index].add(num);
        }

        // Sort individual buckets
        for (ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Concatenate buckets
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
            for (float num : bucket) {
                arr[index++] = num;
            }
        }
    }

    private static void printArray(float[] arr) {
        for (float num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
