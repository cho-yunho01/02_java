package com.ohgiraffers.io.note.controller;

import com.ohgiraffers.io.member.Member;

import java.io.*;
import java.util.Scanner;

public class FileController {
    String path = "src/main/java/com/ohgiraffers/io/note/note.txt";
    Scanner sc = new Scanner(System.in);
    String[] inputLines = new String[10];

    public void fileSave() throws IOException {
        BufferedWriter bw = null;
        try {
            System.out.println("파일명을 정해주세요");
            String fileName = sc.nextLine();
            fileName = path + fileName;
            bw = new BufferedWriter(new FileWriter(path));
            String input = "";
            boolean enter = true;
            while(enter){
                System.out.println("텍스트를 입력하세요");
                input = sc.nextLine();
                if(!input.equals("exit")){
                    input = input + "\n";
                    bw.write(input);
                }else enter = false;
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bw.close();
        }
    }

    public void fileOpen(){
   BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine())!= null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public void fileEdit() throws IOException {
       System.out.print("수정할 파일명 : ");
       String fileName = sc.nextLine();
       String editPath = "src/main/java/com/ohgiraffers/io/note/";
       editPath = editPath + fileName;
       BufferedReader br = null;
       try {
           br = new BufferedReader(new FileReader(editPath));
           String line;
           while((line = br.readLine())!= null){
               System.out.println(line);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
       BufferedWriter bw = null;
       try {
           bw = new BufferedWriter(new FileWriter(path,true));
           String input = "";
           boolean enter = true;
           while(enter){
               input = sc.nextLine();
               if(!input.equals("exit")){
                   input = input + "\n";
                   bw.write(input);
               }else enter = false;
           }
           bw.flush();
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           bw.close();
       }
   }
}
