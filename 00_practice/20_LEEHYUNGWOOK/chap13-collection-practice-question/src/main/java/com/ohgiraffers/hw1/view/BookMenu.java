package com.ohgiraffers.hw1.view;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.Random;
import java.util.Scanner;

public class BookMenu {

    Scanner sc = new Scanner(System.in);
    BookManager bm = new BookManager();

    public BookMenu() {}

    public void menu() {
        while (true) {
            System.out.println("""
                    *** 도서관리 프로그램 ***
                    1. 새 도서 추가
                    2. 도서정보 정렬 후 출력
                    3. 도서 삭제
                    4. 도서 검색 출력
                    5. 전체 출력
                    6. 끝내기
                    """);
            System.out.print("원하는 기능을 선택해주세요 : ");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    bm.addBook(inputBook());
                    break;
                case 2: {
                    System.out.print("정렬방식을 선택해주세요. (1. 오름차순 2. 내림차순)");
                    int sortId = sc.nextInt();

                    System.out.println(bm.sortedBookList(sortId));
                    break;
                }
                case 3: {
                    bm.displayAll();
                    System.out.print("삭제할 도서 인덱스를 선택하세요.");
                    int deleteId = sc.nextInt();
                    bm.deleteBook(deleteId);
                    break;
                }
                case 4: {
                    int index = bm.searchBook(inputBookTitle());
                    if (index == -1) {
                        System.out.println("조회한 도서가 존재하지 않음");
                    } else {
                        bm.printBook(index);
                    }
                    break;
                }
                case 5:
                    bm.displayAll();
                    break;
                case 6:
                    System.out.print("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.print("잘못 입력하셨습니다.");
                    break;
            }
        }
    }

    public BookDTO inputBook() {
        Random random = new Random();
        int ranNum = random.nextInt(10000);
        sc.nextLine();

        System.out.print("제목을 입력해주세요 : ");
        String title = sc.nextLine();
        System.out.print("장르 타입을 입력해주세요 (1:인문 / 2:자연과학 / 3:의료 / 4:기타) : ");
        int category = sc.nextInt();
        System.out.print("저자를 입력해주세요 : ");
        String author = sc.next();

        return new BookDTO(ranNum, category, title, author);
    }

    public String inputBookTitle() {
        sc.nextLine();
        System.out.print("책 제목을 입력해주세요 : ");
        String bookTitle = sc.nextLine();
        return bookTitle;
    }
}
