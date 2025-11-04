package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.model.comparator.AscCategory;
import com.ohgiraffers.hw1.model.comparator.DescCategory;
import com.ohgiraffers.hw1.model.dto.BookDTO;
import com.ohgiraffers.hw1.view.BookMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {

    Scanner sc = new Scanner(System.in);
    private ArrayList<BookDTO> bookList;
    BookMenu bookMenu = new BookMenu();

    public BookManager() {
        bookList = new ArrayList<>();
    }

    public void addBook(BookDTO book) {
        bookList.add(book);
    }

    public void deleteBook(int index) {
        boolean isExist = false;
        for (BookDTO book : bookList) {
            if(book.getbNo() == index){
                bookList.remove(book);
                isExist = true;
            }
        }

        if(isExist){
            System.out.println(index + "번 도서가 삭제되었습니다.");
        } else {
            System.out.println("삭제할 도서가 없습니다.");
        }
    }

    public int searchBook(String title) {
        int index = 0;
        for (BookDTO book : bookList) {
            if (book.getTitle().equals(title)) {
                index = book.getbNo();
            } else {
                index = -1;
            }
        }
        return index;
    }

    // index == 도서번호
    public void printBook(int index) {
        if (index == -1) {
            System.out.println("조회한 도서가 존재하지 않음");
        } else {
//           BookDTO book = bookList.get(bookList.get(index).getbNo());
            for(BookDTO book : bookList){
                if(book.getbNo() == index){
                    System.out.println(book);
                }
            }
        }
    }

    public void displayAll() {
        for (BookDTO book : bookList) {
            System.out.println(book);
        }
    }

    public ArrayList<BookDTO> sortedBookList(int select) {
        if(select == 1) {
            bookList.sort(new AscCategory() {
                @Override
                public int compare(BookDTO o1, BookDTO o2) {
                    return super.compare(o1, o2);
                }
            });
        } else if (select == 2) {
            bookList.sort(new DescCategory() {
                @Override
                public int compare(BookDTO o1, BookDTO o2) {
                    return super.compare(o1, o2);
                }
            });
        } else {
            System.out.println("잘못된 번호 입력입니다.");
        }

        return bookList;
    }

    public void printBookList(ArrayList<BookDTO> br) {
        for (BookDTO book : br) {
            System.out.println(book);
        }
    }
}
