import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[][] side = new boolean[101][101];
		int answer = 0;
		
		for(int rec = 0; rec < 4; rec++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int r = x1; r < x2; r++) {
				for(int c = y1; c < y2; c++) {
					side[r][c] = true;
				}
			}
		}
		
		for(int r = 0; r < 101; r++) {
			for(int c = 0; c < 101; c++) {
				if(side[r][c]) 
					answer += 1;
			}
		}
		
		System.out.println(answer);
	}
}
