package com.hihi.section04.wrapper;

public class Application2 {

    public static void main(String[] args) {

        // parsing: 문자열(String) 값을 기본자료형 값으로 변경하는 것을 parsing이라고 한다.
        byte b = Byte.parseByte("1");
        short s = Short.parseShort("2");
        int i = Integer.parseInt("4");      // <===얘는 꼭기억
        long l = Long.parseLong("8");       //8L, 8l 따위의 것은 안됨.
        float f = Float.parseFloat("3.14f");    //float는 f됨.
        double d = Double.parseDouble("8.0");
        boolean bool = Boolean.parseBoolean("true");

        char c = "abc".charAt(0);

    }
}
