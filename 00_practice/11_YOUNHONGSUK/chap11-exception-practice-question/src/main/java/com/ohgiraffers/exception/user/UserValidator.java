package com.ohgiraffers.exception.user;

public class UserValidator {
    public void validateUserInfo(String userId, String userName) throws MissingInfoException{

        if(userId==null || userName==null ||  userName.isEmpty() || userId.isEmpty()){
            if(userId==null || userId.isEmpty()){
                System.out.println("필수 정보 userId가 누락되었습니다.");
            } else System.out.println("필수 정보 userName가 누락되었습니다.");
            throw new MissingInfoException();
        }
        System.out.println("사용자 정보 검증 완료.");

    }

}
