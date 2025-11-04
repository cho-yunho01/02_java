package com.ohgiraffers.io.note.controller;

import java.io.*;
import java.util.Scanner;

public class FileController {
    public void fileSave() {
        Scanner sc = new Scanner(System.in);
        System.out.print("내용을 입력하세요 : ");
        StringBuilder sb = new StringBuilder();
        String save;
        while(true){
            String str = sc.nextLine();
            if(str.equals("exit")){

                break;
            }
            else{
                sb.append(str);
                sb.append("\n");
            }

        }
        System.out.println("파일을 저장하시겠습니까? Y or N");
        save = sc.nextLine();
        if(save.equalsIgnoreCase("y")) {
            System.out.print("저장할 파일명을 입력하시오 : ");
            String fileName = sc.nextLine();
            BufferedWriter bw = null;
            try{
                bw = new BufferedWriter(new FileWriter("src/main/java/com/ohgiraffers/io/note/"+fileName+".txt"));
                bw.write(sb.toString());
                System.out.println(fileName + ".txt 파일에 성공적으로 저장하였습니다.");
            }catch(IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else{
            System.out.println("종료합니다. ");
        }
    }

    public void filopen(){
        Scanner sc = new Scanner(System.in);
        System.out.print("열기 할 파일명 : ");
        String fileName = sc.nextLine();
        String path = "src/main/java/com/ohgiraffers/io/note/"+fileName+".txt";
        BufferedReader br = null;
        String content =null;
        try {
            br = new BufferedReader(new FileReader(path));
            while((content = br.readLine()) != null){
                System.out.println(content);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void fileEdit(){
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 파일 명: ");
        String fileName = sc.nextLine();
        String path = "src/main/java/com/ohgiraffers/io/note/"+fileName+".txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String content =null;

        try {
            br = new BufferedReader(new FileReader(path));
            while((content = br.readLine()) != null){
                System.out.println(content);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // ------------------------------------------------------------------------
        StringBuilder sb = new StringBuilder();
        String save;
        while(true){
            String str = sc.nextLine();
            if(str.equals("exit")){
                break;
            }
            else{
                sb.append(str);
                sb.append("\n");
            }

        }
        System.out.println("파일을 저장하시겠습니까? Y or N");
        save = sc.nextLine();
        if(save.equalsIgnoreCase("y")) {
            try{
                bw = new BufferedWriter(new FileWriter(path,true));
                bw.write(sb.toString());
                System.out.println(fileName + ".txt 파일의 내용이 변경되었습니다.");
            }catch(IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else{
            System.out.println("다시 메뉴로 돌아갑니다.");
        }



    }

}
