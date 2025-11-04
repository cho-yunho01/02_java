package chap12_generics.section02.extent.run;

import chap12_generics.section02.extent.Animal;
import chap12_generics.section02.extent.Bunny;
import chap12_generics.section02.extent.Rabbit;
import chap12_generics.section02.extent.RabbitFarm;

public class Application {
    public static void main(String[] args) {
        RabbitFarm<Rabbit> farm = new RabbitFarm<>();
        farm.setAnimal(new Bunny());
        farm.getAnimal().cry();

    }
}
