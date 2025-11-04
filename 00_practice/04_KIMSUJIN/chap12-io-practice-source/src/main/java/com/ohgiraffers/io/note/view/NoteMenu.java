package com.ohgiraffers.io.note.view;

import java.util.Scanner;
import com.ohgiraffers.io.note.controller.FileController;

public class NoteMenu {

    public void viewMenu() {
        Scanner sc = new Scanner(System.in);
        FileController fc = new FileController();

        outer: while (true) {
            System.out.print("번호를 입력하세요 : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // 1. 노트 새로 만들기
                    fc.fileSave(); break;
                case 2:
                    // 2. 노트 열기
                    fc.fileOpen(); break;
                case 3:
                    // 3. 노트 열어서 수정하기
                    fc.fileEdit(); break;
                case 4:
                    // 4. 끝내기
                    System.out.println("프로그램을 종료합니다."); break outer;
                default:
                    System.out.println("잘못 입력하셨습니다"); break;
            }
        }

    }
}

