package _2605;

import java.util.Scanner;

public class Main {
    // 5
    // 0 1 1 3 2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] array = new int[N];

        array[0] = 1;
        // 맨처음 무조건 0 빼기
        sc.nextInt();

        for(int i = 1; i < N; i++){
            int pass = sc.nextInt();
            for(int j = i ; j > i - pass; j--){
                array[j] = array[j - 1];
            }
            array[i - pass] = i + 1;
        }

        for(int i : array){
            System.out.print(i + " ");
        }
    }
}
