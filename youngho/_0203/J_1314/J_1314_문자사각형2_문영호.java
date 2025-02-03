package _0203.J_1314;

import java.util.Scanner;

// 열이 고정되어 있고 열의 값이 0 또는 짝수일때 밑으로
// 홀수면 위로 올리기
public class J_1314_문자사각형2_문영호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];

        int alpha = 'A';
        for(int i = 0; i < N; i++){
            if(  i % 2 == 0){
                for(int j = 0; j < N; j++ ){
                    arr[j][i] = alpha++;

                    if(alpha == 'Z' + 1)
                        alpha = 'A';
                }
            }else{
                for(int j = N - 1; j >= 0; j--){
                    arr[j][i] = alpha++;

                    if(alpha == 'Z' + 1)
                        alpha = 'A';
                }
            }
        }
        for(int[] xx : arr){
            for(int x : xx){
                System.out.print((char)x + " ");
            }
            System.out.println();
        }
    }
}
//A H I P
//B G J O
//C F K N
//D E L M