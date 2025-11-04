package com.ohgiraffers.hw1.view;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.Scanner;

public class BookMenu {
    Scanner sc = new Scanner(System.in);
    BookManager bm;

    public BookMenu() {
        this.bm = new BookManager();

    }

    public void menu() {
        int num = 0;
        String menu = """
                1. 새 도서 추가
                2. 도서정부 정렬 후 출력
                3. 도서 삭제
                4. 도서 검색 출력
                5. 전체 출력
                6. 끝내기
                """;
        do {
            System.out.println(menu);
            System.out.print("메뉴 번호 선택 : ");
            num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:

                    bm.addBook(inputBook());

                    break;
                case 2:
                    System.out.print("정렬방식을 선택해주세요 (1. 오름차순, 2.내림차순) : ");
                    int sortNum = sc.nextInt();
                    if (sortNum == 1 || sortNum == 2) {
                        bm.printBookList(bm.sortedBookList(sortNum));
                    } else {
                        System.out.println("번호를 잘못입력하였습니다.");
                    }
                    break;
                case 3:
                    System.out.print("도서 번호를 입력하세요 : ");
                    int delNum = sc.nextInt();
                    bm.deleteBook(delNum);
                    break;

                case 4:
                    String tilte = inputBookTitle();
                    int index = bm.serachBook(tilte);
                    if (index != 1) {
                        bm.printBook(index);
                    } else {
                        System.out.println("조회한 도서가 존재하지 않음.");
                    }
                    break;

                case 5:
                    bm.displayAll();
                    break;

                case 6:
                    System.out.println("종료합니다. ");
                    break;

            }
        } while (num != 6);

    }

    public BookDTO inputBook() {
        System.out.print("도서 번호 : ");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.print("도서 제목 : ");
        String title = sc.nextLine();
        System.out.print("도서 장르 (1:인문 / 2:자연과학 / 3:의료 / 4:기타) : ");
        int type = sc.nextInt();
        sc.nextLine();
        System.out.print("도서 저자 : ");
        String author = sc.nextLine();
        BookDTO book = new BookDTO(num, type, title, author);
        return book;
    }


    public String inputBookTitle() {
        System.out.print("도서 제목 :");
        String title = sc.nextLine();
        return title;
    }
}
