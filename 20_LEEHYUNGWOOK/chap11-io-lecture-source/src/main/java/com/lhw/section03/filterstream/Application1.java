package com.lhw.section03.filterstream;

import java.io.*;

public class Application1 {

    public static void main(String[] args) {

        BufferedWriter bw = null;

        // BufferedWriter는 혼자서 안쓰기고, 매개변수로 FileWriter을 받아서 사용해야만한다.
        // BufferedWriter의 상속 클래스들을 확인해보면, Writer 클래스를 상속받는 것을 확인할 수 있다.
        // Writer 클래스에 포함된 녀석이면 되니, FileWriter도 매개변수로 사용가능하다.
        // 이렇게 혼자서 사용되지 못하고, fileWriter의 도움을 받아서 작성되는 것을 보조스트림이라고 한다.
        try {
            bw = new BufferedWriter(new FileWriter("src/main/java/com/lhw/section03/filterstream/testBuffered.txt")); //생성자를 통해 인스턴스 생성

            bw.write("안녕하세요\n");
            bw.write("반갑습니다.\n");

            //bw.flush();//강제로 버퍼 공간을 비운다.-> bw.close()에 bw.flush()가 있다.
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        }
        /*=====================================*/
        // FileReader로 읽어오기
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("src/main/java/com/lhw/section03/filterstream/testBuffered.txt"));

            String temp;
            while( (temp = br.readLine()) != null) {
                System.out.println(temp);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
