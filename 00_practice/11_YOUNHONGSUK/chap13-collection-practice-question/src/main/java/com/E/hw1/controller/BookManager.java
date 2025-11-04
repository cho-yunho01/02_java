package com.E.hw1.controller;

import com.E.hw1.model.comparator.AscCategory;
import com.E.hw1.model.comparator.DescCategory;
import com.E.hw1.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.Collections;

public class BookManager {

    ArrayList<BookDTO> list = new ArrayList<>();

    //list.add(new BookDTO(1,2,"molu", "shin yongha"))\;

    BookDTO book = new  BookDTO(1,2,"molu", "shinyongha");
    BookDTO book2 = new  BookDTO(2,2,"chang pop", "shinchangsup");
    BookDTO book3 = new  BookDTO(3,3,"lck", "faker");


    public void setup(){
        list.add(book);
        list.add(book2);
        list.add(book3);

    }

    public void addBook(BookDTO book){
        list.add(book);
    }

    public void deleteBook(int index){
        for(BookDTO book:list){
            if(book.getbNo() == index){
                list.remove(book);
                break;
            }
        }
    }

    public int searchBook(String title){
        int index = -1;
        for(BookDTO book:list){
            if(book.getTitle().equals(title)){
                index = book.getbNo();
            }
            System.out.println("검색 도서 번호 확인 : " + index);
        } return index;
    }

    public void printBook(int index){
        System.out.println(list.get(index).toString());
    }

    public void disPlayAll(){
        for(BookDTO book:list){
            System.out.println(book.toString());
        }
    }

    public ArrayList<BookDTO> sortedBookList(int select){
        if(select == 1){
            list.sort(new AscCategory());
            System.out.println(list);
        }else if (select == 2){
            list.sort(new DescCategory());
            System.out.println(list);
        } else System.out.println("input must be between 1 and 2");
        return null;
    }

    public void printBookList(ArrayList<BookDTO> br ){
        for(BookDTO book:br){
            System.out.println(book.toString());
        }
    }

}
