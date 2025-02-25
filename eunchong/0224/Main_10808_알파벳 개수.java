/**
 * 아이디어 : 알파벳 개수만큼의 배열을 만들고 알파벳 - 'a' 를 통해 해당 인덱스를 구해 증감연산으로 빈도를 측정
 * 시간 : 120 ms
 * 메모리 : 15892 kb
 * 난이도 : 하
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br. readLine();    // 숫자들을 입력받음
        int [] alpha = new int [26];    // 숫자 빈도 측정을 위한 배열 생성

        // 반복문을 돌며 빈도 측정
        for (char c: str.toCharArray()) {
            alpha[c-'a']++; // 알파벳 - 'a' 를 하게 되면 인덱스가 나옴
        }

        // 빈도 측정 결과 출력
        for (int n: alpha) {
            System.out.print(n + " ");
        }
    }
}