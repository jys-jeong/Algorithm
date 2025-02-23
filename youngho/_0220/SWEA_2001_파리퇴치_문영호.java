package _0220;

import java.util.Scanner;

// 첫번째 시도
// 완전탐색 . M 만큼 배열 전부 돌아서 합이 최대인곳
// 아무리 생각해도 비효율임 슬라이딩윈도우 를 적용하자니 너무 귀찮고
// 두번째 시도
// 누적합 이라는 개념을 검색해서 알아봄
//
// 누적합?
// 1 2 3
// 4 5 6
/**
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * 배열로 보지말고 크게 네모를 그려보자
 * 6 까지의 합은
 * 1 2 3
 * 4 5 6 으로 표현될것임
 *
 * 1 2 3
 *
 * +
 *
 * 1 2
 * 4 5
 *
 * + (자기 자신) 6
 *
 * - 겹치는부분 1 2
 *
 * 이걸 구현하면 됌
 *
 * 1, 1 -> N, N으로 표현하고
 *
 * 0 0 0 0
 * 0 1 2 3
 * 0 4 5 6
 * 0 7 8 9
 *
 * -> 이 배열을 미리 위에서 정해둔 규칙으로 바꿈
 *
 * 그러면 1,2 자리에는 3이들어갈텐데
 *  네모로 보면 됌 1 2
 *
 *  prefixSum(3,3) ->
 *  prefixSum(3, 2) + prefixSum (2, 3)
 *  - prefixSum(2, 2) + arr[3][3]
 *
 *  공식
 *
 *  pre[i][j] = pre[i -1][j] + pre[i][j -1] - pre[i-1][j-1] + arr[i][j]
 *
 *  추가 - 입력받을 때 그냥 섬으로 바꿔놔도 상관없음
 *
 *
 * */
public class SWEA_2001_파리퇴치_문영호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 1; t <= T; t++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr  = new int[N + 1][N + 1];
            for(int i = 1 ; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] +  sc.nextInt();
                }
            }

//        printArr(arr);

            int result = -1;
            for(int i = M; i <= N; i++){
                for(int j = M; j <= N; j++){
                    int sum = arr[i][j] - arr[i - M][j] - arr[i][j - M] + arr[i - M][j - M];
                    result = Math.max(result, sum);
                }
            }

            System.out.println("#" + t + " " + result);



        }



    }
    static void printArr(int[][] arr){
        for(int[] xx : arr){
            for (int x : xx){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

//5 2
//1 3 3 6 7
//8 13 9 12 8
//4 16 11 12 6
//2 4 1 23 2
//9 13 4 7 3
