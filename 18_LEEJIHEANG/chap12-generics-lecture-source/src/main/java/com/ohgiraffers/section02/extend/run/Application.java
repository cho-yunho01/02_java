package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.Bunny;
import com.ohgiraffers.section02.extend.DrunkenBunny;
import com.ohgiraffers.section02.extend.RabbitFarm;

public class Application {
    public static void main(String[] args) {

        RabbitFarm<Rabbit> rabbitFarm = new RabbitFarm<>();
        rabbitFarm.setAnimal(new Rabbit());
        rabbitFarm.
        rabbitFarm.setAnimal(new Bunny());
        rabbitFarm.setAnimal(new DrunkenBunny());

    }
}
