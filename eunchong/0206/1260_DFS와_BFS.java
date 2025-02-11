/**
 * 아이디어 : 일반적인 DFS, BFS 알고리즘 탐색 수행
 * 시간 : 212 ms
 * 메모리 : 20492 KB
 * 난이도 : 중 (알고리즘을 학습한 후 구현하니까 할만했던거 같습니다.)
 */

import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;     // 그래프를 저장할 변수
    static boolean [] visited;              // 방문 여부를 저장할 변수
    static StringBuilder ans_dfs;       // DFS 탐색 결과를 저장할 변수
    static StringBuilder ans_bfs;       // BFS 탐색 결과를 저장할 변수

    // DFS 탐색을 위한 함수
    static void DFS(int current) {
        visited[current] = true;   // 현재 노드를 방문 체크
        ans_dfs.append(current).append(" ");    // 현재 노드를 방문했다고 결과에 추가

        // 간선이 연결된 노드를 타고 들어가면서 탐색
        for (int neighbor : graph.get(current)) {
            // 연결된 노드가 방문하지 않았다면
            if (!visited[neighbor]) {
                // DFS 탐색
                DFS(neighbor);
            }
        }
    }

    // BFS 탐색을 위한 함수
    static void BFS(int start) {
        // BFS 탐색을 위한 큐
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start);                 // 시작 노드 큐에 저장
        ans_bfs.append(start).append(" ");  // 시작 노드를 방문했다고 결과에 추가
        visited[start] = true;              // 시작 노드를 방문했다고 체크

        // 큐가 비어있지 않다면
        while (!queue.isEmpty()) {
            // 큐에서 값을 하나 빼서
            int current = queue.poll();

            for (int next : graph.get(current)) {
                // 방문하지 않은 노드라면
                if (!visited[next]) {
                    queue.offer(next);                  // 큐에 삽입
                    ans_bfs.append(next).append(" ");   // 다음 노드를 방문했다고 결과에 추가
                    visited[next] = true;               // 다음 노드 방문했다고 체크
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수
        int V = Integer.parseInt(st.nextToken());   // 탐색을 시작할 정점의 번호

        graph = new ArrayList<>();        // 그래프를 저장할 변수 초기화
        visited = new boolean[N+1];         // 방문을 체크할 배열 초기화
        ans_dfs = new StringBuilder();  // dfs 결과를 저장할 StringBuilder 초기화
        ans_bfs = new StringBuilder();  // bfs 결과를 저장할 StringBuilder 초기화

        // adj 내부 리스트 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 연결된 간선들의 정보를 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // 간선들의 정보를 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        DFS(V);                 // DFS 탐색
        visited = new boolean[N+1]; // visited 변수 초기화
        BFS(V);                 // BFS 탐색

        System.out.println(ans_dfs);    // DFS 탐색 결과 출력
        System.out.println(ans_bfs);    // BFS 탐색 결과 출력
    }
}