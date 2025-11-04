package com.ohgiraffers.io.note.controller;

import java.io.BufferedWriter;
import java.util.Scanner;

public class FileController {
    public void fileSave() {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = null;


        if(save.equalsIgnoreCase("y")) {
            System.out.print("저장할 파일명을 입력하시오 : ");
            String fileName = sc.nextLine();
            BufferedWriter bw = null;

        }
    }

    public void fileOpen() {
    }

    public void fileEdit() {
    }
}
