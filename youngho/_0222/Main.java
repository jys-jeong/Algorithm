package _0222;

import java.util.Scanner;

public class Main {
    //재귀로 부분집합 을 표시해야겠네요
    static int N, M;
    static boolean[] isSelected;
    static int[][] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        temp = new int[N][M];

        for(int i = 0; i < N ; i++){
            for(int j = 0; j < M; j++){
                temp[i][j] = sc.nextInt();
            }
        }
        System.out.println(check());
    }

    static boolean check() {
        for (int col = 0; col < M; col++) {
            int before = temp[0][col];
            int maxCount = -1;
            int count = 1;
            for (int row = 1; row < N; row++) {
                if (before == temp[row][col]) {
                    count++;
                } else { // 다르면
                    before = temp[row][col];
                    count = 1;
                }

                if (count >= 2) {
                    continue;
                }
            }
            if(count < 2){
                return false;
            }
        }
        return  true;
    }

}
