/**
 * 아이디어 : 열린 괄호가 나오면 스택에 삽입하고 닫힌 괄호가 나오면 스택에서 값을 꺼내 짝이 맞는지 확인합니다.
 * 만약 스택이 비어 있거나 짝이 맞지 않다면 규칙 위반입니다. 그리고 마무리 후 스택이 비어있지 않은 경우도 규칙 위반입니다.
 * 시간 : 104 ms
 * 메모리 : 14284 kb
 * 난이도 : 하 (수업에서 배운 알고리즘을 실습하기 위해 풀어본거라 큰 어려움 없이 풀 수 있었습니다,)
 */

package Algorithm;

import java.io.*;
import java.util.*;

public class Main_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            // 괄호를 입력받음
            String bracket = br.readLine();
            boolean result = true;

            // 꺼낼 토큰이 남아있으면
            for (char c: bracket.toCharArray()) {
                // 열린 괄호이면
                if (c == '(')
                    // 스택에 삽입
                    stack.push(c);
                    // 닫힌 괄호이면
                else if (c == ')') {
                    // 스택이 비어있는지 확인하고 비어있지 않으면
                    if (!stack.isEmpty()) {
                        // 괄호가 짝이 맞는지 비교하여 결과를 result에 대입
                        result = stack.pop() == '(';
                    }
                    // 비어있다면 짝이 맞지 않는 것이기 때문에
                    else {
                        // result에 false 대입
                        result = false;
                        break;
                    }
                }
            }

            // 만약 스택에 남이있는 괄호가 있다면 규칙 위반
            if (!stack.isEmpty())
                result = false;

            // 결과 삽입
            if (result)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }

        // 결과 출력
        System.out.println(sb);
    }
}
