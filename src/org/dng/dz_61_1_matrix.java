package org.dng;

import java.util.Arrays;

/**
 * Задание 1
 * Написать и протестировать методы работы с квадратными матрицами (матрицы представить в виде двухмерных массивов).
 * Должны присутствовать методы:
 * ■ 1 создания единичной (диагональной) матрицы;
 * ■ 2 создания нулевой матрицы;
 * ■ 3 сложение матриц;
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

    public static int[][] randomMatrix(int dimY, int dimX, int rndRange) throws IllegalArgumentException {
        if ((dimY < 1) || (dimX < 1)) {
            //System.out.println("Wrong dimension!");
            throw new IllegalArgumentException("Wrong matrix dimension!");
        }
        int[][] matrix = new int[dimY][dimX];
        for (int i = 0; i < dimY; i++) {
            for (int j = 0; j < dimX; j++) {
                matrix[i][j] = (int) (Math.random() * rndRange);
            }
        }
        return matrix;
    }

    public static int[][] matrixAddition(int[][] m1, int[][] m2) throws IllegalArgumentException {
        //lets compare dimensions of matrix
        if(m1.length != m2.length){
            throw new IllegalArgumentException("Error! Matrix dimensions must be equal!");
        }
        if( (m1.length == 0) ||(m2.length == 0) ){
            throw new IllegalArgumentException("Error! Matrix dimensions must be >0 !");
        }

        for (int i = 0; i < m1.length; i++) {
            if(m1[i].length != m2[i].length){
                throw new IllegalArgumentException("Error! Matrix dimensions must be equal!");
            }
        }


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
                matrix[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return matrix;
    }

    public static int det(int[][] matrix) throws IllegalArgumentException {
        int rez = 0;
        int dimY = matrix.length, dimX = matrix[0].length;
        if (dimY != dimX) {
            throw new IllegalArgumentException("Error. The matrix is not square! determinant can`t be found!");
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
        //throw exception
        System.out.println("example of matrix addition...");
        int[][] m1 = randomMatrix(4, 2, 10);
        System.out.println("first matrix");
        printMatrix(m1);
        int[][] m2 = randomMatrix(2, 3, 10);
        System.out.println("second matrix");
        printMatrix(m2);
        try {
            System.out.println("sum: ");
            printMatrix(matrixAddition(m1, m2));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println();
        }

        //point 3 - matrix addition
        System.out.println("example of matrix addition...");
        int[][] m3 = randomMatrix(4, 2, 10);
        System.out.println("first matrix");
        printMatrix(m3);
        int[][] m4 = randomMatrix(4, 2, 10);
        System.out.println("second matrix");
        printMatrix(m4);
        System.out.println("sum: ");
        try {
            printMatrix(matrixAddition(m3, m4));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println();
        }

        //point 6 - find determinant of matrix
        //throw exception
        int[][] m11 = randomMatrix(4, 3, 10);
        //int[][] m1 = {{8, 1, 5},{0, 8, 7}, {0, 0, 7}};
        System.out.println("lets find the determinant of the matrix ");
        printMatrix(m11);
        System.out.print("the determinant = ");
//        System.out.println(det(m11));
        try {
            System.out.println(det(m11));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println();

        int[][] m12 = randomMatrix(4, 4, 10);
        System.out.println("lets find the determinant of the matrix ");
        printMatrix(m12);
        System.out.print("the determinant = ");
//        System.out.println(det(m11));
        try {
            System.out.println(det(m12));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println();


    }
}
