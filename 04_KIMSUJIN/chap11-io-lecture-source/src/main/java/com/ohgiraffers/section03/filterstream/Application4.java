package com.ohgiraffers.section03.filterstream;

import com.ohgiraffers.section03.filterstream.dto.MemberDto;

import java.io.*;

public class Application4 {

    public static void main(String[] args) {

        //객체 단위로 입출력을 하기 위한 ObjectInputStream/ObjectOutputStream 확인
        MemberDto[] outputMembers = {
                new MemberDto("user01", "pass01", "홍길동", "hong345@hihi.com", 25, '남', 1250.7),
                new MemberDto("user02", "pass02", "유관순", "you@hihi.com", 25, '남', 1250.7),
                new MemberDto("user03", "pass03", "이순신", "lee@hihi.com", 25, '남', 1250.7),
        };

        ObjectOutputStream objOut = null;

        try {
//            objOut = new ObjectOutputStream(
//                    new BufferedOutputStream(
//                            new FileOutputStream("src/main/java/com/ohgiraffers/section03/filterstream/testObjectStream.txt")));

            boolean exists = new File("src/main/java/com/ohgiraffers/section03/filterstream/testObjectStream.txt").exists();
            System.out.println("exists: " + exists);

            if(exists){
                //파일이 있을 경우
                objOut = new MyOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("src/main/java/com/ohgiraffers/section03/filterstream/testObjectStream.txt")));
            }else {
                // 파일이 없을 경우
                objOut = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("src/main/java/com/ohgiraffers/section03/filterstream/testObjectStream.txt")));
            }


            for(int i = 0; i < outputMembers.length; i++) {
                objOut.writeObject(outputMembers[i]);
                objOut.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("===================");
        MemberDto[] inputMembers = new MemberDto[3];

        ObjectInputStream objin = null;

        try {
            objin = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("src/main/java/com/ohgiraffers/section03/filterstream/testObjectStream.txt")));

            while (true) {
                System.out.println(objin.readObject());
            }

        } catch (EOFException e) {
            System.out.println("끝");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (objin != null) {
                try {
                    objin.close();
                } catch (IOException e) {}
            }
        }

    }
}
