package com.ohgiraffers.hw1.model.dto;

public class BookDTO {
    private int no;
    private int category;
    private String title;
    private String author;

    public BookDTO() {

    }

    public BookDTO(int no, int category, String title, String author) {
        this.no = no;
        this.category = category;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "no=" + no +
                ", category=" + categoryToString() +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    private String categoryToString() {
        switch (category) {
            case 1: return "인문";
            case 2: return "자연과학";
            case 3: return "의료";
            case 4: return "기타";
            default: return "몰라";
        }
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
