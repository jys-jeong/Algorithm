package _0221;
import java.util.*;


// 비트 마스킹임
// 11111111
// 00000001 로 이런식으로 처리 


public class Main_11723_집합_문영호 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int set = 0;
        for(int i = 0; i < M; i++){
            String input = sc.next();
            int a = 0;
            if(!(input.equals("all") || input.equals("empty"))){
                a = sc.nextInt();
            }

            if(input.equals("add")){
                set = set | (1 << (a - 1)); // a번째 비트를 1로 설정한다.
            }else if(input.equals("check")){
                if((set & (1 << (a - 1))) != 0 ){ // a 가 포함되어 있다면 1
                    // System.out.println(1);
                    sb.append(1);
                }else{ // 아니면 0
                    // System.out.println(0);
                    sb.append(0);
                }
                sb.append("\n");
            }else if(input.equals("remove")){
                if((set & (1 << (a - 1))) != 0) // 1 XOR 1 = 0 → 존재하면 제거됨.
                                                // 0 XOR 1 = 1 → 존재하지 않으면 그대로 유지됨.
                    set = set ^ (1 << (a - 1));
            }else if(input.equals("toggle")){
                set = set ^ (1 << (a - 1));
                // 1 XOR 1 = 0 → 존재하면 제거.
                // 0 XOR 1 = 1 → 존재하지 않으면 추가.
            }else if(input.equals("all")){
                set = (int)Math.pow(2, 20) -1;
                // 다 1로
            }else if(input.equals("empty")){
                set = 0;
            }
            // System.out.println(Integer.toBinaryString(set));
        }

        System.out.println(sb.toString());
    }



}