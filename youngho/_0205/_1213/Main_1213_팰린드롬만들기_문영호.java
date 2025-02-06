package _0205._1213;


import java.util.Scanner;

// AAB < ABB 사전순

// 문자의 개수 중 홀수가 2 이상이면 팰린드롬이 아님
// AABAA 를 만드려면
// 왼쪽에 AA 만들고 reverse하면 된다.
// 왼쪽 문자열 만들기 : A가 4개이니 /2 2쓰면 된다.
// 홀수면 홀수인 문자 기억해서 가운데 넣어주기
// left + if(홀수면 OddChar) + left.reverse
public class Main_1213_팰린드롬만들기_문영호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        // 0~ z까지 int arr만들고
        int[] arr = new int['z' + 1];

        // arr[A] <- +1
        // char -> int 자동
        for(int i = 0; i < input.length(); i++){
            arr[input.charAt(i)] += 1;
        }

        int oddCount = 0;
        char oddChar= 'A';

        StringBuilder left = new StringBuilder();
        for(int i = 'A'; i <= 'z'; i++){
            // 홀수면 oddCount 1증가
            if(arr[i] % 2 == 1){
                oddCount++;
                if(oddCount > 1){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                oddChar = (char)i;
            }
            // 0이 아니면 StringBuilder에 개수/2 만큼 넣기
            if(arr[i] != 0) {
                for(int j = 0; j < arr[i]/2; j++){
                    left.append((char)i);
                }
            }
        }


//        System.out.println(left.toString());
        // 홀수가 있으면 left OddChar left.reverse
        if(oddCount == 1){
            System.out.println(left.toString() + oddChar +left.reverse().toString());
        }else {
            // 없으면 left + left.reverse
            System.out.println(left.toString() + left.reverse().toString());
        }

    }
}
