package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.*;

public class Application2 {
    static void main() {

        WildCardFarm wildCardFarm = new WildCardFarm();

        // 농장 생성 자체가 불가능한 것은 매개변수로 사용할 수 없다.
//        wildCardFarm.anyType(new RabbitFarm<Mammal>(new Mammal()));
//        wildCardFarm.anyType(new RabbitFarm<Reptile>(new Reptile()));

        RabbitFarm<Rabbit> rabbitFarm1 = new RabbitFarm<>();
        rabbitFarm1.setAnimal(new Rabbit());

        wildCardFarm.anyType(rabbitFarm1);
        wildCardFarm.anyType(new RabbitFarm<Bunny>(new Bunny()));
        wildCardFarm.anyType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

//        wildCardFarm.extendsType(new RabbitFarm<Rabbit>(new Rabbit)));
        wildCardFarm.extendsType(new RabbitFarm<Bunny>(new Bunny()));
//        wildCardFarm.extendsType(new RabbitFarm<DrunkenBunny>)(new DrunkenBunny()));

        wildCardFarm.superType(new RabbitFarm<Rabbit>(new Rabbit()));
        wildCardFarm.superType(new RabbitFarm<Bunny>(new Bunny()));
        // wildCardFarm.superType(new RabbitFarm<DrunkBunny>(new DrunkBunny)));

        // 제네릭타입의 일반화사용할 때 Type을 써주고 이 Type내용만 쓸거다 또는 extends, super같은 내용들은 매개변수일때 사용한다.
        //
    }
}
