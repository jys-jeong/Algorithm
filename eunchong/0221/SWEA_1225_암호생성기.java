/**
 * 아이디어 : 큐 자료구조를 이용해서 문제의 사이클을 반복합니다. 이후 숫자가 감소해서 0이하가 되면 사이클을 종료하고 암호를 저장합니다.
 * 시간 : 92 ms
 * 메모리 : 26880 kb
 * 난이도 : 하 (문제를 보고 금방 아이디어가 떠올라서 쉽게 구현할 수 있었습니다.)
 */

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();     // 결과를 저장할 변수

        // 반복문을 돌며 10개의 테스트 케이스를 처리
        for (int i = 0; i < 10; i++) {
            // T를 입력받음
            int T = Integer.parseInt(br.readLine());
            // 암호문 제작에 사용될 8개의 숫자를 입력받음
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 암호문 제작에 사용할 큐를 생성
            ArrayDeque<Integer> que = new ArrayDeque<>();

            // 8개의 암호문에 사용될 수를 큐에 추가
            for (int j = 0;  j < 8; j++) {
                que.offer(Integer.parseInt(st.nextToken()));
            }

            // 사이클을 돌 때 숫자에서 1 ~ 5씩 돌아가면서 빼기 위해 count 변수 선언
            int count = 1;

            // 무한루프를 돌며 암호문 생성
            while(true) {
                int first = que.poll();     // 맨앞 숫자를 빼서 first 변수에 저장

                // 5의 배수가 아니면 %5를 했을 때 1~4 값이 그대로 나오는 것을 활용
                if (count % 5 > 0) {
                    first -= count % 5;
                }
                // 5의 배수이면 %5를 했을 때 0이 되기 때문에 5를 뺌
                else {
                    first -= 5;
                }

                count++;    // count 증가

                // 만약 count를 뺀 숫자가 0이하기 되면
                if (first <= 0) {
                    que.offer(0);   // 0을 암호문 맨뒤에 삽입하고
                    break;             // 암호문 제작을 위한 반복문 종료
                }

                que.offer(first);       // 아니면 그냥 first를 맨 뒤에 삽입
            }

            // 암호문 StringBuilder에 삽입
            sb.append("#").append(T).append(" ");
            while(!que.isEmpty())
                sb.append(que.poll()).append(" ");
            sb.append("\n");
        }

        // 암호문 출력
        System.out.println(sb);
    }
}