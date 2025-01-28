import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<int[]> stack = new Stack<>();
        int N = sc.nextInt();
        int[][] pillar = new int[N][2];
        int answer = 0;
   
        for (int i = 0; i < N; i++) {
            pillar[i][0] = sc.nextInt();
            pillar[i][1] = sc.nextInt();
        }

        Arrays.sort(pillar, (a, b) -> Integer.compare(a[0], b[0]));
        int[] temp = new int[2];
        
        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty() && stack.peek()[1] <= pillar[i][1]) {
                temp = stack.pop();
            }
            if(stack.isEmpty() && i != 0) {
            	answer += (temp[1] * (pillar[i][0] - temp[0]));
            }
            stack.push(pillar[i]);
        }

        while(stack.size() > 1) {
        	int temp2[] = stack.pop();
        	answer += temp2[1] * (temp2[0] - stack.peek()[0]);
        }
       
        answer += stack.peek()[1];
        
        System.out.println(answer);
    }
}