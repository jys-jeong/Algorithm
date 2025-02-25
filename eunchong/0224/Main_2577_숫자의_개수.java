/*
 * 아이디어 : 숫자를 문자열로 변환하고 반복문을 돌며 빈도 측정
 * 시간 : 108 ms
 * 메모리 : 14224 kb
 * 난이도 : 하
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());    // A를 입력받음
        int B = Integer.parseInt(br.readLine());    // B를 입력받음
        int C = Integer.parseInt(br.readLine());    // C를 입력받음

        int R = A * B * C;          // A * B * C를 R에 대입
        String sR = R + "";         // R을 문자열로 변환하여 대입
        int [] nums = new int[10];  // 빈도 측정을 위한 배열 선언

        // 숫자빈도 측정
        for (char c: sR.toCharArray()) {
            int n = c - '0';    // 숫자 - '0' 을 하면 해당 인덱스가 나옴
            nums[n]++;
        }

        // 숫자 빈도 출력
        for (int n: nums) {
            System.out.println(n);
        }
    }
}