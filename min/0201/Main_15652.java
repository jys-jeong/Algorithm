import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] temp;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);      
        N = sc.nextInt();
        M = sc.nextInt();
        sc.close();
        
        temp = new int[M];
         
        dfs(1, 0);
        System.out.println(sb);
    }
    
    static void dfs(int index, int depth) {
    	if(depth == M) {
    		for(int i = 0; i < M; i++) {
    			sb.append(temp[i] + " ");
    		}
    		sb.append("\n");
    		return;
    	}
    	
    	for(int i = index; i <= N; i++) {
    		temp[depth] = i;
    		dfs(i, depth + 1);
    	}
    }
}