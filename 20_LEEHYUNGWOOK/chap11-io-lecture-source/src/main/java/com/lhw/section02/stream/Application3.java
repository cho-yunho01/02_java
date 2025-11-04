package com.lhw.section02.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application3 {

    public static void main(String[] args) {

        /*
        * FileOutputStream
        * Write는 파일이 없어도 새로 생성해준다.
        * */
        FileOutputStream fout = null;

        try {

            /*
            - OutputStream의 경우 대상 파일이 존재하지 않으면 파일을 자동으로 생성해준다.
            - 두 번째 인자를 true를 전달하면 이어쓰기가 된다.
            - false는 이어쓰기가 아닌 덮어쓰기이며 기본값은 false이다*/
            fout = new FileOutputStream("src/main/java/com/lhw/section02/stream/testOutputStream.txt", false/*(이어붙이기여부)*/);
            fout.write(97);


            byte[] barr = new byte[]{98,99,100,101,102,10,103};
            fout.write(barr);
            fout.write(barr, 1, 3);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
