import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int side[][] = new int[101][101];
		
		for(int i = 1; i <= N; i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			for(int r = R; r < R + w; r++) {
				for(int c = C; c < C + h; c++) {
					side[r][c] = i;
				}
			}
		}
		
		int[] answer = new int[N+1];
		
		for(int r = 0; r < 101; r++) {
			for(int c = 0; c < 101; c++) {
				answer[side[r][c]] += 1;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.println(answer[i]);
		}
	}
}
