package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.model.comparator.AscCategory;
import com.ohgiraffers.hw1.model.comparator.DescCategory;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.awt.print.Book;
import java.util.ArrayList;

public class BookManager {
    private ArrayList<BookDTO> bookList;

    public BookManager() {
        bookList = new ArrayList<>();
    }

    public void addBook(BookDTO book){
        bookList.add(book);
    }

    public void deleteBook(int index){
        bookList.remove(index);
    }

    public int searchBook(String title){
        for (int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).getTitle().equals(title)){
                return i;
            }
        }
        return  -1 ;
    }

    public void printBook(int index){
        System.out.println(bookList.get(index));
    }

    public void displayAll(){
        if(bookList.isEmpty()){
            System.out.println("출력할 도서가 없습니다.");
        }else{
            for(BookDTO book : bookList){
                System.out.println(book);
            }
        }
    }

    public ArrayList<BookDTO> sortedBookList(int select){
        // 전달받은 매개변수의 값에 따라 정렬(1. 오름차순,2. 내림차순)
        // 해당 배열 주소 값 리턴
        if(select == 1){
            bookList.sort(new AscCategory());
            return bookList;
        }else if(select == 2){
            bookList.sort(new DescCategory());
            return bookList;
        } return  bookList;
    }

    public void printBookList(ArrayList<BookDTO> br){
        for(BookDTO book : br){
            System.out.println(book);
        }
    }

}
