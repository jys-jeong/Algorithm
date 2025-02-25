/**
 * 아이디어 : 반복문을 돌면서 개수를 셈
 * 시간 : 104 ms
 * 메모리 : 14284 kb
 * 난이도 : 하
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 숫자의 개수를 입력받음
        int [] numbers = new int[N];                // 입력받은 수를 저장할 배열 초기화

        StringTokenizer st = new StringTokenizer(br.readLine());    // 숫자들을 입력받음
        for (int i = 0; i < N; i++) {
            // 입력받은 숫자들로 배열 초기화
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());   // target 수를 입력받음

        int count = 0;  // target이 입력받은 숫자에 몇개 들어 있는지 셀 변수

        // 입력받은 숫자들에 target이 몇개 있는지 셈
        for (int n: numbers) {
            if (n == target) {
                count++;
            }
        }

        System.out.println(count);  // 결과 출력
    }
}
