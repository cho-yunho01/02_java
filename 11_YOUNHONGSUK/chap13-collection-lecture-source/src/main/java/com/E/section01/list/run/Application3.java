package com.E.section01.list.run;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Application3 {

    public static void main(String[] args) {

        List<String> ll = new LinkedList<String>();

        /*내부적인 구현코드는 다르지만 LinkedList도 List계열이기 때문에 동이랗ㄴ 메소드를 호출해서
        * 작업할 수 있다*/

        ll.add("A");
        ll.add("B");
        ll.add("C");

        System.out.println(ll.size());

        //저장 순서 유지, 중복 허용을 확인
        for(int i = 0; i < ll.size(); i++){

            System.out.println(ll.get(i));
        }
        Iterator<String> it = ll.iterator();
        while(it.hasNext()){
            System.out.println(it .next());
        }

        /*LInkedList는 ArrayList와 내부적인 구현 방식이 다르므로
        * 수정 삭제가 빈번한 상황에서는 LinkedLIst를 사용하는 것이 효율적이다
        * ~first ~last 접미어를 붙여 순차적 기능을 강조한 함수들이 LinkedList에는 추가적으로 정의 되어 있다*/

        ((LinkedList) ll).addFirst("world");
        System.out.println(ll);

        ((LinkedList) ll).removeFirst();
        System.out.println(ll);
        System.out.println(ll.isEmpty());
        ll.clear();
        System.out.println(ll.isEmpty());
    }

}
