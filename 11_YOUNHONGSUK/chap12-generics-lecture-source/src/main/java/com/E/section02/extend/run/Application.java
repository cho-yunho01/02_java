package com.E.section02.extend.run;

import com.E.section02.extend.*;

public class Application {

    public static void main(String[] args) {
//
//        RabbitFarm<Rabbit> rf = new RabbitFarm<>();
//        rf.setAnimal(new Rabbit());
//        System.out.println(rf.getAnimal());
//        rf.setAnimal(new Rabbit());
//        System.out.println(rf.getAnimal());
//        rf.setAnimal(new DrukenBunny());
//        System.out.println(rf.getAnimal());
//        rf.getAnimal().cry();

//        RabbitFarm<Animal> f1 = new RabbitFarm<>();
//        RabbitFarm<Mammal> f2 = new RabbitFarm<Mammal>();
        //RabbitFarm<Snake> f3 = new RabbitFarm<Snake>();

//        RabbitFarm<Rabbit,Reptile>f4 = new RabbitFarm<>();
//        RabbitFarm<Bunny> f5 = new RabbitFarm<>();
//        RabbitFarm<DrunkBunny> f6 = new RabbitFarm<>();
//
//        f4.setAnimal(new Rabbit());
//        ((Rabbit)f4.getAnimal()).cry();
//        f4.getAnimal().cry();
//
//        f5.setAnimal(new Bunny());
//        ((Bunny)f5.getAnimal()).cry();
//        f5.getAnimal().cry();
//
//        f6.setAnimal(new DrunkBunny());
//        ((DrunkBunny)f6.getAnimal()).cry();
//        f6.getAnimal().cry();

        /*extends 키워드를 이용하여 특정 타입만 사용하도록 제러릭 범위를 제한할 수 있다*/

        WildCardFarm wcf = new WildCardFarm();

        /*농장 생성 자체가 불가능한 것은 매개변수로 사용 할 수 없다*/

        RabbitFarm<Rabbit> rf1 = new  RabbitFarm<>();
        rf1.setAnimal(new Rabbit());
        wcf.anyType((rf1));
        wcf.anyType(new RabbitFarm<Bunny>(new Bunny()));

//        wcf.extendsType(new RabbitFarm<Rabbit>(new Rabbit()));
        wcf.extendsType(new RabbitFarm<Bunny>(new Bunny()));
        wcf.extendsType(new RabbitFarm<DrunkBunny>(new DrunkBunny()));
     
        wcf.superType(new RabbitFarm<Rabbit>(new Rabbit()));
        wcf.superType(new RabbitFarm<Bunny>(new Bunny()));
//        wcf.superType(new RabbitFarm<DrunkBunny>(new DrunkBunny()));
    }

}
