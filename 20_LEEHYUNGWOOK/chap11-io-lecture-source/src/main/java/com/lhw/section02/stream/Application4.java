package com.lhw.section02.stream;

import java.io.FileWriter;
import java.io.IOException;

public class Application4 {

    public static void main(String[] args) {

        FileWriter fw = null;

        try {
            fw = new FileWriter("src/main/java/com/lhw/section02/stream/testWriter.txt");

            fw.write(97);
            fw.write('A');
            fw.write(new char[]{'a','p','p','l','e'});
            fw.write("한글 한글한글");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
