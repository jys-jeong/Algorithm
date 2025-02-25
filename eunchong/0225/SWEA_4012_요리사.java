import java.util.*;
import java.io.*;

public class Solution {
    static int N;               // 재료의 개수
    static int[][] board;       // 시너즈를 저장할 배열
    static boolean [] visited;  // 0~N-1 범위의 숫자에서 선택을 했는지 안했는지 체크하기 위한 배열
    static int minFlavor;       // 맛의 차이의 최솟값

    // 2명에게 재료를 분배했을 때 나올 수 있는 가능한 모든 조합에 대해 맛을 계산하고 맛의 차이를 계산하여 맛 차이의 최솟값을 구하는 함수
    static void dfs(int cnt, int start) {
        // 재료의 분배가 끝났으면
        if (cnt == N/2) {
            int sum = 0;    // 손님 A의 시너즈 합을 구해 맛을 저장할 변수
            int sum2 = 0;   // 손님 B의 시너즈 합을 구해 맛을 저장할 변수

            // 반복문을 돌며 각 손님의 시너즈 합을 계산하여 맛을 산정
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j)     // 두명이 동일한 재료를 선택할 수는 없기 때문에
                        continue;   // 패스

                    // 두 숫자다 true이면 손님 A가 고른 재료이기 때문에
                    if (visited[i] && visited[j])
                        sum += board[i][j];     // 시너즈를 계산하여 합에 더함

                    // 두 숫자다 false면 손님 B가 고른 재료이기 때문에
                    if (!visited[i] && !visited[j])
                        sum2 += board[i][j];    // 시너즈를 계산하여 합에 더함
                }
            }

            // 맛의 차를 구한 후 현재 맛의 차 최솟값과 비교하여 업데이트
            minFlavor = Math.min(Math.abs(sum - sum2), minFlavor);

            return; // return
        }

        // 재료를 가능한 모든 조합을 구함
        for (int i = start; i < N; i++) {
            visited[i] = true;           // 현재 숫자를 뽑았다고 체크
            dfs(cnt+1, i+1);    // dfs 호출 이때 start는 동일한 숫자를 중복해서 뽑지 않게 하기 위해 +1 증가
            visited[i] = false;          // 현재 숫자를 뽑은 것을 원복
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수를 입력받음

        // 테스트 케이스 개수 만큼 반복문을 돌며 처리
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());    // 재료의 개수를 입력받음
            board = new int[N][N];                  // 시너즈 점수를 저장할 배열을 초기화
            visited = new boolean[N];               // 숫자 선택 여부를 저장할 배열을 초기화
            minFlavor = Integer.MAX_VALUE;          // 맛의 차의 최솟값을 저장할 변수를 초기화

            // 반복문을 돌며 시너즈 점수 정보를 입력받음
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // dfs 함수를 호출하여 맛의 차의 최솟값을 구함
            dfs(0, 0);

            // 결과를 StringBuilder에 저장
            sb.append("#").append(tc).append(" ").append(minFlavor).append("\n");
        }

        // 결과 출력
        System.out.println(sb);
    }
}