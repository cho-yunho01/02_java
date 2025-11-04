package com.ohgiraffers.exception.charcheck;

public class CharacterProcess {
    public int countAlpha(String s) throws CharCheckException {
        //유니코드로 A~z 사이에 있는지 확인
        String str = s.toLowerCase();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' ) {
                count++;
            }else{
                throw new CharCheckException("체크할 문자열 안에 공백 포함할 수 없습니다.");
            }
        }
        return count;
    }


}
