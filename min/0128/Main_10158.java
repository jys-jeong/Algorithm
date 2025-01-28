import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int w = sc.nextInt();
        int h = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int t = sc.nextInt();
        int x_move = 1;
        int y_move = 1;
        int how_t = 0;
        
        int x_total_time = t % (w * 2);
        int y_total_time = t % (h * 2);
        
        while(x_total_time > 0) {
        	if(p == w || p == 0) 
        		x_move = -x_move;
        	
            if(x_move == 1) 
            	how_t = w - p;
            if(x_move == -1)
            	how_t = p;
      
            if(how_t > x_total_time) {
        		how_t = x_total_time;
        	}
            
        	p += x_move * how_t;     	
        	x_total_time -= how_t;
        }
        
        while(y_total_time > 0) {
        	if(q == h || q == 0) 
         		y_move = -y_move;
        	
        	if(y_move == 1) 
        		how_t = h - q;
            if(y_move == -1)
            	how_t = q;
      
            if(how_t > y_total_time) {
        		how_t = y_total_time;
        	}
            
        	q += y_move * how_t;     	
        	y_total_time -= how_t;
        }
        System.out.println(p + " " + q);
    }
}