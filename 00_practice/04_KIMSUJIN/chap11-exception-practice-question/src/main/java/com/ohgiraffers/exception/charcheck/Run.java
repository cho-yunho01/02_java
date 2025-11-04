package com.ohgiraffers.exception.charcheck;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
    Run run = new Run();
    run.test1();

    }

    public void test1(){
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력하세요 : ");
        String str = sc.nextLine();
        CharacterProcess cp = new CharacterProcess();

        try {
            cp.countAlpha(str);
        } catch (CharCheckException e) {
            System.out.println(e.getMessage());
        }
    }
}
