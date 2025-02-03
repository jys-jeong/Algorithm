package _0203.J_1303;

import java.util.Scanner;

// 정올 1856 숫자사각형2
public class J_1303_숫자사각형1_문영호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int row = sc.nextInt();

        int[][] arr = new int[col][row];

        int cnt = 1;
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
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

// 4 5 <- 입력
// 1 2 3 4 5
//6 7 8 9 10
//11 12 13 14 15
//16 17 18 19 20