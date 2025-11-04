package com.lhw.section02.extend;


//public class RabbitFarm<T implements Animal> { 이렇게는 안된다.(implement)
//public class RabbitFarm<T extends Animal> {
public class RabbitFarm<T extends Rabbit> {
//public class RabbitFarm<T extends Rabbit & Animal> {

//public class RabbitFarm<T extends Rabbit , Reptile> {
    //field

    private T animal;
    //constructor
    public RabbitFarm(){}
    public RabbitFarm(T animal){
        this.animal = animal;
    }

    //getter
    public T getAnimal() {
        return animal;
    }
    //setter
    public void setAnimal(T animal) {
        this.animal = animal;
    }
}
