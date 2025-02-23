package _0220;

import java.util.*;


// 햄버거 다이어트
// 조합 뽑아서 ->
// 칼로리가 limit 이하일 때
// max 체크하고
// M 이 최대


public class SWEA_5215_햄버거다이어트_문영호 {

    static int N, limit; // 이하임
    static int max;
    static List<int[]> list ;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 1; t <= T; t++){

            N = sc.nextInt();
            limit = sc.nextInt();
            max = Integer.MIN_VALUE;
            list = new ArrayList<>();

            for(int i =0; i < N; i++){
                int score = sc.nextInt();
                int cal = sc.nextInt();

                list.add(new int[]{score, cal});
            }

            back(0, 0, 0, 0);

            sb.append("#").append(t).append(" ").append(max).append("\n");

        }
        System.out.println(sb.toString());
    }

    static void back(int depth, int startWith, int sumSatis , int sumCal){

        if(sumCal <= limit){
            max = Math.max(max, sumSatis);
        }else{
            return;
        }

        if(depth == N){
            return;
        }

        for(int i = startWith; i < N; i++){
            int[] cur = list.get(i);
            // 왼쪽이 만족
            // 오른쪽이 칼로리
            back(depth + 1, i + 1, sumSatis + cur[0], sumCal + cur[1]);

        }
    }


}

//1
// 5 1000
// 100 200
// 300 500
// 250 300
// 500 1000
// 400 400