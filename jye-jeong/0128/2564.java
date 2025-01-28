import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
	
	public static int n,m,p;
	public static int dist[]=new int[105];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<=p;i++) {
			st= new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int tmp=0;
			if(dir==1) {
				tmp+=a;
			}
			else if(dir==2) {
				tmp+=(2*n+m)-a;
			}
			else if(dir==3) {
				tmp+=(2*n+2*m)-a;
			}
			else if(dir==4) {
				tmp+=n+a;
			}
			dist[i]=tmp;
		}
		
		int sum=0;
		for(int i=0 ;i<p;i++) {
			int tmpSum = Math.abs(dist[p]-dist[i]);
			tmpSum = Math.min(2*(m+n)-tmpSum, tmpSum);
			
			sum+=tmpSum;
		}
		System.out.println(sum);
	}


}