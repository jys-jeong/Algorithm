/**
 * 아이디어 : 6과 9를 타겟으로 최소 세트 개수를 구하고 6과 9를 제외한 숫자를 타겟으로 최소 세트를 구해서 더 큰 값을 사용
 *          6과 9는 서로 대체할 수 있기 때문에 6과 9를 합하고 2를 나눈 값을 올림하여 별도로 계산 진행
 * 시간 : 104 ms
 * 메모리 : 14332 kb
 * 난이도 : 중 (구현 아이디어가 생각보다 잘 떠오르지 않아서 시간이 걸렸습니다.)
 */

package Algorithm;

import java.io.*;
import java.util.*;

public class Main_1475_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();    // 숫자 빈도를 저장하기 위한 변수

        // 0부터 9까지 초기화
        for (int i = 0; i < 10; i++) {
            map.put(i, 0);
        }

        String number = br.readLine();  // 숫자를 입력받음

        // 각 숫자의 빈도를 카운트
        for (char n : number.toCharArray()) {
            int digit = n - '0';
            map.put(digit, map.get(digit) + 1);
        }

        // 6과 9를 타겟으로 최소 세트를 구함
        // 6과 9를 합산하고 2로 나눈 올림 값 계산
        int sixNine = map.get(6) + map.get(9);
        int combined = (int) Math.ceil(sixNine / 2.0);

        // 6, 9 제외한 다른 숫자들의 최대 빈도 계산
        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9)
                continue;
            max = Math.max(max, map.get(i));
        }

        max = Math.max(max, combined);  // 둘 중 더 큰 값을 사용
        System.out.println(max);        // 결과 출력
    }
}

