import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_숨바꼭질_문영호 {
    
    static int N;
    static int K;

    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        visited = new boolean[100001];
        arr = new int[100001];
        System.out.println(BFS(N, K));

    }

    static int BFS(int N, int K){
        if(N == K) return 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);

        arr[N] = 0;
        visited[N] = true;
        while(true){
            int x = queue.poll();

            if(x == K){
                return arr[x];

            }
            
            for(int nx : new int[]{ x - 1, x + 1, x * 2}){
                if(nx >= 0 && nx <= 100000 && !visited[nx]){
                    visited[nx] = true;
                    arr[nx] = arr[x] + 1;
                    queue.offer(nx);
                }

            }
            

        }
    }
    
}

//5 17