package com.ohgiraffers.section01.list.dto;

import com.ohgiraffers.section01.list.comparator.AscendingPrice;

import java.util.*;

public class Application2 {


    public static void main(String[] args) {

        //리스트 계열에 데이터를 추가 : add()
        // 데이터를 조회 : get(index)
        // 데이서 수정 : set(index,value)
        // 데이터 삭제 : remove(index

        List<BookDto> bookList = new ArrayList<>();
        bookList.add(new BookDto(1, "홍길동전", "허균", 50000));
        bookList.add(new BookDto(2, "목민심서", "정약용", 30000));
        bookList.add(new BookDto(3, "동의보감", "허준", 40000));
        bookList.add(new BookDto(4, "삼국사기", "김부식", 40000));
        bookList.add(new BookDto(5, "삼국사기", "일연", 58000));

        System.out.println(bookList);
        System.out.println(bookList.size());

        for (BookDto bookDto : bookList) {
            System.out.println(bookDto);
        }
        bookList.sort(new AscendingPrice()); // 가격 오름차순 정렬
        System.out.println("가격 오름 차순 정렬");

        for (BookDto bookDto : bookList) {
            System.out.println(bookDto);
        }

        // 익명 클래스
        bookList.sort(new Comparator<BookDto>() {
            @Override
            public int compare(BookDto o1, BookDto o2) {
                return o1.getPrice() >= o2.getPrice() ? -1 : 1;
            }
        });

        System.out.println("==========");

        for (BookDto bookDto : bookList) {
            System.out.println(bookDto);
        }

        System.out.println();
        bookList.sort(new Comparator<BookDto>() {
            @Override
            public int compare(BookDto o1, BookDto o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        for (BookDto bookDto : bookList) {
            System.out.println(bookDto);
        }

        System.out.println();
        bookList.sort(new Comparator<BookDto>() {
            @Override
            public int compare(BookDto o1, BookDto o2) {
                return o2.getTitle().compareTo(o1.getTitle());
            }
        });

        for (BookDto bookDto : bookList) {
            System.out.println(bookDto);
        }

    }

}
