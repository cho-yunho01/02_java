package com.lhw.section01.file;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExamClass {

    public static void main(String[] args) {

        /*- 경로 : `src/main/java/com/lhw/section01/logs/app`
          - 생성한 경로에 오늘 날짜로 파일을 생성하고
          - 해당 파일을 열어서 아무 글자나 입력해보자
          - 현재 경로, 상위 폴더 경로, 파일의 사이즈 출력*/

        String basePath = "src/main/java/com/lhw/section01/logs/app";
        File baseFolder = new File(basePath); //생성할 폴더 객체
        boolean mkdirs = baseFolder.mkdirs();

        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String fileName = today + ".txt"; // 20251030
        File todayFile = new File(basePath + File.separator + fileName);
        {
            try {
                boolean createSuccess = todayFile.createNewFile();
                System.out.println("createSuccess = " + createSuccess);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("file.length() = " + todayFile.length());
        System.out.println("file.getPath() = " + todayFile.getPath());
        System.out.println("file.getParent() = " + todayFile.getParent());
        System.out.println("file.getAbsolutePath() = " + todayFile.getAbsolutePath());

    }

}
