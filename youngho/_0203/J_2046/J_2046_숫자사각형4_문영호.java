package _0203.J_2046;

import java.util.Scanner;

public class J_2046_숫자사각형4_문영호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int type = sc.nextInt();
        int[][] arr = new int[n][n];

        rect(arr, type);


        for(int[] aa : arr){
            for(int a : aa){
                System.out.print(a + " ");
            }
            System.out.println();
        }

    }

    public static void rect(int[][] arr, int type){
        switch (type){
            case 1:
                 rect1(arr);
                 break;
            case 2:
                rect2(arr);
                break;
            case 3:
                rect3(arr);
                break;
        }

    }

    public static void rect1(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = i + 1;
            }
        }
    }
    // 1 1 1
    // 2 2 2
    // 3 3 3

    public static void rect2(int[][] arr){

        for(int i = 0; i < arr.length; i++){
            int cnt = 1;
            if(i % 2 == 0){
                for(int j = 0; j < arr[i].length; j++){
                    arr[i][j] = cnt++;
                }
            }else {
                for(int j = arr.length - 1; j >= 0; j--){
                    arr[i][j] = cnt++;
                }
            }
        }
    }
    // 1 2 3 4
    // 4 3 2 1
    // 1 2 3 4
    // 4 3 2 1


    public static void rect3(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = (i + 1) * (j + 1);
            }
        }
    }
}

