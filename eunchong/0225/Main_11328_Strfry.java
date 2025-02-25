/**
 * 아이디어 : 정렬해서 같으면 Possible 같지 않으면 Impossible
 * 시간 : 388 ms
 * 메모리 : 25760 kb
 * 난이도 : 하
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 문자열 세트의 개수를 입력받음

        StringBuilder sb = new StringBuilder(); // 결과를 저장할 변수

        // 반복문을 돌며 문자열 세트를 처리
        for (int i = 0; i < N; i++) {
            // 문자열 세트를 입력받음
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 문자형 배열로 변환해서 변수에 대입
            char [] word = st.nextToken().toCharArray();
            char [] word2 = st.nextToken().toCharArray();

            // 각각 알파벳 순으로 정렬
            Arrays.sort(word);
            Arrays.sort(word2);

            // 서로 같은지 체크해서 같으면 true 다르면 false로 세팅
            boolean check = true;
            for (int j = 0; j < word.length; j++) {
                if (word[j] != word2[j]) {
                    check = false;
                    break;
                }
            }

            // 결과를 저장
            sb.append(check ? "Possible" : "Impossible").append("\n");
        }

        System.out.println(sb); // 결과 출력
    }
}
