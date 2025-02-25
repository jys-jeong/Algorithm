/**
 * 아이디어 : 완전 탐색을 이용해서 모든 경우를 구함
 * 시간 : 228 ms
 * 메모리 : 23384 kb
 * 난이도 : 하 (완전탐색을 배우고 나서 풀어보니 쉽게 풀 수 있었습니다.)
 */

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;                // N과 M
    static int [] p;                // 순열을 만드는데 사용될 숫자들
    static int [] nums;             // 순열을 저장할 변수
    static boolean [] visited;      // 방문 여부를 체크할 변수
    static StringBuilder result;    // 결과를 저장할 변수

    // 순열 함수
    static void permutation(int depth) {
        // 모든 자리수의 숫자를 결정하여 순열을 만들었으면
        if (depth == M) {
            // 결과에 순열 추가
            for (int num : nums) {
                result.append(num).append(" ");
            }
            result.append("\n");

            // 함수 리턴
            return;
        }

        // 반복문을 돌며 순열에 들어갈 숫자를 한자리씩 결정
        for (int i = 0; i < N; i++) {
            // 이미 뽑은 숫자이면 pass
            if (visited[i]) continue;

            // 해당 숫자를 뽑았다고 체크
            visited[i] = true;
            // 순열을 저장할 배열에 현재 인덱스의 숫자를 대입
            nums[depth] = p[i];

            // 재귀를 돌며 완전 탐색 방식으로 순열을 구함
            permutation(depth + 1);

            // 재귀 호출 종료 후 원복
            nums[depth] = 0;
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // N을 입력받음
        M = Integer.parseInt(st.nextToken());   // M을 입력받음

        p = new int[N]; // 순열 생성에 사용될 숫자들을 저장할 배열

        // 순열 생성에 사용될 숫자들을 생성
        for (int i = 1; i <= N; i++) {
            p[i-1] = i;
        }

        nums = new int[M];              // 순열 저장에 사용할 변수 초기화
        visited = new boolean[N];       // 방문 여부를 체크할 변수 초기화
        result = new StringBuilder();   // 결과를 저장할 변수 초기화

        permutation(0); // 순열 구하기

        System.out.println(result); // 결과 출력
    }
}