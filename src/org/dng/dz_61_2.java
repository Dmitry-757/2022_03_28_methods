package org.dng;

import java.util.Arrays;

/**
 Задание 2
 Написать и протестировать перегруженный метод, выводящий на экран:
 ■ одномерный массив типа int;
 ■ одномерный массив типа String;
 ■ двухмерный массив типа int;
 ■ двухмерный массив типа float
 */


public class dz_61_2 {
    public static void meth(int num){
        int[] arr = new int[5];
        for (int i = 0; i < num; i++) {
            arr[i] = num;
        }
        System.out.println("одномерный массив типа int");
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    public static void meth(String prefix){
        String[] arr = new String[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = prefix+"_"+i;
        }
        System.out.println("одномерный массив типа String");
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    public static void meth(int dimY, int dimX ){
        int[][] arr = new int[dimY][dimX];
        for (int i = 0; i < dimY; i++) {
            for (int j = 0; j < dimX; j++) {
                arr[i][j] = (int) (Math.random() * 100);
            }
        }

        System.out.println("двухмерный массив типа int");
        for (int[] y : arr) {
            System.out.print("[");
            for (int x : y) {
                System.out.printf("%3d", x);
            }
            System.out.print(" ]");
            System.out.println();
        }
        System.out.println();
    }

    public static void meth(int dimY, int dimX,  double fill){
        double[][] arr = new double[dimY][dimX];
        for (int i = 0; i < dimY; i++) {
            for (int j = 0; j < dimX; j++) {
                arr[i][j] = fill;
            }
        }

        System.out.println("двухмерный массив типа float");
        for (double[] y : arr) {
            System.out.print("[");
            for (double x : y) {
                System.out.printf("%5.2f", x);
            }
            System.out.print(" ]");
            System.out.print("\n");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        meth(4);
        meth("point2");
        meth(3,4);
        meth(4,5, 1.5);
    }
}
