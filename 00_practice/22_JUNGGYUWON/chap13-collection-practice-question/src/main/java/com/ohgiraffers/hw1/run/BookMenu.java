package com.ohgiraffers.hw1.run;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.BookDTO;

import java.util.Scanner;

public class BookMenu {
    Scanner sc = new Scanner(System.in);
    BookManager bm = new BookManager();

    public BookMenu() {


    }

    public void menu() {
        String menu = """
                *** 도서관리 프로그램***
                1. 새 도서 추가
                2. 도서정보 정렬 후 출력
                3. 도서 삭제
                4. 도서 검색출력 
                5. 전체 출력
                6. 끝내기
                메뉴 번호 선택 : """;


        boolean flag = true;
        while (flag) {
            System.out.print(menu);
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    bm.addBook(inputBook());
                    break;

                case 2:
                    System.out.print("정렬방식을 선택해주세요 (1. 오름차순, 2.내림차순)");
                    int selectBook = sc.nextInt();
                    sc.nextLine();

                    boolean flag2 = true;
                    while (flag2) {
                        if (selectBook == 1 || selectBook == 2) {
                            flag2 = false;
                        } else {
                            System.out.println(" 번호를 잘못 입력하셨습니다.");
                            System.out.print("정렬방식을 선택해주세요 (1. 오름차순, 2.내림차순)");
                            selectBook = sc.nextInt();
                        }
                    }
                    bm.printBookList( bm.sortedBookList(selectBook)); // while문 탈출했을때만 실행
                    break;

                case 3:
                    System.out.print("삭제할 도서 번호를 입력해주세요 : ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    bm.deleteBook(index);
                    break;

                case 4:
                    int idx = bm.serachBook(inputBookTitle());
                    if(idx == -1){
                        System.out.println("조회한 도서가 존재하지 않음");
                    }
                    else{
                        bm.printBook(idx);
                    }
                    break;

                case 5:
                    bm.diplayAll();
                    break;

                case 6:
                    flag = false;
                    System.out.println("종료합니다.");
                    break;

                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
                    break;
            }
        }

    }

    public BookDTO inputBook() {
        System.out.print(" 도서 번호 : ");

        int id = sc.nextInt();
        sc.nextLine();
        System.out.print(" 도서 제목 : ");
        String title = sc.nextLine();
        System.out.print("도서 장르 (1:인문 / 2:자연과학 / 3:의료 / 4:기타) : ");

        int category = sc.nextInt();
        sc.nextLine();

        System.out.print("도서 저자 : ");
        String author = sc.nextLine();

        return new BookDTO(id, category, title, author);

    }

    public String inputBookTitle() {
        System.out.print(" 도서 제목 : ");
        String title = sc.nextLine();
        return title;
    }
}

