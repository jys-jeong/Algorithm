import java.util.Scanner;

public class Main {
	static int bingo[][] = new int[5][5];
	static int address[] = new int[26];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 25; i++) {
			address[sc.nextInt()] = i;
		}
		
		for(int i = 0; i < 25; i++) {
			int RC = address[sc.nextInt()];
			int R = RC / 5;
			int C = RC % 5;	
			bingo[R][C] = 1;
			if(check()) {
				System.out.println(i + 1);
				break;
			}
		}
	}
	
	static boolean check() {
		int line = 0;
		
		for(int i = 0; i < 5; i++) {
			int count1 = 0;
			int count2 = 0;
			for(int j = 0; j < 5; j++) {
					count1 += bingo[i][j];
					count2 += bingo[j][i];
			}
			if(count1 == 5)
				line += 1;
			if(count2 == 5) 
				line += 1;
		} // 행과 열 체크
		
		int count1 = 0;
		int count2 = 0;
		
		for(int i = 0; i < 5; i++) {
			count1 += bingo[i][i];
			count2 += bingo[4-i][i];
		}
		if(count1 == 5) 
			line += 1;
		if(count2 == 5)
			line += 1;
		 // 대각선 체크
		
		return line >= 3;
	}
}

