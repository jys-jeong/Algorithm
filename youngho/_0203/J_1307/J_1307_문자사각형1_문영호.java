package _0203.J_1307;

import java.util.Scanner;


// 그림그려가며 열을 먼저 출력하기
// 항상 행을 먼저 생각해서 배열 다루는 기술이 부족하다고 느낌
public class J_1307_문자사각형1_문영호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] arr = new int[N][N];

        int alpha = 'A';
        for(int i = N-1; i >= 0; i--){
            for(int j = N-1; j >= 0; j--){
                arr[j][i] = alpha++;

                if(alpha == 'Z' + 1)
                    alpha = 'A';
            }
        }

        for(int[] aa : arr){
            for(int a : aa){
                System.out.print((char)a + " ");
            }
            System.out.println();
        }

    }
}
// P L H D
//O K G C
//N J F B
//M I E A
