package com.lhw.section03.filterstream;

import com.lhw.section03.filterstream.dto.MemberDto;

import java.io.*;

public class Application4 {
    public static void main(String[] args) {
        // 객체 단위 입출력을 하기 위한 ObjectInput/OutputStream을 확인하는 내용이다.
        /* Write 입력하기*/
        MemberDto[] outputMembers = {
                new MemberDto("user01", "pass01", "홍길동", "hang345@lhw.com", 25, '남', 1250.7),
                new MemberDto("user02", "pass02", "유관순", "korea345@lhw.com", 16, '여', 2000),
                new MemberDto("user03", "pass03", "이순신", "soonshin345@lhw.com", 35, '남', 3125.3)
        };

        ObjectOutputStream objOut = null;

        try { //기존에 덮어쓰기할 때 발생하는 오류를 잡기 위해 아래처럼 예외처리한다.
//            objOut = new ObjectOutputStream(
//                    new BufferedOutputStream(
//                            new FileOutputStream("src/main/java/com/lhw/section03/filterstream/testObjectStream.txt")
//                    ));
            // 먼저 해당 경로에 파일이 존재하는지 확인한다.
            boolean exists = new File("src/main/java/com/lhw/section03/filterstream/testObjectStream.txt").exists();

            if (exists) {
                //파일이 있을 경우
                objOut = new MyOutputStream( // 재정의한 메소드를 담은 클래스 객체를 생성한다.
                        // 위 클래스는 헤더값을 추가하는 기능을 삭제한 클래스이다. 따라서, 만약 파일이 있을경우
                        // 더 이상 헤더를 추가하지 않고(기존 ObjectOutputStream에선 헤더 매번 추가함),
                        // 내용만 추가하는 것이다.
                        new BufferedOutputStream(
                                new FileOutputStream("src/main/java/com/lhw/section03/filterstream/testObjectStream.txt")
                        ));
            } else {
                //파일이 없을 경우
                objOut = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("src/main/java/com/lhw/section03/filterstream/testObjectStream.txt")
                        ));
            }

            for (int i = 0; i < outputMembers.length; i++) { //멤버객체배열의 크기만큼 for문
                objOut.writeObject(outputMembers[i]); //객체 단위의 Write
            }
            objOut.flush(); //버퍼가 안차도 나가고 close() 안해도 나간다.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*읽어오기(Read)*/
        System.out.println("=====================================");
        MemberDto[] inputMembers = new MemberDto[3];

        ObjectInputStream objIn = null;
        try {
            objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(
                    "src/main/java/com/lhw/section03/filterstream/testObjectStream.txt"
            )));
            while (true) {
                System.out.println(objIn.readObject()); //그냥 read x readObject O
            }
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (objIn != null) {
                try {
                    objIn.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }



}
