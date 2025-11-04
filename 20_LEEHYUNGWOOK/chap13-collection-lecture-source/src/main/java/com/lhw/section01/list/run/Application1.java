package com.lhw.section01.list.run;

import java.util.*;

public class Application1 {

    public static void main(String[] args) {
        /*자바에서 컬렉션 프레임워크는 여러 개의 다양한 데이터들을
        쉽고 효과적으로 처리할 수 있도록 표준화된 방법을 제공하는
        클래스들의 집합을 의미한다. 즉, 데이터는 효율적으로 저장하는
        자료구조와 데이터를 처리하는 알고리즘을 미리 구현해 놓은 클래스를 말한다.*/


        /*
        * - ArrayList는 인스턴스를 생성하게 되면 내부적으로 10칸짜리 배열을 생성해서 관리한다.
          - 배열의 단점을 보완하기 위해 만들어졌기 때문에 크기 변경, 요소 추가/삭제/정렬 기능들을 메소드로
            * 제공하고 있다.
          - 자동적으로 수행되는 것이지 속도가 빨라지는 것은 아니다.
          - ArrayList는 스레드간 동기화가 지원되지 않는다. 따라서
            * 다수의 스레드가 동시에 접근하여 데이터를 조작하게 될 경우 데이터 훼손이 일어날 수 있다.
          - ArrayList는 인덱스로 데이터에 접근할 수 있기 때문에 조회 기능적으로 뛰어나다.*/
        // ArrayList 기본생성자로 생성
        ArrayList alist = new ArrayList();
        List list = new ArrayList();

//        list = new LinkedList();
        Collection clist = new ArrayList(); // 다형성 -> 클래스 바꿀 때 용이함

        alist.add("hello");
        System.out.println(alist);
        alist.add(1);
        System.out.println(alist);
        System.out.println(alist.size());
        /*
        * arrayList의 크기는 size() 로 확인 -> size() 는 요소 갯수 반환함.*/
        for (int i = 0; i < alist.size(); i++) {
            System.out.println(alist.get(i));
        }
        alist.add("apple");
        System.out.println("alist = " + alist);
        alist.add(0, "orange");
        System.out.println("alist = " + alist);
        alist.remove(0);
        System.out.println("alist = " + alist);
        alist.set(0, "hello world");
        System.out.println("alist  = " + alist);

        List<String> stringList = new ArrayList();
        stringList.add("apple");
        stringList.add("orange");
        stringList.add("banana");
        stringList.add("mango");
        stringList.add("grape");

        System.out.println("stringList = " + stringList);

        Collections.sort(stringList); //매개변수로 List<T> 를 받아온다.
        System.out.println("stringList = " + stringList);

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(215);
        intList.add(33);
        intList.add(54);
        intList.add(5);
        intList.add(655);
        System.out.println("intList = " + intList);
        Collections.sort(intList);
        System.out.println("intList = " + intList);

        /*
         * Iterator란?
         * Collection 인터페이스의 iterator() 메소드를 이용해서 인스턴스를 생성할 수 있다.
         * 컬렉션에서 값을 읽어오는 방식을 통일된 방식으로 제공하기 위해 사용한다.
         * 반복자라고 불리우며, 반복문을 이용해서 목록을 하나씩 꺼내는 방식으로 사용하기 위함이다.
         *
         * 인덱스로 관리되는 컬렉션이 아닌 경우에는 반복문을 사용해서 요소에 하나씩 접근할 수 없기 때문에
         * 인덱스를 사용하지 않고도 반복문을 사용하기 위한 목록을 만들어주는 역할이라고 보면된다.
         *
         * hasNext() : 다음 요소를 가지고 있는 경우 true, 더이상 요소가 없는 경우 false를 반환
         * next() : 다음 요소를 반환
         * */

        stringList = new LinkedList<>(stringList);
        //Linkedlist 변환 : ArrayList 형변환.
        Iterator<String> dIter = ((LinkedList<String>) stringList).descendingIterator();
//        while(dIter.hasNext()){
//            System.out.println(dIter.next());
//        } //저장이 안되고 출력만 됨.

        // 내림차순 ArrayList를 새로 생성한다.
        List<String> descList = new ArrayList<>();
        while (dIter.hasNext()) {
            descList.add(dIter.next());
        }
        System.out.println("descList = " + descList);
    }
}
