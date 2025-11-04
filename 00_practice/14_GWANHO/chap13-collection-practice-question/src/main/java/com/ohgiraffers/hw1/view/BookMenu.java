package com.ohgiraffers.hw1.view;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.Scanner;

public class BookMenu {

    public void menu() {
        Scanner sc = new Scanner(System.in);
        BookManager manager = new BookManager();

        manager.addBook(new BookDTO(1, 1, "책1", "저자1"));
        manager.addBook(new BookDTO(6, 3, "책6", "저자6"));
        manager.addBook(new BookDTO(2, 1, "책2", "저자2"));
        manager.addBook(new BookDTO(9, 4, "책9", "저자9"));
        manager.addBook(new BookDTO(7, 3, "책7", "저자7"));
        manager.addBook(new BookDTO(5, 2, "책5", "저자5"));
        manager.addBook(new BookDTO(3, 1, "책3", "저자3"));
        manager.addBook(new BookDTO(8, 4, "책8", "저자8"));
        manager.addBook(new BookDTO(4, 2, "책4", "저자4"));

        do {
            String menu = """
                    *** 도서 관리 프로그램 ***
                    1. 새 도서 추가
                    2. 도서정보 정렬 후 출력
                    3. 도서 삭제
                    4. 도서 검색출력
                    5. 전체 출력
                    6. 끝내기
                    ==========================================
                    메뉴 선택 : """;
            System.out.print(menu);

            int number = Integer.parseInt(sc.nextLine());
            switch (number) {
                case 1:
                    manager.addBook(inputBook());
                    break;
                case 2:
                    System.out.print("정렬방식을 선택해주세요 (1. 오름차순, 2.내림차순) : ");
                    int select = Integer.parseInt(sc.nextLine());
                    if(select == 1 || select == 2) {
                        manager.printBookList(manager.sortedBookList(select));
                    } else {
                        System.out.println("번호를 잘못입력하였습니다");
                    }
                    break;
                case 3:
                    System.out.print("삭제할 도서 번호 : ");
                    manager.deleteBook(Integer.parseInt(sc.nextLine()));
                    break;
                case 4:
                    int index = manager.searchBook(inputBookTitle());
                    if(index == -1) {
                        System.out.println("조회한 도서가 존재하지 않음");
                    } else {
                        manager.printBook(index);
                    }
                    break;
                case 5:
                    manager.displayAll();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다.");;
            }
        } while (true);
    }

    public BookDTO inputBook() {
        Scanner sc = new Scanner(System.in);

        System.out.println("책 정보 입력 : ");

        System.out.println("도서 번호 : ");
        int no = Integer.parseInt(sc.nextLine());
        System.out.println("도서 장르 (1:인문 / 2:자연과학 / 3:의료 / 4:기타) : ");
        int category = Integer.parseInt(sc.nextLine());
        System.out.println("도서 제목 : ");
        String title = sc.nextLine();
        System.out.println("도서 저자 : ");
        String author = sc.nextLine();

        return new BookDTO(no , category, title, author);
    }

    public String inputBookTitle() {
        Scanner sc = new Scanner(System.in);

        System.out.print("도서 제목 : ");
        return sc.nextLine();
    }
}
