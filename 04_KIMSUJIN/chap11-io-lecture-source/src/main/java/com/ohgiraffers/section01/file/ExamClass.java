package com.ohgiraffers.section01.file;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExamClass {

    public static void main(String[] args) {

        // 경로 : src/main/java/com/ohgiraffers/section01/logs/app
//
//         // 생성한 경로에 오늘 날짜로 파일을 생성하고
//        LocalDate now = LocalDate.now();
//        String today = now.toString();
//
//        File file = new File("src/main/java/com/ohgiraffers/section01/logs/app/");
//
//
//
//        try {
//            boolean createSuccess = file.createNewFile();
//            System.out.println("createSuccess: " + createSuccess);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        // 해당 파일을 열어서 아무 글자나 입력

        // 현재 경로, 상위 폴더 경로,


        //
        String basePath = "src/main/java/com/ohgiraffers/section01/logs/app";

        File baseFolder = new File(basePath);

        boolean mkdirs = baseFolder.mkdirs();
        System.out.println("mkdirs: " + mkdirs);

        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String fileName = today + ".txt";

        File todayFile = new File(basePath + "\\" + today +  fileName);
        try {
            boolean newFile = todayFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 현재 경로, 상위 폴더경로, 파일의 사이즈 출력
        System.out.println("1. 현재 파일 경로" + todayFile.getPath());
        System.out.println(todayFile.getParent());
        System.out.println(todayFile.length());
        System.out.println(todayFile.getAbsolutePath());

    }
}
