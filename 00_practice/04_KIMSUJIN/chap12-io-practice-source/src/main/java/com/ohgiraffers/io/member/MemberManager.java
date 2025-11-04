package com.ohgiraffers.io.member;

import java.io.*;

public class MemberManager {

    private Member[] members;

    public void readMembers(){
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("src/main/java/com/ohgiraffers/io/member/members.ser")));

//            while (true) {
//                System.out.println(ois.readObject());
//            }

            while(true){
                Object obj = ois.readObject();
                members = (Member[]) obj;
            }

        }catch (EOFException e) {
            for (Member member : members) {
                System.out.println(member);
            }
            System.out.println("읽기 완료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {}
            }
        }
    }

//    public void addMember(Member member){
//
//        ObjectOutputStream oos = null;
//
//        try {
//            oos = new ObjectOutputStream(
//                    new BufferedOutputStream(
//                            new FileOutputStream("src/main/java/com/ohgiraffers/io/member/members.ser")));
//
//                oos.writeObject(member);
//                oos.flush();
//            } catch (FileNotFoundException ex) {
//            throw new RuntimeException(ex);
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//
//    }

    }

