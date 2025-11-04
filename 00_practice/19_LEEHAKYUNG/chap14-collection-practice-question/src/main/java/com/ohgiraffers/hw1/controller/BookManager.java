package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.model.comparator.AscCategory;
import com.ohgiraffers.hw1.model.comparator.DescCategory;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.ArrayList;

public class BookManager {

    private ArrayList<BookDTO> booklist = new ArrayList<>();
    public BookManager() {}

    public void addBook(BookDTO book) {
        booklist.add(book);
    }

    public void deleteBook(int bNo) {
        for (BookDTO book : booklist) {
            if (book.getbNo() == bNo) {
                int index = booklist.indexOf(book);
                booklist.remove(index);
                return;
            }
        }
        System.out.println("삭제할 도서가 없습니다.");
    }

    public int searchBook(String title) {
        for (BookDTO book : booklist) {
            if (book.getTitle().equals(title)) {
                return booklist.indexOf(book);
            }
        }
        return -1;
    }

    public void printBook(int index) {
        BookDTO book = booklist.get(index);
        if (book == null) {
            System.out.println("조회한 도서가 존재하지 않음.");
        }
        System.out.println(book);
    }

    public void displayAll() {
        if (booklist.isEmpty()) {
            System.out.println("출력할 도서가 없습니다.");
            return;
        }
        for (BookDTO book : booklist) {
            System.out.println(book);
        }
    }

    public ArrayList<BookDTO> sortedBookList(int select) {
        if (select == 1) {
            AscCategory asc = new AscCategory();
            booklist.sort(asc);
            return booklist;
        } else {
            DescCategory desc = new DescCategory();
            booklist.sort(desc);
            return booklist;
        }
    }

    public void printBookList(ArrayList<BookDTO> br) {
        for (BookDTO book : br) {
            System.out.println(book);
        }
    }

}
