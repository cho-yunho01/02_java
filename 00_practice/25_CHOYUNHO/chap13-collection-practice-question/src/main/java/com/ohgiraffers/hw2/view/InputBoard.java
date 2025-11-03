package com.ohgiraffers.hw2.view;

import com.ohgiraffers.hw2.model.dto.BoardDTO;

import java.time.LocalDate;
import java.util.Scanner;

public class InputBoard {

    public BoardDTO InputBoard(){
        int num = InputBoardNo();
        String title =  InputBoardTitle();
        Scanner sc = new Scanner(System.in);
        System.out.print("작성자를 입력하시오 : ");
        String writer = sc.nextLine();
        LocalDate localDate = LocalDate.now();
        String content = InputBoardContent();
        BoardDTO boardDTO = new BoardDTO(num,title,writer,localDate,content,0);
        return  boardDTO;
    }

    public int InputBoardNo(){
        System.out.print("글 번호 입력: ");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextByte();
        return index;
    }

    public String InputBoardTitle(){
        Scanner sc = new Scanner(System.in);
        System.out.print("제목을 입력하시오 : ");
        String title = sc.nextLine();
        return title;
    }

    public String InputBoardContent(){
        Scanner sc = new Scanner(System.in);
        System.out.print("내용 입력: ");
        String e;
        StringBuilder sb = new StringBuilder();
        while(true){
            e = sc.nextLine();
            if(e.equalsIgnoreCase("exit")){
                break;
            }
            else{
                sb.append(e);
            }
        }
        return sb.toString();

    }

}
