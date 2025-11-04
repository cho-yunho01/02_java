package com.ohgiraffers.section01.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExamClass {
    public static void main(String[] args) {
        //경로: src/main/java/com/ohgiraffers/section01/logs/app
        String basePath="src/main/java/com/ohgiraffers/section01/logs/app";

        //저장할 폴더를 생성
        File baseFolder=new File(basePath);//생성할 폴더 객체
        boolean mkdirs=baseFolder.mkdirs();
        System.out.println("mkdirs : "+mkdirs);
        /*저장할 폴더 생성*/

        //
         //생성한 경로에 오늘 날짜로 파일(20251030.txt)을 생성하고
       String today= LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
       String fileName=today+".txt";
       File todayFile=new File(basePath+"/"+fileName);
       try{
           boolean newFile=todayFile.createNewFile();
           System.out.println("newFile : "+newFile);
       }catch (IOException e){
           throw new RuntimeException(e);
       }


        //현재 경로, 상위 폴더경로, 파일의 사이즈 출력
        System.out.println(todayFile.getPath());
        System.out.println(todayFile.getParent());
        System.out.println(todayFile.length());
    }
}
