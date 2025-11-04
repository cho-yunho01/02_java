package com.ohgiraffers.io.member;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MemberManager {
    private Member[] members;

    public void readMembers() {
        ObjectInputStream ois = null;

        boolean exists = new File("src/main/java/com/ohgiraffers/io/member/members.ser").exists();
        if (exists) {
            try {
                ois = new ObjectInputStream(
                        new java.io.FileInputStream("src/main/java/com/ohgiraffers/io/member/members.ser"));
                members = (Member[]) ois.readObject();
                for (Member member : members) {
                    System.out.println(member);
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
        int oldLen = (members == null) ? 0 : members.length;
        Member[] newMembers = new Member[oldLen + 1];

        for (int i = 0; i < oldLen; i++) {
            newMembers[i] = members[i];
        }
        newMembers[oldLen] = m;
        members = newMembers;
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/main/java/com/ohgiraffers/io/member/members.ser"));
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