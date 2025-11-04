package com.ohgiraffers.section03.filterstream.dto;


/**
 * 객체 입출력 처리를 위해서는 반드시 직렬화 처리를 해줘야한다.
 * 직렬화 대상 클래스에 Serialization인터페이스만 구현하면 데이터 직렬화 처리가 가능하다.
 */


public class MemberDto implements java.io.Serializable {
    private String id;
    private String pwd;
    private String name;
    private String email;
    private int age;
    private char gender;
    private double point;

    public MemberDto(String id, String pwd, String name, String email, int age, char gender, double point) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.point = point;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", point=" + point +
                '}';
    }
}
