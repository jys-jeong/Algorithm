import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		sx +=t;
		sy+=t;
		sx%=w*2;
		sy%=h*2;
		if(sx>w)	sx=2*w-sx;
		if(sy>h)	sy=2*h-sy;
		System.out.println(sx+" "+sy);
	}
		
}