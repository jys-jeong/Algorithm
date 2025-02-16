
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
    
	public static int n,k;
	

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        char lastVer='U',lastHor='D';
        n = Integer.parseInt(st.nextToken());
        st =new StringTokenizer(br.readLine());
        for(int i=0 ;i<n*2;i++) {
        	char tmp = st.nextToken().charAt(0);
        	if(tmp=='U'||tmp=='D') {
        		lastVer=tmp;
        	}
        	else {
        		lastHor=tmp;
        	}
        }
        
        k = Integer.parseInt(br.readLine());
        if(lastHor=='L'&&lastVer=='D') {
        	k=hor(k);
        }
        else if(lastHor=='R'&&lastVer=='U') {
        	k=ver(k);
        }
        else if(lastHor=='R'&&lastVer=='D') {
        	k=ver(hor(k));
        }
        int one =k;
        int two = ver(k);
        int three = hor(k);
        int four = ver(hor(k));
        
        for(int i=0 ;i<Math.pow(2, n);i++) {
        	if(i%2==0) {
        		for(int j=0;j<Math.pow(2, n-1);j++) {
        			System.out.print(one+" "+two+" ");
            	}
        		System.out.println();
        	}
        	else {
        		for(int j=0;j<Math.pow(2, n-1);j++) {
        			System.out.print(three+" "+four+" ");
            	}
        		System.out.println();
        	}
        }
        
    }
    
    public static int ver(int a) {
    	if(a==0)	return 1;
    	else if(a==1)	return 0;
    	else if(a==2)	return 3;
    	else if(a==3)	return 2;
    	
    	return 0;
    }
    public static int hor(int a) {
    	if(a==0)	return 2;
    	else if(a==1)	return 3;
    	else if(a==2)	return 0;
    	else if(a==3)	return 1;
    	return 0;
    }
}

