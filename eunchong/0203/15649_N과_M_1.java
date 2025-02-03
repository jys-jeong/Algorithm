/**
 * 아이디어 : 트리 형태로 탐색하며 순열을 만드는데, 동일한 숫자가 두개 들어가는 것을 막기 위해 visited 배열을 만들어서 체크해준다.
 * 시간 : 236 ms
 * 메모리 : 22100 KB
 * 난이도 : 중 (어떻게 구현해야 할지 감이 안잡혀서 강의를 봤습니다. 강의를 보니 생각보다 구현은 할만 했던거 같습니다.)
 */

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;    // N과 M
    static boolean[] visited;   // 방문 여부를 체크할 배열
    static StringBuilder result = new StringBuilder();  // 결과를 저정할 변수

    // DFS 탐색을 하며 순열을 찾는 함수
    public static void dfs(int depth, int[] current) {
        // 주어진 길이의 순열을 만들었으면
        if (depth == M) {
            // result에 순열을 추가하고
            for (int i = 0; i < M; i++) {
                result.append(current[i]).append(" ");
            }
            result.append("\n");
            return; // 함수 종료
        }

        // 아니면
        for (int i = 1; i < N; i++) {
            // 동일한 숫자가 두번 들어가는 것을 막기위해 visited 배열로 방문 여부 체크
            if (!visited[i]) {              // 방문하지 않은 숫자이면
                visited[i] = true;          // 방문 여부 true로 체크
                current[depth] = i;         // 현재 방문 숫자 current 배열에 추가
                dfs(depth + 1, current);    // dfs로 추가 탐색
                visited[i] = false;         // 방문 여부 false로 체크
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // N을 입력받음
        M = Integer.parseInt(st.nextToken());   // M을 입력받음

        visited = new boolean[N + 1];   // 방문 여부를 체크할 배열, 1부터 시작할거기 때문에 N+1을 크기로 설정
        dfs(0, new int[M]);             // dfs 함수를 호출하여 순열을 구함
        System.out.println(result);     // 결과를 출력
    }
}
