package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.*;

import java.lang.reflect.Member;

public class Application2 {
    public static void main(String[] args) {
        WildCardFarm wildCardFarm = new WildCardFarm();

//        // 농장 생성 자체가 불가능한 것은 매개변수로 사용할 수 없다.
//        wildCardFarm.anyType(new RabbitFarm<Reptile>(new Reptile()));
//        wildCardFarm.anyType(new RabbitFarm<Mammal>(new Mammal()));

        //지금 Rabbit만 들어올 수 있음
        //1. 객체 만들고 set으로 바꾼거고
        RabbitFarm<Rabbit> rabbitFarm1 = new RabbitFarm<>();
        rabbitFarm1.setAnimal(new Rabbit());

        wildCardFarm.anyType(rabbitFarm1);

        //2. 생성하면서 객체를 만들거다.
        wildCardFarm.anyType(new RabbitFarm<Bunny>(new Bunny()));

        WildCardFarm.anyType(new RabbitFarm<DrunkBunny>(new DrunkBunny()));


        //extendsType은 지금 bunny까지만 제한을 걸어둠 따라서 안됨
        //wildCardFarm.extendsType(new RabbitFarm<Rabbit>(new Rabbit()));

        wildCardFarm.extendsType(new RabbitFarm<Bunny>(new Bunny()));
        wildCardFarm.extendsType(new RabbitFarm<DrunkBunny>(new DrunkBunny()));


        //하한의 제한을 걸어줌
        wildCardFarm.superType(new RabbitFarm<Rabbit>(new Rabbit()));
        wildCardFarm.superType(new RabbitFarm<Bunny>(new Bunny()));
       // wildCardFarm.superType(new RabbitFarm<DrunkBunny>(new DrunkBunny()));

    }
}
