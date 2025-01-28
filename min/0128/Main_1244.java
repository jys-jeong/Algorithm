import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] swch = new int[N];
        
        for(int i = 0; i < N; i++) {
        	swch[i] = sc.nextInt();
        }
        
        int cnt = sc.nextInt();
        
        for(int i = 0; i < cnt; i++) {
        	int gender = sc.nextInt();
        	int num = sc.nextInt();
        	
        	if(gender == 1) {
        		for(int j = 1; j <= N / num; j++) {
        			swch[num * j - 1] = change(swch[num * j - 1]);
        		}
        	}
        	
        	int state = 1;
        	if(gender == 2) {
        		swch[num - 1] = change(swch[num - 1]);
        		while(num - state - 1 >= 0 && num + state - 1 < N) {
        			if(swch[num - state - 1] == swch[num + state - 1]) {
        				swch[num + state - 1] = change(swch[num + state - 1]);
        				swch[num - state - 1] = change(swch[num - state - 1]);
        				state += 1;
        			}
        			else {
        				break;
        			}
        		}
        	}
        }
        
        for(int i = 0; i < (N - 1 / 20) + 1; i++) {
        	for(int j = 0; j < 20; j++) {
        		if(i * 20 + j >= N) 
        			break;
        		System.out.print(swch[i * 20 + j] + " ");
        	}
        	System.out.println();
        }  
    }   

    static int change(int num) {
    	return num == 0 ? 1 : 0;
    }
}