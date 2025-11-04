package com.lhw.section02.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application2 {

    public static void main(String[] args) {

        File path = new File("src/main/java/com/lhw/section02/stream/testReader.txt");
        try (FileReader fr = new FileReader(path);) {
//            int value;
//            while ((value = fr.read()) != -1) {
//
//                System.out.print((char) value);
//            }
            int size = (int) new File("src/main/java/com/lhw/section02/stream/testReader.txt").length();
            System.out.println("size = " + size);
            // char 단위로 받아오는 buffer : 문자기반 : 한글읽기
            char[] buffer = new char[size];
            fr.read(buffer);
            for  (int i = 0; i < buffer.length; i++) {
                System.out.print(buffer[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
