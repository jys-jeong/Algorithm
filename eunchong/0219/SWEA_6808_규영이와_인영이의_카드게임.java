/**
 * 아이디어 : 인영이의 카드의 경우의 수가 9!로 10!이 안되고
 * 카드만 결정하면 카드를 하나씩 비교해가며 승패를 결정하면 되기 때문에,
 * 완전 탐색으로 문제를 해결할 수 있을거 같습니다.
 * 시간 : 2622 ms
 * 메모리 : 26916 kb
 * 난이도 : 중 (완전 탐색을 이해하고 나니 코드를 설계해서 한번에 통과할 수 있었습니다.)
 */

import java.io.*;
import java.util.*;

public class Solution {
    static int T;
    static boolean [] visited;
    static int [] nums;
    static int [] gNums;
    static int [] iNums;
    static int win, lose;

    // 인영이의 카드 패를 만듦
    static void makeINums() {
        boolean [] check = new boolean[19]; // 규영이가 가지고 있지 않는 숫자를 체크하기 위한 변수

        // 1~18 중 규영이가 가지고 있지 않은 숫자를 체크
        for (int i = 0; i < 9; i++) {
            check[gNums[i]] = true;
        }

        // 규영이가 가지고 있지 않는 수자로 인영이의 패를 만듦
        int index = 0;
        for (int i = 1; i < 19; i++) {
            if (!check[i])
                iNums[index++] = i;
        }
    }

    // 인영이와 규영이의 카드패를 비교하여 승패를 결정하는 함수
    static void battle() {
        int gScore = 0; // 규영이의 점수를 저장하기 위한 변수
        int iScore = 0; // 인영이의 점수를 저장하기 위한 변수

        // 패의 카드를 각각 한장씩 비교해가면서 점수를 합산
        for (int i = 0; i < 9; i++) {
            // 규영이의 카드가 더 숫자가 크면
            if (gNums[i] > nums[i])
                // 규영이 점수에 플러스
                gScore += gNums[i] + nums[i];
                // 인영이의 카드가 더 숫자가 크면
            else if (nums[i] > gNums[i])
                // 인영이의 점수에 플러스
                iScore += gNums[i] + nums[i];
        }

        // 규영이의 점수가 더 크면
        if (gScore > iScore)
            win++;  // 승리 횟수 증가
            // 인영이의 점수가 더 크면
        else if (iScore > gScore)
            lose++; // 패배 횟수 증가
    }

    // 순열 함수
    static void permutation(int depth) {
        // 9개의 카드 패를 모두 결정하였으면 재귀 호출 종료
        if (depth == 9) {
            // 결정된 9개의 카드패를 통해 승패를 결정
            battle();
            // 리턴
            return;
        }

        // 9장의 카드패를 결정하기 위해 반복문을 돌림
        for (int i = 0; i < 9; i++) {
            // 이미 선택한 카드이면 continue
            if (visited[i]) continue;

            visited[i] = true;  // 해당 카드를 이미 뽑았다고 체크
            nums[depth] = iNums[i]; // 카드 패에 현재 카드를 저장

            permutation(depth + 1); // 다음 카드를 결정하기 위해 재귀 호출

            nums[depth] = 0;    // 리셋
            visited[i] = false; // 해당 카드를 뽑았다는 표시를 원복
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수를 입력받음
        StringBuilder result = new StringBuilder(); // 결과를 저장할 StringBuilder

        // 반복문을 돌며 테스트 케이스를 입력받고 처리
        for (int i = 1; i <= T; i++) {
            visited = new boolean[9];   // 해당 번호를 뽑았는지 안 뽑았는지 체크하기 위한 변수
            nums = new int[9];          // 인영이의 패를 저장할 변수
            gNums = new int[9];         // 규영이의 패를 저장할 변수
            iNums = new int[9];         // 인영이의 패가 될 수 있는 숫자들을 저장한 배열
            win = 0;                    // 규영이의 승리 횟수를 저장할 변수
            lose = 0;                   // 규영이의 패배 횟수를 저장할 변수

            // 규영이의 패를 입력받음
            StringTokenizer cards = new StringTokenizer(br.readLine());

            // 규영이의 패를 초기화
            for (int j = 0; j < 9; j++) {
                gNums[j] = Integer.parseInt(cards.nextToken());
            }

            // 규영이의 패를 정렬 (인영이의 패가 될 수 있는 숫자들을 편하게 결정하기 위해)
            Arrays.sort(gNums);
            // 인영이의 패를 만듦
            makeINums();

            // 인영이의 패가 될 수 있는 모든 경우를 찾아서 승패 여부를 계산
            permutation(0);
            // 승패 결과를 result 변수에 대입
            result.append("#").append(i).append(" ").append(win).append(" ").append(lose).append("\n");
        }

        // 결과를 출력
        System.out.println(result);
    }
}
