package _0220;


import java.util.*;

// 괄호 짝짓기
// 괄호 이해
// {}{}{} OK
// {{ <>> X
// 짝이 맞아야함
// 4종류니 스택에 넣고 뽑았을 때 짝이 아니면 멈추면 된다


public class SWEA_1218_괄호짝짓기_문영호 {
    static StringBuilder sb = new StringBuilder();
    static Set<Character> left = new HashSet<>();
    static Set<Character> right = new HashSet<>();

    static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        left.add('<');
        left.add('{');
        left.add('(');
        left.add('[');

        right.add('>');
        right.add('}');
        right.add(')');
        right.add(']');


        for(int t = 1; t <= 10; t++){
            Deque<Character> stack = new ArrayDeque<>();
            int N = sc.nextInt();
            sc.nextLine();
            String input = sc.nextLine();
            flag = false;
            sb.append("#").append(t).append(" ");

            for(int i = 0; i < N; i++){
                char a = input.charAt(i);
                if(left.contains(a)){
                    stack.push(a);
                }else{ // right
                    char x  = stack.pop();
                    // 아직 논리적인 사고가 부족해서 보기 편하게
                    // ex ) > 일때 < 가 아니면 플래그를 트루로 두고 for문 빠져나감
                    //
                    if(a == '>'){
                        if(x != '<'){
                            flag = true;
                            break;
                        }
                    }else if(a == '}'){
                        if(x != '{'){
                            flag = true;
                            break;
                        }
                    }else if(a == ')'){
                        if(x != '('){
                            flag = true;
                            break;
                        }
                    }else if(a == ']'){
                        if (x != '[') {
                            flag = true;
                            break;
                        }
                    }
                }
            }

            if(flag){
                sb.append(0);
            }else
                sb.append(1);

            sb.append("\n");
        }
        System.out.println(sb.toString());

    }


}

