/**
 * 아이디어 : 순서대로 사각형을 그리는데 초기화 값은 순서 값으로 설정, 이후 각 색종이의 넓이를 계산할 때 순서 값의 개수를 셈
 * 시간 : 240 ms
 * 메모리 : 18976 KB
 * 난이도 : 하 (이전에 풀었던 문제와 유사해서 쉽게 풀 수 있엇습니다.)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_SIZE = 1001;   // 평면의 칸수
    static int [][] board = new int[MAX_SIZE][MAX_SIZE];  // 평면
    static int N;   // 색종이의 개수

    // 주어진 값으로 사각형을 그리는 함수
    static void drawRect(int x, int y, int width, int height, int val) {
        for (int i = y; i < y + height; i++) {
            for (int j = x; j < x + width; j++) {
                board[i][j] = val;
            }
        }
    }

    // 주어진 값의 마킹된 영역의 넓이를 구하는 함수
    static int calcArea(int val) {
        int area = 0;

        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (board[i][j] == val) {
                    area += 1;
                }
            }
        }

        return area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 색종이의 좌표와 길이를 입력받아 사각형을 그림
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            drawRect(x, y, width, height, i+1);
        }

        // 보이는 색종이의 넓이를 각각 출력
        for (int i = 0; i < N; i++) {
            int area = calcArea(i+1);
            System.out.println(area);
        }
    }
}
