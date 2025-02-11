/**
 * 아이디어 : 지도를 한 칸씩 돌면서 1이면 DFS 탐색을 하며 영역의 크기를 측정합니다.
 * 이때 이미 탐색한 영역은 visited로 체크하여 중복된 영역을 탐색하지 않게 합니다.
 * 시간 : 112 ms
 * 메모리 : 14200 KB
 * 난이도 : 하 (이전 DFS 문제에서 탐색 영역을 1차원에서 2차원으로만 확장하면 되서 쉬었습니다.)
 */

package Algorithm;

import java.io.*;
import java.util.*;

public class Main_2667_단지번호붙이기 {
    static int N;                       // 지도의 크기를 저장할 변수
    static int [][] graph;              // DFS 탐색을 할 그래프
    static boolean [][] visited;        // 방문 여부를 체크할 변수
    static int [] dx = {-1, 0, 1, 0};   // 상하좌우 이동을 위한 dx
    static int [] dy = {0, 1, 0, -1};   // 상하좌우 이동을 위한 dy
    static int size;                    // 영역의 크기를 저장할 변수

    // 상하좌우 이동을 할 때 좌표가 지도안에 있는지 확인할 함수
    static boolean boundCheck(int y, int x) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    // DFS 탐색을 위한 함수
    static void DFS(int currentY, int currentX) {
        size++;                             // 영역 1 증가
        visited[currentY][currentX] = true; // 현재 영역을 방문 체크

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int newX = currentX + dx[i];
            int newY = currentY + dy[i];

            // 새로운 좌표가 지도 범위 안에 있고 집이 있고 방문하지 않았다면
            if (boundCheck(newY, newX) && graph[newY][newX] == 1 && !visited[newY][newX]) {
                DFS(newY, newX);    // 새로운 좌표로 DFS 탐색
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> result;                   // 결과를 저장할 변수
        N = Integer.parseInt(br.readLine());    // 지도의 크기를 입력받음
        graph = new int[N][N];                  // graph 변수 초기화

        // 지도를 입력받음
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                graph[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        visited =new boolean[N][N];        // visited 배열을 초기화
        result = new ArrayList<>();        // result 변수를 초기화

        // 지도를 한칸씩 돌면서 영역 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 집이 있고 방문하지 않았다면
                if (graph[i][j] == 1 && !visited[i][j]) {
                    size = 0;           // 영역을 측정할 변수 0으로 초기화
                    DFS(i, j);          // 현재 좌표를 시작으로 DFS 탐색 시작
                    result.add(size);   // 탐색 결과를 추가
                }
            }
        }

        Collections.sort(result);           // 탐색 결과 정렬

        System.out.println(result.size());  // 단지수 출력

        // 단지내 집의 수 오름차순 출력
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}
