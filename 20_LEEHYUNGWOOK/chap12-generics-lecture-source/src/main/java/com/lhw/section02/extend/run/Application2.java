package com.lhw.section02.extend.run;

import com.lhw.section02.extend.*;

public class Application2 {

    public static void main(String[] args) {

        WildCardFarm wildCardFarm = new WildCardFarm();

        //농장 생성 자체가 불가능한 것은 매개변수로 사용할 수 없다.
//        wildCardFarm.anyType(new RabbitFarm<Mammal>(new Mammal()));
//        wildCardFarm.anyType(new RabbitFarm<Reptile>(new Reptile()));

        // <방법 1>
        RabbitFarm<Rabbit> rabbitFarm1 = new RabbitFarm<>();
        rabbitFarm1.setAnimal(new Rabbit());
        wildCardFarm.anyType(rabbitFarm1);
        // rabbitFarm을 생성하고 넣어줌
        // <방법 2>
        wildCardFarm.anyType(new RabbitFarm<Bunny>(new Bunny()));
        //생성할 때 매개변수 생성자로 객체생성해줌
        // 방법 1과 2는 동일하다.
        wildCardFarm.anyType(rabbitFarm1);
        wildCardFarm.anyType(new RabbitFarm<Bunny>(new Bunny()));
        wildCardFarm.anyType(new RabbitFarm<DrunkBunny>(new DrunkBunny()));

        // Extends type -> Bunny 제한자.
        // extendsType 메소드에는 Rabbit으로 생성할 수 없다.
//        wildCardFarm.extendsType(new RabbitFarm<Rabbit>(new Rabbit()));
        // 따라서 Bunny와 DrunkBuny가 상한선이다.
        wildCardFarm.extendsType((new RabbitFarm<Bunny>(new Bunny())));
        wildCardFarm.extendsType((new RabbitFarm<DrunkBunny>(new DrunkBunny())));

        // 아래는 superType 메소드. <? super Bunny> 로 들어갔다. 따라서, Bunny 하한선으로 접근제한한다.
        wildCardFarm.superType(new RabbitFarm<Rabbit>(new Rabbit()));
        wildCardFarm.superType((new RabbitFarm<Bunny>(new Bunny())));
        // Bunny 하한선이므로 DrunkBunny는 사용하지 못한다.
//        wildCardFarm.superType((new RabbitFarm<DrunkBunny>(new DrunkBunny())));
    }
}
