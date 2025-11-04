package com.ohgiraffers.section03.filterstream.dto;

/*
* 객체 입출력 처리를 위해서는 반드시 직렬화 처리를 해야 한다.
* 직렬화 대상 클래스에 Serializable 인터페이스만 구현하면 데이터 직렬화 처리가 가능하다.
* */
public class MyoutputStream implements java.io.Serializable {

    private String id;
    private String pwd;
    private String name;
    private String email;
    private int age;
    private char gender;
    private double point;

    public MemberDto() {
    }

    public MemberDto(String id, String pwd, String name, String email, int age, char gender, double point) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.point = point;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "🧟‍♂️" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", point=" + point +
                "🧟‍♂️";
    }
}
