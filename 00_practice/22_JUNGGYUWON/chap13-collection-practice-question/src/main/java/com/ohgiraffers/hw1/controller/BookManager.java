package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.model.BookDTO;
import com.ohgiraffers.hw1.model.comparator.AscCategory;
import com.ohgiraffers.hw1.model.comparator.DescCategory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class BookManager {
    private ArrayList<BookDTO> bookList;

    public BookManager() {
        this.bookList = new ArrayList<>();
    }

    public void addBook(BookDTO book){
        bookList.add(book);
    }

    public void deleteBook(int index){
        if(index >= 0 && index < bookList.size()){
            bookList.remove(index);
            System.out.println("도서가 삭제되었습니다.");
        }
        else{
            System.out.println("해당 인덱스의 도서가 존재하지않습니다.");
        }
    }

    public int serachBook(String bTitle){
        int index = -1;
        for (BookDTO bookDTO : bookList) {
            if(bookDTO.getTitle().equals(bTitle)){
                index = bookList.indexOf(bookDTO);
            }
        }
        return index;
    }

    public void printBook(int index){
        System.out.println( bookList.get(index));

    }

    public void diplayAll(){
        if(bookList.isEmpty()){
            System.out.println("출력할 도서가 없습니다.");
        }
        else{
            for (BookDTO bookDTO : bookList) {
                System.out.println(bookDTO);
            }
        }
    }

    public ArrayList<BookDTO> sortedBookList(int select){
        ArrayList<BookDTO> temp = new ArrayList<>();
        if(select ==1){
            Iterator<BookDTO> iterator = bookList.iterator();
            while (iterator.hasNext()){
                temp.add(iterator.next());
            }
           temp.sort(new AscCategory());
            return temp;
        }
        else if(select ==2){
            Iterator<BookDTO> iterator = bookList.iterator();
            while (iterator.hasNext()){
                temp.add(iterator.next());
            }
            temp.sort(new DescCategory());
            return temp;
        }
        else{
            return null;
        }
    }

    public void printBookList(ArrayList<BookDTO> br){
        for (BookDTO bookDTO : br) {
            System.out.println(bookDTO);
        }
    }
}
