package com.ohgiraffers.section01.list.run;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Application3 {


    public static void main(String[] args) {
        List<String> lList = new LinkedList<String>();

        /*
         * 내부적인 구현코드는 다르지만 LinkedList도 List 계열이기 때문에
         * 동일한 메소드를 사용 가능하다.
         * */

        lList.add("apple");
        lList.add("orange");
        lList.add("banana");
        lList.add("pear");
        lList.add("banana");

        System.out.println("lList.size() = " + lList.size());
        // 저장 순서 유지, 중복 허용 확인
        for (String s : lList) {
            System.out.println(s);
        }

        // toString()을 오버라이딩
        System.out.println("lList = " + lList);

        Iterator<String> iterator = lList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        lList.set(0, "pineapple");
        System.out.println("lList = " + lList);

        lList.clear();

        /*
         * LinkedList는 ArrayList와 내부적인 구현 방식이 다르므로
         * 수정, 삭제가 빈번한 상황에서는 LinkedList 사용하는 것이 효율적이다.
         * ~first, ~last 접미어를 붙여 순차적 기능을 강조한 함수들이 LinkedList에는 추가적으로 정의 되어 있다.
         * */
        lList.add("hello");
        ((LinkedList)lList).addFirst("world");
        ((LinkedList)lList).addLast("Lotte");
        System.out.println("lList = " + lList);
        ((LinkedList)lList).removeFirst();
        ((LinkedList)lList).removeLast();
        System.out.println("lList = " + lList);

        System.out.println("isEmpty = " + lList.isEmpty());
        lList.clear();
        System.out.println("isEmpty = " + lList.isEmpty());
    }
}
