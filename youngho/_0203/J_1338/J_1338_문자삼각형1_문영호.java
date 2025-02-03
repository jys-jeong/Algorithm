package _0203.J_1338;

import java.util.Scanner;

// 정올 문자열 출력

public class J_1338_문자삼각형1_문영호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        char [][]arr = new char[N+1][N+1];

        char alpha = 'A';

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                arr[i][j] = ' ';
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = i, k = N; j <= N; j++, k--){
                arr[j][k] = alpha++;

                if(alpha > 'Z'){
                    alpha = 'A';
                }
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                System.out.printf("%2c" , arr[i][j]);

            }
            System.out.println();

        }
    }
}
