package com.lhw.section01.list.run;

import com.lhw.section01.list.comparator.AscendingPrice;
import com.lhw.section01.list.dto.BookDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application2 {

    public static void main(String[] args) {
        /*
        * list.size();           => 요소의 갯수 반환
        * list.add(값);          => 제일 뒤에 값 삽입
        * list.add(인덱스, 값);  => 해당 인덱스에 값 삽입
        * list.get(인덱스);      => 값 반환
        * list.remove(인덱스);   => 인덱스에 있는 값 삭제
        * list.set(인덱스, 값);  => 인덱스에 있는 값 수정
        * */

        List<BookDto> bookList = new ArrayList<>();
        bookList.add(new BookDto(1, "홍길동전", "허균", 50000));
        bookList.add(new BookDto(2, "목민심서", "정약욕", 30000));
        bookList.add(new BookDto(3, "동의보감", "허준", 54000));
        bookList.add(new BookDto(4, "삼국사기", "김부식", 62000));
        bookList.add(new BookDto(5, "홍길동전", "일연", 1000));

        System.out.println("bookList = " + bookList);
        System.out.println("bookList = " + bookList.size());

        for  (BookDto book : bookList) {
            System.out.println(book);
        }

//        Collections.sort(bookList )  바로는 안된다. 다른 클래스들도 모두 Comparator라는 클래스를 오버라이딩해서 sort를 한다.
//        객체를 생성하여 리스트에 넣고 sorting하고 싶으면 Comparator 클래스의 메소드를 오버라이딩해야한다.
        // Compare 재정의 완료
        bookList.sort(new AscendingPrice());//가격 오름차순 정렬

        System.out.println("가격 오름차순 정렬");
        for  (BookDto book : bookList) {
            System.out.println(book);
        }

        // 익명 클래스 ( 한번 사용하고 말 것임 ) > 내림차순정렬
        bookList.sort(new Comparator<BookDto>() { //클래스와 같은 개념임.
            @Override
            public int compare(BookDto o1, BookDto o2) {
                return o1.getPrice() >= o2.getPrice()? -1 : 1;
            }
        });

        System.out.println("가격내림차순 정렬 ====");
        for  (BookDto book : bookList) {
            System.out.println(book);
        }

        bookList.sort(new Comparator<BookDto>() {

            @Override
            public int compare(BookDto o1, BookDto o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        System.out.println("책 제목 오름차순 정렬 =======");
        for  (BookDto book : bookList) {
            System.out.println(book);
        }

        bookList.sort(new Comparator<BookDto>() {

            @Override
            public int compare(BookDto o1, BookDto o2) {
                return o2.getTitle().compareTo(o1.getTitle());
            }
        });

        System.out.println("책 제목 내림차수 정렬 =======");
        for  (BookDto book : bookList) {
            System.out.println(book);
        }

    }
}
