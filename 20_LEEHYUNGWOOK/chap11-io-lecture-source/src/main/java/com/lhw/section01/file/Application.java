package com.lhw.section01.file;

import java.io.File;
import java.io.IOException;

public class Application {

    public static void main(String[] args) {

//        얜 생성 안됨
        File file = new File("src/main/java/com/lhw/section01/file/test.txt");

        /*얘가 생성됨*/
        try {
            boolean createSuccess = file.createNewFile();
            System.out.println("createSuccess = " + createSuccess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("file.length() = " + file.length());
        System.out.println("file.getPath() = " + file.getPath());
        System.out.println("file.getParent() = " + file.getParent());
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());

        String path = "c:\\devTest\\test"; // 폴더(경로)이다.
        File filePath = new File(path); // 새로운 파일 객체 생성하고 폴더 경로를 넣어준다.
        // 폴더의 생성여부를 exists() 메소드를 통해 확인해야 한다.
        System.out.println("filePath.exist() = " + filePath.exists());

        boolean mkdirs = filePath.mkdirs();
        System.out.println("mkdirs = " + mkdirs);
        // mkdir()과 mkdirs()의 차이는 하나의 디렉토리 / 경로의 모든 디렉토리 생성 차이이다.

        boolean delete = filePath.delete(); // test를 지운다.
        System.out.println("delete = " + delete); // true

        File file1 = new File("c:\\devTest");//지울 파일 경로를 저장하고
        boolean delete2 = file1.delete(); //지워주고 확인하면 dev_test 도 지워준다.
        System.out.println("delete2 = " + delete2); // true

        // src 파일의 test도 삭제해보자
        boolean delete3 = file.delete();
        System.out.println("delete3 = " + delete3);

        File testFile = new File("넣어줄 경로");

        boolean createFolder = false; //생성 여부를 빼 놓는다.
        if (!testFile.exists()) { //testFile 이 생성되었는가?
            createFolder = testFile.mkdirs();
            // testFile이 존재 하지 않으면 디렉토리를 만들어준다.
        }
    }
}
