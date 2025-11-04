package com.ohgiraffers.io.member;

import java.io.*;

public class MemberManager {

    Member[] members = new Member[10];

    public void readMembers() {
        int count = 0;


        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/main/java/com/ohgiraffers/io/member/members.ser")));){
            while(true) {
                members[count] = (Member) ois.readObject();
                count++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            for ( int i = 0; i < count; i++ ) {
                System.out.println(members[i].toString());
            }
            System.out.println("======================================");
        }

    }

    public void addMember(Member member) {
        int count = 0;

        //읽어오기
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/main/java/com/ohgiraffers/io/member/members.ser")));){
            while(true) {
                members[count] = (Member) ois.readObject();
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if ( members[0] == null ) {
            members[0] = member;
            count++;
        } else {
            members[count] = member;
            count++;
        }
        // 쓰기
        try (ObjectOutputStream objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/main/java/com/ohgiraffers/io/member/members.ser")));) {
                for ( int i = 0 ; i < count; i++) {
                    objOut.writeObject(members[i]);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


}
