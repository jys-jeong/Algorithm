package _0219;

import java.util.*;
import java.util.Scanner;

public class Test {

    static int N;
    static int M;

    static int[] temp;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[N][M];


        printMap();

//        downMap();
        attackTri(0, 3, 1);

        System.out.println();
        printMap();
    }
//0 0 0
//0 0 0
//1 1 1

    //
    // 위 왼쪽 오른쪽
    static int[] dx = new int[]{0, -1, 0};
    static int[] dy = new int[]{-1, 0 , 1};

    static boolean[][] visited;
    static int count = 0;

    static void attackTri(int depth, int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{depth, x, y});

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();

            if (xy[0] > 2) {
                continue;
            }

            for (int i = 0; i < 3; i++) {
                int nx = xy[1] + dx[i];
                int ny = xy[2] + dy[i];

                if (isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) { // 방문처리 해줘야함
                    System.out.println("here");
                    visited[nx][ny] = true;
                    map[nx][ny] = 0;
                    count++;
                    System.out.println("depth + 1: " + (depth + 1) + " nx :" + nx + "ny : " + ny);
                    queue.push(new int[]{ depth + 1, nx, ny});
                }
            }


        }

    }

    static boolean isIn(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    // 밑으로 한칸
    static void downMap() {
        // N, M
        // 밑에는 N - 1이겠지
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                map[i + 1][j] = map[i][j];
            }
        }
    }

    static void printMap() {
        for (int[] xx : map) {
            for (int x : xx) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    static void back(int depth, int startWith) {

    }
}
