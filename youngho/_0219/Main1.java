package _0219;

import java.util.*;

public class Main1 {
    static int[][] map;
    static int N, M, D;
    static boolean[] visited;
    static int[] temp;
    static Set<Point> set =  new HashSet<>();

    // Point Class -> y1, y2, y3 가지고 있음
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();

        map = new int[N][M];





    }


    static void solve(int day, int[][] map, Point point, int count ){
        if(day > 0){
            downMap(map);
        }
        // 같은곳 공격 - 상괸없는말임
        // 공격해서 없애야 함




    }



    static void downMap(int [][] map){
        // N, M
        // 밑에는 N - 1이겠지
        for(int i = N - 2; i >= 0; i--){
            for(int j = 0; j < M; j++){
                map[i + 1][j] = map[i][j];
            }
        }
    }

    static void back(int depth){
        if(depth == 3){
            Point point = new Point(temp[0], temp[1], temp[2]);

            if(!set.contains(point)){
                solve(0, map.clone(), point, 0);
            }

            return;
        }

        for(int i = 0; i < M; i++){

            visited[i] = true;
            temp[depth] = i;
            back(depth + 1);
            visited[i] = false;

        }

    }



    static class Point{
         int y1, y2, y3;

        public Point(int y1, int y2, int y3) {
            this.y1 = y1;
            this.y2 = y2;
            this.y3 = y3;
        }

        @Override
        public boolean equals(Object obj) {
            return y1 == ((Point)obj).y1 && y2 == ((Point)obj).y2
                    && y3 == ((Point)obj).y3;
        }

        @Override
        public int hashCode() {
            return y1 + y2 + y3;
        }
    }


}
//5 5 1
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//1 1 1 1 1
