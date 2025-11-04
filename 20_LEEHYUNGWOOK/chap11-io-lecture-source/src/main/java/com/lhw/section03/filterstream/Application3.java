package com.lhw.section03.filterstream;

import java.io.*;

public class Application3 {

    public static void main(String[] args) {
        // 외부 데이터로부터 byte,int,char,String읽어오기: parsing
        DataOutputStream dout = null;

        try {
            dout = new DataOutputStream(new FileOutputStream("src/main/java/com/lhw/section03/filterstream/score.txt"));

            //write를 타입 지정하여 작성한다.
            dout.writeUTF("홍길동"); //문자열 UTF
            dout.writeInt(95);       //숫자나 문자는 각각 Int,Char
            dout.writeChar('A');
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                dout.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /*===================================================
        * Data(데이터타입이 정해진 파일) 읽어오기*/
        DataInputStream din = null;

        try {
            din = new DataInputStream(new FileInputStream("src/main/java/com/lhw/section03/filterstream/score.txt"));

            while (true) { //몇 개가 올지 모르니, true를 걸어 반복문을 돌린다.
                //파일에 기록된 순서대로 읽어와야 한다.
                System.out.println(din.readUTF()+","+din.readInt()+","+din.readChar()); //읽어올 때도 readUTF로 한다.
                // 아래처럼, 파싱 순서가 맞지 않으면 아예 불러와지지 않는다.
                //System.out.println(+din.readInt()+","+din.readUTF()+","+din.readChar()); //읽어올 때도 readUTF로 한다.
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException e) {
            System.out.println("파일 읽기 완료!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                din.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
