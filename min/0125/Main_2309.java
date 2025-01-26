import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] tmp = new int[7];
	static int[] height = new int[9];
	static int flag = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		for(int i = 0; i < 9; i++) {
			height[i] = sc.nextInt();
		}
		Arrays.sort(height);
		dfs(0, 0);
		
		sc.close();
	}
	
	static void dfs(int index, int depth) {
		if(depth == 7) {
			if(Arrays.stream(tmp).sum() == 100 && flag == 0) {
				for(int i = 0; i < 7; i++) {
					System.out.println(tmp[i]);
					flag = 1;
				}
			}
			return;
		}
		
		for(int i = index; i < 9; i++) {
			tmp[depth] = height[i]; 
			dfs(i + 1, depth + 1);
		}
	}
}