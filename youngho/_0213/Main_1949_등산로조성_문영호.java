package _0213;

import java.util.*;
import java.util.Scanner;

public class Main_1949_등산로조성_문영호 {

    /**
     * 1.높은 봉우리 에서 시작
     * 2. visited 따로 안만들고 낮은 봉우리 나오면 추가하는걸로
     * 3. 딱 한번 자기보다 높은 봉우리를 만나면 제거 가능
     * 봉우리를 -1 하기 k 다돌ㄹ지 말고
     */
    static int N, K, T;
    static int[][] arr;
    static int maxResult = Integer.MIN_VALUE;
    static int maxMountain = 0;
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            maxResult = 0;
            maxMountain = 0;
            N = sc.nextInt();
            K = sc.nextInt();
            arr = new int[N][N];
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    arr[i][j] = sc.nextInt();
                    if(maxMountain < arr[i][j]){
                        maxMountain  = arr[i][j];
                    }
                }
            }

            // printArr();

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(arr[i][j] == maxMountain){
                        visited[i][j] = true;
                        DFS(i, j, maxMountain, 1, K);
                        visited[i][j] = false;
                    }
                }
            }
            sb.append("#" +t + " "  + maxResult).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void printArr(){
        sb.append("=================== ").append("\n");
        for(int[] aa : arr){
            for(int a : aa){
                sb.append( a + " ");
            }
            sb.append("\n");
        }
        sb.append("=================== ").append("\n");
    }

    static void DFS(int x, int y, int treeHeight, int count, int k){
        maxResult = Math.max(count, maxResult);

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!isIn(nx, ny) || visited[nx][ny])
                continue;

            // 산 안깍을을 때
            // 산 깎았을 때

            if(k == 0  &&  arr[nx][ny] < treeHeight){ // 이미 깎았을 경우
                visited[nx][ny] = true;
                DFS(nx, ny , arr[nx][ny], count + 1, k);
                visited[nx][ny] = false;
            }else if(k > 0){
                // 산을 깎은 적이 없고
                // 산의 크기가 작을 때
                if( arr[nx][ny] < treeHeight){
                    visited[nx][ny] = true;
                    DFS(nx, ny , arr[nx][ny], count + 1, k);
                    visited[nx][ny] = false;
                }else if(  (arr[nx][ny] - K) < treeHeight){
                    visited[nx][ny] = true;
                    DFS(nx, ny , treeHeight -1, count + 1, 0);
                    visited[nx][ny] = false;
                }
            }

        }

    }

    static boolean isIn(int x, int y){
        return x>= 0 && x < N && y >= 0 && y < N ;
    }

}