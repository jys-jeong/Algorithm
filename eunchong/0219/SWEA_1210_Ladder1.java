/**
 * 아이디어 : 사다리를 거꾸로 뒤집어서 X에서 출발지를 찾아감
 * 메모리 : 134 ms
 * 시간 : 35,840 kb
 * 난이도 : 상 (이유는 모르겠지만 계속 답이 다르게 나오거나 무한 루프가 돌아서 어려웠습니다.)
 */

import java.io.*;
import java.util.*;

public class Solution {
    static int SIZE = 100;          // 보드판 가로 세로 길이
    static int xx, xy;              // 보드판 X 좌표
    static int [][] map;            // 보드판

    // X에서 시작하여 출발점 X 좌표를 찾는 코드
    static int findStart() {
        int row = xx;   // row에 X의 x좌표 대입
        int col = xy;   // col에 X의 y좌표 대입

        do {
            map[col][row] = 7;     // 없으면 무한루프

            // 왼쪽으로 이동할 수 있으면 왼쪽으로 이동
            if (row != 0 && map[col][row - 1] == 1) {
                row--;
            }
            // 오른쪽으로 이동할 수 있으면 오른쪽으로 이동
            else if (row != SIZE - 1 && map[col][row + 1] == 1) {
                row++;
            }
            // 좌우로 이동이 불가하면 위로 이동
            else {
                col--;
            }
        } while (col != 0); // 출발점에 도착하면 반복문 종료

        return row; // 출발점의 x 좌표 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();     // 결과 저장을 위한 StringBuilder 선언

        for (int i = 0; i < 1; i++) {
            int T = Integer.parseInt(br.readLine());    // 테스트 케이스 번호를 입력받음
            map = new int[SIZE][SIZE];                  // 보드판 초기화

            // 보드판에 사다리 정보를 입력받음
            for (int j = 0; j < SIZE; j++) {
                StringTokenizer row = new StringTokenizer(br.readLine());

                for (int k = 0; k < SIZE; k++) {
                    int value = Integer.parseInt(row.nextToken());
                    map[j][k] = value;

                    // 도착점의 좌표도 동시에 찾음
                    if (value == 2) {
                        xx = k;
                        xy = SIZE-1;
                    }
                }
            }

            // 도착점의 좌표를 찾아서 start에 저장
            int start = findStart();

            // 결과를 result에 저장
            result.append("#").append(T).append(" ").append(start).append("\n");
        }

        // 결과 출력
        System.out.println(result);
    }
}
