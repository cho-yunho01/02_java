package com.E.hw1.view;

import com.E.hw1.controller.BookManager;
import com.E.hw1.model.dto.BookDTO;

import java.util.Scanner;

public class BookMenu {

    private Scanner sc = new Scanner(System.in);
    private BookManager bm = new BookManager();

    public BookMenu() {
    }

    public void menu(){
        bm.setup();
        boolean go  = true;
        while(go){
            System.out.println("""
                    1. 새 도서 추가
                    2. 도서정보 정렬 후 출력
                    3. 도서 삭제
                    4. 도서 검색출력
                    5. 전체 출력
                    6. 끝내기
                    """);

            int input = sc.nextInt();
            switch(input){
                case 1: bm.addBook(inputBook());
                break;
                case 2:
                    System.out.println("""
                            정렬 방식을 선택하세요
                            1. 오름차순
                            2. 내림차순
                            """);
                    int order = sc.nextInt();
                    bm.sortedBookList(order);
                break;
                case 3:
                    System.out.println("input book number");
                    int bn = sc.nextInt();
                            bm.deleteBook(bn);
                            break;
                case 4:
                    String title = inputBookTitle();
                    if(bm.searchBook(title) != -1) bm.printBook(bm.searchBook(title)-1);
                     else System.out.println("book does not exist");
                break;
                case 5: bm.disPlayAll();
                break;
                case 6: go = false;
                break;
            }
        }
    }

    public BookDTO inputBook(){

        System.out.println("enter bNo");
        int n = sc.nextInt();
        System.out.println("enter category");
        System.out.println("""
                1 : 인문 / 2 : 자연과학
                        3 : 의료 / 4 : 기타)""");
        int category = sc.nextInt();
        System.out.println("enter title");
        String title = sc.next();
        System.out.println("enter author");
        String author = sc.next();

        return  new BookDTO(n,category,title,author);
    }
    public String inputBookTitle(){
        System.out.println("enter title");
        String title = sc.next();
        return title;
    }

}
