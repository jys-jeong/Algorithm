package _0203.J_1339;



import java.util.Scanner;
// 삼각형의 높이 N을 입력받아서 아래와 같이 문자 'A'부터 차례대로 맨 오른쪽 가운데 행부터 차례대로 아래와 같이 채워서 
//
//삼각형 모양을 출력하는 프로그램을 작성하시오.
//
//(1) 오른쪽 가운데 행에 문자 'A'를 채우고 왼쪽 열로 이동하여 위에서 아래로 채워나간다.
//(2) 가장 왼쪽 행까지 반복하여 모두 채워 나간다. (문자 'Z'다음에는 'A'부터 다시 시작한다.)

// 어렵당

public class J_1339_문자삼각형2_문영호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if( (N < 1 || N >=100 )  ||  N % 2 == 0) {

            System.out.println("INPUT ERROR");
            return;
        }

        int[][] arr = new int[N][N];

        char alpha = 'A';

        for(int i = N / 2; i >= 0; i-- ){
            for(int j = i; j < N - i; j++){
                arr[j][i] = alpha++;

                if(alpha == 'Z' + 1)
                    alpha = 'A';
            }
        }

        for(int[] ar : arr){
            for(int x : ar){
                if( 'A' <= x && x <= 'Z' )
                    System.out.print((char)x + " ");
            }
            System.out.println();
        }


    }
}

//E
//F B
//G C A
//H D
//I