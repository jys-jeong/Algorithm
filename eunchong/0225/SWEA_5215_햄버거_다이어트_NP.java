/**
 * 아이디어 : Next Permutation을 이용해서 가능한 모든 조합 경우의 수를 구하고 칼로리 제한을 넘지 않는 조합중 최대 맛 점수를 구함
 * 시간 : 1349 ms
 * 메모리 : 32944 kb
 * 난이도 : 중 (Next Permutation이 잘 이해가 안되기도 했고 어디에 쓰는 건지 모르겠어서 좀 어려웠습니다.)
 */

import java.io.*;
import java.util.*;

public class Solution {
    static int N, L;
    static int[] calorie, flavor;
    static int maxFlavor;

    // nextPermutation 메서드: 배열 arr의 다음 순열을 구함 (사전순으로)
    static boolean nextPermutation(int[] arr) {
        int i = N - 1;

        // Step 1: 뒤쪽 부터 탐색해서 꼭대기 찾기
        while(i > 0 && arr[i - 1] >= arr[i])
            i--;

        // 교환자리가 없는 절벽 형태
        if(i == 0)
            return false;   // false 반환

        // Step 2: 교환할 값보다 한단계 더 큰수를 뒤쪽부터 찾음
        int j = N - 1;
        while(arr[i - 1] >= arr[j])
            j--;

        // 자리 교환
        swap(arr, i - 1, j);

        // Step 3: 꼭대기 부터 맨 뒤까지 오름차순 정렬
        reverse(arr, i, N - 1);

        return true;
    }

    // 배열에서 두 원소의 위치를 교환
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 배열의 start 인덱스부터 end 인덱스까지 원소를 역순으로 정렬
    static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();     // 결과를 저장할 StringBuilder

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수를 입력받음

        // 테스트 케이스 개수만큼 입력 처리
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   // 재료의 개수를 입력받음
            L = Integer.parseInt(st.nextToken());   // 제한 칼로리를 입력받음

            flavor = new int[N];    // 맛 점수를 저장할 배열 초기화
            calorie = new int[N];   // 칼로리를 저장할 배열 초기화

            // 맛 점수와 칼로리를 입력받음
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                flavor[i] = Integer.parseInt(st.nextToken());
                calorie[i] = Integer.parseInt(st.nextToken());
            }

            maxFlavor = 0;  // 최대 맛 점수

            // Next Permutation을 통해 완전탐색으로 답을 구함
            for (int k = 0; k <= N; k++) {
                int[] select = new int[N];
                for (int i = 0; i < N - k; i++) {
                    select[i] = 0;
                }
                for (int i = N - k; i < N; i++) {
                    select[i] = 1;
                }

                // 선택된 재료들의 맛 점수와 칼로리의 합을 구함
                do {
                    int sumCal = 0, sumFlavor = 0;  // 맛 점수의 합과 칼로리의 합을 저장할 변수

                    // 반복문을 돌며 선택된 재료들의 맛점수와 칼로리의 합을 구함
                    for (int i = 0; i < N; i++) {
                        if (select[i] == 1) {
                            sumCal += calorie[i];
                            sumFlavor += flavor[i];
                        }
                    }
                    // 칼로리의 합이 제한 칼로리 이내라면
                    if (sumCal <= L) {
                        // 최대 맛 점수 업데이트
                        maxFlavor = Math.max(maxFlavor, sumFlavor);
                    }
                } while (nextPermutation(select));  // Next Permutation 반복
            }

            // 결과 저장
            sb.append("#").append(tc).append(" ").append(maxFlavor).append("\n");
        }
        System.out.print(sb);   // 결과 출력
    }
}
