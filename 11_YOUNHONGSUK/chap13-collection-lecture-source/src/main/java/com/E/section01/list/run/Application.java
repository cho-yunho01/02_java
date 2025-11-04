package com.E.section01.list.run;

import com.E.section01.list.comparator.AscPrice;
import com.E.section01.list.dto.BookDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        /**
         * 리스트계열의 데이터를 추가: add()
         * 데이터를 조회: get(index)
         * 데이터를 수정: set(index, value)
         * 데이터를 삭제: remove(index)
         */



        List<BookDTO> bookList = new ArrayList<>();
        bookList.add(new BookDTO (1,"홍길동전", "허균", 5000));
        bookList.add(new BookDTO (2,"홍길동", "허", 500));
        bookList.add(new BookDTO (3,"홍길전", "균", 50));
        bookList.add(new BookDTO (4,"홍동전", "허허", 5700));

        System.out.println(bookList.size());

        for(BookDTO book : bookList){
            System.out.println(book);
        }

//        Collections.sort(bookList);
        System.out.println("======================");
        bookList.sort(new AscPrice());
        for(BookDTO book : bookList){
            System.out.println(book);
        }

        //익명 클래스
        bookList.sort(new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO o1, BookDTO o2){
                return o1.getPrice() >= o2.getPrice() ? -1: 1;
            }
        });

        bookList.sort(new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO o1, BookDTO o2) {
               return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        for(BookDTO book : bookList){
            System.out.println(book);
        }

    }
}
