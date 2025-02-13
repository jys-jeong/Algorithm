/**
 * 아이디어
 * 1. 2N-1 크기의 배열을 만들고 각 마을 마다 1칸씩 간격을 두고 값을 입력받음
 * 2. 간격으로 남겨둔 칸을 벽으로 세울지 그냥 나둘지 가로 세로 모두 연산을 통해 결정
 *  - 벽을 세울거면 -1로 초기화, 그냥 나둘거면 -2으로 초기화
 * 3. 이후 각 칸들을 돌며 각각 BFS 탐색을 수행하고 인구 이동 시작
 * 4. 다시 2번으로 가서 2~3번을 이동이 불가능할 때 까지 반복
 * 시간 : 1156 ms
 * 메모리 : 307960 kb
 * 난이도 : 상 (아이디어는 생각났는데 구현이 너무 복잡했습니다.)
 */

import java.util.*;
import java.io.*;

public class Main {
    static int N;                       // 땅으 크기
    static int L;                       // 인구 차이 최소
    static int R;                       // 인구 차이 최대
    static int [][] map;                // 국가 및 경계 저장 배열
    static int [][] visited;            // 방문 여부를 체크할 배열
    static int [] dx = {1, -1, 0, 0};   // 상하좌우 이동을 위한 dx
    static int [] dy = {0, 0, 1, -1};   // 상하좌우 이동을 위한 dy

    // 인구 이동이 불가능한지 확인하는 함수
    static boolean isNotMoveable(List<List<int[]>> alliances) {
        // 인구 이동이 불가능한 경우 => N * N개 만큼 연합이 나오는 경우
        return alliances.size() == N * N;
    }

    // 새로운 좌표가 탐색 범위 안에 있는지 확인하기 위한 함수
    static boolean boundCheck(int y, int x) {
        return y >= 0 && y < 2 * N - 1 && x >= 0 && x < 2 * N - 1;
    }

    // 연합을 만들기 위한 BFS
    static List<int[]> bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();    // 탐색을 위한 큐
        queue.add(new int[] {y, x});                // 큐에 현재 점 추가
        visited[y][x] = 1;                          // 방문 여부 체크
        List<int[]> result = new ArrayList<>();     // 연맹을 저장할 리스트

        // 큐가 비어있지 않다면
        while (!queue.isEmpty()) {
            // 큐에서 값을 빼 현재 위치로 초기화
            int[] curr = queue.poll();

            // 경계가 아닌 국가일 때만 연맹에 추가
            if (map[curr[0]][curr[1]] != -2)
                result.add(curr);

            // 상하좌우 이동을 통해 탐색 진행
            for (int i = 0; i < 4; i++) {
                int newY = curr[0] + dy[i];
                int newX = curr[1] + dx[i];

                // 새로운 좌표가 경계 내에 있고 국경이 막혀있지 않으면서 방문하지 않았다면
                if (boundCheck(newY, newX) && map[newY][newX] != -1 && visited[newY][newX] == 0) {
                    // 새로운 좌표를 큐에 삽입
                    queue.offer(new int[] {newY, newX});
                    // 방문 여부 체크
                    visited[newY][newX] = 1;
                }
            }
        }

        return result;  // 결과 반환
    }

    // 경계를 결정할 함수
    static void determineBound() {
        // 가로 경계 세팅
        for (int i = 0; i < 2 * N - 1; i += 2) {
            for (int j = 0; j < 2 * N - 2; j += 2) {
                int diff = Math.abs(map[i][j] - map[i][j+2]);
                if (L <= diff && diff <= R) {
                    map[i][j+1] = -2;  // 국경선 열기
                    visited[i][j+1] = 0;
                } else {
                    map[i][j+1] = -1;  // 국경선 닫기
                    visited[i][j+1] = -1;
                }
            }
        }

        // 세로 경계 세팅
        for (int i = 0; i < 2 * N - 1; i += 2) {
            for (int j = 0; j < 2 * N - 2; j += 2) {
                int diff = Math.abs(map[j][i] - map[j+2][i]);
                if (L <= diff && diff <= R) {
                    map[j+1][i] = -2;  // 국경선 열기
                    visited[j+1][i] = 0;
                } else {
                    map[j+1][i] = -1;  // 국경선 닫기
                    visited[j+1][i] = -1;
                }
            }
        }
        // 교차점은 항상 국경 닫힘 처리
        for (int i = 1; i < 2 * N - 1; i += 2) {
            for (int j = 1; j < 2 * N - 1; j += 2) {
                map[i][j] = -1;
                visited[i][j] = -1;
            }
        }
    }

    // 연맹을 맺어서 인구를 업데이트 할 함수
    static void updatePopulation(List<List<int[]>> alliances) {
        List<Integer> avg = new ArrayList<>();

        // 연맹 국가의 인구수 평균을 구함
        for (List<int[]> alliance : alliances) {
            int sum = 0;
            for (int[] row : alliance) {
                sum += map[row[0]][row[1]];
            }
            avg.add(sum / alliance.size());
        }

        // 구한 인구수 평균으로 연맹 국가의 인구수를 업데이트
        for (int i = 0; i < alliances.size(); i++) {
            List<int[]> alliance = alliances.get(i);
            for (int j = 0; j < alliance.size(); j++) {
                int[] row = alliance.get(j);
                map[row[0]][row[1]] = avg.get(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 땅의 크기
        L = Integer.parseInt(st.nextToken());   // 인구 차이 최소
        R = Integer.parseInt(st.nextToken());   // 인구 차이 최대

        map = new int[2 * N - 1][2 * N - 1];    // 국가 및 경계 저장 배열

        // 초기화: 모든 칸을 기본값 -2 (국경 열림)으로 설정
        for (int i = 0; i < 2 * N - 1; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                map[i][j] = -2;
            }
        }

        // 실제 국가 값 입력 (짝수 행, 짝수 열)
        for (int i = 0; i < 2 * N - 1; i += 2) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2 * N - 1; j += 2) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;    // 인구 이동이 며칠 동안 발생하는지 저장할 변수
        while (true) {
            visited = new int[2 * N - 1][2 * N - 1]; // 방문 여부 배열 초기화

            determineBound();   // 국경 설정

            // 연맹들을 저장할 리스트
            List<List<int[]>> alliances = new ArrayList<>();

            // 모든 칸을 돌며 BFS 탐색
            for (int i = 0; i < 2 * N - 1; i++) {
                for (int j = 0; j < 2 * N - 1; j++) {
                    List<int[]> alliance = new ArrayList<>();

                    // 방문하지 않았다면
                    if (visited[i][j] == 0)
                        // BFS 탐색을 통해 연맹 국가들을 알아내서 반환
                        alliance = bfs(i, j);

                    // 연맹 국가가 비어 있지 않다면
                    if (!alliance.isEmpty())
                        // 연맹들을 저장할 리스트에 추가
                        alliances.add(alliance);
                }
            }

            // 인구 이동이 불가능한 경우 반복문 종료
            if (isNotMoveable(alliances))
                break;

            day++;  // 인구 이동 발생 일수 증가
            updatePopulation(alliances);    // 인구수 업데이트
        }

        System.out.println(day);    // 결과 출력
    }
}
