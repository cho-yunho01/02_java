package com.ohgiraffers.exception.file;

public class FileValidator {

    public void validateExtension(String fileName) throws InvalidFileFormatException{

        if(fileName.contains("jpg") ||  fileName.contains("png")){
            String extension = fileName.substring(fileName.length()-3);
            System.out.println("파일 형식 검증 완료: " + extension );
        }else throw new InvalidFileFormatException();

    }

}
