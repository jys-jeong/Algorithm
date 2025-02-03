/**
 * 아이디어 : 기본 기능은 N과 M(1)과 동일하게 구현하지만, result에 순열을 추가할 때 오름차순인 경우에만 추가합니다.
 * 시간 : 120 ms
 * 메모리 : 15760 KB
 * 난이도 : 중 (이전 문제와 유사해서 무난하게 알고리즘을 생각해낼 수 있었습니다.)
 */

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;    // N과 M
    static boolean[] visited;   // 방문 여부를 나타낼 배열
    static StringBuilder result = new StringBuilder();  // 결과를 저장할 변수

    // DFS 탐색을 하며 순열을 찾는 함수
    public static void dfs(int depth, int[] current) {
        // 주어진 길이의 순열을 만들었으면
        if (depth == M) {
            boolean asc = true; // 오름차순 여부를 체크할 변수
            int prev = 0;       // 오름차순 체크를 위해 이전 값을 저장할 변수

            // 이전값과 현재값을 비교하여 오름차순 여부를 판단
            for (int i = 0; i < M; i++) {
                if (prev > current[i]) {
                    asc = false;
                    break;
                }

                prev = current[i];
            }

            // 순열이 오름차순인 경우에만 result에 순열을 추가
            if (asc) {
                for (int i = 0; i < M; i++) {
                    result.append(current[i]).append(" ");
                }
                result.append("\n");
            }

            return; // 함수 종료
        }

        // 아니면
        for (int i = 1; i <= N; i++) {
            // 동일한 숫자가 두번 들어오는 것을 막기위해 visited 배열로 방문 여부 체크
            if (!visited[i]) {              // 방문하지 않은 숫자이면
                visited[i] = true;          // 방문 여부를 true로 세팅
                current[depth] = i;         // 순열에 현재값을 추가
                dfs(depth + 1, current);    // dfs로 추가 탐색
                visited[i] = false;         // 방문 여무 false로 세팅
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // N을 입력받음
        M = Integer.parseInt(st.nextToken());   // M을 입력받음

        // 가지치기
        // N과 M이 같으면 그냥 순서대로 출력해주고 종료
        if (N == M) {
            for (int i = 1; i <= N; i++)
                System.out.print(i + " ");
            return;
        }

        visited = new boolean[N + 1];   // 방문 여부를 체크할 배열
        dfs(0, new int[M]); // dfs 함수를 호출하여 순열을 구함

        System.out.print(result);   // 결과 출력
    }
}
