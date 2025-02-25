/**
 * 아이디어 : 투포인터를 이용해서 포인터가 가리키는 값의 합이 target 인지 확인하고 카운트를 셉니다.
 * 시간 : 304 ms
 * 메모리 : 27256 kb
 * 난이도 : 하
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 숫자의 개수를 입력받음
        int [] numbers = new int[n];                // 입력받은 숫자를 저장할 배열을 초기화

        StringTokenizer st = new StringTokenizer(br.readLine());    // 숫자들을 입력받음
        for (int i = 0; i < n; i++) {
            // 배열에 숫자들을 대입
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);   // 숫자들을 정렬

        int target = Integer.parseInt(br.readLine());   // target을 입력받음

        int left = 0;       // 왼쪽을 가리킬 포인터 변수
        int right = n - 1;  // 오른쪽을 가리킬 포인터 변수
        int count = 0;      // 합이 target과 같은 케이스가 몇개 인지 카운트 할 변수


        while (left < right) {  // left 와 right 포인터가 반전되지 않으면
            int sum = numbers[left] + numbers[right];   // 두 포인터가 가리키는 위치의 합을 구함
            if (sum == target) {    // 합이 target과 같으면
                count++;    // 카운트 증가
                left++;     // 왼쪽 포인터 오른쪽으로 한칸 이동
                right--;    // 오른쪽 포인터 왼쪽으로 한칸 이동
            }
            else if (sum > target) {    // 합이 target 보다 크면
                right--;    // 오른쪽 포인터 왼쪽으로 한칸 이동
            }
            else {  // 합이 target 보다 작으면
                left++;     // 왼쪽 포인터 오른쪽으로 한칸 이동
            }
        }

        System.out.println(count);  // 결과 출력
    }
}
