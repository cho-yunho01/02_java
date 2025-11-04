package com.ohgiraffers.io.member;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MemberManager {
    private int count = 0;
    private Member[] members;

    public void readMembers() {
        count = 0;
        ObjectInputStream ois = null;

        boolean exists = new File("src/main/java/com/ohgiraffers/io/member/members.ser").exists();
        if (exists) {
            try {
                ois = new ObjectInputStream(
                        new java.io.FileInputStream("src/main/java/com/ohgiraffers/io/member/members.ser"));

                while (true) {
                    Member member = (Member) ois.readObject();
                    System.out.println(member.toString());
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void addMember(Member m) {
        Member[] newMembers = new Member[count + 1];

        for (int i = 0; i < count; i++) {
            newMembers[i] = members[i];
        }
        newMembers[count] = m;
        members = newMembers;
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/main/java/com/ohgiraffers/io/member/members.ser", true));
            oos.writeObject(members);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try { oos.close(); } catch (Exception ignored) {}
            }
        }
    }
}