package org.dng;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

class dz_61_1_matrixTest {

    @org.junit.jupiter.api.Test
    void matrixAddition1() {
        int[][] m1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] m2 = {{17,18,19,20},{21,22,23,24},{25,26,27,28},{29,30,31,32}};

        int[][] expected = {{18, 20, 22, 24},{26,28,30,32},{34,36,38,40},{42,44,46,48}};
        int[][] actual = dz_61_1_matrix.matrixAddition(m1, m2);
        Assertions.assertArrayEquals(expected, actual);
    }


    @org.junit.jupiter.api.Test
    void matrixAdditionException() {
        int[][] m1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] m2 = {{17, 18, 19, 20}, {21, 22, 23, 24}, {25, 26, 27, 28}};

        int[][] expected = {{18, 20, 22, 24}, {26, 28, 30, 32}, {34, 36, 38, 40}, {42, 44, 46, 48}};

        //one way test
//        Throwable e = assertThrows(IllegalArgumentException.class, () -> dz_61_1_matrix.matrixAddition(m1, m2));
//        assertNotNull(e.getMessage());

        //another test
        try {
            dz_61_1_matrix.matrixAddition(m1, m2);
            Assertions.fail("Exception was expected!");
        }
        catch (IllegalArgumentException ex){
            System.out.println("Test done. Caught exception = "+ ex.getMessage());
            Assertions.assertNotEquals("", "Error! Matrix dimensions must be equal!");
        }

    }


    @org.junit.jupiter.api.Test
    void det() {
        int[][] m1 = {{2,2,3,4},{5,6,7,8},{9,10,10,12},{13,14,15,16}};

        int expected = 16;
        int actual = dz_61_1_matrix.det(m1);
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void detWithException() {
        int[][] m1 = {{2,2,3,4},{5,6,7,8},{9,10,10,12},{13,14,15,16},{1,2,3,4}};
        try {
            dz_61_1_matrix.det(m1);
            Assertions.fail("Exception was expected!");
        }
        catch (IllegalArgumentException ex){
            System.out.println("Test done. Caught exception = "+ ex.getMessage());
            Assertions.assertNotEquals("", "Error. The matrix is not square! determinant can`t be found!");
        }
    }

}