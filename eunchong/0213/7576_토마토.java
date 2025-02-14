/**
 * 아이디어 : 창고를 한칸씩 돌면서 익은 토마토 이면 상하좌우 이동을 하면서 BFS 탐색을 위해 큐에 추가한다.
 * 이후 총 소요된 날짜를 계산하는데, 큐에 삽입이 한차례 지나갈 때 마다 증가시킨 값을 저장해서 계산에 사용한다.
 * 시간 : 528 ms
 * 메모리 : 103040 kb
 * 난이도 : 상 (소요된 날짜를 계산하는 부분이랑 시작점이 여러개일 경우 어떻게 구현을 해야 할지 잘 모르겠어서 어려웠습니다.)
 */

import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
    int depth;

    Point(int y, int x, int depth) {
        this.y = y;
        this.x = x;
        this.depth = depth;
    }
}

public class Main {
    static int N, M;            // 창고의 가로, 세로 길이
    static int[][] storage;     // 창고의 토마토 상태를 저장할 배열
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    static Queue<Point> queue = new ArrayDeque<>();

    // 새로운 좌표가 탐색 범위 안에 있는지 확인하기 위한 함수
    static boolean boundCheck(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    static boolean checkFull() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (storage[i][j] == 0)
                    return false;
            }
        }

        return true;
    }

    static void bfs() {
        int date = 0;

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            date = current.depth;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (boundCheck(ny, nx) && storage[ny][nx] == 0) {
                    queue.offer(new Point(ny, nx, date + 1));
                    storage[ny][nx] = 1;
                }
            }
        }

        if (checkFull())
            System.out.println(date);
        else
            System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    // 창고의 가로 세로 길이를 입력받음

        M = Integer.parseInt(st.nextToken());   // 창고의 가로 길이
        N = Integer.parseInt(st.nextToken());   // 창고의 세로 길이

        storage = new int[N][M];
        int result = 0;

        // 창고에 토마토 상태를 입력받음
        for (int i = 0; i < N; i++) {
            // 토마토 상태를 입력받음
            st = new StringTokenizer(br.readLine());

            // 창고 배열에 토마토 상태를 세팅
            for (int j = 0; j < M; j++) {
                storage[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 창고를 한칸씩 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 익은 토마토이고 아직 방문하지 않았으면
                if (storage[i][j] == 1) {
                    queue.offer(new Point(i, j, 0));
                }
            }
        }

        bfs();
    }
}
