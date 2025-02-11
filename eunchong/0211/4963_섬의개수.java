/**
 * 아이디어 : 지도를 한칸식 돌며 섬이면 8방향 DFS 탐색을 합니다.
 * 시간 : 140 ms
 * 메모리 : 15912 kb
 * 난이도 : 하 (단지번호 붙이기랑 비슷한 문제라 무난하게 구현할 수 있었습니다.)
 */

package Algorithm;

import java.io.*;
import java.util.*;

public class Main_4963_섬의개수 {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};  // 8방향 탐색을 위한 dx
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};  // 8방향 탐색을 위한 dy

    // 새로운 탐색 좌표가 탐색 범위 안에 있는지 확인하는 함수
    static boolean boundCheck(int y, int x, int w, int h) {
        return y >= 0 && y < h && x >= 0 && x < w;
    }

    // DFS 탐색을 위한 함수
    static void dfs(int y, int x, int w, int h, int [][] map, boolean [][] visited) {
        visited[y][x] = true;   // 현재 좌표를 방문으로 체크

        // 8방향 탐색
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 새로운 좌표가 탐색 범위 안에 있고 아직 방문하지 않았고 섬이라면
            if (boundCheck(ny, nx, w, h) && !visited[ny][nx] && map[ny][nx] == 1) {
                // 새로운 좌표에 대해 dfs 탐색
                dfs(ny, nx, w, h, map, visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();     // 결과를 저장할 변수

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());   // 가로 길이를 입력받음
            int h = Integer.parseInt(st.nextToken());   // 세로 길이를 입력받음

            // 0 0이 들어오면 종료
            if (w == 0 && h == 0)
                break;

            int [][] map = new int[h][w];               // 지도
            boolean [][] visited = new boolean[h][w];   // 방문 여부를 체크할 변수
            int count = 0;                              // 섬의 개수를 셀 변수

            // 반복문을 돌며 지도에 섬과 바다를 입력받음
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 지도를 한칸식 돌면서 섬의 개수를 탐색
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 현재 위치가 섬이고 아직 방문하지 않았다면
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j, w, h, map, visited);  // dfs 탐색
                        count++;                        // 섬의 개수 증가
                    }
                }
            }

            result.append(count).append("\n");  // 섬의 개수를 result에 추가
        }

        System.out.println(result);     // 섬의 총 개수를 출력
    }
}
