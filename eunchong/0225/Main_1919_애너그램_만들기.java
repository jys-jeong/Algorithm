/**
 * 아이디어 : 두 문자열의 공통되는 문자의 개수를 세고 각 문자열 길이에서 해당 개수를 뺀 값을 합하면 제거해야 할 문자 개수가 나옴
 * 시간 : 104 ms
 * 메모리 : 14160 kb
 * 난이도 : 하
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] word = br.readLine().toCharArray();     // 첫번째 문자열을 입력받음
        char [] word2 = br.readLine().toCharArray();    // 두번째 문자열을 입력받음

        // 문자열을 정렬
        Arrays.sort(word);
        Arrays.sort(word2);

        // 빈도 측정을 위한 변수
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // 각 단어의 알파벳 빈도 측정
        for (char c : word) {
            freq1[c - 'a']++;
        }

        // 각 단어의 알파벳 빈도 측정
        for (char c : word2) {
            freq2[c - 'a']++;
        }

        int count = 0;  // 두 문자열에서 겹치는 알파벳 개수를 셀 변수

        // 두 문자열의 알파벳 빈도를 비교하여 공통되는 알파벳 개수를 셈
        for (int i = 0; i < 26; i++) {
            count += Math.min(freq1[i], freq2[i]);
        }

        // 두 문자열의 길이에서 공통된 알파벳 개수를 각각 뺀 수를 더한 값이 제거해야할 문자 개수
        int a = (word.length - count);
        int b = (word2.length - count);

        System.out.println(a + b); // 결과 출력
    }
}
