package com.ohgiraffers.hw1.model.comparator;

import com.ohgiraffers.hw1.model.BookDTO;

import java.util.Comparator;

public class DescCategory implements Comparator<BookDTO> {

    @Override
    public int compare(BookDTO o1, BookDTO o2) {
        if(o2.getCategory()>o1.getCategory()){
            return 1;
        }
        else if(o2.getCategory()<o1.getCategory()){
            return -1;
        }
        else{
            return 0;
        }
    }

}
