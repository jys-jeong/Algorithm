/**
 * 아이디어 : 최대 높이에 도달할 때 까지 왼쪽 오른쪽에서 이동하며 넓이의 합을 구함. 넓이의 합을 구할 때는 높이가 변할 때 마다 이전 영역의 넓이를 더하는 식으로 계산
 * 시간 : 112 ms
 * 메모리 : 14532 KB
 * 난이도 : 상 (모든 케이스를 포함할 수 있는 알고리즘을 생각해내기도 힘들었고 이를 구현하기도 힘들었습니다.)
 */

import java.io.*;
import java.util.*;

public class Main {
    static int [][] block;
    static int N;

    // 주어진 블록들의 최대 높이를 구하는 함수
    static int getMaxHeight() {
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            maxHeight = Math.max(maxHeight, block[i][1]);
        }

        return maxHeight;
    }

    // 최대 높이를 가진 블록의 첫번째 좌표와 마지막 좌표를 구하는 함수
    static int [] getMaxCoordinate(int maxHeight) {
        int maxStart = 0;
        int maxEnd = 0;

        for (int i = 0; i < N; i++) {
            if (block[i][1] == maxHeight) {
                maxStart = i;
                break;
            }
        }

        for (int i = N-1; i >= 0; i--) {
            if (block[i][1] == maxHeight) {
                maxEnd = i;
                break;
            }
        }

        return new int [] {maxStart, maxEnd};
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 블록의 개수
        block = new int[N][2];  // 블록을 저장할 변수

        // 반목문을 돌며 블록을 입력받음
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            block[i][0] = Integer.parseInt(st.nextToken());
            block[i][1] = Integer.parseInt(st.nextToken());
        }

        // 블록을 x 좌표를 기준으로 정렬
        Arrays.sort(block, (a, b) -> Integer.compare(a[0], b[0]));

        int maxHeight = getMaxHeight();     // 블록의 최대 높이
        int maxStart = getMaxCoordinate(maxHeight)[0];  // 최대 높이를 가진 블록의 시작 좌표
        int maxEnd = getMaxCoordinate(maxHeight)[1];    // 최대 높이를 가진 블록의 끝 좌표

        int left = 0;   // 왼쪽에서 오른쪽으로 이동하기 위한 인덱스
        int right = N - 1;  // 오른쪽에서 왼쪽으로 이동하기 위한 인덱스
        int leftStart = block[0][0];    // 영역 넓이를 계산 할 때 해당 최대 높이 구역의 첫 번째 블록 x 좌표
        int leftHeight = 0;     // 왼쪽에서 오른쪽으로 이동하며 만나는 영역 블록의 최대 높이
        int rightStart = block[N-1][0]; // 영역 넓이를 계산 할 때 해당 최대 높이 구역의 마지막 블록 x 좌표
        int rightHeight = 0;    // 오른쪽에서 왼쪽으로 이동하며 만나는 영역 블록의 최대 높이
        int area = 0;   // 넓이

        // 최대 높이 블록에 도달할 때 까지 왼쪽에서 오른쪽으로 이동하며 최대 높이가 변할 때 마다 넓이를 계산
        while (block[left][1] != maxHeight) {
            leftHeight = Math.max(leftHeight, block[left][1]);  // 해당 영역의 최대 높이
            leftStart = Math.min(leftStart, block[left][0]);    // 해당 영역의 시작 좌표

            // 해당 영역의 높이 보다 더 높은 블록을 만나면
            if (block[left][1] < block[left + 1][1]) {
                // 넓이를 계산 (해당 영역 시작 좌표 - 새로운 블록 x 좌표) * 해당 영역 높이
                area += (block[left + 1][0] - leftStart) * leftHeight;
                // 영역의 시작 좌표를 다음 블록의 x 좌표로 업데이트
                leftStart = block[left + 1][0];
            }

            // 오른쪽으로 한칸 이동
            left++;
        }

        // 최대 높이 블록에 도달할 때 까지 오른쪽에서 왼쪽으로 이동하며 최대 높이가 변할 때 마다 넓이를 계산
        while (block[right][1] != maxHeight) {
            rightHeight = Math.max(rightHeight, block[right][1]);   // 해당 영역의 최대 높이
            rightStart = Math.max(rightStart, block[right][0]);     // 해당 영역의 시작 좌표

            // 해당 영역의 높이 보다 더 높은 블록을 만나면
            if (block[right][1] < block[right - 1][1]) {
                // 넓이를 계산 (해당 영역 시작 좌표 - 새로운 블록 x 좌표) * 해당 영역 높이
                area += (rightStart - block[right - 1][0]) * rightHeight;
                // 영역의 시작 좌표를 다음 블록 x 좌표로 업데이트
                rightStart = block[right - 1][0];
            }

            // 왼쪽으로 한칸 이동
            right--;
        }

        // 최대 높이 블록의 넓이를 계산
        area += (block[maxEnd][0] - block[maxStart][0] + 1) * maxHeight;

        // 결과 출력
        System.out.println(area);
    }
}
