package _0203.J_1304;

import java.util.Scanner;

public class J_1304_숫자사각형3_문영호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        int cnt = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[j][i] = cnt++;
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
