package _0219;

import java.util.Arrays;
import java.util.Scanner;

// 메모리
// 시간 100개 6초


// 카드 18장 중 9 장씩 나눠가짐
// 규영이는 순서가 정해진 9장을 미리 뽑음
// 인영이는 남은 카드 9 장을 내야함. -> 9P9 -> 9! 백트레킹으로 순열 찾기
// 10! -> 360만, 9! -> 36만
// 36만 * 100 개 -> 36,000,000
// 가능

//



public class SWEA_6808_규영이와인영이의카드게임_문영호 {
    
    static int[] arr1; // 변수명을 좀 잘 써야겠다. 헷갈림
    // 규영이꺼
    static int[] arr2; // 인영이꺼
    static boolean[] gu; // 규영이 카드 이면 true, false -> 인영이카드
    static boolean[] visited; // 순열을 뽑기 위한 방문처리
    static int[] temp; // 순열을 담아두기 위한 배열
    static int winGu, winIn; // 규영이가 이긴횟수, 인영이가 이긴횟수 = 규영이가 진 횟수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 1; t <= T; t++){
            // 규영이는 카드를 9장 가지고있음
            arr1 = new int[9];
            // 인영이도 9장
            arr2 = new int[9];
            //  gu 는 1 ~ 18 그대로 쓰려고 18 + 1 했음
            gu = new boolean[19];
            // 순열
            visited = new boolean[9];
            // 순열
            temp =new int[9];

            winGu = 0;
            winIn = 0;
            // 규영이 카드~
            for(int i = 0; i < 9; i++){
                arr1[i] = sc.nextInt();
                gu[arr1[i]] = true; // false 는 인영이꺼
            }

            // 인영이 카드~
            int j = 0;
            for(int i = 1; i < 19; i++){
                if(!gu[i]){
                    arr2[j++] = i;
                }
            }
            // printArrs();

            // 순열 뽑기
            back(0);

            System.out.println("#"+ t + " " + winGu + " " + winIn);

        }
    }

    static void back(int depth){
        // 기저조건 0, 1, 2, 3, 4, 5, 6,7, 8 까지 하면 depth 가 9임 
        if(depth == 9){ // 9장을 다 뽑았다면 depth가 8일거임 그 상태에서 한번 더 부르면 9
            // 여기에  규영이 인영이 카드 비교 
            int sumGu = 0;
            int sumIn = 0;

            for(int i = 0; i < 9; i++){
                // 규영이 카드가 이기면
                if(arr1[i] > temp[i]){
                    sumGu += arr1[i] + temp[i];
                }else{ // 인영이 카드가 이긴거 arr1[i] < temp[i] 같을 때는 없음
                    sumIn += arr1[i] + temp[i];
                }

            }
            // 규영이가 이기면 winGu 아니면 winIn;
            if(sumGu > sumIn){
                winGu++;
            }else
                winIn++;

            return;
        }

        // 인영이가 내는거임 규영이는 정해져있음
        for(int i = 0; i < 9; i++){

            // 인영이 카드 9장 중 한장 뽑기 ---> 1장중 1장뽑기
            if(!visited[i]){

                visited[i] = true;
                temp[depth] = arr2[i];
                back(depth + 1);
                visited[i] = false;

            }
        }


    }

    static void printArrs(){
        System.out.println();
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println();
    }
}
