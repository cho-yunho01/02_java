package com.ohgiraffers.io.note.view;

import com.ohgiraffers.io.note.controller.FileController;

import java.io.IOException;
import java.util.Scanner;

public class NoteMenu {

    public void menu() {
        Scanner sc = new Scanner(System.in);
        FileController fc = new FileController();
        boolean on = true;

        try {
            while(on){
                System.out.println("""
                     ****** MyNote ****** 
                    1. 노트 새로 만들기
                    2. 노트 열기
                    3. 노트 열어서 수정하기/
                    4. 끝내기
                    
                    번호를 입력하세요 : 
                    """);

                int input = sc.nextInt();

                switch (input){
                    case 1: fc.fileSave();
                        break;
                    case 2: fc.fileOpen();
                        break;
                    case 3: fc.fileEdit();
                        break;
                    case 4:
                        System.out.println("프로그램을 종료합니다.");
                        on = false; break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
