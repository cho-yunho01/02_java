package com.ohgiraffers.hw1.view;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class BookMenu {

    public void menu() {
        /*
        * *** 도서 관리 프로그램 ***
            1. 새 도서 추가 // addBook (inputBook()이 리턴한 객체) 실행
            2. 도서정보 정렬 후 출력 // sortedBookList(정렬종류번호) 실행
            =>입력받은 매개변수를 이용하여 정렬방식에 따라 출력
            정렬방식을 선택해주세요 (1. 오름차순, 2.내림차순)
            1,2 이외의 값을 입력했을 시에는 “번호를 잘못입력하였습니다”를 출력
            => ArrayList<BookDTO> 리턴 받아 printBookList(ArrayList<BookDTO>) 실행
            3. 도서 삭제 // deleteBook (도서 번호) 실행
            4. 도서 검색출력 // searchBook (inputBookTitle()이 리턴한 도서 제목) 실행
            => index 리턴 받아 -1일 경우 “조회한 도서가 존재하지 않음”
            -1이 아닐 경우 printBook(index) 출력
            5. 전체 출력 // displayAll() 실행
            => 결과 리스트 리턴 받아 비어있을 경우 “출력할 도서가 없습니다.”
            아닌 경우는 전체 출력
            6. 끝내기 // main()으로 리턴
            메뉴 번호 선택 : >> 입력 받음
            // 메뉴 화면 반복 실행 처리
            // 해당 메뉴 번호에 따라 BookManager 클래스 메소드 실행
        * */
        Scanner sc = new Scanner(System.in);
        BookManager bm = new BookManager();
        BookMenu bookMenu = new BookMenu();
        ArrayList<BookDTO> list = new ArrayList<>();

        while (true) {
            String menu = """
                    ****** 도서 관리 프로그램 ******
                    1. 새 도서 추가
                    2. 도서정보 정렬 후 출력
                    3. 도서 삭제
                    4. 도서 검색출력
                    5. 전체 출력
                    6. 끝내기
                    번호를 입력하세요 :
                    """;
            System.out.print(menu);
            int no = sc.nextInt();
//            sc.nextLine();

            switch (no) {
                case 1:
                    BookDTO book = bookMenu.inputBook();
                    bm.addBook(book);
                    break;
                case 2:
                    System.out.print("정렬방식을 선택해주세요 (1. 오름차순 / 2. 내림차순) : ");
                    int sort = sc.nextInt();
                    list = bm.sortedBookList(sort);
                    bm.printBookList(list);
                    break;
                case 3:
                    System.out.print("삭제하실 도서 번호를 입력해주세요. : ");
                    int bNo = sc.nextInt();
                    bm.deleteBook(bNo);
                    break;
                case 4:
                    String title = bookMenu.inputBookTitle();
                    int index = bm.searchBook(title);
                    bm.printBook(index);
                    break;
                case 5:
                    bm.displayAll();
                    break;
                case 6:
                    System.out.println("도서 관리 프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다.");
            }
        }
    }

    public BookDTO inputBook() {
        Scanner sc = new Scanner(System.in);

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

        BookDTO book = new BookDTO(bNo, category, title, author);
        return book;
    }

    public String inputBookTitle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("도서 제목 : ");
        String title = sc.nextLine();

        return title;
    }
}
