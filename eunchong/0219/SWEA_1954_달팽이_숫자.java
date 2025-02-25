/**
 * 아이디어 : 달팽이 모양으로 움직일 때마다 움직인 공간의 차원을 축소시킴
 * 시간 : 92 ms
 * 메모리 : 25216 kb
 * 난이도 : 하 (전에 풀었던 문제라 금방 인덱스 조작을 위한 패턴을 찾을 수 있었습니다.)
 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder(); // 결과를 저장할 StringBuilder
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수를 저장할 변수

        // 테스트 케이스 개수만큼 반복문을 돌며 테스트 케이스를 처리
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());    // N을 입력받음

            // 차원 축소를 위한 변수 선언
            int rowStart = 0;   // 가로 공간 시작 인덱스
            int colStart = 0;   // 세로 공간 시작 인덱스
            int rowEnd = N-1;   // 가로 공간 끝 인덱스
            int colEnd = N-1;   // 새로 공간 끝 인덱스

            int num = 1;    // 달팽이 배열에 숫자를 채워넣기 위한 변수
            int [][] map = new int[N][N];   // 달팽이 보드판

            // 달팽이 모양으로 숫자를 채워넣기 위해 N * N번 반복문을 돌림
            while (num < N*N+1) {
                // 오른쪽 방향 탐색
                for (int j = rowStart; j <= rowEnd; j++) {
                    map[colStart][j] = num++;
                }
                colStart++; // 가로 위쪽 공간 축소

                // 아래 방향 탐색
                for (int j = colStart; j <= colEnd; j++) {
                    map[j][rowEnd] = num++;
                }
                rowEnd--;   // 세로 오른쪽 공간 축소

                // 왼쪽 방향 탐색
                for (int j = rowEnd; j >= rowStart; j--) {
                    map[colEnd][j] = num++;
                }
                colEnd--;   // 가로 아래쪽 공간 축소

                // 위쪽 방향 탐색
                for (int j = colEnd; j >= colStart; j--) {
                    map[j][rowStart] = num++;
                }
                rowStart++; // 세로 왼쪽 공간 축소
            }

            // 결과를 result에 저장
            result.append("#").append(i).append("\n");
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result.append(map[j][k]).append(" ");
                }
                result.append("\n");
            }
        }

        System.out.println(result); // 결과 출력
    }
}
