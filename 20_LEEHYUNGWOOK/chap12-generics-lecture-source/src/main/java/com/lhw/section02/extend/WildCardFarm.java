package com.lhw.section02.extend;

public class WildCardFarm {

    /*매개변수로 전달받은 토끼농장을 구현할 때 사용한 타입 변수에 대해서 제한을 할 수 있다.*/

    /*제네릭 클래스 타입의 객체를 메소드의 매개변수로 받을 때, 그 객체의 타입변수를 제한할 수 있다.
    * <?>: 모든 타입을 허용하는 와일드 카드
    * <? extends T>: T 타입 또는 T의 하위 타입을 허용하는 와일드 카드
    * <? super T>: T 타입 또는 T의 상위 타입을 허용하는 와일드 카드#
    * */

    public void anyType(RabbitFarm<?> farm) {
        farm.getAnimal().cry();
    }

    public void extendsType(RabbitFarm<? extends Bunny> farm) {
        farm.getAnimal().cry();
    }

    public void superType(RabbitFarm<? super Bunny> farm) {
        farm.getAnimal().cry();
    }
}
