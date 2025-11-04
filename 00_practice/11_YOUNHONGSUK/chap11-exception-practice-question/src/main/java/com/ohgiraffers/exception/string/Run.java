package com.ohgiraffers.exception.string;

public class Run {

    public static void main(String[] args) throws StringLengthException {

        StringValidator s = new StringValidator();
        try {
            System.out.println(s.isValidLength("HelloJava"));
            s.isValidLength("Hi");
        } catch (StringLengthException e) {
            System.out.println("문자열의 길이는 5자 이상, 10자 이하이어야 합니다.");
        }

    }

}
