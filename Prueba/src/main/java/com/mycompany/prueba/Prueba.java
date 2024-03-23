
package com.mycompany.prueba;
import java.util.*;

public class Prueba {

    public static void main(String[] args) {
        Scanner Captura = new Scanner(System.in);
        int NumF, NumC, NumF2, NumC2;

        System.out.println("Ingrese el numero de filas para la Matiz 1");
        NumF = Captura.nextInt();
        System.out.println("Ingrese el numero de columnas para la Matiz 1");
        NumC = Captura.nextInt();
        System.out.println("Ingrese el numero de filas para la Matiz 2");
        NumF2 = Captura.nextInt();
        System.out.println("Ingrese el numero de columnas para la Matiz 2");
        NumC2 = Captura.nextInt();
        int[][] M3 = new int[NumF][NumC];

        if (NumC != NumF2) {
            System.out.println("Las matrices que ingreso no se puden operar de ninguna manera");
            return;
        } else if ((NumF == NumC) && NumF2 == NumC2) {
            int[][] MT1 = new int[NumF][NumC];
            int[][] MT2 = new int[NumF2][NumC2];

            //Ingreso de los datos de Matriz 1
            System.out.print("Matriz 1");
            Leer(Captura, MT1);
            System.out.print("Matriz 2");
            //Ingreso de los datos de Matriz 2
            Leer(Captura, MT2);
            System.out.println("No se pueden multiplicar las matrices debe ser el numero de columnas de la primera matriz debe ser igual al numero de filas de la segunda matriz.");
            System.out.println("Matriz resultado de la suma:");
            int[][] ResulSuma = Suma(MT1, MT2);
            Mostrar1(ResulSuma);
            System.out.println("Matriz resultado de la resta:");
            int[][] ResulRest = resta(MT1, MT2);
            Mostrar1(ResulRest);
        } else {

            int[][] MT1 = new int[NumF][NumC];
            int[][] MT2 = new int[NumF2][NumC2];

            //Ingreso de los datos de Matriz 1
            System.out.print("Matriz 1");
            Leer(Captura, MT1);
            System.out.print("Matriz 2");
            //Ingreso de los datos de Matriz 2
            Leer(Captura, MT2);
            //Resultado de Multiplicacion,Suma,Resta
            System.out.println("Matriz resultado de la multiplicación:");
            int[][] ResulMulti = Multi(MT1, MT2);
            Mostrar1(ResulMulti);
            
            System.out.println("No se pueden sumar y restar las matrices debe ser el numero de columnas y filas de las matrices debe de ser iguales.");
        

        }

    }

    public static void Leer(Scanner scanner, int[][] MT) {
        int NumF = MT.length;
        int NumC = MT[0].length;

        for (int f = 0; f < NumF; f++) {
            for (int c = 0; c < NumC; c++) {
                System.out.println("Ingrese un valor para la posición [" + f + "][" + c + "]: ");
                MT[f][c] = scanner.nextInt();
            }
        }
        System.out.println("Mostrando Matriz ");
        for (int f = 0; f < NumF; f++) {
            for (int c = 0; c < NumC; c++) {
                System.out.print(" [" + (f + 1) + "][" + (c + 1) + "]: " + MT[f][c] + "\t");
            }
            System.out.println();
        }

    }

    public static int[][] Completo(int[][] MT1, int[][] MT2) {
        int NumF = MT1.length;
        int NumC = MT1[0].length;
        int NumC2 = MT2[0].length;
        int[][] M4 = new int[NumF][NumC2];
        int[][] M3 = new int[NumF][NumC2];
        int[][] M2 = new int[NumF][NumC2];
        int[][] M1 = new int[NumF][NumC2];

        for (int i = 0; i < NumF; i++) {
            for (int j = 0; j < NumC2; j++) {
                for (int k = 0; k < NumF; k++) {

                    M1[i][j] = MT1[i][k] + MT2[k][j];
                    M2[i][j] = MT1[i][k] - MT2[k][j];
                    M3[i][j] = MT1[i][k] * MT2[k][j];
                    M4[i][j] = M1[i][j] - M2[i][j] * M3[i][j];
                }
            }
        }

        return M4;
    }

    public static int[][] Multi(int[][] MT1, int[][] MT2) {
        int NumF = MT1.length;
        int NumC = MT1[0].length;
        int NumC2 = MT2[0].length;

        int[][] M3 = new int[NumF][NumC2];
        for (int i = 0; i < NumF; i++) {
            for (int j = 0; j < NumC2; j++) {
                for (int k = 0; k < NumC; k++) {
                    M3[i][j] += MT1[i][k] * MT2[k][j];
                }
            }
        }

        return M3;
    }

    public static int[][] Suma(int[][] MT1, int[][] MT2) {
        int NumF = MT1.length;
        int NumC = MT1[0].length;
        int NumC2 = MT2[0].length;

        int[][] M2 = new int[NumF][NumC];
        for (int i = 0; i < NumF; i++) {
            for (int j = 0; j < NumC; j++) {

                M2[i][j] = MT1[i][j] + MT2[i][j];

            }
        }

        return M2;
    }

    public static int[][] resta(int[][] MT1, int[][] MT2) {
        int NumF = MT1.length;
        int NumC = MT1[0].length;
        int NumC2 = MT2[0].length;

        int[][] M1 = new int[NumF][NumC2];
        for (int i = 0; i < NumF; i++) {
            for (int j = 0; j < NumC2; j++) {

                M1[i][j] = MT1[i][j] - MT2[i][j];

            }
        }

        return M1;
    }

    public static void Mostrar1(int[][] M1) {
        int NumF = M1.length;
        int NumC = M1[0].length;

        for (int i = 0; i < NumF; i++) {
            for (int j = 0; j < NumC; j++) {
                System.out.print(" [" + (i + 1) + "][" + (j + 1) + "]: " + M1[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

