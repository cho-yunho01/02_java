package com.lhw.section01.generic;

public class GenericTest<T> {

    private T value; //타입변수

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }


}
