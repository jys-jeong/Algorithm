/**
 * 아이디어 : 잘라야 하는 점선과 시작 끝 지점을 경계로 해서 가로 세로 경계 사이 최대 길이를 구해서 곱하는 방식으로 문제 해결
 * 시간 : 100 ms
 * 메모리 : 14136 KB
 * 난이도 : 중 (아이디어를 떠올리기가 좀 힘들었습니다.)
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(st.nextToken());    // 종이의 가로 길이
        int ySize = Integer.parseInt(st.nextToken());    // 종이의 세로 길이

        int n = Integer.parseInt(br.readLine());        // 잘라야 하는 점선의 개수
        int area = 0;   // 가장 큰 영역의 넓이
        List<Integer> xEdges = new ArrayList<>();   // x 경계를 저장할 변수
        List<Integer> yEdges = new ArrayList<>();   // y 경계를 저장할 변수
        int maxWidth = 0;   // 가로 최대 길이를 저장할 변수
        int maxHeight = 0;  // 세로 최대 길이를 저장할 변수

        xEdges.add(0);      // 가로축 시작점을 경계에 추가
        yEdges.add(0);      // 세로축 시작점을 경계에 추가
        xEdges.add(xSize);  // 가로축 끝점을 경계에 추가
        yEdges.add(ySize);  // 세로축 끝점을 경계에 추가

        for (int i = 0; i < n; i++) {
            // 자르는 방향과 좌표를 입력받음
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st2.nextToken());   // 자르는 방향
            int position = Integer.parseInt(st2.nextToken());    // 자르는 좌표

            // 자르는 방향에 따라 경계 값을 추가
            if (direction == 0) {
                yEdges.add(position);
            }
            else if (direction == 1) {
                xEdges.add(position);
            }
        }

        // 경계를 저장한 리스트를 정렬
        Collections.sort(xEdges);
        Collections.sort(yEdges);

        // 경계 값 사이의 길이를 비교해서 가장 길이가 긴 부분을 찾음
        int prevX = xEdges.get(0);
        for (int i = 1; i < xEdges.size(); i++) {
            int distance = Math.abs(xEdges.get(i) - prevX);

            if (maxWidth < distance) {
                maxWidth = distance;
            }

            prevX = xEdges.get(i);
        }

        // 경계 값 사이의 길이를 비교해서 가장 길이가 긴 부분을 찾음
        int prevY = yEdges.get(0);
        for (int i = 1; i < yEdges.size(); i++) {
            int distance = Math.abs(yEdges.get(i) - prevY);

            if (maxHeight < distance) {
                maxHeight = distance;
            }

            prevY = yEdges.get(i);
        }

        // 가로 세로 가장 길이가 긴 부분을 찾아 영역의 넓이를 구함
        area = maxWidth * maxHeight;
        System.out.println(area);   // 결과 출력
    }
}
