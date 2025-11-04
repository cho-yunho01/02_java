package com.lhw.section02.extend.run;

import com.lhw.section02.extend.*;

public class Application {

    public static void main(String[] args) {

        /*RabbitFarm<Rabbit> rabbitFarm = new RabbitFarm<>();
        rabbitFarm.setAnimal(new Rabbit()); //Rabbit 객체 추가
        rabbitFarm.getAnimal().cry();
        rabbitFarm.setAnimal(new Bunny());  //Bunny 객체 추가
        rabbitFarm.getAnimal().cry();
        rabbitFarm.setAnimal(new DrunkBunny()); //DrunkBunny 객체 추가
        rabbitFarm.getAnimal().cry();*/
        // 동적바인딩이 일어나 각기 다른 타입의 객체들이 들어갈 수 있다.

        /*Extends 키워드를 이용하여 특정 타입만 사용하도록 제네릭 범위를 제한할 수 있다. */
//        RabbitFarm<Animal> farm1 = new RabbitFarm<>();
//        RabbitFarm<Mammal> farm2 = new RabbitFarm<>();
//        RabbitFarm<Snake> farm3 = new RabbitFarm<>();
        RabbitFarm<Rabbit>  farm4 = new RabbitFarm<>();
        RabbitFarm<Bunny>   farm5 = new RabbitFarm<>();
        RabbitFarm<DrunkBunny> farm6 =  new RabbitFarm<>();

        // 토끼의 후손이거나 토끼인 경우에만 토끼 농장의 타입으로 사용가능
        // 하도록 제네릭을 제한한 것이다.
        farm4.setAnimal(new Rabbit());
        ((Rabbit) farm4.getAnimal()).cry(); // 케스팅 꼭 안해도 됨
        farm4.getAnimal().cry(); // 요거랑 (Rabbit) 쓴거랑 똑같음.

        farm5.setAnimal(new Bunny());
        ((Bunny) farm5.getAnimal()).cry();
        farm5.getAnimal().cry();

        farm6.setAnimal(new DrunkBunny());
        ((DrunkBunny) farm6.getAnimal()).cry();
        farm6.getAnimal().cry();
    }
}
