/**
 * 아이디어 : 학생을 입력받을 때 마다 규칙을 고려하여 학생들을 배정
 * 시간 : 160 ms
 * 메모리 : 17336 kb
 * 난이도 : 상 (구현이 너무 복잡해서 아이디어를 생각하고 코드를 짜기가 힘들었던거 같습니다.)
 */

package Algorithm;

import java.io.*;
import java.util.*;

public class Main_21608_상어_초등학교 {
    static int N;                                               // 교실의 가로 세로 칸수
    static int[][] board;                                       // 학생들의 자리를 저장할 배열
    static int[] dx = {0, 0, -1, 1};                            // 상하좌우 탐색을 위한 변수
    static int[] dy = {-1, 1, 0, 0};                            // 상하좌우 탐색을 위한 변수
    static Map<Integer, int[]> prefMap = new HashMap<>();       // 각 학생의 선호 학생들을 저장할 변수

    // 주어진 좌표가 경계안에 속하는지 체크하는 함수
    static boolean boundCheck(int y, int x) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    // 주어진 값이 배열안에 존재하는지 확인하는 함수
    static boolean isIn(int val, int [] array) {
        boolean check = false;  // 배열안에 존재하는지 체크하기 위한 변수

        // 반복문을 돌며 주어진 값이 배열에 존재하면 check 변수에 true를 대입하고 break
        for (int j : array) {
            if (val == j) {
                check = true;
                break;
            }
        }

        return check;   // check 변수 반환
    }

    // 상하좌우 이동을 하며 인접한 칸에 좋아하는 학생이 몇명 있는지 카운트하는 함수
    static int countLikes(int y, int x, int [] likes) {
        int count = 0;  // 좋아하는 학생 수

        // 상하좌우 이동을 하며 인접한 칸에 좋아하는 학생의 수를 셈
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];   // 새로운 y 좌표
            int newX = x + dx[i];   // 새로운 x 좌표

            // 이동한 새로운 좌표가 경계안에 있고 좋아하는 해당 자리 학생이 좋아하는 학생 리스트에 있으면
            if (boundCheck(newY, newX) && isIn(board[newY][newX], likes)) {
                count++;    // 카운트 증가
            }
        }

        return count;   // 카운트 반환
    }

    // 빈칸의 개수를 세는 함수
    static int countEmpty(int y, int x) {
        int count = 0;  // 빈칸의 개수

        // 상하좌우 이동을 하며 빈칸의 개수를 셈
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];   // 새로운 y 좌표
            int newX = x + dx[i];   // 새로운 x 좌표

            // 이동한 새로운 좌표가 경계안에 있고 빈칸이면
            if (boundCheck(newY, newX) && board[newY][newX] == 0) {
                count++;    // 카운트 증가
            }
        }

        return count;   // 카운트 반환
    }

    // 만족도 점수를 계산할 함수
    static int satisfactionScore(int y, int x, int[] likes) {
        int count = 0;  // 좋아하는 학생 수

        // 상하좌우 이동을 하며 인접한 칸에 좋아하는 학생의 수를 셈
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];     // 새로운 y 좌표
            int newX = x + dx[i];     // 새로운 x 좌표

            // 이동한 새로운 좌표가 경계안에 있고 해당 자리 학생이 좋아하는 학생 리스트 안에 있으면
            if (boundCheck(newY, newX) && isIn(board[newY][newX], likes)) {
                count++;    // 카운트 증가
            }
        }

        // 좋아하는 학생 수에 따라 점수를 반환
        switch (count) {
            case 1: return 1;       // 1명이면 1점 반환
            case 2: return 10;      // 2명이면 10점 반환
            case 3: return 100;     // 3명이면 100점 반환
            case 4: return 1000;    // 4명이면 1000점 반환
            default: return 0;      // 0명이면 0점 반환
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 교실의 가로 세로 칸수
        board = new int[N][N];                  // 교실 배열

        // N^2 개의 줄에 학생 번호와 좋아하는 학생의 번호를 입력받고 자리 배정
        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());  // 학생 번호를 입력받음
            int [] likes = new int[4];

            // 좋아하는 학생의 번호를 입력받음
            for (int j = 0; j < 4; j++) {
                likes[j] = Integer.parseInt(st.nextToken());
            }

            prefMap.put(number, likes); // 학생의 번호를 키로 좋아하는 학생의 번호를 값으로 맵에 추가

            int maxLikeCount = -1;      // 최대 좋아하는 학생수
            int maxEmptyCount = -1;     // 최대 빈칸 수
            int x = -1;                 // 학생을 배정할 x 좌표
            int y = -1;                 // 학생을 배정할 y 좌표

            // 매 칸 마다 기준에 따라 자리 배정
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // 이미 학생이 배정된 칸이면 continue
                    if (board[j][k] != 0)
                        continue;

                    // 인접한 칸의 좋아하는 학생 수를 카운트하여 대입
                    int likeCount = countLikes(j, k, likes);
                    // 인접한 칸의 비어있는 칸수를 카운트하여 대입
                    int emptyCount = countEmpty(j, k);

                    // 만약 현재 최대 좋아하는 학생 수 보다 이번 좋아하는 학생수가 더 많으면
                    if (maxLikeCount < likeCount) {
                        maxLikeCount = likeCount;       // maxLikeCount 값 업데이트
                        maxEmptyCount = emptyCount;     // maxEmptyCount 값 업데이트

                        // 현재 좌표를 학생 배정 좌표로 결정
                        y = j;
                        x = k;
                    }
                    // 만약 인접한 칸에 좋아하는 학생 수가 같은 여러 칸이 존재할 경우 비어있는 칸이 많은 곳에 배치
                    else if ((maxLikeCount == likeCount) && (maxEmptyCount < emptyCount)) {
                        maxEmptyCount = emptyCount; // maxEmptyCount 값 업데이트

                        // 현재 좌표를 학생 배정 좌표로 결정
                        y = j;
                        x = k;
                    }
                    // 만약 좋아하는 학생 수와 비어있는 칸수 까지 같은 칸이 여러개이면 행의 번호가 더 작은 칸으로 배치
                    else if ((maxLikeCount == likeCount) && (maxEmptyCount == emptyCount) && (y > j)) {
                        // 현재 좌표를 학생 배정 좌표로 결정
                        y = j;
                        x = k;
                    }
                    // 만약 좋아하는 학생 수와 비어있는 칸수, 행의 번호가 같은 칸이 여러개이면 열의 번호가 작은 칸으로 배치
                    else if ((maxLikeCount == likeCount) && (maxEmptyCount == emptyCount) && (y == j) && (x > k)) {
                        // 현재 좌표를 학생 배정 좌표로 결정
                        y = j;
                        x = k;
                    }
                }
            }

            board[y][x] = number;   // 구한 좌표에 학생 배치
        }

        // 정해진 자리에 따라 학생 선호도 계산
        int totalLikes = 0;     // 학생 선호도 저장을 위한 변수

        // 반복문을 돌며 각 칸마다 학생 선호도 점수를 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int student = board[i][j];  // 현재 위치의 학생 번호를 구함

                int [] likes = prefMap.get(student);    // 학생 번호로 선호하는 학생들을 구함
                totalLikes += satisfactionScore(i, j, likes);   // 이를 통해 학생 선호도 점수를 구해서 전체 학생 선호도 점수에 합함
            }
        }

        System.out.println(totalLikes);     // 결과 출력
    }
}
