package com.ohgiraffers.io.note.controller;

import java.io.*;
import java.util.Scanner;

public class FileController {
    Scanner sc = new Scanner(System.in);
    //사용자가 입력한 내용을 받아 새로운 파일로 저장하는 기능
    public void fileSave(){
        //1. 내용 입력 "exit" 입력전까지 모든 내용을 StringBuilder에 누적, 각줄 끝에 \n 추가
        StringBuilder sb = new StringBuilder();
        System.out.println("내용을 입력하세요 :");
        while(true){
            String line = sc.nextLine();
            //2.파일 쓰기 BufferedWriter를 열어 sb의 내용을 파일에 작성
            if(line.equals("exit")){
                System.out.print("저장할 파일명을 입력하시오 : ");
                String fileName = sc.nextLine();
                BufferedWriter bw = null;
                try{
                    bw=new BufferedWriter(new java.io.FileWriter(fileName));
                    bw.write(sb.toString());
                    bw.flush();
                }catch(Exception e){
                    e.printStackTrace();

                }finally{
                    if(bw!=null) try{bw.close();}catch(Exception e){
                        e.printStackTrace();
                    }
                }
                break;
            }
            sb.append(line).append("\n");
        }



    }

    public void fileOpen(){
        System.out.print("열기 할 파일 명 :");
        String fileName = sc.nextLine();
        String content=null;
        try { //1. 파일읽기 BufferedReader를 열어 파일 내용을 읽을 준비
            BufferedReader br = new BufferedReader(new java.io.FileReader(fileName));
            //2. br.readLine()을 사용하여 파일 한 줄씩 읽어 콘솔에 출력한다. null 반환시 종료
            if(br!=null){
                while((content=br.readLine())!=null){
                    System.out.println(content);
                }
            }else{
                throw new FileNotFoundException();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
        }
        
    }

    public void fileEdit(){
        System.out.print("수정할 파일명 : ");
        String fileName=sc.nextLine();
        String content=null;
        BufferedWriter bw=null;
        BufferedReader br=null;
        
        try {
            FileWriter fw=new FileWriter(fileName,true);
            bw = new BufferedWriter(fw);
            br = new BufferedReader(new FileReader(fileName));

            if(br!=null){
                while((content=br.readLine())!=null){
                    System.out.println(content);
                }
            }else{
                throw new FileNotFoundException();
            }

            System.out.print("내용을 추가하겠습니까?(y/n)");
            String save=sc.nextLine();
            if(save.equalsIgnoreCase("y")){
                System.out.print("추가할 내용을 입력하세요 : ");
                String addContent=null;
                while(true){
                addContent=sc.nextLine();
                if(addContent.equals("exit")){
                    break;
                }else{
                    bw.write(addContent);
                    continue;
                }
                }
                System.out.println(fileName+".txt 파일의 내용이 변경되었습니다.");
            }else{
                System.out.println("다시 메뉴로 돌아갑니다.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(bw != null) {
                    bw.close();
                }
                if(br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
