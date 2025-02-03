package _0203.J_1856;

import java.util.Scanner;

public class J_1856_숫자사각형2_문영호 {
    public static void main(String[] args) {
        // n 높이 m 너비
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        int cnt = 1;
        for(int i = 0; i < n; i++){
            if(i % 2 == 0) {
                for(int j = 0; j < m; j++){
                    arr[i][j] = cnt++;
                }
            }else
                for(int j = m - 1; j >=0 ; j--){
                    arr[i][j] = cnt++;
                }

        }

        for(int[] aa : arr){
            for(int a : aa){
                System.out.print(a + " ");
            }
            System.out.println();
        }


    }
}

//1 2 3 4 5
//10 9 8 7 6
//11 12 13 14 15
//20 19 18 17 16