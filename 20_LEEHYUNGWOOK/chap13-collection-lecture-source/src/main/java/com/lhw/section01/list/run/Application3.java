package com.lhw.section01.list.run;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Application3 {

    public static void main(String[] args) {

        List<String> linkedList = new LinkedList<String>();

        /* 내부 구현코드는 다르지만, LinkedList도 List이기 때문에
         * 동일한 메소드 호출해서 사용할 수 있다.
         * list.size();           => 요소의 갯수 반환
         * list.add(값);          => 제일 뒤에 값 삽입
         * list.add(인덱스, 값);  => 해당 인덱스에 값 삽입
         * list.get(인덱스);      => 값 반환
         * list.remove(인덱스);   => 인덱스에 있는 값 삭제
         * list.set(인덱스, 값);  => 인덱스에 있는 값 수정
         * */

        linkedList.add("apple");
        linkedList.add("banana");
        linkedList.add("orange");
        linkedList.add("banana");
        linkedList.add("pear");
        linkedList.add("grape");
        linkedList.add("lemon");

        System.out.println(linkedList); //tostring 오버라이딩
        System.out.println(linkedList.size());
        //저장순서대로 저장
        for ( int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

        System.out.println("향상된 for문===========");
        for (String s: linkedList) {
            System.out.println(s);
        }

        System.out.println("Iterator ==========");
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        linkedList.set(0, "PINEAPPLE");
        System.out.println(linkedList);

        linkedList.clear();
//        linkedList = (LinkedList) linkedList;
        linkedList.add("hello");
        ((LinkedList<String>) linkedList).addFirst("world");
        System.out.println("linkedList : " + linkedList);
        ((LinkedList<String>) linkedList).removeFirst();
        System.out.println("linkedList : " + linkedList);
        ((LinkedList<String>) linkedList).removeLast();
        System.out.println("linkedList : " + linkedList);

        System.out.println("linkedList.isEmpty() = " + linkedList.isEmpty());
    }
}
