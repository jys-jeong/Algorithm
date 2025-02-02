/**
 * 아이디어 : 사각형을 평면으로 펼쳐서 거리를 계산
 * 시간 : 104 ms
 * 메모리 : 14176 KB
 * 난이도 : 중 (평면으로 펼쳤을 때 거리를 역방향으로 계산하는 부분이 구현하기 힘들었습니다.)
 */

import java.io.*;
import java.util.*;

public class Main {
    static int width;
    static int height;
    static int [] map;

    // 동근이의 위치를 찾아서 반환하는 함수
    static int findDong(int dong) {
        for (int i = 0; i < map.length; i++) {
            if (map[i] == dong)
                return i;
        }

        return -1;
    }

    // 상점의 번호와 동근이의 위치가 주어지면 거리를 계산하여 반환하는 함수
    static int calcDistance(int target, int dong) {
        int distance = 0;   // 거리
        int targetX = -1;   // 타겟 상점의 좌표

        // 타겟 상점의 좌표를 찾음
        for (int i = 0; i < map.length; i++) {
            if (map[i] == target) {
                targetX = i;
                break;
            }
        }

        // 타겟 상점이 없으면 0을 반환
        if (targetX != -1) {
            // 타겟 상점이 있으면
            // 왼쪽으로 돌 때와 오른쪽으로 돌때 거리를 계산
            int right = Math.abs(targetX - dong);
            int left;

            if (dong > targetX) {
                left = map.length - dong + targetX;
            }
            else {
                left = map.length - targetX + dong;
            }

            // 오른쪽 왼쪽 도는 거리 중 더 짧은 거리를 선택
            distance = Math.min(left, right);
        }

        return distance;    // 계산 거리를 반환
    }

    // 방향과 좌표, 상점 번호를 입력받아 맵에 세팅하는 함수
    static void setCoordinates(int direction, int distance, int store) {
        if (direction == 1) {   // 북쪽인 경우
            map[distance - 1] = store;  // 좌표 세팅
        }
        else if (direction == 2) {  // 남쪽인 경우
            map[width + height + width - distance - 1] = store; // 좌표 세팅
        }
        else if (direction == 3) {  // 서쪽인 경우
            map[width + width + height + height - distance - 1] = store;    // 좌표 세팅
        }
        else if (direction == 4) {  // 동쪽인 경우
            map[width + distance - 1] = store;  // 좌표 세팅
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        width = Integer.parseInt(st.nextToken());   // 맵의 가로 길이를 입력받음
        height = Integer.parseInt(st.nextToken());  // 맵의 세로 길이를 입력받음
        map = new int[(width * 2) + (height * 2)];  // 맵에 배열을 생성하여 초기화

        int N = Integer.parseInt(br.readLine());    // 상점의 개수를 입력받음
        int sumOfDistance = 0;  // 최단 거리의 합

        // 반복문을 돌며 상점의 좌표를 입력받고 상점 좌표를 맵에 세팅
        for (int i = 0; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            setCoordinates(direction, distance, i+1);
        }

        int dong = findDong(N+1);   // 동근이의 좌표를 찾아서 세팅

        // 반복문을 돌며 동근이와 상점간의 최단 거리를 계산하여 sumOfDistance에 합함
        for (int i = 0; i < N; i++) {
            sumOfDistance += calcDistance(i + 1, dong);
        }

        System.out.println(sumOfDistance);  // 결과 출력
    }
}
