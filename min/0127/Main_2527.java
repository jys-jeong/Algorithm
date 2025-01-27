import java.util.Scanner;

public class Main {
	static int[] rect1 = new int[4];
	static int[] rect2 = new int[4];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int test = 0; test < 4; test++) {
			for(int i = 0; i < 4; i++) {
				rect1[i] = sc.nextInt();
			}
			
			for(int i = 0; i < 4; i++) {
				rect2[i] = sc.nextInt();
			}
			
			System.out.println(answer());
		}
	}
	
	static String answer() {
        int x1 = Math.max(rect1[0], rect2[0]); 
        int y1 = Math.max(rect1[1], rect2[1]);
        int x2 = Math.min(rect1[2], rect2[2]);
        int y2 = Math.min(rect1[3], rect2[3]);
        
        if(x2 > x1 && y2 > y1) {
        	return "a";
        }
        else if(x2 > x1 && y1 == y2 || x1 == x2 && y2 > y1) {
            return "b";
        }
        else if(x1 == x2 && y1 == y2) {
            return "c"; 
        } else {
            return "d"; 
        }
    }
}