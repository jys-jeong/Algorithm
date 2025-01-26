import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int side[][] = new int[101][101];
		
		for(int i = 0; i < N; i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			
			for(int r = R; r < R + 10; r++) {
				for(int c = C; c < C + 10; c++) {
					side[r][c] = 1;
				}
			}
		}
		
		int answer = 0;
		
		for(int r = 0; r < 101; r++) {
			for(int c = 0; c < 101; c++) {
				answer += side[r][c];
			}
		}
			System.out.println(answer);
	}
}

