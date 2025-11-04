package com.lhw.section01.list.comparator;

import com.lhw.section01.list.dto.BookDto;

import java.util.Comparator;

public class AscendingPrice implements Comparator<BookDto> {
    // 가격오름차순
    @Override
    public int compare(BookDto o1, BookDto o2) {
        int result = 0;
        if(o1.getPrice() > o2.getPrice()) {
            result = 1; //o1 기준 양수이니 자리를 바꾼다.
        } else if (o1.getPrice() < o2.getPrice()) {
            result = -1; //자리를 안바꾼다.
        } else {// 같으면
            result = 0;
        }

        return result;
    }

    // Comparator 혹은
    // Comparable 기능을 붙이는 것.

}
