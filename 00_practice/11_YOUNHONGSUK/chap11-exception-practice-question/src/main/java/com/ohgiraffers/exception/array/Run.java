package com.ohgiraffers.exception.array;

public class Run {

    public static void main(String[] args) throws ArrayLengthException {

        int[] a = {1,2,3};
        ArrayProcessor ap = new ArrayProcessor();


        try {
            System.out.println(ap.getElementAtIndex(a,1));
            System.out.println(ap.getElementAtIndex(a,3));
        } catch (ArrayLengthException e) {
            System.out.println("index out of bound");;
        }


    }

}
