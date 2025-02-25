/**
 * 아이디어 :
 * 1. 조합을 이용해서 모든 연산 경우의 수를 구함
 * 2. 덱을 이용해서 해당 수식을 계산하고 결과를 리스트에 저장
 * 3. 리스트를 정렬하고 양끝 값의 차이를 구함
 * 시간 : 255 ms
 * 메모리 : 74,984 kb
 * 난이도 : 중 (구현 자체는 무난하게 할 수 있었는데, 시간 제한에 안걸리게 최적화 하는 아이디어가 안 떠올랐습니다.)
 */

import java.io.*;
import java.util.*;

public class Solution {
    static int N;                       // 숫자의 개수
    static int [] numbers;              // 숫자
    static char [] selectedOperator;    // 선택된 연산자를 저장할 배열
    static int [] opCounts;             // 연산자 개수를 카운팅 하는 변수
    static List<Integer> result;        // 연산 결과를 저장할 리스트

    // 수식을 연산하여 결과를 리스트에 저장하는 함수
    static void calc() {
        // 덱을 이용해서 연산 진행
        ArrayDeque<Integer> numDeque = new ArrayDeque<>();          // 숫자를 저장할 덱
        ArrayDeque<Character> operatorDeque = new ArrayDeque<>();   // 연산자를 저장할 덱

        // 입력받은 숫자를 numDeque에 추가
        for (int number : numbers) {
            numDeque.addLast(number);
        }

        // 입력받은 연산자를 operatorDeque에 추가
        for (char c : selectedOperator) {
            operatorDeque.addLast(c);
        }

        // 연산자를 저장한 덱이 빌때까지 아래 코드 반복
        while(!operatorDeque.isEmpty()) {
            int a = numDeque.removeFirst();         // 덱에서 첫번째 값 꺼냄
            int b = numDeque.removeFirst();         // 덱에서 두번째 값 꺼냄
            char op = operatorDeque.removeFirst();  // 덱에서 연산자를 꺼냄
            int result = 0;                         // 연산 결과를 저장할 변수

            // 반복문을 돌며 연산 진행
            switch (op) {
                case '+':   // 연산자가 + 면 덧셈 연산 수행
                    result = a + b;
                    break;
                case '-':   // 연산자가 - 면 뺄셈 연산 수행
                    result = a - b;
                    break;
                case '*':   // 연산자가 * 면 곱셈 연산 수행
                    result = a * b;
                    break;
                case '/':   // 연산자가 / 면 나눗셈 연산 수행
                    result = a / b;
                    break;
            }

            numDeque.addFirst(result);  // 연산 결과를 다시 덱 맨 앞에 추가
        }

        result.add(numDeque.removeFirst()); // 덱에 남아있는 값이 최종 연산 결과이기 때문에 이 값을 꺼내 리스트에 추가
    }

    // 인덱스가 들어오면 연산자를 반환하는 함수
    static char getOp(int i) {
        if (i == 0)         // 0이면 + 연산자 반환
            return '+';
        else if (i == 1)    // 1이면 - 연산자 반환
            return '-';
        else if (i == 2)    // 2면 * 연산자 반환
            return '*';
        else                // 3이면 / 연산자 반환
            return '/';
    }

    // 조합을 통해 연산자를 선택하는 함수
    static void backtrack(int cnt) {
        // 연산자를 모두 선택하였으면
        if (cnt == N-1) {
            calc();     // 수식 계산 진행
            return;     // return
        }

        // 반복문을 돌며 연산자 선택 진행
        for (int i = 0; i < 4; i++) {
            // 해당 연산자를 다 사용했으면
            if (opCounts[i] == 0)
                continue;   // 선택하지 않고 패스

            opCounts[i]--;                      // 해당 인덱스에 해당하는 연산자 선택
            selectedOperator[cnt] = getOp(i);   // 선택된 연산자에 현재 연산자 추가
            backtrack(cnt + 1);             // 다음 연산자 선택하러 감
            opCounts[i]++;                      // 연산자 선택 원복
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();     // 결과를 저장할 StringBuilder
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수를 입력받음

        // 반복문을 돌며 테스트 케이스 입력을 처리
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());    // 숫자의 개수를 입력받음
            opCounts = new int[4];                  // 연산자의 개수를 카운팅할 배열 초기화
            selectedOperator = new char[N-1];       // 선택된 연산자를 저장할 배열 초기화
            result = new ArrayList<>();             // 연산 결과를 저장할 리스트 초기화
            numbers = new int[N];                   // 입력된 숫자들을 저장할 배열 초기화

            StringTokenizer st = new StringTokenizer(br.readLine());    // 연산자 입력받음

            // 연산자를 opCounts 배열을 통해 빈도 카운팅
            for (int i = 0; i < 4; i++) {
                int count = Integer.parseInt(st.nextToken());
                opCounts[i] = count;
            }

            st = new StringTokenizer(br.readLine());    // 숫자들을 입력받음

            // 입력받은 숫자들을 배열에 추가
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            backtrack(0);   // 조합을 이용해서 가능한 모든 수식을 만들고 연산을 진행한 결과를 리스트에 저장

            Collections.sort(result);   // 연산 결과 리스트 정렬
            int diff = Math.abs(result.get(0) - result.get(result.size()-1));   // 양 끝값을 꺼내 차를 계산
            sb.append("#").append(tc).append(" ").append(diff).append("\n");    // 결과를 StringBuilder에 추가
        }

        System.out.println(sb);     // 결과 출력
    }
}