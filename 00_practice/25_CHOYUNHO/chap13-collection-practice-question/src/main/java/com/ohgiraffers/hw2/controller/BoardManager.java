package com.ohgiraffers.hw2.controller;

import com.ohgiraffers.hw2.model.dto.BoardDTO;
import com.ohgiraffers.hw2.view.ResultPrinter;

import java.util.ArrayList;
import java.util.Comparator;

public class BoardManager {
    private ArrayList<BoardDTO> boardList = new ArrayList<>();

    private ResultPrinter rp;

    public void insertBoard(BoardDTO b){
        boardList.add(b);
    }
    public void selectAllList(){
        for(BoardDTO b : boardList){
            System.out.println(b);
        }
    }

    public void selectOneBoard(int boardNo){
        for(int i=0;i<boardList.size();i++){
            if(boardList.get(i).getBoardNo() == boardNo){
                System.out.println(boardList.get(i));
            }
        }
    }

    public void updateBoardTitle(int boardNo, String title){
        for(int i=0;i<boardList.size();i++){
            if(boardList.get(i).getBoardNo() == boardNo){
                boardList.get(i).setBoardTitle(title);
            }
        }
    }

    public void updateBoardContent(int boardNo, String content){
        for(int i=0;i<boardList.size();i++){
            if(boardList.get(i).getBoardNo() == boardNo){
                boardList.get(i).setBoardContent(content);
            }
        }
    }
    public void deleteBoard(int boardNo){
        for(int i=0;i<boardList.size();i++){
            if(boardList.get(i).getBoardNo() == boardNo){
                boardList.remove(i);
            }
        }

    }

    public void searchBoard(String title){
        for(int i=0;i<boardList.size();i++){
            if(boardList.get(i).getBoardTitle().equals(title)){
                System.out.println(boardList.get(i));
            }
        }
    }

    public void sortList(Comparator<BoardDTO> c){}
}
