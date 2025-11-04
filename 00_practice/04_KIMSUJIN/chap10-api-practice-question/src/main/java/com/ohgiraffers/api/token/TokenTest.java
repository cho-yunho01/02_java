package com.ohgiraffers.api.token;

import java.util.StringTokenizer;

public class TokenTest {
    public static void main(String[] args) {
        String s = "J a v a P r o g r a m ";

        //원본 문자열 길이 출력
        System.out.println("원본 문자열: \"" + s + "\"");
        System.out.println("문자열 길이: " + s.length());

        StringTokenizer st = new StringTokenizer(s, " ");
        int tokenCount = st.countTokens();

        System.out.println("토큰 갯수 : " + tokenCount);

        //char 배열
        char [] chars = new char[tokenCount];

        //토큰을 char배열에 저장
        for (int i = 0; i < tokenCount; i++) {
            String token = st.nextToken();
            chars[i] = token.charAt(0);
        }

        // char 값 출력
        System.out.print("char[] 값 : ");
        for(char c : chars){
            System.out.print(c + " ");
        }
        System.out.println();

        String result = new String(chars).toUpperCase();
        System.out.println(result);
    }
}
