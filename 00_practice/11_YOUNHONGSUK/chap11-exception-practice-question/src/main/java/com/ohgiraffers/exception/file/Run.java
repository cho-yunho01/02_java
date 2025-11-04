package com.ohgiraffers.exception.file;

public class Run {
    public static void main(String[] args) {

        FileValidator f =  new FileValidator();
        try {
            f.validateExtension("profile.jpg");
            f.validateExtension("document.pdf");
        } catch (InvalidFileFormatException e) {
            System.out.println("허용되지 않는 파일 형식입니다. (.jpg, .png 만 허용)");
        }
    }

}
