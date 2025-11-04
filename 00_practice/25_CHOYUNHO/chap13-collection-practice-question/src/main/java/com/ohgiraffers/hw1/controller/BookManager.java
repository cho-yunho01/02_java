package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.model.comparator.AscCategory;
import com.ohgiraffers.hw1.model.comparator.DescCategory;
import com.ohgiraffers.hw1.model.dto.BookDTO;
import java.util.ArrayList;

public class BookManager {

    private ArrayList<BookDTO> books;
    public BookManager() {
        books = new ArrayList<>();
    }

    public void addBook(BookDTO book){
        books.add(book);
    }

    public void deleteBook(int index){
        for(int i = 0 ; i<books.size();i++){
            if(books.get(i).getbNo() == index){
                books.remove(i);
            }
        }
    }

    public int serachBook(String bTitle){
        int index = 0;
        boolean tr = false;

        for(int i=0;i<books.size();i++){
            if(books.get(i).getTitle().equals(bTitle)){
                index = i;
                tr = true;
            }
        }
        if(tr){
            return index;
        }
        else{
            return -1;
        }

    }

    public void printBook(int index){
        System.out.println(books.get(index));
    }

    public void displayAll(){
        if(books.isEmpty()){
            System.out.println("출력할 도서가 없습니다.");
        }
        else{
            for(int i=0;i<books.size();i++){
                System.out.println(books.get(i));
            }
        }
    }
    public ArrayList<BookDTO> sortedBookList(int select){
        if(select==1){
            books.sort(new AscCategory());
            return books;
        }
        else if(select==2){
            books.sort(new DescCategory());
            return books;
        }
        else{
            System.out.println("잘못된 값 입력:");
            return books;
        }

    }

    public void printBookList(ArrayList<BookDTO> br){
        for(BookDTO book:br){
            System.out.println(book);
        }
    }



}
