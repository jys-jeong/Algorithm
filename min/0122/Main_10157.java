import java.util.Scanner;

public class Main {
	static int R, C, K;
	static int[][] seat;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
	
		int C = sc.nextInt();
		int R = sc.nextInt();
		int K = sc.nextInt();
		seat = new int[R][C];
		
		int count = 1; 
		int r = R-1;
		int c = 0;
		
		while(count < R * C - 1) { 
			while(r-1 >= 0 && seat[r-1][c] == 0) { // 상
    			seat[r][c] = count; 
    			r--; 
    			count++; 
    		}
			
    		while(c+1 < C && seat[r][c+1] == 0) { // 우
    			seat[r][c] = count; 
    			c++; 
    			count++;  
    		}
    		
    		while(r+1 < R && seat[r+1][c] == 0) { // 하
    			seat[r][c] = count;  
    			r++;  
    			count++; 
    		}
    		
    		while(c-1 >= 0 && seat[r][c-1] == 0) { // 좌
    			seat[r][c] = count; 
    			c--; 
    			count++; 
    		}
    	}
		seat[r][c] = count;
		
		if(K <= R * C) {
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(seat[i][j] == K) {
						System.out.print(j+1);
						System.out.print(" ");
						System.out.print(R-i);
					}
				}
			}
		}
		
		else {
			System.out.print(0);
		}
	}
}