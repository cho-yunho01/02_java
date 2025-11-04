package com.ohgiraffers.exception.user;

public class Run {

    public static void main(String[] args) {

        UserValidator u =  new UserValidator();
        try {
            u.validateUserInfo("admin","홍길동");
            //u.validateUserInfo("", "홍길동");
            u.validateUserInfo("admin", null);
        } catch (MissingInfoException e) {
            e.printStackTrace();
        }
    }
}
