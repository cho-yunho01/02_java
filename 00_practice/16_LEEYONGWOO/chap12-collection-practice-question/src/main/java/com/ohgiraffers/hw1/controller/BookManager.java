package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.model.comparator.AscCategory;
import com.ohgiraffers.hw1.model.comparator.DescCategory;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BookManager {
    public ArrayList<BookDTO> bookList;
    public BookManager() {
        this.bookList = new ArrayList<>();
    }

    public void addBook(BookDTO book) {
        this.bookList.add(book);
    }

    public void deleteBook(int bNo) {
        this.bookList.remove(bNo);
    }

    public int searchBook(String bookTitle){
        for(int i=0; i<this.bookList.size(); i++){
            if(this.bookList.get(i).getTitle().equals(bookTitle)){
                return i;
            }
        }
        return -1;
    }

    public void printBook(int index){
        if(index==-1){
            System.out.println("조회한 도서가 존재하지 않음");
        }else {
            System.out.println(this.bookList.get(index));
        }
    }

    public void displayAll(){
        if(this.bookList.size()==0){
            System.out.println("출력할 도서가 존재하지 않음");
        }else {
            for (int i = 0; i < this.bookList.size(); i++) {
                System.out.println(i + " : " + this.bookList.get(i));
            }
        }
    }

    public ArrayList<BookDTO> sortedBookList(int select){
        if(select==1){
            this.bookList.sort(new AscCategory());
        }else if(select==2) {
            this.bookList.sort(new DescCategory());
        }else{
            System.out.println("번호를 잘못 입력하였습니다.");
        }
        return this.bookList;
    }

    public void printBookList(ArrayList<BookDTO> br) {
        for(BookDTO b: br){
            System.out.println(b.toString());
        }
    }
}
