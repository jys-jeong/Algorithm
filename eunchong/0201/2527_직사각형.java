/**
 * 아이디어 : 각 좌표의 범위를 체크하여 a ~ d를 판단
 * (d) : x 좌표가 벗어난 경우, y 좌표가 벗어난 경우
 * (c) : 두 꼭지점의 좌표가 같은 경우
 * (b) : 위 아래 높이 차로 만나지 않는 경우는 d에서 체크했기 때문에, x좌표가 같아서 만나는 경우와 y좌표가 같아서 만나는 경우
 * (a) : 그 밖의 경우
 * 시간 : 100 ms
 * 메모리 : 14160 KB
 * 난이도 : 상 (모든 케이스를 포함할 수 있는 알고리즘을 생각해내기도 힘들었고 이를 구현하기도 힘들었습니다.)
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int N = 4;  // 사각형의 개수

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 두 사각형의 좌표를 입력 받음
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            // case d
            if (x1 > p2 || x2 > p1 || y2 >q1 || y1 > q2)
                result.append("d\n");
                // case c
            else if ((p1 == x2 && q1 == y2) || (x1 == p2 && y1 == q2) || (x1 == p2 && q1 == y2) || (p1 == x2 && y1 == q2))
                result.append("c\n");
                // case b
            else if ((p2 == x1) || (p1 == x2) || (q1 == y2) || (y1 == q2))
                result.append("b\n");
                // case a
            else
                result.append("a\n");
        }

        System.out.println(result); // 결과 출력
    }
}
