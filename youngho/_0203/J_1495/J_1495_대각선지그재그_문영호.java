package _0203.J_1495;

import java.util.Scanner;

public class J_1495_대각선지그재그_문영호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int x = 0;
        int y = 0;

        int[][] arr = new int[n][n];
        int cnt = 1;
        while(x != n -1 && y != n-1){
            arr[x][y] = cnt++;

            if( x + 1 >= n - 1){
                y++;
            }else
                x++;
            arr[x][y] = cnt++;

            while(x > 1 || y <= n -1){
                arr[x--][y++] = cnt++;
            }

            if(y + 1 < n - 1){
                y++;
            }else
                x--;

            arr[x][y] = cnt++;
            while(x >= 0 || y <= n -1){
                arr[x++][y--] = cnt++;
            }

        }



    }


}
