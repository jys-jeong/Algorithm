/**
 * 아이디어 : 좌표를 입력받아 직사각형 영역에 해당하는 부분에 1을 채우고 1의 개수를 세서 면적을 계산
 * 시간 : 100 ms
 * 메모리 : 14108 KB
 * 난이도 : 하 (이전에 풀었던 문제와 유사해서 쉽게 풀 수 있엇습니다.)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2669_직사각형_네개의_합집합의_면적_구하기 {
    static final int MAX_SIZE = 100;                        // x,y 좌표의 최대 값
    static int[][] board = new int[MAX_SIZE][MAX_SIZE];     // 수직선 보드

    // 좌표를 입력받아 직사각형을 그릴 함수
    static void drawRect(int x1, int y1, int x2, int y2) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                board[i][j] = 1;
            }
        }
    }

    // 수직선 상에서 1로 마킹된 영역을 계산할 함수
    static int calcArea() {
        int area = 0;

        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (board[i][j] == 1) {
                    area += 1;
                }
            }
        }

        return area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 좌표를 입력 받아 직사각형을 그림
        for(int i = 0; i < 4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            drawRect(x1, y1, x2, y2);
        }

        int result = calcArea();    // 직사각형 영역의 넓이를 계산
        System.out.println(result);
    }
}
