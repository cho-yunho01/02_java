package com.ohgiraffers.exception.string;

public class StringValidator {

    public boolean isValidLength(String s) throws StringLengthException{
        if(s.length() < 5 ||s.length()>10){
            throw new StringLengthException();
        }
        else return true;
    }


}
