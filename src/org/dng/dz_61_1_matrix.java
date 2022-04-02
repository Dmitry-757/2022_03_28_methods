package org.dng;

import java.util.Arrays;

/**
 * Задание 1
 * Написать и протестировать методы работы с квадратными матрицами (матрицы представить в виде двухмерных массивов).
 * Должны присутствовать методы:
 * ■ 1 создания единичной (диагональной) матрицы;
 * ■ 2 создания нулевой матрицы;
 * ■ 3 сложение матриц;
 * ■ 4 умножения матриц;
 * ■ 5 умножение матрицы на скаляр;
 * ■ 6 определение детерминанта матрицы;
 * ■ 7 вывод матрицы на консоль
 */

public class dz_61_1_matrix {
    public static void printMatrix(int[][] matrix) {
        for (int[] y : matrix) {
            System.out.print("[");
            for (int x : y) {
                System.out.printf("%3d", x);
            }
            System.out.print(" ]");
            System.out.println();
            //System.out.println(Arrays.toString(y));
        }
        System.out.println();
    }

    public static int[][] unitaryMatrix(int dim) {
        int[][] matrix = new int[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    public static int[][] zeroMatrix(int dim) {
        int[][] matrix = new int[dim][dim];
        for (int[] y : matrix) {
            Arrays.fill(y, 0);
        }
        return matrix;
    }

    public static int[][] randomMatrix(int dimY, int dimX, int rndRange) {
        if ((dimY < 1) || (dimX < 1)) {
            System.out.println("Wrong dimension!");
            int[][] matrix = null;
            return matrix;
        }
        int[][] matrix = new int[dimY][dimX];
        for (int i = 0; i < dimY; i++) {
            for (int j = 0; j < dimX; j++) {
                matrix[i][j] = (int) (Math.random() * rndRange);
            }
        }
        return matrix;
    }

    public static int[][] matrixAddition(int[][] m1, int[][] m2) {
        //lets find max dimensions of matrix
        int y = Math.max(m1.length, m2.length);
        int x = 0;
        for (int[] d : m1) {
            x = Math.max(x, d.length);
        }
        for (int[] d : m2) {
            x = Math.max(x, d.length);
        }

        int[][] matrix = new int[y][x];
        for (int i = 0; i < (y); i++) {
            for (int j = 0; j < x; j++) {
                int a1, a2;
                if ((i < m1.length) && (j < m1[i].length))
                    a1 = m1[i][j];
                else a1 = 0;
                if ((i < m2.length) && (j < m2[i].length))
                    a2 = m2[i][j];
                else a2 = 0;

                matrix[i][j] = a1 + a2;
            }
        }
        return matrix;
    }

    public static int det(int[][] matrix) {
        int rez = 0;
        int dimY = matrix.length, dimX = matrix[0].length;
        if (dimY != dimX) {
            System.out.println("the matrix is not square! determinant can`t be found!");
            return -11111;
        }

        if ((dimY == 2) && (dimX == 2)) {
            return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        }


        for (int y = 0; y < dimY; y++) {
            int a = matrix[y][0]; //разложение по 1-му столбцу, оптимизацию писать лень ))
            int[][] minor = new int[dimY - 1][dimX - 1]; //reduce of dimension

            for (int i = 0; i < dimY; i++) {
                if (i == y) continue;
                int z = (i < y) ? i : (i - 1);
                System.arraycopy(matrix[i], 1, minor[z], 0, minor[z].length);
            }
//            printMatrix(minor);
//            System.out.println("a = " + (int)Math.pow((-1),(1+y+1))*a);
            rez += (int) Math.pow((-1), (1 + y + 1)) * a * det(minor);
        }
        return rez;
    }

    public static void main(String[] args) {
        //point 1 - unitary matrix
        System.out.println("unitary matrix:");
        printMatrix(unitaryMatrix(3));
        System.out.println();

        //point 2 - zero matrix
        System.out.println("Zero matrix");
        printMatrix(zeroMatrix(4));
        System.out.println();

        //point 3 - matrix addition
        System.out.println("example of matrix addition...");
        int[][] m1 = randomMatrix(4, 2, 10);
        System.out.println("first matrix");
        printMatrix(m1);
        int[][] m2 = randomMatrix(2, 3, 10);
        System.out.println("second matrix");
        printMatrix(m2);
        System.out.println("sum: ");
        printMatrix(matrixAddition(m1, m2));

        //point 6 - find determinant of matrix
        int[][] m11 = randomMatrix(4, 4, 10);
        //int[][] m1 = {{8, 1, 5},{0, 8, 7}, {0, 0, 7}};
        System.out.println("lets find the determinant of the matrix ");
        printMatrix(m11);
        System.out.print("the determinant = ");
        System.out.println(det(m11));
        System.out.println();

    }
}
