package com.ohgiraffers.hw1.model.dto;

public class BookDTO {

    //필드
    private int bNo;
    private int category;
    private String title;
    private String author;

    //생성자
    public BookDTO() {    }
    public BookDTO(int bNo, int category, String title, String author) {
        this.bNo = bNo;
        this.category = category;
        this.title = title;
        this.author = author;
    }

    //setter

    public void setbNo(int bNo) {
        this.bNo = bNo;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    //getter

    public int getbNo() {
        return bNo;
    }

    public int getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "[" +
                "bNo : " + bNo +
                ", category : " + category +
                ", title : '" + title + '\'' +
                ", author : '" + author + '\'' +
                "]";
    }
}
