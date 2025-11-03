package com.ohgiraffers.hw2.view;

import com.ohgiraffers.hw2.controller.BoardManager;
import com.ohgiraffers.hw2.model.comparator.*;

import java.util.Scanner;

public class BoardMenu {
    private BoardManager bm;
    private InputBoard ib;

    public void mainMenu(){
        String menu= """
                *** 게시글 서비스 프로그램 ***
                1. 게시글 쓰기 
                2. 게시글 전체보기
                3. 게시글 한 개보기
                4. 게시글 제목 수정
                5. 게시글 내용 수정
                6. 게시글 삭제
                7. 게시글 제목 검색
                8, 정렬하기
                9. 끝내기
                """;
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 번호 선택 : ");
        int num;
        do{
            System.out.print(menu);
            System.out.print("메뉴 번호 선택 : ");
            num = sc.nextInt();
            sc.nextLine();
            switch (num){
                case 1:
                    bm.insertBoard(new InputBoard().InputBoard());
                    break;
                case 2:
                    bm.selectAllList();
                    break;
                case 3:
                    System.out.print("번호를 입력 : ");
                    int index = sc.nextInt();
                    bm.selectOneBoard(index);
                    break;
                case 4:
                    System.out.print("수정할 번호를 입력 : ");
                    int No = sc.nextInt();
                    sc.nextLine();
                    System.out.print("수정할 제목 입력 : ");
                    String title = sc.nextLine();
                    bm.updateBoardTitle(No,title);
                    break;
                case 5:
                    bm.updateBoardContent(ib.InputBoardNo(), ib.InputBoardContent());
                    break;
                case 6:
                    System.out.print("삭제할 번호를 입력 : ");
                    int delNo = sc.nextInt();
                    bm.deleteBoard(delNo);
                    break;
                case 7:
                    System.out.print("검색할 제목 입력: ");
                    String s_title = sc.nextLine();
                    bm.searchBoard(s_title);
                    break;
                case 8:
                    break;
                case 9: break;
            }

        }while(num != 9);

    }

    public void sortSubMenu(){
        String sortMenu = """
                1. 글번호순 오름차순 정렬
                2. 글번호순 내림차순 정렬
                3. 작성날짜순 오름차순 정렬
                4. 작성날짜순 내림차순 정렬
                5. 글제목순 오름차순 정렬
                6. 글제목순 내림차순 정렬
                """;
        Scanner sc = new Scanner(System.in);
        System.out.print(sortMenu);
        System.out.print("메뉴 번호 선택 : ");
        int num = sc.nextInt();
        sc.nextLine();
        switch (num){
            case 1: bm.sortList(new AscBoardNo()); break;
            case 2: bm.sortList(new DescBoardNo()); break;
            case 3: bm.sortList(new AscBoardDate()); break;
            case 4: bm.sortList(new DescBoardDate()); break;
            case 5: bm.sortList(new AscBoardTitle()); break;
            case 6: bm.sortList(new DescBoardTitle()); break;
        }

    }

}
