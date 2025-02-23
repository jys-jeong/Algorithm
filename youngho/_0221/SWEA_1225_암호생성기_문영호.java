package _0221;

import java.util.Scanner;

// 8 자리 수
// 5개 왼쪽으로 주어지는 수는 Integer.max 가 올 수도 있음
// 숫자가 크니 규칙을 찾아보자
// 1의 위치만 주목
// 1 2 3 4 5 6 7 8
// 8 cycle 돌면
// 1 2 3 4 5 6 7 8 있고 -15 가 된다.

// 생각할 거 input 값 중 min 값 뽑아서
// min /  15 -> 하면
// 값이 5면  15 * 4 만큼 다른 인풋도 나눠주고
// 규칙대로 몇번 돌리면 된다.

// min / 15  에서 - 1  하는 이유는 /15 로 나누게 되면 나머지가 15 이하면
// 1 이면 싸이클을 제대로 못타서 15 이상이 남게 함
// 그러면 min 이 0 이면 탈출하기 때문에 for문 안에 넉넉하게 30번 돌림
// 예측으론 8 번인데 최대 16번


public class SWEA_1225_암호생성기_문영호 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int t = 1; t <= 10; t++){

            int min = Integer.MAX_VALUE;
            int minX = 0;
            int[] input = new int[8];
            sc.nextInt();
            for(int i = 0; i < 8; i++){
                input[i] = sc.nextInt();
                if(input[i] < min ){
                    min = input[i];
                    minX = i;
                }
            }
            // 8 cycle 마다 -15 반복
            // 똑같은 자리에
            int div = input[minX] / 15;
            div--;

            for(int i = 0; i < 8; i++){
                input[i] = input[i] - (div * 15);
            }

            // min 은 14 이하이니 8 cycle 안에 끝날것임

            for(int i = 0; i < 100; i++){
                boolean flag = false;
                for(int c = 1; c <= 5; c++){
                    int x = input[0] - c;
                    for(int j = 0; j < 7; j++){
                        input[j] = input[j + 1];
                    }
                    input[7] = x;

                    if(x <= 0){
                        flag = true;
                        input[7] = 0;
                        break; // c 돌린 포문 빠져나가고
                    }
                }
                if(flag){
                    break;
                }
            }
            sb.append("#").append(t).append(" ");
            for(int x : input){
                sb.append(x).append( " ");
            }
            sb.append("\n");

        }


        System.out.println(sb.toString());

    }

}