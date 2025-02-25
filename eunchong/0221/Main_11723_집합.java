/**
 * 아이디어 : 비트마스킹을 이용하여 20 비트 비트 마스킹 변수에 대해 각 연산을 처리
 * 시간 : 1076 ms
 * 메모리 : 313364 kb
 * 난이도 : 중 (비트 마스킹을 잘 몰라서 정답 코드를 봤는데, 막상 코드를 보니 생각보다 단순했던거 같습니다.)
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());    // 명령어의 개수를 입력받음
        int bitMask = 0;                            // 비트 마스킹에 사용할 변수

        // M개의 명령어를 입력받아 처리
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());    // 명령어를 입력받음
            String command = st.nextToken();    // 명령 부분을 잘라냄
            int value = 0;

            // 명령어 뒤에 붙은 값이 있으면 값을 잘라냄
            if (st.hasMoreTokens()) {
                value = Integer.parseInt(st.nextToken());
            }

            // switch 문을 돌며 명령 처리
            switch (command) {
                case "add":     // OR 연산을 통해 해당 숫자 자리에 1을 세팅
                    bitMask |= (1 << value);
                    break;
                case "remove":  // 해당 숫자 자리에 0을 AND 연산시켜서 해당 자리 값을 0으로 세팅
                    bitMask &= ~(1 << value);
                    break;
                case "check":   // AND 연산을 통해 해당 자리가 있는지 확인하여 있으면 1 없으면 0을 StringBuilder에 추가
                    sb.append((bitMask & (1 << value)) != 0 ? 1 : 0).append('\n');
                    break;
                case "toggle":  // XOR 연산을 통해 값 반전
                    bitMask ^= (1 << value);
                    break;
                case "all":     // 2^21 - 1을 대입하여 모든 값을 1로 세팅
                    bitMask = (1 << 21) - 1;
                    break;
                case "empty":   // 0을 대입하여 모든 값을 0으로 세팅
                    bitMask = 0;
                    break;
            }
        }

        System.out.println(sb);     // 결과 출력
    }
}
