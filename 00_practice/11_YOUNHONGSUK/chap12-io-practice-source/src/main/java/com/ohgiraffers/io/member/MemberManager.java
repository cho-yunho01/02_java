package com.ohgiraffers.io.member;

import java.io.*;

public class MemberManager {

    String path = "src/main/java/com/ohgiraffers/io/member/members.ser";
    Member[] inputMembers = null;
    public void readMembers() {

        ObjectInputStream objIn = null;

        try {
            objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));

            while (true){
                Object obj = objIn.readObject();
                inputMembers = (Member[]) obj;
            }

        } catch (EOFException e) {

            for (Member member : inputMembers) {
                System.out.println(member);
            }
            System.out.println("끝");
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

    public void addMember(Member member){
        ObjectOutputStream objOut = null;
        try {
            int count = 0;
            for(int i = 0; i <  inputMembers.length; i++){
                if(inputMembers[i] != null) count++;
            }

            inputMembers[count] = member;

            objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)));

            objOut.writeObject(inputMembers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (objOut != null) {
                try {
                    objOut.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
