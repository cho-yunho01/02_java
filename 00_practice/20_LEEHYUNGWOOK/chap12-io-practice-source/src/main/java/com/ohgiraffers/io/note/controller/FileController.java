package com.ohgiraffers.io.note.controller;

import java.io.*;
import java.util.Scanner;

public class FileController {

    public void fileSave() {
        //FileWriter,Buffered
        //덮어쓰기(새파일생성)
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.print("내용을 입력하세요. 멈추고 싶다면 exit을 쳐주세요 : ");
        String inputLine = sc.nextLine();
        while (!inputLine.equals("exit")) {
            sb.append(inputLine);
            sb.append("\n");
            inputLine = sc.nextLine();
        }

        if(inputLine.equalsIgnoreCase("exit")) {
            System.out.print("저장할 파일명을 입력하시오 : ");
            String fileName = sc.nextLine();
            BufferedWriter bw = null;

            try {
                bw = new BufferedWriter(new FileWriter("src/main/java/com/ohgiraffers/io/" +  fileName + ".txt"));
                bw.write(sb.toString());
                System.out.println(fileName + ".txt 파일에 성공적으로 저장하였습니다.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    bw.close();
                } catch (IOException e) {}
            }
        }

    }

    public void fileOpen() {
        /* 1. 파일 읽기 BufferedReader 를 열어 파일 내용을 읽을 준비를 합니다.
         * 2. 내용 출력 br.readLine() 을 사용하여 파일 내용을 한 줄씩 읽어 콘솔에 출력합니다. null 반환 시 종료.
         * 3. 예외 처리 파일이 없을 경우 FileNotFoundException 처리*/
        Scanner sc = new Scanner(System.in);
        System.out.print("열기 할 파일 명 : ");
        String fileName = sc.nextLine();

        String content = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/java/com/ohgiraffers/io/"+fileName+".txt"));
            while ( (content = br.readLine()) != null) {
                System.out.println(content);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void fileEdit() {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;

        System.out.print("수정할 파일 명 : ");
        String fileName = sc.nextLine();
        String content = null;
        try {
            br = new BufferedReader(new FileReader("src/main/java/com/ohgiraffers/io/" + fileName + ".txt"));
            while ( (content = br.readLine()) != null) {
                System.out.println(content);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일명이 잘못되었습니다.");
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print("수정을 멈추려면 exit을 쳐주세요.");
        String editContent = sc.nextLine();
        while (!editContent.equals("exit")) {
            sb.append(editContent);
            sb.append("\n");
            editContent = sc.nextLine();
        }

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter("src/main/java/com/ohgiraffers/io/" + fileName + ".txt", true));
            if (editContent.equalsIgnoreCase("exit")) {
                bw.write(sb.toString());
                System.out.println(fileName + ".txt 파일의 내용이 변경되었습니다.");
            } else {
                System.out.println("다시 메뉴로 돌아갑니다.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bw.close();
                br.close();
            } catch (IOException e) {}
        }


    }
}
