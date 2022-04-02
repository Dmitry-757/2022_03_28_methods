package org.dng;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 Задание 3
 В массиве хранится n явно заданных текстовых строк.
 Создать метод:
 ■ выводящий содержимое массива в строку через пробел;
 ■ сортирующий массив в обратном порядке (без учета регистра) от z до a;
 ■ сортирующий массив по количеству слов в строке (слова разделены пробелами).
 Программа должна вывести строки в начальном и отсортированном порядке.
 Дополнительно: 1 балл за генерацию случайных уникальных строк реализованных в виде метода
 */

class strArrayComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return (numWords(o1) - numWords(o2));
    }

    private int numWords(String str){
        Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я]+");
        Matcher matcher = pattern.matcher(str);
        int numWord = 0;
        while (matcher.find()){
            numWord++;
        }
        return numWord;
    }
}

public class dz_61_3 {

    static String getRaveString(int numWord){
        Random rnd = new Random();
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < numWord; i++) {
            int streamSize = rnd.nextInt(3,10);
            rnd
                .ints(streamSize,97, 122) //long streamSize, int randomNumberOrigin, int randomNumberBound
                .forEach(v -> buf.append((char)v));
            if (i == (numWord - 1)){
                buf.append(".");
            }
            else {
                buf.append(" ");
            }
        }
//        System.out.println(buf.toString());
        String firstLetter = buf.substring(0, 1).toUpperCase();
        buf.replace(0,1, firstLetter);
        return buf.toString();
    }

    static void printArr(String[] arr){
        for (String s:arr) {
            System.out.println(s);
        }
    }

    //метод сортирующий массив по количеству слов в строке (слова разделены пробелами)
    static String[] ArrSort(String[] arr){
        return Arrays.stream(arr).sorted(new strArrayComparator()).toArray(String[]::new);
    }

    public static void main(String[] args) {
//        try(Scanner sc = new Scanner(System.in)){
//            System.out.println("Enter number of sentences");
//            int numSentences = 0;
//            if (sc.hasNextInt()) {numSentences = sc.nextInt();}
//            else {throw new Exception("Wrong input number of sentences");}
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
        int n = 6;
        String[] arr = new String[n];
        arr[0] = "выводящий содержимое массива в строку через пробел";
        arr[1] = "сортирующий массив в обратном порядке (без учета регистра) от z до a";
        arr[2] = "сортирующий массив по количеству слов в строке (слова разделены пробелами)";
        arr[3] = getRaveString(4);
        arr[4] = getRaveString(8);
        arr[5] = getRaveString(5);

        System.out.println("let`s make an array of words ...");
        printArr(arr);
        System.out.println();
        System.out.println("let`s sort the array by the number of words ...");
        System.out.println();
        printArr(ArrSort(arr));

    }
}
