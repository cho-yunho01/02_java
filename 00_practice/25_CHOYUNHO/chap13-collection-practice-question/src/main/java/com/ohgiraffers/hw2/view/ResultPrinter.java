package com.ohgiraffers.hw2.view;

import com.ohgiraffers.hw2.model.dto.BoardDTO;

import java.util.ArrayList;

public class ResultPrinter {
    public void printAllList(ArrayList<BoardDTO> list){
       if(list.isEmpty()){
           System.out.println("게시물이 없습니다.");
       }
       else{
           for(BoardDTO b : list){
               System.out.println(b);
           }
       }
    }

    public void printBoard(BoardDTO b){
        System.out.println(b);
    }

    public void errorPage(String msg){}

    public void successPage(String msg){}

    public void noSearchResult(){}
}
