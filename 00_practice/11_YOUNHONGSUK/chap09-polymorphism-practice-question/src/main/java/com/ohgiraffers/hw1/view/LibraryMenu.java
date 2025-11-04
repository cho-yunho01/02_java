package com.ohgiraffers.hw1.view;

import com.ohgiraffers.hw1.controller.LibraryManager;
import com.ohgiraffers.hw1.model.dto.Book;
import com.ohgiraffers.hw1.model.dto.CookBook;
import com.ohgiraffers.hw1.model.dto.Member;

import java.util.Scanner;

public class LibraryMenu {

    private LibraryManager lm = new LibraryManager();
    protected Scanner sc = new Scanner(System.in);

    private boolean go = true;

    public void mainMenu() {

        System.out.println("Welcome to the Library Menu");
        System.out.println("Enter your name");
        String name = sc.next();
        System.out.println("Enter your age");
        int age = sc.nextInt();
        System.out.println("Enter your gender");
        char gender = sc.next().charAt(0);

        Member mem = new Member(name, age, gender);

        lm.insertMember(mem);

        while (go) {
            System.out.println("""
                    ==== 메뉴 ===== 
                    1. 마이페이지
                    2. 도서 전체 조회
                    3. 도서 검색
                    4. 도서 대여하기
                    0. 프로그램 종료
                    """);

            int input = sc.nextInt();
            switch (input) {
                case 1:
                    lm.myInfo();
                    break;
                case 2:
                    selectAll();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    selectAll();
                    rentBook();
                    break;
                case 0:
                    go = false;
                    break;
            }
        }
    }

    public void selectAll() {
        Book[] bList = lm.selectAll();
        for (Book b : bList) {
            System.out.println(b.toString());
            //System.out.println(b.getTitle() + " / " + b.getAuthor() + " / " + b.getPublisher());
        }
    }

    public void searchBook() {
        System.out.println("enter title keyword");
        String title = sc.next();
        Book[] ba = lm.searchBook(title);

        for (Book b : ba) {
            if (b != null) {
                System.out.println(b.getTitle() + " / " + b.getAuthor() + " / " + b.getPublisher());
            }
        }
    }

    public void rentBook() {
        System.out.println("enter index");
        int index = sc.nextInt();
        boolean correct = true;
        while(correct){
            if(index < 5){
                correct = false;
            break;}
            else
                System.out.println("index must be between 0-4");
            index = sc.nextInt();
        }
        int result = lm.rentBook(index);
        switch (result) {
            case 0:
                System.out.println("rented");
                break;
            case 1:
                System.out.println("can't rent due to age restriction");
                break;
            case 2:
                if (((CookBook) lm.selectAll()[index]).isCoupon()) {
                    System.out.println("rented, and coupon added, can check from my page");
                } else {
                    System.out.println("rented, no coupon added");
                }
        }

    }

    public LibraryManager getLm () {
        return lm;
    }

    public void setLm (LibraryManager lm){
        this.lm = lm;
    }
}