package com.ohgiraffers.section01.level02.normal;

import java.util.Scanner;

public class Application2_review {

    static void main() {
        /* 주민등록번호를 스캐너로 입력 받고 문자 배열로 저장한 뒤,
         * 성별 자리 이후부터 *로 가려서 출력하세요
         *
         * -- 입력 예시 --
         * 주민등록번호를 입력하세요 : 990101-1234567
         *
         * -- 출력 예시 --
         * 990101-1******
         */

        // 1. 스캐너 클래스
        // 2. syso
        // 3. String으로 주민등록번호 입력받기
        // 4. 문자 배열로 저장하기
        // 5. 성별 자리 이후부터 *로 가려서 출력하기

        Scanner sc = new Scanner(System.in);
        System.out.print("주민등록 번호 : ");
        String str = sc.nextLine();
        char[] carr = str.toCharArray();
        for (int i = 0; i < carr.length; i++) {
            if( i >= 8 ) {
                carr[i] = '*';
            }
            System.out.print(carr[i]);
        }
    }
}