/**
 * 아이디어 : 모양별 배열을 만들고 모양의 개수를 배열에 기록한 후 두 배열을 비교하여 승자를 결정
 * 시간 : 244 ms
 * 메모리 : 28920 KB
 * 난이도 : 하 (아이디어가 금방 떠올라서 쉽게 풀 수 있었습니다.)
 */

import java.util.*;
import java.io.*;

public class Main {
    static int N;   // 딱지놀이 라운드 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder(); // 결과를 저장할 변수
        N = Integer.parseInt(br.readLine());    // 딱지 놀이 라운드 수를 입력 받음

        // 반복문을 돌며 플레이어의 카드 정보를 입력받고 승패를 결정
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());    // 첫 번째 플레이어의 카드 정보를 입력받음
            int playerASize = Integer.parseInt(st.nextToken()); // 플레이어 A의 모양 개수
            int [] playerA = new int[4];    // 플레이어 A의 카드 모양을 저장할 배열

            // 플레이어의 카드 모양을 배열에 기록
            for (int j = 0; j < playerASize; j++) {
                int pattern = Integer.parseInt(st.nextToken());
                playerA[pattern - 1]++;
            }

            st = new StringTokenizer(br.readLine());    // 두 번째 플레이어의 카드 정보를 입력받음
            int playerBSize = Integer.parseInt(st.nextToken()); // 플레이어 B의 모양 개수
            int [] playerB = new int[4];    // 플레이어 B의 카드 모양을 저장할 배열

            // 플레이어의 카드 모양을 배열에 기록
            for (int j = 0; j < playerBSize; j++) {
                int pattern = Integer.parseInt(st.nextToken());
                playerB[pattern - 1]++;
            }

            // 플레이어 승패 판정
            if (playerA[3] > playerB[3]) {  // 별의 개수가 많은 쪽이 승리
                result.append("A\n");
            }
            else if (playerA[3] < playerB[3]) { // 별의 개수가 많은 쪽이 승리
                result.append("B\n");
            }
            else if (playerA[2] > playerB[2]) { // 동그라미 개수가 많은 쪽이 승리
                result.append("A\n");
            }
            else if (playerA[2] < playerB[2]) { // 동그라미 개수가 많은 쪽이 승리
                result.append("B\n");
            }
            else if (playerA[1] > playerB[1]) { // 네모 개수가 많은 쪽이 승리
                result.append("A\n");
            }
            else if (playerA[1] < playerB[1]) { // 네모 개수가 많은 쪽이 승리
                result.append("B\n");
            }
            else if (playerA[0] > playerB[0]) { // 세모 개수가 많은 쪽이 승리
                result.append("A\n");
            }
            else if (playerA[0] < playerB[0]) { // 세모 개수가 많은 쪽이 승리
                result.append("B\n");
            }
            else {  // 모든 개수가 같다면 무승부
                result.append("D\n");
            }
        }

        System.out.println(result); // 결과 출력
    }
}
