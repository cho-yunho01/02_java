package com.ohgiraffers.exception.array;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        Run run = new Run();
        run.test4();
    }

    public void test4(){
        ArrayProcessor ap = new ArrayProcessor();
        Scanner sc = new Scanner(System.in);
        System.out.print("인덱스 입력 : ");
        int n = sc.nextInt();
        int arr[]   = new int[3];

        try {
            ap.getElementAtIndex(arr ,n);
            System.out.println("인덱스" + n + "의 값은 " + arr[n] + "입니다.");
        } catch (ArrayLengthException e) {
            System.out.println(e.getMessage());
        }
    }
}
