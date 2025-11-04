package com.ohgiraffers.hw1.view;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class BookMenu {

    private Scanner sc = new Scanner(System.in);
    private BookManager bm = new BookManager();

    public BookMenu() {}


    public void menu() {
        while (true) {
            System.out.print("*** 도서 관리 프로그램 ***\n" +
                    "1. 새 도서 추가\n" +
                    "2. 도서 정보 정렬 후 출력\n" +
                    "3. 도서 삭제\n" +
                    "4. 도서 검색 출력\n" +
                    "5. 전체 출력\n" +
                    "6. 끝내기\n" +
                    "메뉴 번호 선택 : ");
            int inNum = sc.nextInt();
            sc.nextLine();
            if (inNum == 1) {
                BookDTO newBook = inputBook();
                bm.addBook(newBook);
            } else if (inNum == 2) {
                System.out.print("정렬방식을 선택해주세요 (1. 오름차순, 2.내림차순) : ");
                int sortNum = sc.nextInt();
                if ((sortNum != 1) && (sortNum != 2)) {
                    System.out.println("번호를 잘못 입력하였습니다.");
                }
                ArrayList<BookDTO> bAList = bm.sortedBookList(sortNum);
                bm.printBookList(bAList);
            } else if (inNum == 3) {
                System.out.print("삭제할 도서의 번호를 입력하세요 : ");
                int delBNo = sc.nextInt();
                bm.deleteBook(delBNo);
            } else if (inNum == 4) {
                String bTitle = inputBookTitle();
                int idx = bm.searchBook(bTitle);
                if (idx == -1) {
                    System.out.println("조회한 도서가 존재하지 않음");
                } else {
                    bm.printBook(idx);
                }
            } else if (inNum == 5) {
                bm.displayAll();
            } else if (inNum == 6) {
                return;
            }
        }
    }

    public BookDTO inputBook() {
        System.out.print("도서 번호 : ");
        int bNo = sc.nextInt();
        sc.nextLine();
        System.out.print("도서 제목 : ");
        String title = sc.nextLine();
        System.out.print("도서 장르 (1:인문 / 2:자연과학 / 3:의료 / 4:기타) : ");
        int category = sc.nextInt();
        sc.nextLine();
        System.out.print("도서 저자 : ");
        String author = sc.nextLine();
        BookDTO newBook = new BookDTO(bNo, category, title, author);
        return newBook;
    }

    public String inputBookTitle() {
        System.out.print("도서 제목 : ");
        String title = sc.nextLine();
        return title;
    }
}
