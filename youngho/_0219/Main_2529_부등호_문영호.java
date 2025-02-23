//package _0219;
//
//import java.util.*;
//
//
//// 시간제한 1초
//// 메모리 256MB
//
//// 부등호 개수 K
////  < >
//// 이면 1 < 2 > 3 이런식으로 들어가는거임
//// 골라야 할 숫자는 k + 1 개
//
//// 백트레킹으로 K + 1 만큼 뽑고
//// 백트레킹 -> 앞에 0부터 넣으니 이미 정렬되어있음
//// 조건에 맞으면 리스트에 넣음
//// 최소값을 찾았다면 최대값으로 넘어가는 방법이 있을까나
//
//// 백트레킹 K!
//// k <= 9 이니 36만 1초 충분
//public class Main_2529_부등호_문영호 {
//    // K부등호 개수
//    static int K;
//    // list - 부등호 넣는곳 < >
//    static List<String> list = new ArrayList<>();
//    // 결과 넣을곳
//    static List<String> result = new ArrayList<>();
//    // visited - 순열뽑을 때
//    static boolean[] visited;
//    // 순열 놓는곳
//    static int[] temp ;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        K = sc.nextInt() ; // K + 1 만큼
//        // 입력 받고
//        temp = new int[K + 1];
//        visited = new boolean[10 ];
//        for(int i = 0; i < K; i++){
//            list.add(sc.next());
//        }
//        // 백트레킹으로 순열 뽑아서 고고
//        back(0);
//        // 최대값 - 마지막에 넣은값
//        System.out.println(result.get(result.size() - 1));
//        // 최소값 - 맨 처음에 넣은값
//        System.out.println(result.get(0));
//
//    }
//    //
//    static void back(int depth){
//        // K + 1만큼 뽑았다면
//        if(depth == K + 1){
//            // 확인작업
//            // 1 < 2 < 3 이라면
//            // 0 0 1 1 2
//            // 부등호의 인덱스와
//            // 숫자의 인덱스를 따로보면
//            // 숫자[i] 부등호 [i] 숫자[i + 1] 인것을 알 수 있음
//            // 그대로 구현
//            for(int i = 0; i < K ; i++){
//                int x = temp[i];
//                int y = temp[i + 1];
//                String s = list.get(i);
//                if(s.equals(">")){
//                    // System.out.println();
//                    // System.out.println(">" + (x > y));
//                    if(!(x > y)){
//                        return;
//                    }
//                }else if (s.equals("<")){
//                    if(!(x < y)){
//                        return;
//                    }
//                }
//
//            }
//            // 리턴하지 않았다면 통과된거임
//            // 그대로 리스트에 넣어줌
//            StringBuilder sb1 = new StringBuilder();
//            for(int i = 0; i < K + 1; i++){
//                sb1.append(temp[i]);
//            }
//            result.add(sb1.toString());
//
//            return;
//        }
//        // 이쪽이 먼저 실행되면서 K + 1 만큼 뽑음
//        for(int i = 0; i < 10; i++){
//            if(!visited[i]){
//                visited[i] = true;
//                temp[depth] = i;
//                back(depth + 1);
//                visited[i] = false;
//            }
//        }
//    }
//}
//
////2
////< >
