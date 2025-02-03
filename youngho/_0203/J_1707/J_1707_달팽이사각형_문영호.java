package _0203.J_1707;

import java.util.Scanner;

// 1495 대각선 지그재그 
// bottom , top, left, right 두고
// 맨 윗줄부터 오른쪽으로 가면 bottom 한칸 올리고
// 오른쪽 줄 다 채우면 왼쪽으로 한칸 가고
// 맨 아랫줄 다 채우면 top 한칸 줄이고
// 종료 조건 -> left > right && bottom > top

public class J_1707_달팽이사각형_문영호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        int bottom = 0;
        int left = 0;
        int right = n -1;
        int top = n -1;

        int cnt = 1;

        while(bottom <= top && left <= right){
            for(int i = left; i <= right; i++)
                arr[bottom][i] = cnt++;

            bottom++;

            for(int i = bottom; i <= top; i++)
                arr[i][right] = cnt++;

            right--;

            for(int i = right; i >= left; i--)
                arr[top][i] = cnt++;

            top--;

            for(int i = top; i >= bottom; i--)
                arr[i][left] = cnt++;

            left++;
        }

        for(int[] aa : arr){
            for(int a : aa){
                System.out.print(a + " ");
            }
            System.out.println();
        }


    }
}

// 1 2 3 4 5
//16 17 18 19 6
//15 24 25 20 7
//14 23 22 21 8
//13 12 11 10 9