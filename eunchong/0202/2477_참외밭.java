/**
 * 아이디어 : 큰 직사각형에서 작은 직사각형을 뺀다.
 * 작은 직사각형 가로 길이 : 작은 가로 길이 중 가장 긴 세로 길이와 붙어있지 않은 가로 길이
 * 작은 직사각형 세로 길이 : 작은 세로 길이 중 가장 긴 가로 길이와 붙어있지 않은 세로 길이
 * 붙어있지 않은 : +1 -1 인덱스 연산을 한 객체와 작은 직사각형 후보 길이 객체와 같은지 틀린지
 * 시간 : 100 ms
 * 메모리 : 14308 KB
 * 난이도 : 중 (문제를 읽었을 때는 어렵게 느껴졌는데, 막상 그림을 그리니 구현 난이도가 적당한 알고리즘이 보여서 풀 수 있었습니다.)
 */

import java.util.*;
import java.io.*;

class Point {
    int direction;
    int distance;

    Point(int direction, int distance) {
        this.direction = direction;
        this.distance = distance;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int density = Integer.parseInt(br.readLine());  // 1 제곱 미터당 자라는 참외의 개수
        Point [] points = new Point[6]; // 변의 방향과 거리를 저장할 변수

        // 반복문을 돌며 변의 방향과 거리를 입력받음
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            points[i] = new Point(direction, distance);
        }

        // 큰 사각형의 넓이를 구함
        int bigWidth = 0;
        int bigWidthIndex = -1;
        int bigHeight = 0;
        int bigHeightIndex = -1;
        int bigRectArea = 0;

        for (int i = 0; i < 6; i++) {
            // 가장 긴 가로 길이를 구함
            if (points[i].direction == 1 || points[i].direction == 2) {
                if (points[i].distance > bigWidth) {
                    bigWidth = points[i].distance;
                    bigWidthIndex = i;
                }
            }
            // 가장 긴 세로 길이를 구함
            if (points[i].direction == 3 || points[i].direction == 4) {
                if (points[i].distance > bigHeight) {
                    bigHeight = points[i].distance;
                    bigHeightIndex = i;
                }
            }
        }

        bigRectArea = bigWidth * bigHeight;

        // 작은 사각형의 넓이를 구함
        int smallWidth = 0;
        int smallHeight = 0;
        int smallRectArea = 0;

        Point [] tmpWidth = new Point[2];
        int wIndex = 0;
        Point [] tmpHeight = new Point[2];
        int hIndex = 0;

        // 작은 사각형 가로 세로 후보 길이를 구함
        for (int i = 0; i < 6; i++) {
            if (points[i].direction == 1 || points[i].direction == 2) {
                if (points[i].distance != bigWidth) {
                    tmpWidth[wIndex] = points[i];
                    wIndex++;
                }
            }
            if (points[i].direction == 3 || points[i].direction == 4) {
                if (points[i].distance != bigHeight) {
                    tmpHeight[hIndex] = points[i];
                    hIndex++;
                }
            }
        }

        // 작은 직사각형 가로 세로 길이를 구함
        int size = points.length;

        for (int i = 0; i < 2; i++) {
            if (tmpWidth[i] != points[(bigHeightIndex + 1) % size] &&
                    tmpWidth[i] != points[(bigHeightIndex - 1 + size) % size]) {
                smallWidth = tmpWidth[i].distance;
            }
            if (tmpHeight[i] != points[(bigWidthIndex + 1) % size] &&
                    tmpHeight[i] != points[(bigWidthIndex - 1 + size) % size]) {
                smallHeight = tmpHeight[i].distance;
            }
        }

        // 작은 직사각형 넓이를 구함
        smallRectArea = smallWidth * smallHeight;

        // 밭의 넓이를 구함
        int totalArea = bigRectArea - smallRectArea;

        // 총 참외 수를 구함
        int result = density * totalArea;
        System.out.println(result);
    }
}
