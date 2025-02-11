/**
 * 아이디어 : 나머지 나무들이 키가 가장 큰 나무 키를 따라잡기 직접 까지 성장했을 때
 * 최대 나무의 키와 나머지 나무들의 키의 차에서 2의 개수가 한개 이고 1의 개수가 나머지 일때 필요 일수는 2 * 1의 개수 - 1이 됩니다.
 * 최대 나무의 키와 나머지 나쿠들의 키의 차이에서 1의 개수가 한개 이고 2의 개수가 나머지 일때 필요 일수는 2 * 2의 개수가 됩니다.
 * 최대 나무의 키와 나머지 키의 차이에서 1의 개수와 2의 개수가 같으면 필요 일수는 1의 개수 + 2의 개수가 됩니다.
 * 하지만 1의 개수와 2의 개수가의 차이가 2 이상이 되면 위 규칙이 성립하지 않기 때문에 2 한개를 1 두개로 쪼개서 변환해줍니다.
 * 시간 : 88 ms
 * 메모리 : 26240 kb
 * 난이도 : 상 (규칙을 생각해낼 수도 없었고 2를 1로 쪼갠다는 개념도 생각해낼 수 없을 만큼 어려운 문제였습니다.)
 */

package Algorithm;

import java.io.*;
import java.util.*;

public class Solution_14510_나무높이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수를 입력받음
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());    // 나무의 개수를 입력받음
            st = new StringTokenizer(br.readLine());    // 나무의 키를 입력받음
            int [] trees = new int[N];                  // 나무의 키를 저장할 배열
            int maxHeight = 0;                          // 가장 키가 큰 나무의 키

            // 나무의 키를 배열에 저장하면서 최대 나무 키를 구함
            for (int j = 0; j < N; j++) {
                trees[j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, trees[j]);
            }

            // 나무가 마지막에 자라는데 필요한 1과 2의 개수 구하기
            int even = 0;
            int odd = 0;
            for (int j = 0; j < N; j++) {
                int diff = maxHeight - trees[j];

                // 가장 큰 키와 같은 키면 패스
                if (diff == 0)
                    continue;

                // 2로 나누어 떨어지는 개수가 필요한 2의 개수
                even += diff / 2;
                // 2로 나누었을 때 나머지 개수가 1의 개수
                odd += diff % 2;
            }

            // 2를 1로 쪼개기
            if (even > odd) {
                // 2하나는 1+1로 쪼갤 수 있음
                while (Math.abs(even - odd) > 1) {
                    even--;
                    odd += 2;
                }
            }

            int result = 0;
            // 1의 개수가 2의 개수 보다 많으면
            if (odd > even)
                // result는 2 * odd - 1
                result = odd * 2 - 1;
                // 2의 개수가 1의 개수 보다 많으면
            else if (even > odd)
                // result는 even * 2
                result = even * 2;
                // 1의 개수와 2의 개수가 같으면
            else
                // result는 even + odd
                result = odd + even;

            // 결과 출력
            System.out.println("#" + (i+1) + " " + result);
        }
    }
}