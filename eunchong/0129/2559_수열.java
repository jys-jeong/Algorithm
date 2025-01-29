/**
 * 아이디어 : 반복문을 돌며 주어진 범위의 합을 구하고 현재 최대 값과 비교하여 최대 합을 구함
 * 시간 : 1012 ms
 * 메모리 : 24116 KB
 * 난이도 : 중 (음수만 나올 수 있다는 엣지 케이스를 발견 못해서 시간이 좀 걸렸습니다.)
 */

import java.io.*;
import java.util.*;

public class Main {
    static int N;   // 수의 개수
    static int K;   // 합의 범위
    static int [] numbers; // 숫자들

    // 주어진 범위의 합을 구하는 함수
    static int getSumRange(int start, int end) {
        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += numbers[i];
        }

        return sum;
    }

    // 숫자들에서 주어진 범위의 최대합을 구하는 함수
    static int getMaxSum() {
        int maxSum = -100 * N - 1;  // 합의 최대 값

        int start = 0;  // 범위의 시작 인덱스
        int end = start + K - 1;    // 범위의 종료 인덱스

        while(end < N) {    // 범위의 끝이 배열 범위 안에 있을 때만 합을 구함
            maxSum = Math.max(maxSum, getSumRange(start, end)); // 범위의 합을 구한 다음 합의 최대 값 업데이트
            start++;    // start 인덱스 1 증가
            end = start + K - 1;    // end 인덱스 업데이트
        }

        return maxSum;  // 합의 최대값 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 수의 개수를 입력받음
        K = Integer.parseInt(st.nextToken());   // 합의 범위를 입력받음
        int maxSum;     // 합의 최대값

        numbers = new int[N];   // 숫자들을 저장할 배열을 생성하여 초기화

        // 숫자들을 입력받아 배열에 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 주어진 범위에서의 합의 최대 값을 구함
        if (N == 1) // 입력 받은 숫자가 한개면 해당 숫자 반환
            maxSum = numbers[0];
        else    // 아니면 숫자들에서 주어진 범위 내의 합이 최대인 값을 구함
            maxSum = getMaxSum();

        System.out.println(maxSum); // 결과 출력
    }
}
