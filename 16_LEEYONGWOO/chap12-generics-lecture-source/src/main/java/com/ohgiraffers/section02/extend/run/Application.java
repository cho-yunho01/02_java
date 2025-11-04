package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.*;

public class Application {
    public static void main(String[] args) {
//        RabbitFarm<Rabbit> rabbitFarm = new RabbitFarm<>();
//
//        rabbitFarm.setAnimal(new Rabbit());
//        rabbitFarm.getAnimal().cry();
//
//        rabbitFarm.setAnimal(new Bunny());
//        rabbitFarm.getAnimal().cry();
//
//        rabbitFarm.setAnimal(new DrunkBunny());
//        rabbitFarm.getAnimal().cry();
        /*extends키워드를 이용하여 특정 타입만 사용하도록 제네릭 범위를 제한할 수 있다.*/
       //안됨 RabbitFarm<Animal> farm1=new RabbitFarm<Animal>();
       //안됨  RabbitFarm<Mammal>farm1=new RabbitFarm<Mammal>();
       //안됨 RabbitFarm<Snake>farm1=new RabbitFarm<Snake>();
        RabbitFarm<Rabbit>farm4=new RabbitFarm<>();
        RabbitFarm<Bunny>farm5=new RabbitFarm<>();
        RabbitFarm<DrunkBunny>farm6=new RabbitFarm<>();

        farm4.setAnimal(new Rabbit());
        farm4.getAnimal().cry();
        farm4.getAnimal().cry();

        farm5.setAnimal(new Bunny());
        farm5.getAnimal().cry();
        farm5.getAnimal().cry();

        farm6.setAnimal(new DrunkBunny());
        farm6.getAnimal().cry();
        farm6.getAnimal().cry();

    }
}
