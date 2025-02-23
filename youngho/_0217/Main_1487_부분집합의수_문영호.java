package _0217;

import java.util.Scanner;
//import java.util.List;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.ArrayList;


public class Main_1487_부분집합의수_문영호 {
    static int T;
    static int N,W;
    static int[] arr;
    static int result;
    static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            N = sc.nextInt();
            W = sc.nextInt();
            sum = 0;
            arr = new int[N];
            result = 0;
            for(int i = 0; i < N; i++){
                arr[i] = sc.nextInt();
//                sum += arr[i];
            }
            // 비트마스킹 N * 2 ^ N
            // 지금 문제는 N이 65면 오버플로우 발생이지
            // 1 << N
            // 1 << 31 이상이면 오버플로우 발생
//            for(int i = 0; i < (1 << N) ; i++){
//                sum = 0;
//                for(int j = 0; j < N; j++){
//                    if( (i & (1 << j)) != 0){
//                        sum += arr[j];
//                    }
//                }
//
//                if(sum == W){
//                    result++;
//                }
//            }

//            result = meetInTheMiddle();

            System.out.println(result);

        }

    }

//    public static int meetInTheMiddle(){
//        int n = arr.length;
//        int mid = n / 2;
//
//        int []left = Arrays.copyOfRange(arr, 0, mid);
//        int [] right = Arrays.copyOfRange(arr, mid, n);
//
//        List<Integer> leftSums = getSubsetSums(left);
//        List<Integer> rightSums = getSubsetSums(right);
//
//        int count = 0;
//        for(int sum : leftSums){
//            int complement = W - sum;
//            count += Collections.frequency(rightSums, complement);
//        }
//
//
//        return count;
//    }

//    public static List<Integer> getSubsetSums(int[] subset){
//        int size = subset.length;
//        List<Integer> sums = new ArrayList<>();
//        for(int i = 0; i < (1 << size) ; i++){
//            int sum = 0;
//            for(int j = 0; j < size; j++){
//                if((i & (1 << j)) != 0){
//                    sum += subset[j];
//                }
//            }
//            sums.add(sum);
//        }
//
//        return sums;
//    }
}
