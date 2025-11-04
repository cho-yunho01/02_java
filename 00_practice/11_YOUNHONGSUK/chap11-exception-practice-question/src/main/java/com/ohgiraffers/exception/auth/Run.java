package com.ohgiraffers.exception.auth;

public class Run {

    public static void main(String[] args) {

        AuthChecker a =  new AuthChecker();
        try {
            a.checkAdminPermission("user1", true);
            a.checkAdminPermission("user2", false);
        } catch (PermissionDeniedException e) {
            e.printStackTrace();
        }

    }




}
