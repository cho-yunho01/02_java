package com.ohgiraffers.hw1.model.dto;

public class AniBook extends Book {

    private int AccessAge;

    public AniBook() {
    }

    public AniBook(String title, String author, String publisher, int accessAge) {
        super(title, author, publisher);
        AccessAge = accessAge;
    }

    @Override
    public String toString() {
        return "AniBook{" +
                super.toString() +
                "AccessAge= " + AccessAge +
                '}';
    }

    public int getAccessAge() {
        return AccessAge;
    }

    public void setAccessAge(int accessAge) {
        AccessAge = accessAge;
    }
}
