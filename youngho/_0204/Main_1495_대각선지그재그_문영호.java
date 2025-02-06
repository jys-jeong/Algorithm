package _0204;

import java.util.Scanner;

public class Main_1495_대각선지그재그_문영호 {

    static int[] dx = {-1, 1};
    static int[] dy = {1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int currentX = 0;
        int currentY = 0;
        int cnt = 1;

        arr[currentX][currentY] = cnt++;

        while(cnt < n * n){
            // 아래로 한칸 내리기 불가능하면 오른쪽으로 한칸
            if(currentX == n-1){
                currentY++;
            }else{
                currentX++;
            }
            // 한개 찍고
            arr[currentX][currentY] = cnt++;

            // 오른쪽 위 대각선으로 올리기
            while(currentX > 0 && currentY < n - 1){
                currentX += dx[0];
                currentY += dy[0];

                arr[currentX][currentY] = cnt++;
            }

            // 오른쪽으로 한칸 불가능하면 아래로

            if(currentY == n-1){
                currentX++;
            }else{
                currentY++;
            }

            arr[currentX][currentY] = cnt++;

            while(currentX < n-1 && currentY > 0){
                currentX += dx[1];
                currentY += dy[1];

                arr[currentX][currentY] = cnt++;
            }

        }

        for(int[] xx : arr){
            for(int x : xx){
                System.out.print(x + " ");
            }
            System.out.println();
        }


    }
}

