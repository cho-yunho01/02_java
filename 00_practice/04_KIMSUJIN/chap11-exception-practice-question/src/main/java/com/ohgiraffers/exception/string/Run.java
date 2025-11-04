package com.ohgiraffers.exception.string;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        run.test5();
    }

    public void test5(){
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String str = sc.nextLine();

        StringValidator sv = new StringValidator();
        try {
            sv.isValidLength(str);
        } catch (StringLengthException e) {
            System.out.println(e.getMessage());
        }
    }
}
