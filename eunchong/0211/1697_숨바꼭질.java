/**
 * 아이디어 : +1 -1 *2를 차례대로 적용하며 완전탐색을 하여 몇번째에 동생의 위치로 가는지 찾습니다.
 * 시간 : 148 ms
 * 메모리 : 20700 kb
 * 난이도 : 상 (아이디어는 생각 났는데, 어떻게 구현해야할지 잘 생각이 안나서 어려웠습니다.)
 */

package Algorithm;

import java.io.*;
import java.util.*;

public class Main_1697_숨바꼭질 {
    static int BFS(int start, int target) {
        Queue<Integer> queue = new ArrayDeque<>();  // BFS 탐색을 위한 큐
        boolean[] visited = new boolean[100001];    // 방문 체크를 위한 배열
        int depth = 0;                              // 탐색 깊이를 저장할 배열

        // 가지치기
        if (start == target) {
            return 0;
        }

        queue.offer(start);     // 시작점을 큐에 추가
        visited[start] = true;  // 시작점을 방문 체크

        // 큐가 비어있지 않으면
        while(!queue.isEmpty()) {
            int size = queue.size();    // 큐의 사이즈를 저장

            for (int i = 0; i < size; i++) {    // 큐의 사이즈 만큼 반복
                int current = queue.poll();     // 큐에서 값을 하나 빼 현재 값에 저장

                // +1 -1 *2 를 순차적으로 적용하여 next 변수에 저장
                int [] next = {current + 1, current - 1, current * 2};
                for (int n: next){  // +1 -1 *2를 순차적으로 적용한 값을 돌며
                    if (n == target)        // target 과 같은지 비교
                        return depth + 1;   // 같다면 depth + 1 반환

                    // n이 탐색 범위 안에 있고 방문한적 없다면
                    if (n >= 0 && n <= 100000 && !visited[n]) {
                        queue.offer(n);     // 큐에 추가
                        visited[n] = true;  // 방문 체크
                    }
                }
            }

            depth++;    // 탐색 깊이 증가
        }

        return -1;  // target을 찾을 수 없으면 -1 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 수빈이 위치
        int K = Integer.parseInt(st.nextToken());   // 동생 위치

        int result = BFS(N, K);     // BFS 탐색
        System.out.println(result); // 결과 출력
    }
}

