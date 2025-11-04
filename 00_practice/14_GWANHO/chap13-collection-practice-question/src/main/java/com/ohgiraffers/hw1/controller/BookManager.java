package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.model.AscCategory;
import com.ohgiraffers.hw1.model.DescCategory;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.ArrayList;

public class BookManager {
    private ArrayList<BookDTO> books = null;

    public BookManager() {
        books = new ArrayList<>();
    }

    public void addBook(BookDTO book) {
        if(book != null) {
            books.add(book);
        }
    }

    public void deleteBook(int index) {
        for(BookDTO book : books) {
            if(book.getNo() == index) {
                books.remove(book);
                break;
            }
        }

        System.out.println("삭제할 도서가 없습니다.");
    }

    public int searchBook(String title) {
        for(BookDTO book : books) {
            if(book.getTitle().equals(title)) {
                return book.getNo();
            }
        }
        return -1;
    }

    public void printBook(int index) {
        for(BookDTO book : books) {
            if(book.getNo() == index) {
                System.out.println(book);
                return;
            }
        }

        System.out.println("출력할 도서가 없습니다.");
    }

    public void displayAll() {

        if(books.isEmpty()) {
            System.out.println("출력할 도서가 없습니다.");
        }

        for(BookDTO book : books) {
            System.out.println(book);
        }
    }

    public ArrayList<BookDTO> sortedBookList(int select) {
        if(select == 1) {
            books.sort(new AscCategory());
        } else if(select == 2) {
            books.sort(new DescCategory());
        }
        return books;
    }

    public void printBookList(ArrayList<BookDTO> bookList) {
        for(BookDTO book : bookList) {
            System.out.println(book);
        }
    }
}
