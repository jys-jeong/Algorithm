/**
 * 아이디어 : 한 칸씩 지나가며 확인을 하다가 바둑돌을 발견하면 가로, 세로, 대각선을 체크하여 승부가 났는지 체크
 * 시간 : 128 ms
 * 메모리 : 16108 KB
 * 난이도 : 중 (어떻게 구현해야 할지 생각해 내기는 쉬웠는데, 왼쪽 대각성은 가장 왼쪽 바둑돌이나, 6목 같은 케이스를 잘못 처리해서 시간이 많이 걸렸습니다.)
 */

package Algorithm;

import java.io.*;
import java.util.*;

public class Main_2615_오목 {
    static int N = 19;
    static int[][] board = new int[N][N];
    static int winX, winY;

    // 주어진 좌표가 보드판의 경계를 벗어났는지 확인하는 함수
    static boolean boundCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    // 현재 위치를 기준으로 가로, 세로, 대각선을 체크하여 승패 결과를 반환
    // 1은 검은 바둑돌 승리, 2는 흰색 바둑돌 승리, 0은 승패가 아지 결정 되지 않음
    static int gameCheck(int x, int y) {
        int result = 0;
        int M = 5;
        int current = board[y][x];
        boolean check = true;

        // 가로 체크
        for (int i = 0; i < M; i++) {
            if (!boundCheck(x+i, y) || board[y][x+i] != current) {
                check = false;
                break;
            }
        }

        // 6목 체크
        if ((boundCheck(x+M, y) && board[y][x+M] == current)
                || (boundCheck(x-1, y) && board[y][x-1] == current)) {
            check = false;
        }

        // 결과 학인 후 반환값 세팅
        if (check) {
            winX = x;
            winY = y;
            result = current;
        }
        check = true;

        // 세로 체크
        for (int i = 0; i < M; i++) {
            if (!boundCheck(x, y+i) || board[y+i][x] != current) {
                check = false;
                break;
            }
        }

        // 6목 체크
        if ((boundCheck(x, y+M) && board[y+M][x] == current)
                || (boundCheck(x, y-1) && board[y-1][x] == current)) {
            check = false;
        }

        // 결과 학인 후 반환값 세팅
        if (check) {
            winX = x;
            winY = y;
            result = current;
        }
        check = true;

        // 왼쪽 대각선 체크
        for (int i = 0; i < M; i++) {
            if (!boundCheck(x-i, y+i) || board[y+i][x-i] != current) {
                check = false;
                break;
            }
        }

        // 6목 체크
        if (boundCheck(x-M, y+M) && board[y+M][x-M] == current
                || (boundCheck(x+1, y-1) && board[y-1][x+1] == current)) {
            check = false;
        }

        // 결과 학인 후 반환값 세팅
        if (check) {
            // 왼쪽 대각선의 경우 가장 왼쪽 바둑돌은 가장 마지막 바둑돌
            winX = x - 4;
            winY = y + 4;
            result = current;
        }
        check = true;

        // 오른쪽 대각선 체크
        for (int i = 0; i < M; i++) {
            if (!boundCheck(x+i, y+i) || board[y+i][x+i] != current) {
                check = false;
                break;
            }
        }

        // 6목 체크
        if (boundCheck(x+M, y+M) && board[y+M][x+M] == current
                || (boundCheck(x-1, y-1) && board[y-1][x-1] == current)) {
            check = false;
        }

        // 결과 학인 후 반환값 세팅
        if (check) {
            winX = x;
            winY = y;
            result = current;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 보드판을 입력 받음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        // 보드판을 한칸씩 이동하며 승패 체크
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 바둑돌이 놓여 있으면
                if (board[i][j] != 0) {
                    // 해당 칸을 기준으로 승패 여부를 확인
                    result = gameCheck(j, i);

                    // 승패가 난 경우 결과 출력 후 종료
                    if (result != 0) {
                        System.out.println(result);
                        System.out.println((winY + 1) + " " + (winX + 1));
                        return;
                    }
                }
            }
        }

        // 승패가 나지 않은 경우 0을 출력
        System.out.println(0);
    }
}
